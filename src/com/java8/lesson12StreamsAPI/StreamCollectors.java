package com.java8.lesson12StreamsAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java8.pojo.Students;

public class StreamCollectors {
	
	StreamCollectors() {
		
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
		
		//get students belonging to section A using collectors
		List<Students> objSectionAStuds = objStudents.stream()
										  .filter((stud) -> stud.getSection().equals("A"))
										  .collect(Collectors.toList());
		System.out.println("objSectionAStuds:: " + objSectionAStuds);
		
		//count the number of objects
		Long listCount = objStudents.stream()
							.collect(Collectors.counting());
		System.out.println("listCount:: " + listCount);
		
		//grouping elements - returns Map<Boolean, String>
		Map<String, List<Students>> objGroupedStudents = objStudents.stream()
									  .collect(Collectors.groupingBy(Students::getSection));
		System.out.println("objGroupedStudents:: " + objGroupedStudents);
		
		//partitionBy - returns Map<Boolean, List>
		Map<Boolean, List<Students>> objPartitionByStudents = objStudents.stream()
				  .collect(Collectors.partitioningBy((stud)-> stud.getMarks()>80));
		System.out.println("objPartitionByStudents:: " + objPartitionByStudents);
		
		//count
		Long dishCount = Dishes.menu.stream().collect(Collectors.counting());
		Long dishCount1 = Dishes.menu.stream().count();
		System.out.println("dishCount:: "  +dishCount);
		System.out.println("dishCount1:: "  +dishCount1);
		
		//max, min of Calories
		Comparator<Dishes> objComparator = Comparator.comparing(Dishes::getCalories);
		Optional<Dishes> maxCaloriesDish = Dishes.menu.stream()
		           					   .collect(Collectors.maxBy(objComparator));
		System.out.println("maxCaloriesDish:: "  +maxCaloriesDish.get());
		
		Optional<Dishes> minCaloriesDish = Dishes.menu.stream()
				   .collect(Collectors.minBy(objComparator));
		System.out.println("minCaloriesDish:: "  +minCaloriesDish.get());
		
		//summing
		Integer sumOfCalories = Dishes.menu.stream()
				   .collect(Collectors.summingInt((dish) -> dish.getCalories()));
				System.out.println("sumOfCalories:: "  +sumOfCalories);
		
		//averaging
		Double average = Dishes.menu.stream()
		   .collect(Collectors.averagingInt((dish) -> dish.getCalories()));
		System.out.println("average:: "  +average);
		
		//summarize
		IntSummaryStatistics objSummary = Dishes.menu.stream()
											  .collect(Collectors.summarizingInt((dish) -> dish.getCalories()));
		System.out.println("objSummary:: "  +objSummary);
		
		//String concatenation
		String objMenu = Dishes.menu.stream()
				         .map(Dishes::getName)
				         .collect(Collectors.joining());
		System.out.println("objMenu:: "  +objMenu);
		
		String objMenu1 = Dishes.menu.stream()
		         .map(Dishes::getName)
		         .collect(Collectors.joining(","));
		System.out.println("objMenu1:: "  +objMenu1);
	}

	public static void main(String[] args) {
		StreamCollectors objStreamCollectors = new StreamCollectors();

	}

}
