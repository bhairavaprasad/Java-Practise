package com.tss.test;

import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

/**
 * To convert array based data into list / collection based we can use
 * java.util.Arrays class. This class provide a static method asList(Object[] a)
 * that converts array into list / collection.
 */
public class ArrayToCollection
{
	public static void main(String[] args)
	{
		String[] array = { "Happy", "New", "Year", "2006" };
		List list = Arrays.asList(array);
		
		Iterator iterator = list.iterator();
		while (iterator.hasNext())
		{
			System.out.println((String) iterator.next());
		}
	}
}
