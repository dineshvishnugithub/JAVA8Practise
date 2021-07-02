package com.java8.lesson2DefaultMethodSAM;

//replica of first interface

public interface TestingInterface2 {

	 public static final double price = 1.5;
	 
	 //even if static final is not given in interface, jvm will consider it static final
	 public int quantity = 1;
	 
	 //single abstract method - SAM - for functional interface
	 public int getQuantity();
	 
	 //when u declare another abstract method, the interface will show u exception that its not a functional interface
	 //try uncommenting below.
	 //if you need this method, then comment @FunctionalInterface
//	 public int getItems();
	 
	 //java8 feature: default key work is used and implementation can be given in the interface itself.
	 //means a concrete method can be given in the interface itself
	 public default int getCount() {
		 System.out.println("Inside TestingInterface2:getCount():: ");
		 return 100;
	 }
	 
	 //java8 feature: static method with implementation can be given in the interface itself.
	 public static void getPrice() {
		 System.out.println("Inside TestingInterface2:getPrice() is called.");
	 }
}
