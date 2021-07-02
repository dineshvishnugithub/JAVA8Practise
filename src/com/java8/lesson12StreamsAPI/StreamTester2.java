package com.java8.lesson12StreamsAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

public class StreamTester2 {
	
	StreamTester2(){
		
		//distinct() function - removes duplicates
		List<Integer> objMixedNos = Arrays.asList(2,4,6,6,6,8,3,9,9,2);
		objMixedNos.stream().filter((num) -> num%2==0)
							.distinct()
		                    .forEach(System.out::println);
		
		//truncate stream - once the filtered list reaches the limit count, it stops processing
		List<Dishes> objDishes = Dishes.menu.stream()
								 .filter((dish) -> dish.getCalories() > 300)
								 .limit(3)
								 .collect(toList());
		System.out.println("objDishes:: " + objDishes);
		
		//skip() function used to skip the first n elements
		List<Dishes> objDishes1 = Dishes.menu.stream()
				 .filter((dish) -> dish.getCalories() > 300)
				 .skip(2)
				 .collect(toList());
		System.out.println("objDishes1:: " + objDishes1);
		
		//map returns stream, again if u apply map, it works on it to return streams
		//first map - input stream<List>, output stream<string>
		//second map - input stream<string>, output stream<integer>
		List<Integer> objDishes2 = Dishes.menu.stream()
				 .map(Dishes::getName)
				 .map(String::length)
				 .collect(toList());
		System.out.println("objDishes2:: " + objDishes2);
		
		List<Integer> obj2DList1 = Arrays.asList(1,2,3);
		List<Integer> obj2DList2 = Arrays.asList(4,5,6);
		List<Integer> obj2DList3 = Arrays.asList(7,8,9);
		List<List<Integer>> obj2DList = Arrays.asList(obj2DList1, obj2DList2, obj2DList3);
		List<Integer> objDishes3 = obj2DList.stream()
				 .flatMap((obj2D) -> obj2D.stream())
				 .collect(toList());
		System.out.println("objDishes3:: " + objDishes3);
		
		List<Integer> oddList = Arrays.asList(1,3,5);
		List<Integer> evenList = Arrays.asList(2,4,6);
		List<Integer> primeList = Arrays.asList(2,3,5);
		List<Integer> combinedList = Stream.of(oddList, evenList, primeList) // returns Stream(List<List<Integer>>)
								     .flatMap((objListOfList) -> objListOfList.stream()) //returns Stream(List<Integer>)
								     .collect(Collectors.toList());
		System.out.println("combinedList:: " + combinedList);
	}

	public static void main(String[] args) {
		StreamTester2 objStreamTester2 = new StreamTester2();

	}

}
