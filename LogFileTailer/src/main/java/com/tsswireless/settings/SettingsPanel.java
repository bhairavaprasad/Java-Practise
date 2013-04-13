package com.tsswireless.settings;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.tsswireless.swing.container.ControlPanel;
import com.tsswireless.swing.container.HorizontalPanel;
import com.tsswireless.swing.control.ReflectedAction;
import com.tsswireless.swing.field.FB;
import com.tsswireless.swing.field.FieldInfo;
import com.tsswireless.swing.field.cell.TColorChooserCellEditor;
import com.tsswireless.swing.field.cell.TColorChooserCellRenderer;
import com.tsswireless.swing.field.validate.TColorValidator;
import com.tsswireless.swing.table.CU;
import com.tsswireless.swing.table.TTable;
import com.tsswireless.swing.table.ds.EditableDataSource;
import com.tsswireless.swing.table.ds.ReflectedEditableTableModel;
import com.tsswireless.swing.table.ds.ReflectedTableModel;
import com.tsswireless.ttable.tailer.TTableTailer;
import com.tsswireless.ttable.tailer.TailerRule;
import com.tsswireless.widgets.table.JCEditCellEvent;
import com.tsswireless.widgets.table.JCEditCellListener;

public class SettingsPanel extends JPanel
{
	public final FieldInfo TEXT_MATCH = new FieldInfo(new FB<TailerRule, String>(TailerRule.class, "match"), new CU("TEXT MATCH", CU.A_LEFT, 20));
	public final FieldInfo FOREGROUND_COLOR = new FieldInfo(new FB<TailerRule, Color>(TailerRule.class, "foreground"), new CU("Forground Color", CU.A_CENTER,
		10, new TColorChooserCellRenderer(), new TColorChooserCellEditor(String.class, new TColorValidator())));
	public final FieldInfo BACKGROUND_COLOR = new FieldInfo(new FB<TailerRule, Color>(TailerRule.class, "background"), new CU("Background Color", CU.A_CENTER,
		10, new TColorChooserCellRenderer(), new TColorChooserCellEditor(String.class, new TColorValidator())));
	
	public final ReflectedAction ACTION_APPENDROW = new ReflectedAction("action_appendRow", "", this, "/images/matrix/add2.png");
	public final ReflectedAction ACTION_REMOVELASTROW = new ReflectedAction("action_removeLastRow", "", this, "/images/matrix/delete2.png");
			
	private EditableDataSource<TailerRule> settingsDataSource;
	private ReflectedTableModel setttingsTableModel;
	private TTable settingsTable;
	
	private SettingsManager manager;
	
	public SettingsPanel(SettingsManager settingsManager)
	{
		super();
		this.manager = settingsManager;
		initModel();
		initUI();
	}
			
	private void initModel()
	{
		final FieldInfo[] schema = { TEXT_MATCH, FOREGROUND_COLOR, BACKGROUND_COLOR };
		settingsDataSource = new EditableDataSource<TailerRule>(schema);
		settingsDataSource.setObjects(TTableTailer.tailerRules);
		setttingsTableModel = new ReflectedEditableTableModel(schema, settingsDataSource);
	}
	
	private void initUI()
	{
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		final FormLayout layout = new FormLayout("pref:grow", "pref, pref:grow, pref");
		setLayout(layout);
		
		initSettingsTable();
		
		final JToolBar settingsTableToolbar = initSettingsTableToolbar();
		
		final CellConstraints cc = new CellConstraints();
		final PanelBuilder builder = new PanelBuilder(layout, this);
		builder.add(settingsTableToolbar, cc.xy(1, 1));
		builder.add(settingsTable, cc.xy(1, 2));
		
		HorizontalPanel controlPanel = new HorizontalPanel();		
		controlPanel.setReflectedActionGroup(manager.getButtonsGroup());
		controlPanel.setHorizontalAlignment(ControlPanel.ALIGNMENT_CENTER);
		controlPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		
		builder.add(controlPanel, cc.xy(1, 3));
		
	}
	
	private void initSettingsTable()
	{
		settingsTable = new TTable();
		settingsTable.setResizingPolicy(TTable.RESIZING_POLICY_PRECISE);
		settingsTable.setDataSource(setttingsTableModel);
		settingsTable.setSortable(false);
		settingsTable.setEditable(true);
	}
	
	private JToolBar initSettingsTableToolbar()
	{
		final JToolBar addRemoveRowToolbar = new JToolBar();
		addRemoveRowToolbar.setOrientation(SwingConstants.HORIZONTAL);
		addRemoveRowToolbar.setFloatable(false);
		addRemoveRowToolbar.setBorder(BorderFactory.createEmptyBorder());
		addRemoveRowToolbar.setToolTipText("");
		addRemoveRowToolbar.add(ACTION_APPENDROW);
		addRemoveRowToolbar.add(ACTION_REMOVELASTROW);
		return addRemoveRowToolbar;
	}
	
	public void action_appendRow()
	{
		settingsTable.commitEdit();
		final TailerRule newRule = new TailerRule();
		settingsDataSource.addObject(null, newRule);		
		settingsTable.revalidate();
	}
	
	public void action_removeLastRow()
	{
		settingsTable.commitEdit();
		settingsDataSource.removeObjectAtIndex(setttingsTableModel.getNumRows() - 1);
		settingsTable.revalidate();
	}
	
	public EditableDataSource<TailerRule> getTableDataSource()
	{
		return settingsDataSource;
	}
	
	public TTable getTable()
	{
		return settingsTable;
	}
		
}
