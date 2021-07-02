package com.java8.lesson12StreamsAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTester3 {
	
	StreamTester3() {
		
		//test allmatch() - this checks all the elements matches the filter
		boolean isAllVege = Dishes.menu.stream()
				            .allMatch(Dishes::isVegetarian);
		System.out.println("test allMatch:: " + isAllVege);
		
		//test noneMatch() - this checks all the elements doesn't matches the filter
		boolean isAllLowCalories = Dishes.menu.stream()
				 				   .noneMatch((dish) -> dish.getCalories()>=1500);
        System.out.println("test noneMatch:: " + isAllLowCalories);
		
		//test anyMatch() - this checks any one of the elements matches the filter
		boolean isAny1FoodLowCalorie = Dishes.menu.stream()
							 .anyMatch((dish) -> dish.getCalories()<=500);
		System.out.println("test anyMatch:: " + isAny1FoodLowCalorie);
		
		//test findAny to return any first available data
		Optional<Dishes> objDish = Dishes.menu.stream()
								   .filter((dish) -> dish.getCalories()>500)
								   .findAny();
		System.out.println("test findAny:: " + objDish.get());
		
		//test findFirst to return any first available data
		//the difference is findAny is applied in parallel streams, means all the objects are put in filter parallely
		//findAny stops when the first filtered object is encountered
		//findFirst is done in sequential manner, once the first object encountered is eligible, the processing stops
		Optional<Dishes> objDish1 = Dishes.menu.stream()
								   .filter((dish) -> dish.getCalories()>500)
								   .findFirst();
		System.out.println("test findFirst:: " + objDish1.get());
		
		//reduce functions
		List<Integer> objNumList = Arrays.asList(1,2,3,4,5,6);
		int num = objNumList.stream().reduce(0, (a,b) -> a+b);
		System.out.println("test reduce sum1:: " + num);
		
		int num1 = objNumList.stream().reduce(0, Integer::sum);
		System.out.println("test reduce sum1:: " + num1);
		
		Optional<Integer> maxNo = objNumList.stream().reduce(Integer::max);
		System.out.println("test reduce maxNo:: " + maxNo.get());
		
		Optional<Integer> minNo = objNumList.stream().reduce(Integer::min);
		System.out.println("test reduce minNo:: " + minNo.get());
		
		//numeric streams
		IntStream objEvenNumbers = IntStream.rangeClosed(1, 100).filter((numberStream) -> numberStream%2==0);
		objEvenNumbers.forEach(objEvenNumber -> System.out.println(objEvenNumber));
		
		OptionalInt objOptInt = Dishes.menu.stream()
				   				.mapToInt((objDish11) -> objDish11.getCalories())
				   				.max();
		System.out.println("test OptionalInt objOptInt:: " + objOptInt.getAsInt());
		
		//build Stream from values
		Stream<String> objStream = Stream.of("Dinesh","Vishnu","Kumar", "Chandrasekaran");
				objStream.map(String::toUpperCase)
				                   .forEach(System.out::println);
				
		int numStream[] = {2,6,5};
		int sum = Arrays.stream(numStream).sum();
		System.out.println("using building stream from vlaues sum:: " + sum);
				
		//Empty stream
		Stream<String> objStream1 = Stream.empty();
				
		//infinite Stream
		Stream.iterate(0, n -> n+2)
		      .limit(10)
		      .forEach(System.out::println);
	}

	public static void main(String[] args) {
		StreamTester3 objStreamTester3 = new StreamTester3();

	}

}
