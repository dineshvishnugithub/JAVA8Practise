package com.java8.lesson9UnaryBinaryOperatorFns;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

import com.java8.pojo.Students;

public class UnaryBinaryTester {
	
	UnaryBinaryTester() {
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
		
		//test UnaryOperator<T> extends Function<T,T> -> input and output of same type
		UnaryOperator<Students> objUnary = (stud1) -> {
			stud1.setName(stud1.getName()+"1");
			return stud1;
		};
		System.out.println("Test Unary operator:: " + objUnary.apply(objStudent1));
		
		//test DoubleUnaryOperator, as name suggests it can handle only double- so i/p and o/p is of same double type
		DoubleUnaryOperator objDoubleUnary = (marks) -> {
			return marks + 5;
		};
		System.out.println("Test DoubleUnary operator:: intial marks: " + objStudent1.getMarks() + " after procesing:: " + objDoubleUnary.applyAsDouble(objStudent1.getMarks()));
	
		//test BinaryOperator<T> extends BiFunction<T,T,T> -> 2 input and 1 output of same type
		BinaryOperator<Double> objBinary = (marks1, marks2) -> {
			return marks1+marks2;
		};
		System.out.println("Test Binary operator:: " + objBinary.apply(objStudent1.getMarks(), objStudent2.getMarks()));
		
		//test DoubleBinaryOperator, as name suggests it can handle only double- so 2i/p and 1o/p is of same double type
		DoubleBinaryOperator objDoubleBinaryUnary = (marks1, marks2) -> {
			return marks1 + marks2;
		};
		System.out.println("Test DoubleBinary operator:: 2 marks: " + objStudent1.getMarks() + " , " + objStudent2.getMarks() + " after procesing:: " + objDoubleBinaryUnary.applyAsDouble(objStudent1.getMarks(), objStudent2.getMarks()));

	}

	public static void main(String[] args) {
		UnaryBinaryTester objUnaryBinaryTester = new UnaryBinaryTester();
	}

}
