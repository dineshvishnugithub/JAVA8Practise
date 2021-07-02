package com.java8.lesson10Optional;

import java.util.Optional;

import com.java8.pojo.Students;

public class OptionalTester {
	
	OptionalTester() {
		Students objStudent1 = new Students("dinesh", 2, "A", 85.5);
		Students objStudent2 = null;
		
		//using Optional.of
		//we can pass only non-nullable object, if we pass null object, it will throw exeption
		Optional<Students> objOptionalUsingOf1 = Optional.of(objStudent1);
		//objStudent2 is null, uncomment and run and see, it will throw exception. thats y ofNullable is used to pass object
//		Optional<Students> objOptionalUsingOf2 = Optional.of(objStudent2);
		
		//using Optional.of
		//when accessing the object, it return the object if it is not null or will return empty if its null
		Optional<Students> objOptionalUsingOf3 = Optional.ofNullable(objStudent1);
		Optional<Students> objOptionalUsingOf4 = Optional.ofNullable(objStudent2);
		
		//using orElseGet(Supplier) means it will return the object its present. will return the object returned by supplier if the object is not present
		Students objStudent3 = objOptionalUsingOf3.orElseGet(() -> new Students());
		Students objStudent4 = objOptionalUsingOf4.orElseGet(() -> new Students());
		System.out.println("Using orElseGet objStudent3:: " + objStudent3);
		System.out.println("Using orElseGet objStudent4:: " + objStudent4);
		
		//using isPresent() to check the object is empty or not
		if(objOptionalUsingOf1.isPresent()) {
			System.out.println("objOptionalUsingOf1.isPresent() :: " + true);
		} else {
			System.out.println("objOptionalUsingOf1.isPresent() :: " + false);
		}
		
		if(objOptionalUsingOf3.isPresent()) {
			System.out.println("objOptionalUsingOf3.isPresent() :: " + true);
		} else {
			System.out.println("objOptionalUsingOf3.isPresent() :: " + false);
		}
		
		if(objOptionalUsingOf4.isPresent()) {
			System.out.println("objOptionalUsingOf4.isPresent() :: " + true);
		} else {
			System.out.println("objOptionalUsingOf4.isPresent() :: " + false);
		}
	}

	public static void main(String[] args) {
		OptionalTester objOptionalTester = new OptionalTester();

	}

}
