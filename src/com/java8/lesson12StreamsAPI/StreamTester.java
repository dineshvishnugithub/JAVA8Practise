package com.java8.lesson12StreamsAPI;

import java.util.ArrayList;
import java.util.List;

import com.java8.pojo.Students;

public class StreamTester {
	
	StreamTester() {
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
		
		//using stream api to filter and comput sum of marks
		//1. get stream from the collection
		//2. create pipeline on the stream for filtering and will again give streams. 
		//   Filter uses predicate interface(1 input, boolean output) - intermediate activity
		//3. peek on the streams to do any action or any sop - Intermediate activity
		//   Peek uses Consumer interface(1 input, no output)
		//4. then use mapping to pick which data we are going to work. - intermediate activity
		//   mapping used Function interface(1 input of any type, 1 output of any type)
		//   so mapped stud object to double object
		//5. use sum() to calculate the sum on the data which we allocated during map - termination activity
		double sum = objStudents.stream().filter((stud) -> stud.getSection().equals("B"))
		                    .peek((stud) -> System.out.println("Students:: " + stud))
		                    .mapToDouble((stud) -> stud.getMarks())
		                    .sum();
		System.out.println("final sum is :: " + sum);
	}

	public static void main(String[] args) {
		StreamTester objStreamTester = new StreamTester();
	}

}
