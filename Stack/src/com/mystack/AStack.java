/**************************************************************************************************
 *            Developer   : rojaster 08/10/2013                                                   *
 *            Description : abstract class of data structure of stack                             *
 *                          Includes two methods : push and pop and one property                  *
 *                          to count links on objects of class                                    *
 *            @author Kuzmenko_AN1                                                                *
 **************************************************************************************************/
package com.mystack;

////////////////////////////////////////////////////////////////////////////////////////////////////

public abstract class AStack {
	// static properties
	protected static int link = 0;
	protected static int stackSize = 100;
	
	// non-static properties
	protected Object stack[];
	protected int headOfStack;
	
	// abstract methods 
	abstract public void push(Object o);
	abstract public Object pop();
	abstract public int getStackSize();
	abstract protected void changeDefaultSize(int n);
	
	// non-abstract methods
	public void clearStack(){
		this.stack = null;
		this.stack = new Object[AStack.stackSize];
		this.headOfStack = 0;
	}
	
	final public static int stackCount(){
		return AStack.link;
	}
	
	public int getHeadOfStack(){
		return this.headOfStack;
	}
}
