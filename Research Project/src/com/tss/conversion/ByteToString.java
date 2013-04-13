package com.tss.conversion;

public class ByteToString
{
	
	public static void main(String[] args)
	{
		byte b = 83;
		
		System.out.println(b);
		
		String s = b + "";
		
		System.out.println(s);
		
		System.out.println(Byte.toString(b));
		
		System.out.println(new String(new byte[] { b, 66 }));
		
	}
	
}
