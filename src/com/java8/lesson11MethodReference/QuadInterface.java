package com.java8.lesson11MethodReference;

import com.java8.pojo.Students;

@FunctionalInterface
public interface QuadInterface {
	
	public Students create(String name, int rollno, String section, double marks);

}
