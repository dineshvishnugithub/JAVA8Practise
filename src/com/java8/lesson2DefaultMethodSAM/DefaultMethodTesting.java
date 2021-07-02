package com.java8.lesson2DefaultMethodSAM;

public class DefaultMethodTesting implements TestingInterface1 {

	public DefaultMethodTesting() {
		getCount();
	}
	
	/** if you see when implementing both the interface, when overrriding it uses the nearest interface interface1 only.
	 * DefaultMethodTesting implements TestingInterface1, TestingInterface2
	 * so either ambiguity arises or it uses the first implemented interface
	 * 
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return TestingInterface1.super.getCount();
	} **/

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
		DefaultMethodTesting objDefaultMethodTesting = new DefaultMethodTesting();
		//after running we cann see the getcount() method from the first interface or the nearest interface is only called.
	}
}
