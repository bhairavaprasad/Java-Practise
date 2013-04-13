package com.tss.test.fundamental;

/**
 * We use the @Override annotation as part of method declaration. The @Override
 * annotation is used when we want to override methods and want to make sure
 * have overriden the correct methods. As the annotation name we know that there
 * should be the same method signature in the parent class to override. That
 * means using this annotation let us know earlier when we are mistakenly
 * override method that doesn't exist in the base class.
 */
public class OverrideExample
{
	private String field;
	private String attribute;
	
	@Override
	public int hashCode()
	{
		return field.hashCode() + attribute.hashCode();
	}
	
	@Override
	public String toString()
	{
		return field + " " + attribute;
	}
}
