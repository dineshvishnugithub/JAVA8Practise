package com.java8.lesson12StreamsAPI;

import java.util.Arrays;
import java.util.List;

public class Dishes {
	
	private String name;
	private int calories;
	private boolean vegetarian;
	private Type type;
	
	private enum Type {MEAT, FISH, OTHERS};

	public Dishes(String name, int calories, boolean vegetarian, Type type) {
		super();
		this.name = name;
		this.calories = calories;
		this.vegetarian = vegetarian;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public static List<Dishes> menu = Arrays.asList(new Dishes("Idly", 300, true, Dishes.Type.OTHERS),
			new Dishes("Dosa", 400, true, Dishes.Type.OTHERS),
			new Dishes("Chapathi", 300, true, Dishes.Type.OTHERS),
			new Dishes("Kari Dosa", 600, false, Dishes.Type.MEAT),
			new Dishes("Nethili Fry", 500, true, Dishes.Type.FISH),
			new Dishes("Vanajram Fry", 600, true, Dishes.Type.FISH),
			new Dishes("Kudal Varuval", 800, true, Dishes.Type.MEAT),
			new Dishes("Prawn Masala", 550, true, Dishes.Type.FISH),
			new Dishes("Thala kari", 800, true, Dishes.Type.MEAT),
			new Dishes("Omlette", 300, true, Dishes.Type.MEAT),
			new Dishes("Mutton Sukka", 1000, true, Dishes.Type.MEAT));

	@Override
	public String toString() {
		return "Dishes [name=" + name + ", calories=" + calories + "]";
	}
}
