package com.java8.lesson4LambdaExpr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.List;

import com.java8.pojo.Students;

public class LambdaExprSorting {
	
	LambdaExprSorting(){
		Runnable objRunnable = () -> System.out.println("In Runnable interface");
		
		List<Students> objStudents = new ArrayList<Students>();
		Students objStudent1 = new Students("dinesh", 2, "A");
		Students objStudent2 = new Students("vishnu", 1, "C");
		Students objStudent3 = new Students("kumar", 3, "B");
		objStudents.add(objStudent1);
		objStudents.add(objStudent2);
		objStudents.add(objStudent3);
		
		System.out.println("objStudents before sorting:: " + objStudents);
		
		//using normal inner class way
		/*Collections.sort(objStudents, new Comparator<Students>() {

			@Override
			public int compare(Students objStudentOne, Students objStudentTwo) {
				if(objStudentOne.getRollno()>objStudentTwo.getRollno())
					return 1;
				else if(objStudentOne.getRollno()<objStudentTwo.getRollno())
					return -1;
				return 0;
			}
			
		});
		System.out.println("objStudents after sorting:: " + objStudents);*/
		
		//using lambda expression
		/*Collections.sort(objStudents, (objStudentOne, objStudentTwo) -> Double.compare(objStudentOne.getRollno(), objStudentTwo.getRollno()));
		System.out.println("objStudents after sorting:: " + objStudents);*/
		
		//using method expressions
		Collections.sort(objStudents, comparing(Students::getRollno));
		System.out.println("objStudents after sorting:: " + objStudents);
	}

	public static void main(String[] args) {
		LambdaExprSorting objLambdaExprSorting = new LambdaExprSorting();

	}

}
