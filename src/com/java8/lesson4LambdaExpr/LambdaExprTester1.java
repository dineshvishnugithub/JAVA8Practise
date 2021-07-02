package com.java8.lesson4LambdaExpr;

public class LambdaExprTester1 {
	
	//to implement interface first way to implement interface and add defn to implemented methods.
	//LambdaExprTester1 implements LambdaInterface1
	
	LambdaExprTester1(){
		
		//second way to implement interface is thorugh anonymous inner class.
		/*LambdaInterface1 objInterface1 = new LambdaInterface1() {

			@Override
			public int count1() {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};*/
		
		//now we are going to use lambda expr.
		LambdaInterface1 objLambdaInterface1 = () -> 100;
		System.out.println("Interface1 o/p:: "  + objLambdaInterface1.count1());
		
		LambdaInterface2 objLambdaInterface2 = (desc, price) -> {
			return desc + price;
		};
		
		System.out.println("Interface2 o/p:: "  + objLambdaInterface2.count2("Testing lambda expre with paramter", 5));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LambdaExprTester1 objLambdaExprTester1 = new LambdaExprTester1();
	}

}
