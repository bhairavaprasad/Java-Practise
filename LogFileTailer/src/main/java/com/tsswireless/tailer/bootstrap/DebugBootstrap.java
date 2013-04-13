package com.tsswireless.tailer.bootstrap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.ExperienceBlue;
import com.tsswireless.settings.SettingsManager;
import com.tsswireless.swing.container.ControlPanel;
import com.tsswireless.swing.container.HorizontalPanel;
import com.tsswireless.swing.container.VerticalPanel;
import com.tsswireless.swing.control.ReflectedAction;
import com.tsswireless.swing.control.ReflectedActionGroup;
import com.tsswireless.swing.field.FB;
import com.tsswireless.swing.field.FUI;
import com.tsswireless.swing.field.FieldInfo;
import com.tsswireless.swing.field.TTextField;
import com.tsswireless.swing.table.TTable;
import com.tsswireless.swing.util.GUIHelper;
import com.tsswireless.swing.widgets.splash.SplashScreen;
import com.tsswireless.template.util.FH;
import com.tsswireless.ttable.tailer.TTableTailer;

public class DebugBootstrap extends JFrame
{
	private final ReflectedAction OPEN_DIALOG = new ReflectedAction("openDialog", "Open File", this, null, KeyEvent.VK_F1);
	private final ReflectedAction SETTINGS = new ReflectedAction("settings", "Rules/Settings", this, null, KeyEvent.VK_F2);
	private final ReflectedAction SCROLL_LOCK_UNLOCK = new ReflectedAction("scrollLockUnlock", "Scroll Lock/Unlock", this, null, KeyEvent.VK_F3);
	private final ReflectedAction REMOVE_TAB = new ReflectedAction("killTab", "Remove Tab", this, null, KeyEvent.VK_F4);
	private final ReflectedAction START_STOP_TAILING = new ReflectedAction("stopTailing", "Stop Tailing", this, null, KeyEvent.VK_F5);
	
	private final FieldInfo SELECTED_TAB = new FieldInfo(new FB<DebugBootstrap, String>(DebugBootstrap.class, "selectedTab", FH.STRV(500)), new FUI(
		"Selected Log File", 80));
	
	private final ReflectedActionGroup BUTTONS_GROUP = new ReflectedActionGroup(null, new ReflectedAction[] { OPEN_DIALOG, SETTINGS, SCROLL_LOCK_UNLOCK,
			REMOVE_TAB, START_STOP_TAILING });
	
	private HorizontalPanel buttonsPanel;
	
	private JPanel selectionPanel;
	
	private TTextField selected;
	
	private JTabbedPane tabbedPane;
	
	private JPanel contentPanel;
	
	private String selectedTab;
	
	private VerticalPanel verticalPanel;
	
	private Vector<TTableTailer> tailers = new Vector<TTableTailer>();
	
	public DebugBootstrap()
		throws HeadlessException
	{
		super();
		this.setTitle("TSS Log File Tailer");
		GraphicsDevice screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		final Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(screen.getDefaultConfiguration());
		this.setSize(screen.getDisplayMode().getWidth() - screenInsets.left - screenInsets.right, screen.getDisplayMode().getHeight() - screenInsets.top
			- screenInsets.bottom);
		
		buttonsPanel = new HorizontalPanel(ControlPanel.ALIGNMENT_LEFT);
		buttonsPanel.setReflectedActionGroup(this.BUTTONS_GROUP);
		
		selectionPanel = new JPanel();
		
		selected = new TTextField();
		selected.setFieldInfo(this.SELECTED_TAB);
		
		final FormLayout selectionLayout = new FormLayout("pref:grow", "pref");
		selectionPanel.setLayout(selectionLayout);
		final CellConstraints cc = new CellConstraints();
		final PanelBuilder builder = new PanelBuilder(selectionLayout, selectionPanel);
		builder.add(selected, cc.xy(1, 1));
		
		tabbedPane = new JTabbedPane();
		tabbedPane.addChangeListener(new TabChangeListener());
		contentPanel = new JPanel();
		
		contentPanel.setLayout(new BorderLayout());
		contentPanel.add(tabbedPane, BorderLayout.CENTER);
		
		verticalPanel = new VerticalPanel();
		verticalPanel.add(buttonsPanel);
		verticalPanel.add(selectionPanel);
		verticalPanel.add(contentPanel);
		this.add(verticalPanel, BorderLayout.CENTER);
		
		registerKeyStrokes();
		
		this.setVisible(true);
	}
	
	private void registerKeyStrokes()
	{
		for (ReflectedAction action : BUTTONS_GROUP.getGroup())
		{
			action.register(verticalPanel, JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
			action.register(verticalPanel, JComponent.WHEN_IN_FOCUSED_WINDOW);
			action.register(verticalPanel, JComponent.WHEN_FOCUSED);
		}
	}
	
	public void openDialog()
	{
		JFileChooser fc = new JFileChooser(new File(System.getProperty("user.home") + "//" + "APPDATA" + "//" + "LOCAL" + "//" + ".wsenable"));
		int retval = fc.showOpenDialog(this);
		if (retval == JFileChooser.APPROVE_OPTION)
		{
			File f = fc.getSelectedFile();
			TTableTailer tailer = new TTableTailer(f, this);
			tailers.add(tailer);
			
			tailer.getTable().setName(f.getAbsolutePath());
			tabbedPane.add(f.getName(), tailer.getTable());
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
		}
	}
	
	public void settings()
	{
		SettingsManager.getInstance().init();
	}
	
	public void scrollLockUnlock()
	{
		TTableTailer desiredTailer = getDesiredTailer();
		if (desiredTailer != null)
		{
			if (desiredTailer.isScrollLock())
			{
				desiredTailer.setScrollLock(false);
			}
			else
			{
				desiredTailer.setScrollLock(true);
			}
		}
	}
	
	public void stopTailing()
	{
		TTableTailer desiredTailer = getDesiredTailer();
		if (desiredTailer != null)
		{
			if (desiredTailer.getTailer().isTailing())
			{
				desiredTailer.getTailer().stopTailing();
			}
		}
	}
	
	public void killTab()
	{
		if (tabbedPane.getTabCount() > 0)
		{
			stopTailing();
			tabbedPane.removeTabAt(tabbedPane.getSelectedIndex());
		}
	}
	
	public String getSelectedTab()
	{
		return selectedTab;
	}
	
	public void setSelectedTab(String selectedTab)
	{
		this.selectedTab = selectedTab;
	}
	
	private TTableTailer getDesiredTailer()
	{
		TTable logTable = (TTable) tabbedPane.getComponent(tabbedPane.getSelectedIndex());
		TTableTailer desiredTailer = null;
		for (TTableTailer tailer : tailers)
		{
			if (tailer.getTable().equals(logTable))
			{
				desiredTailer = tailer;
				break;
			}
		}
		return desiredTailer;
	}
	
	class TabChangeListener implements ChangeListener
	{
		public void stateChanged(ChangeEvent e)
		{
			if (((JTabbedPane) e.getSource()).getSelectedIndex() < 0)
			{
				SELECTED_TAB.getValueModel().setValue("");
			}
			else if (((JTabbedPane) e.getSource()).getSelectedIndex() < tabbedPane.getTabCount())
			{
				SELECTED_TAB.getValueModel().setValue(tabbedPane.getComponent(((JTabbedPane) e.getSource()).getSelectedIndex()).getName());
			}
			SELECTED_TAB.fireValidatorUpdate();
		}
	}
	
	
	private static void initLnF()
	{
		PlasticLookAndFeel plasticLookAndFeel = new Plastic3DLookAndFeel();
		plasticLookAndFeel.setCurrentTheme(new ExperienceBlue());
		
		try
		{
			UIManager.setLookAndFeel(plasticLookAndFeel);			
			Color disabledColor = new Color(117, 116, 66);
			UIManager.put("ComboBox.disabledForeground", disabledColor.darker());
			UIManager.put("TextField.inactiveForeground", disabledColor.darker());
			UIManager.put("CheckBox.disabledText", disabledColor.darker());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	
	public static void main(String[] args)
	{
		initLnF();
		ImageIcon myImage = GUIHelper.getIconByName("/images/tssLogo.jpg");
		SplashScreen ss = new SplashScreen(myImage);
		ss.setLocationRelativeTo(null);
		ss.setProgressMax(17);
		ss.setScreenVisible(true);		
		ss.setProgress("Loading app");
		
		final DebugBootstrap bootstrap = new DebugBootstrap();
		bootstrap.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		bootstrap.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				if (JOptionPane.showConfirmDialog(bootstrap, "Are you sure?", "Confirm exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
		});
		
		ss.setScreenVisible(false);
	}
	
}
