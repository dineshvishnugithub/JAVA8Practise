package com.java8.lesson7FunctionHigherOrderFns;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;

import com.java8.pojo.Students;

public class FunctionTester {
	
	FunctionTester() {
		List<Students> objStudents = new ArrayList<Students>();
		Students objStudent1 = new Students("dinesh", 2, "A", 85.5);
		Students objStudent2 = new Students("vishnu", 1, "C",85);
		Students objStudent3 = new Students("kumar", 3, "B",73);
		Students objStudent4 = new Students("chandrasekaran", 5, "A",73.8);
		Students objStudent5 = new Students("vijayan", 6, "C",74.6);
		Students objStudent6 = new Students("arulmozhi varman", 4, "B",97.5);
		Students objStudent7 = new Students("parantakan", 8, "A",96.3);
		Students objStudent8 = new Students("raja raja cholan", 9, "C",99.4);
		Students objStudent9 = new Students("karikalan", 7, "B",92.3);
		objStudents.add(objStudent1);
		objStudents.add(objStudent2);
		objStudents.add(objStudent3);
		objStudents.add(objStudent4);
		objStudents.add(objStudent5);
		objStudents.add(objStudent6);
		objStudents.add(objStudent7);
		objStudents.add(objStudent8);
		objStudents.add(objStudent9);
		
		System.out.println("Testing Function<Students, Students> interface");
		Function<Students, Students> objFucntionOne = (stud1) -> {
			stud1.setName(stud1.getName().toUpperCase());
			return stud1;
		};
		objFucntionOne.apply(objStudent1);
		System.out.println(objStudent1);
		System.out.println("------------");
		
		System.out.println("Testing Function<Students, String> interface");
		Function<Students, String> objFucntionTwo = (stud1) -> {
			return stud1.getName();
		};
		System.out.println(objFucntionTwo.apply(objStudent1));
		System.out.println("------------");
		
		System.out.println("Testing BiFunction<Students, Students, Double> interface");
		BiFunction<Students, Students, Double> objBiFunctionOne = (stud1, stud2) -> stud1.getMarks() + stud2.getMarks();
		System.out.println(objBiFunctionOne.apply(objStudent3, objStudent6));
		System.out.println("------------");
		
		//replace the same code of BiFunction<T,U,R> to use ToDoubleBiFunction<T,U> since it returns double data type
		System.out.println("Testing ToDoubleBiFunction<Students, Students, Double> interface");
		ToDoubleBiFunction<Students, Students> objBiFunctionTwo = (stud1, stud2) -> stud1.getMarks() + stud2.getMarks();
		System.out.println(objBiFunctionTwo.applyAsDouble(objStudent3, objStudent6));
		System.out.println("------------");
		
		//higher order functions - andThen and compose
		System.out.println("Testing Higher order function andThen and compose in Function<Students, Students> interface");
		Function<Students, Students> objFucntionToUpper = (stud1) -> {
			System.out.println("to upper");
			stud1.setName(stud1.getName().toUpperCase());
			return stud1;
		};
		
		Function<Students, Students> objFucntionToLower = (stud1) -> {
			System.out.println("to lower");
			stud1.setName(stud1.getName().toLowerCase());
			return stud1;
		};
		
		System.out.println("Testing andThen ");
		objFucntionToUpper.andThen(objFucntionToLower).apply(objStudent1);
		System.out.println("------------");
		
		System.out.println("Testing compose ");
		objFucntionToUpper.compose(objFucntionToLower).apply(objStudent1);
		System.out.println("------------");
	}

	public static void main(String[] args) {
		FunctionTester objFunctionTester = new FunctionTester();

	}

}
