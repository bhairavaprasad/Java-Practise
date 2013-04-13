package com.tss.test.fundamental;

/**
 * Every instance method has a variable with the name this that refers to the
 * current object for which the method is being called. You can refer to any
 * member of the current object from within an instance method or a constructor
 * by using this keyword. Each time an instance method is called, the this
 * variable is set to reference the particular class object to which it is being
 * applied. The code in the method will then relate to the specific members of
 * the object referred to by this keyword.
 */
public class RemoteControl
{
	private String channelName;
	private int channelNum;
	private int minVolume;
	private int maxVolume;
	
	RemoteControl()
	{
		
	}
	
	RemoteControl(String channelName, int channelNum)
	{
		// 
		// use the this keyword to call another constructor in the
		// same class
		//
		this(channelName, channelNum, 0, 0);
	}
	
	RemoteControl(String channelName, int channelNum, int minVol, int maxVol)
	{
		this.channelName = channelName;
		this.channelNum = channelNum;
		this.minVolume = minVol;
		this.maxVolume = maxVol;
	}
	
	public void changeVolume(int x, int y)
	{
		this.minVolume = x;
		this.maxVolume = y;
	}
	
	public static void main(String[] args)
	{
		RemoteControl remote = new RemoteControl("ATV", 10);
		
		// 
		// when the following line is executed, the this variable in
		// changeVolume() is refer to remote object.
		//
		remote.changeVolume(0, 25);
		System.out.println(remote);
	}

	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	public String toString()
	{
	    final String TAB = "    ";
	    
	    String retValue = "";
	    
	    retValue = "RemoteControl ( "
	        + super.toString() + TAB
	        + "channelName = " + this.channelName + TAB
	        + "channelNum = " + this.channelNum + TAB
	        + "minVolume = " + this.minVolume + TAB
	        + "maxVolume = " + this.maxVolume + TAB
	        + " )";
	
	    return retValue;
	}
}
