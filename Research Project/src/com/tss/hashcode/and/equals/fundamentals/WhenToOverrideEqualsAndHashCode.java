package com.tss.hashcode.and.equals.fundamentals;

import java.util.HashMap;
import java.util.Map;


/**
 * HashTable, HashMap and HashSet are the Collection classes in java.util package that make use of hashing algorithm to store objects. 
 * In all these Collection classes except HashSet, objects are stored as key-value pairs. For the storage and the retrieval of any 
 * user-defined objects it is a good practice to override the following methods which is mentioned below,

hashCode()
equals()

These methods are available in the Object class and hence available to all java classes.
Using these two methods, an object can be stored or retrieved from a Hashtable, HashMap or HashSet.

hashCode() method

This method returns a hashcode value as an int for the object. Default implementation for hashcode() should be overridden in 
order to make searching of data faster. The implementation of hashCode() method for an user-defined object should be calculated
 based on the properties of the class which we wish to consider.
 
equals() method

This method returns a boolean which specifies whether two objects are equal or not. 
The default implementation of equals() method given by the Object Class uses the '==' 
operator to compare two object references, and returns true only if they refer to the same object. 
But, we can meaningfully re-define this equals() method to have en equality check based on our own criterias.

Consider the following code, which defines two user defined classes Employee and EmployeeId which are supposed to be stored in a Map.
 *
 */
public class WhenToOverrideEqualsAndHashCode
{				
	public static void main(String[] args)
	{
		
		Map<EmployeeId, Employee> employees = new HashMap<EmployeeId, Employee>();
		
		employees.put(new EmployeeId("111"), new Employee("Johny"));
		employees.put(new EmployeeId("222"), new Employee("Jeny")); // Line A
		employees.put(new EmployeeId("333"), new Employee("Jessie"));
		
		Employee emp = employees.get(new EmployeeId("222")); // Line B
		System.out.println(emp); // Line C
	}
	
	/*
	 * In Line B, we try to retrieve the Employee object who has Employee Id
	 * with a value of 222. We expect the output to be 'Jeny', because the
	 * Employee with Employee Id (222) was already there in the Collection, but
	 * surprisingly, the output of the above code is null. The reason is that we
	 * did not override the equals() method for EmployeeId and Employee classes
	 * because the default implementation of equals() in the Object class
	 * considers the new EmployeeId("222") in the put statement and new
	 * EmployeeId("222") in the get statement as two different instances, and
	 * hence the call to get() in Line B returns null.
	 */
}
