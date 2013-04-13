package com.tss.swing.worker;

import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;

public class AboutLabelListener implements MouseListener
{
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (Desktop.isDesktopSupported())
		{
			try
			{
				Desktop.getDesktop().browse(new URI("http://growingtoprogram.blogspot.com"));
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
	}
	
}
