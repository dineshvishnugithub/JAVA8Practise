package com.java8.lesson6ConsumerHigherOrderFns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.java8.pojo.Students;

public class ConsumerTester {

	ConsumerTester(){
		List<Students> objStudents = new ArrayList<Students>();
		Students objStudent1 = new Students("dinesh", 2, "A");
		Students objStudent2 = new Students("vishnu", 1, "C");
		Students objStudent3 = new Students("kumar", 3, "B");
		Students objStudent4 = new Students("chandrasekaran", 5, "A");
		Students objStudent5 = new Students("vijayan", 6, "C");
		Students objStudent6 = new Students("arulmozhi varman", 4, "B");
		Students objStudent7 = new Students("parantakan", 8, "A");
		Students objStudent8 = new Students("raja raja cholan", 9, "C");
		Students objStudent9 = new Students("karikalan", 7, "B");
		objStudents.add(objStudent1);
		objStudents.add(objStudent2);
		objStudents.add(objStudent3);
		objStudents.add(objStudent4);
		objStudents.add(objStudent5);
		objStudents.add(objStudent6);
		objStudents.add(objStudent7);
		objStudents.add(objStudent8);
		objStudents.add(objStudent9);
		
		//to print each object using consumer Consumer<T> void accept(T)
		Consumer<Students> objConsumer = (objStudentOne) -> System.out.println(objStudentOne);
		objStudents.forEach(objConsumer);
		
		System.out.println("--------");
		
		//to test andThen in consumer interface
		//it prints first item of object1 and then object2
		//like wise it prints nth item of object1 and then object2
		Consumer<Students> objConsumerOne = (objStudentOne) -> System.out.println("First Object:: " + objStudentOne);
		Consumer<Students> objConsumerTwo = (objStudentOne) -> System.out.println("Second object" + objStudentOne);
		objStudents.forEach(objConsumerOne.andThen(objConsumerTwo));
		
		System.out.println("--------");
		
		
		//to filter students belonging to section A
		//the method uses consumer instead of for each block like last time implementation.
		//for consumer implementation, please refer inside the method.
		testPredicateAndConsumerFunctions(objStudents, (objStudent) -> objStudent.getSection().equals("A"));
		
		//BiConsumer Interface
		Map<String, String> objMap = new HashMap<String,String>();
		objMap.put("One", "1");
		objMap.put("Two", "2");
		objMap.put("three", "3");
		
		System.out.println(" Testing BiConsumer Interface");
		BiConsumer<String, String> objBiConsumer = (obj1, obj2) -> System.out.println(obj1 + " - " + obj2);
		objMap.forEach(objBiConsumer);
		System.out.println("--------");
	}
	
	//Predicate<T> and Consumer<T>
	public void testPredicateAndConsumerFunctions(List<Students> objStudents, Predicate<Students> objPredicate1) {
		System.out.println("Testing Predicates and Consumers");
		//below commented method is the foreach implementation and we are going to replace with Consumer interface. 
		/*
		for(Students objStudent:objStudents) {
			if(objPredicate1.test(objStudent)) {
				System.out.println(objStudent);
			}
		}*/
		Consumer<Students> objConsumer = (objStudent) -> {
			if(objPredicate1.test(objStudent)) {
				System.out.println(objStudent);
			}
		};
		objStudents.forEach(objConsumer);
		System.out.println("---------------");
	}

	public static void main(String[] args) {
		ConsumerTester objConsumerTester = new ConsumerTester();
	}
}
