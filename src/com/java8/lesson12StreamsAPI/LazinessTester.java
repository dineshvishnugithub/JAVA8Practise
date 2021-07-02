package com.java8.lesson12StreamsAPI;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class LazinessTester {
	
	LazinessTester() {
		List<Integer> objIntegerNum = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		//filter, function, map, limit are intermediate functions
		//collect is terminate function
		//system is aware of the limit method and optimises the algorithm to process only 2 filtered outputs.
		//this is the laziness behaviour.
		List<Integer> objEvenIntegerNum = objIntegerNum.stream()
				                          .filter((num) -> {
				                        	  System.out.println("Inside filtering for num:: " + num);
				                        	  return num%2==0;
				                          })
				                          .map((num1) -> {
				                              System.out.println("inside map for num1:: " + num1);
											  return  num1 * num1;
				                          })
				                          .limit(2)
				                          .collect(toList());
	}

	public static void main(String[] args) {
		LazinessTester objLazinessTester = new LazinessTester();

	}

}
