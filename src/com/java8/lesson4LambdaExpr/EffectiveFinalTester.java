package com.java8.lesson4LambdaExpr;

public class EffectiveFinalTester {
	
	private int variable1=0;
	private static int variable2=0;
	
	EffectiveFinalTester(){
		//can use and modify instance variable in lambda expression.
		Runnable objRunnable = () -> System.out.println(variable1++);
		
		//can use and modify static instance variable in lambda expression.
		Runnable objRunnable1 = () -> System.out.println(variable2++);
		
		//cannot modify, but use local variable inside lambda expression
		//even though the local variable
		//just uncomment line 20 and see if its throwing compile exception.
		int varialbe3=0;
		Runnable objRunnable2 = () -> System.out.println(varialbe3);
//		Runnable objRunnable2 = () -> System.out.println(varialbe3++);
	}

	public static void main(String[] args) {
		EffectiveFinalTester objEffectiveFinalTester = new EffectiveFinalTester();

	}

}
