/**************************************************************************************************
 *            Developer   : rojaster 08/10/2013                                                   *
 *            Description : class of dynamic stack                                                *
 *            @author Kuzmenko_AN1                                                                *
 **************************************************************************************************/
package com.mystack;

import  com.mystack.AStack;

////////////////////////////////////////////////////////////////////////////////////////////////////

public class DynamicStack extends AStack{
	
	// properties
	private static int dlink = 0;
	private int currentStackSize;
	
	// constructors
	DynamicStack(){
		this.stack = new Object[stackSize];
		this.currentStackSize = stackSize;
		this.headOfStack = 0;
		++AStack.link;
		++DynamicStack.dlink;
	}

	DynamicStack(int n){
		if(n > 0 && n < Integer.MAX_VALUE){
			this.stack = new Object[n];
			this.currentStackSize = n;
			this.headOfStack = 0;
			++AStack.link;
			++DynamicStack.dlink;
		}
		else{
			System.out.println("Incorrect stack size, please check a size");
			return;
		}
	}

	// methods
	@Override
	public void push(Object o) {
		if(this.headOfStack == this.currentStackSize){
			this.increaseStack(this);
		}
		this.stack[this.headOfStack++] = o;
	}

	@Override
	public Object pop() {
		return this.stack[--this.headOfStack]; 
	}

	private void increaseStack(DynamicStack ds){
		Object tmp[] = new Object[this.currentStackSize+stackSize];
		for(int i = 0; i < this.currentStackSize; ++i){
			tmp[i] = this.stack[i];
		}
		this.currentStackSize = this.currentStackSize + AStack.stackSize;
		//System.out.println("Current size of stack is " + this.currentStackSize);
		this.stack = tmp;
		tmp = null;
	}

	@Override
	protected void changeDefaultSize(int size){
		if(size > 0 && size != AStack.stackSize && size < Integer.MAX_VALUE)
			AStack.stackSize = size;
	}

	public boolean is(){
		return ( this.headOfStack == 0 ) ? false : true;
	}

	public int getStackSize(){
		return this.currentStackSize;
	}

	final public static int counts(){
		return DynamicStack.dlink;
	}

	//before delete object 
	protected void finalize(){
		AStack.link--;
		DynamicStack.dlink--;
	}
}