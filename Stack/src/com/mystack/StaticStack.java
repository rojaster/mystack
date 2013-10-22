/**************************************************************************************************
 *            Developer   : rojaster 11/10/2013                                                   *
 *            Description : class of dynamic stack                                                *
 *            @author Kuzmenko_AN1                                                                *
 **************************************************************************************************/
package com.mystack;

import  com.mystack.AStack;;

////////////////////////////////////////////////////////////////////////////////////////////////////

public class StaticStack extends AStack{
	private static int slink;
	private int defaultStackSize = 300;

	StaticStack(){
		this.stack = new Object[this.getStackSize()];
		this.headOfStack = 0;
		++AStack.link;
		++StaticStack.slink;
	}

	StaticStack(int size){
		this.headOfStack = 0;
		this.changeDefaultSize(size);
		this.stack = new Object[this.defaultStackSize];
		++AStack.link;
		++StaticStack.slink;
	}
	
	@Override
	public void push(Object o){
		if(this.headOfStack < this.defaultStackSize){
			this.stack[this.headOfStack++] = o;
		}
		else{
			System.out.println("Stack is filled");
			return; // needed call a throws
		}
	}

	@Override
	public Object pop(){
		return this.stack[--this.headOfStack];
	}

	@Override
	public int getStackSize(){
		return this.defaultStackSize;
	}

	@Override
	protected void changeDefaultSize(int size){
		if(size > 0 && size != this.defaultStackSize && size < Integer.MAX_VALUE)
			this.defaultStackSize = size;
	}

	public boolean is(){
		return (this.headOfStack == 0) ? false : true;
	}

	final public static int counts(){
		return StaticStack.slink;
	}

	protected void finalize(){
		AStack.link--;
		StaticStack.slink--;
	}
}
