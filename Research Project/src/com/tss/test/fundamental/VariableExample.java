package com.tss.test.fundamental;

/**
 * Variable is a field in which object store its state. It also an allocations
 * for the placement of data in memory. When the statement of variable
 * declaration is compiled, some bytes of memory will be allocated for the
 * variable. The size is determine by the type of variable. One variable
 * definition is able to store data only of one particular type. Before it can
 * use, the variable must be declared. The name and type of variable must
 * specified in variable declaration. If you want the variable to have an
 * initial value, you must specify your own value in the declaration. You can
 * assign a value into variable by using an assignment statement. The assignment
 * operator is =.
 */
public class VariableExample
{
	//
	// declares a double variable number1 and total
	//
	private double number1, total;
	
	//
	// declares a double variable and initializes its value to 10000
	//
	private double number2 = 1000;
	
	public static void main(String[] args)
	{
		VariableExample ve = new VariableExample();
		
		//
		// assigns a value to variable number1
		//
		ve.number1 = 500;
		
		//
		// assigns the calculation result of number1 + number2 to total
		//
		ve.total = ve.number1 + ve.number2;
		System.out.println(ve.total);
	}
}
