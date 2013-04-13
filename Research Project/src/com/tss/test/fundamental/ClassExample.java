package com.tss.test.fundamental;

/**
 * Here is a ClassExample.java file that defines the ClassExample class that use
 * the Person class.
 */
public class ClassExample
{
	public static void main(String[] args)
	{
		Person person = new Person();
		person.setName("Andy");
		person.setTitle("MBA");
		person.setAddress("NY City");
		System.out.println(person);
		
		String nameTitle1 = person.getNameWithTitle();
		System.out.println("Name with title: " + nameTitle1);
		
		Person person2 = new Person("Sarah");
		String nameTitle2 = person2.getNameWithTitle();
		System.out.println("Name with title 2: " + nameTitle2);
	}
}
