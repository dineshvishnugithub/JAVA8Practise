package com.java8.lesson5PredicateHigherOrderFns;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.java8.pojo.Students;

public class PredicateTester {
	
	PredicateTester(){
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
		
		//to filter rollno < 5
		testPredicateAndHigherOrderFunctions(objStudents, (objStudent) -> objStudent.getRollno()<5);
		
		//to filter students belonging to section A
		testPredicateAndHigherOrderFunctions(objStudents, (objStudent) -> objStudent.getSection().equals("A"));
		
		//to filter names starting with A
		testPredicateAndHigherOrderFunctions(objStudents, (objStudent) -> objStudent.getName().startsWith("v"));
		
		//use higher order functions - AND default method
		//we have 2 predicates P1 and P2. the result of P1 AND P2 will be a new predicate P3.
		//this predicate P3 will be supplied to the method.
		//similarly we can use or, negate default methods.
		Predicate<Students> objPredicate1 = (objStudent) -> objStudent.getRollno()<5;
		Predicate<Students> objPredicate2 = (objStudent) -> objStudent.getSection().equals("A");
		testPredicateAndHigherOrderFunctions(objStudents, objPredicate1.and(objPredicate2));
		
		//using IntPredicate
		//replicate the same logic like line no 33 as it uses Generic predicate
		testIntPredicate(objStudents, (id) -> id<5);
		
		//using BiPredicate
		//find same section students
		testBiPredicate(objStudents, (objStudentOne, objStudentTwo) -> objStudentOne.getSection().equals(objStudentTwo.getSection()));
	}
	
	//Predicate<T>
	public void testPredicateAndHigherOrderFunctions(List<Students> objStudents, Predicate<Students> objPredicate1) {
		System.out.println("Testing Predicates");
		for(Students objStudent:objStudents) {
			if(objPredicate1.test(objStudent)) {
				System.out.println(objStudent);
			}
		}
		System.out.println("---------------");
	}
	
	//not like Generic Predicate, this IntPredicate doenst has specific class generics as it uses only int vlaue as input.
	//IntPredicate  where Genric one is Predicate<T>
	public void testIntPredicate(List<Students> objStudents, IntPredicate objPredicate1) {
		System.out.println("Testing IntPredicates");
		for(Students objStudent:objStudents) {
			if(objPredicate1.test(objStudent.getRollno())) {
				System.out.println(objStudent);
			}
		}
		System.out.println("---------------");
	}
	
	//not like Generic Predicate, this BiPredicate uses two inputs BiPredicate<T,T>.
	public void testBiPredicate(List<Students> objStudents, BiPredicate<Students, Students> objPredicate1) {
		System.out.println("Testing testBiPredicate");
		for(Students objStudent1:objStudents) {
			for(Students objStudent2:objStudents) {
				if(objPredicate1.test(objStudent1, objStudent2)) {
					System.out.println(objStudent1);
					System.out.println(objStudent2);
					System.out.println("xx");
				}
			}
		}
		System.out.println("---------------");
	}

	public static void main(String[] args) {
		PredicateTester objPredicateTester = new PredicateTester();
	}

}
