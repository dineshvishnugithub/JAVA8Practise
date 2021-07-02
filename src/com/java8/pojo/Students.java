package com.java8.pojo;

public class Students {
	
	private String name;
	private int rollno;
	private String section;
	private double marks;
	
	public Students(){
		super();
		System.out.println("Inside default constructor");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public Students(String name, int rollno, String section) {
		super();
		this.name = name;
		this.rollno = rollno;
		this.section = section;
		System.out.println("Inside 3 parametrized constructor");
	}
	
	public Students(String name, int rollno, String section, double marks) {
		super();
		this.name = name;
		this.rollno = rollno;
		this.section = section;
		this.marks = marks;
//		System.out.println("Inside 4 parametrized constructor");
	}
	@Override
	public String toString() {
		return "Students [name=" + name + ", rollno=" + rollno + ", section=" + section + ", marks=" + marks + "]";
	}
	
	public Students setMarksCustom(double marks) {
		this.setMarks(marks);
		return this;
	}
}
