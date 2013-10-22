/**************************************************************************************************
 *            Developer   : rojaster 09/10/2013                                                   *
 *            Description : Runnable class for stack                                              *
 *            @author Kuzmenko_AN1                                                                *
 **************************************************************************************************/
package com.mystack;

import java.util.*;
import com.mystack.DynamicStack;
import com.mystack.StaticStack;

////////////////////////////////////////////////////////////////////////////////////////////////////

public final class RunnableStack {
	public static void main(String[] args) {
		ArrayList<DynamicStack> ds = new ArrayList<DynamicStack>();

		for(int i = 0 ; i < 5 ; ++i){
			ds.add(new DynamicStack());
		}

		System.out.println("Summary count of Stacks : " + AStack.stackCount());
		
		System.out.println("Summary count of Dynamic Stacks : " + DynamicStack.counts());

		long t;
		ArrayList<Long> ta = new ArrayList<Long>();
		for(DynamicStack stack : ds){
			t = System.currentTimeMillis();
			for(int j = 0 ; j < 1050; ++j){
				stack.push(j);
			}
			t = System.currentTimeMillis() - t;
			ta.add(t);
		}

		DynamicStack st;
		for(int i = 0 ; i < DynamicStack.link ; ++i){
			System.out.print("DStack " + (i+1) + ", time for push() is " + ta.get(i) + " : ");
			st = ds.get(i);
			while(st.is())
				System.out.print(st.pop() + " ");
			System.out.println();
		}

		for(int i = 0 ; i < 30 ; ++i){
			System.out.print("---");
		}

		StaticStack ss  = new StaticStack();
		StaticStack ss1 = new StaticStack(500);

		System.out.println("\nSummary count of Stacks : " + AStack.stackCount());
		System.out.println("Summary count of Static Stacks : " + StaticStack.counts());

		for(int i = 0 ; i < ss.getStackSize() ; ++i)
			ss.push(i);
		System.out.print("SStack ss : ");
		while(ss.is()){
			System.out.print(ss.pop() + " ");
		}

		for(int i = 0 ; i < ss1.getStackSize() ; ++i)
			ss1.push(i);
		System.out.print("\nSStack ss1 : ");
		while(ss1.is()){
			System.out.print(ss1.pop() + " ");
		}
	}
}
