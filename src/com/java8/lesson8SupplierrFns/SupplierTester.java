package com.java8.lesson8SupplierrFns;

import java.util.function.Supplier;

import com.java8.pojo.Students;

public class SupplierTester {
	
	SupplierTester(){
		
		Supplier<Students> objSupplier = () -> new Students();
		System.out.println("Testing Supplier interface");
		System.out.println(objSupplier.get());
		System.out.println("---------");
		
		//since it is used to create objects, it is considered as the factory of the objects.
	}

	public static void main(String[] args) {
		SupplierTester objSupplierTester = new SupplierTester();
	}

}
