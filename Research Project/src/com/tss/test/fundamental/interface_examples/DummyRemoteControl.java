package com.tss.test.fundamental.interface_examples;

/**
 * The following snippet show you how to create a class that implements the
 * RemoteControl interface.
 */
public class DummyRemoteControl implements RemoteControl
{
	private int x;
	private int y;
	
	public DummyRemoteControl(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void moveUp(int n)
	{
		x = x + n;
	}
	
	@Override
	public void moveRight(int n)
	{
		y = y + n;
	}
	
	@Override
	public void moveDown(int n)
	{
		x = x - n;
	}
	
	@Override
	public void moveLeft(int n)
	{
		y = y - n;
	}
	
	@Override
	public int[] getPosition()
	{
		return new int[] { x, y };
	}
	
	public static void main(String[] args)
	{
		RemoteControl control = new DummyRemoteControl(0, 0);
		control.moveDown(10);
		control.moveLeft(5);
		System.out.println("X = " + control.getPosition()[0]);
		System.out.println("Y = " + control.getPosition()[1]);
	}
}
