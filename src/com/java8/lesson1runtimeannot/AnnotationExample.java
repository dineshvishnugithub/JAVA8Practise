package com.java8.lesson1runtimeannot;

import java.lang.reflect.Method;

public class AnnotationExample {
	
	@SampleRunTimeAnnotationExample(desc="Test String", price=2)
	public void setValues() {
		
	}

	public static void main(String[] args) {
		try {
			Class objClass = Class.forName("com.java8.lesson1runtimeannot.AnnotationExample");
			Method[] objMethod = objClass.getDeclaredMethods();
			for(Method objIndividualMthd:objMethod) {
				if("setValues".equalsIgnoreCase(objIndividualMthd.getName())){
					SampleRunTimeAnnotationExample objAnno = objIndividualMthd.getAnnotation(SampleRunTimeAnnotationExample.class);
					System.out.println("anno desc value:: " + objAnno.desc());
					System.out.println("anno price value:: " + objAnno.price());
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
