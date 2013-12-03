package com.tss.helpful;

import java.net.URL;

public class PhysicalPath
{
	public static void main(String[] args)
	{
		URL location = PhysicalPath.class.getProtectionDomain().getCodeSource().getLocation();
		System.out.println(location.getFile());
	}
}
