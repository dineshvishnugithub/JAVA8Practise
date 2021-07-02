package com.java8.lesson12StreamsAPI;

import java.util.List;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StreamTester1 {
	
	StreamTester1() {
		
	}
	
	public List<String> filterHighCalorieFoodJAVA7() {
		List<Dishes> objDishes = new ArrayList<Dishes>();
		//filter based on calories
		for(Dishes objDish:Dishes.menu){
			if(objDish.getCalories()>400) {
				objDishes.add(objDish);
			}
		}
//		System.out.println(objDishes);
		//sort based on calories
		Collections.sort(objDishes, new Comparator<Dishes>() {

			@Override
			public int compare(Dishes dish1, Dishes dish2) {
				if(dish1.getCalories()>dish2.getCalories()) {
					return 1;
				} else if(dish1.getCalories()<dish2.getCalories()) {
					return -1;
				} 
				return 0;				
			}
			
		});
//		System.out.println(objDishes);
		//return only name as list
		List<String> objDishNames = new ArrayList<String>();
		for(Dishes objDish:objDishes) {
			objDishNames.add(objDish.getName());
		}
		return objDishNames;
	}
	
	public List<String> filterHighCalorieFoodJAVA8() {
		List<String> objDishes = Dishes.menu.stream().filter((dishes) -> dishes.getCalories()>400).sorted(comparing(Dishes::getCalories)).map((dishes) -> dishes.getName()).collect(toList());
		return objDishes;
		
	}

	public static void main(String[] args) {
		StreamTester1 objStreamTester1 = new StreamTester1();
		System.out.println("dishes from JAVA8:: " + objStreamTester1.filterHighCalorieFoodJAVA8());
		System.out.println("dishes from JAVA7:: " + objStreamTester1.filterHighCalorieFoodJAVA7());
	}

}
