package com.tss.test.io;

import java.nio.charset.CharsetDecoder;
import java.nio.charset.Charset;
import java.nio.charset.CharacterCodingException;
import java.nio.CharBuffer;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * The code below detect if a given string has a non ASCII characters in it. We
 * use the CharsetDecoder class from the java.nio package to decode string to be
 * a valid US-ASCII charset.
 */
public class NonAsciiValidation
{
	public static void main(String[] args)
	{
		//
		// This string contains a non ASCII character which will produce
		// exception
		// in this program. While the second string has a valid ASCII only
		// chars.
		//
		byte[] invalidBytes = "Copyright © 2005-2009 Kode Java Org".getBytes();
		byte[] validBytes = "Copyright (c) 2005-2009 Kode Java Org".getBytes();
		
		//
		// Returns a charset object for the named charset.
		//
		CharsetDecoder decoder = Charset.forName("US-ASCII").newDecoder();
		try
		{
			CharBuffer buffer = decoder.decode(ByteBuffer.wrap(validBytes));
			System.out.println(Arrays.toString(buffer.array()));
			
			buffer = decoder.decode(ByteBuffer.wrap(invalidBytes));
			System.out.println(Arrays.toString(buffer.array()));
		}
		catch (CharacterCodingException e)
		{
			System.err.println("The information contains a non ASCII character(s).");
			e.printStackTrace();
		}
	}
}
