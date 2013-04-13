package com.tss.tuning.jtailer.advanced;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.File;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.tss.tuning.LogFileTailer;
import com.tss.tuning.LogFileTailerListener;

/**
 * Hosts a scrollable JList that contains a tailer list model
 *
 * @author shaines
 */
public class TailerPanel extends JPanel implements LogFileTailerListener
{
    private JList list;

    private TailerListModel tailerListModel;

    /**
     * Log file tailer
     */
    private LogFileTailer tailer;

    public TailerPanel( String filename, int maxLines)
    {
        // Build the panel
        setLayout( new BorderLayout() );
        
        tailerListModel = new TailerListModel(maxLines);
        list = new JList( tailerListModel );
        add( new JScrollPane( list ), BorderLayout.CENTER );

        // Set the renderer
        list.setCellRenderer( Tails.getListCellRenderer() );

        // Set the list font
        Font f = new Font( "Monospaced", Font.PLAIN, 12 );
        list.setFont( f );

        // Configure the log file tailer
        tailer = new LogFileTailer( new File( filename ), 1, true );
        tailer.addLogFileTailerListener( this );
        tailer.start();
    }

    public JList getList()
    {
        return list;
    }

    public void setList( JList list )
    {
        this.list = list;
    }

    public TailerListModel getTailerListModel()
    {
        return tailerListModel;
    }

    /**
     * LogFileTailer notification that a new block of lines have been added to the
     * log file
     *
     * @param block         The new block of lines added to the log file
     */
	@Override
	public void newLogFileLine(String line)
	{
        tailerListModel.addLines( line );

        // Select the last line
        list.setSelectedIndex( tailerListModel.getSize() - 1 );
        list.ensureIndexIsVisible( tailerListModel.getSize() - 1 );
    }
}
