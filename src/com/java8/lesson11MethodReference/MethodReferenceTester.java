package com.java8.lesson11MethodReference;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.DoubleFunction;
import java.util.function.Supplier;

import com.java8.pojo.Students;

public class MethodReferenceTester {
	
	MethodReferenceTester() {
		
	    //understand method reference
		//Below we use BinaryOperator<R> extends BiFunction<T,T,T>
		//below is lambda expr to add 2 double numbers
		//similarly it can be done by DoubleBinaryOperator
		BinaryOperator<Double> objBinaryOp1 = (num1, num2) -> num1 + num2;
		double ans1 = objBinaryOp1.apply(5.5, 6.8);
		System.out.println("Type3: using lambda ans1:: " + ans1);
		//now we change the previous implementation using method reference
		//we have a separate method that add the 2 double numbers and returns double
		//since it is present in this class, we use the object instance this::methodname , this::add
		//Type3: this is an example of object accessing an instance method.
		//(args) -> obj.instancemethod(args) becomes obj::instancemethod
		BinaryOperator<Double> objBinaryOp2 = this::add;
		double ans2 = objBinaryOp2.apply(5.5, 6.8);
		System.out.println("Type3: using method reference ans2:: " + ans2);
		
		List<Students> objStudents = new ArrayList<Students>();
		Students objStudent1 = new Students("dinesh", 2, "A", 85.5);
		Students objStudent2 = new Students("vishnu", 1, "C",85);
		objStudents.add(objStudent1);
		objStudents.add(objStudent2);
		//using lambda to sort
		System.out.println("Type1: before sorting:: " + objStudents);
		Collections.sort(objStudents, (stud1, stud2) ->  Double.compare(stud1.getMarks(), stud2.getMarks()));
		System.out.println("Type1: after sorting by Marks using lambda:: " + objStudents);
		//since each object inside the list is of type Students, then we give the field marker directly.
		//Instead of object, we use classname:field
		//Type 1: This is an example for accessing the method name using Class name
		//(args) -> ClassName.staticmethod(args) becomes Classname::staticmethod
		Collections.sort(objStudents, comparing(Students::getRollno));
		System.out.println("Type1: after sorting by Rollno usign method reference:: " + objStudents);
		//we can also order by name
		Collections.sort(objStudents, comparing(Students::getName));
		System.out.println("Type1: after sorting by Name usign method reference:: " + objStudents);
		
		//Type1: access the static method of an class
		//we will use Math.sqrt function to illustrate
		//using lambda
		DoubleFunction objDoubleFn = (num) -> Math.sqrt(num);
		System.out.println("Type1: using lambda " + objDoubleFn.apply(2));
		//using method reference
		DoubleFunction objDoubleFn1 = Math::sqrt;
		System.out.println("Type1: using method reference " + objDoubleFn1.apply(2));
		
		//Type1: access static method declared in the same class
		//using lambda
		DoubleFunction objDoubleFn2 = (num) -> sub(num);
		System.out.println("Type1: using lambda " + objDoubleFn.apply(4));
		//using method reference - use the class name where the fucntion is.
		DoubleFunction objDoubleFn3 = MethodReferenceTester::sub;
		System.out.println("Type1: using method reference " + objDoubleFn3.apply(5));
		
		
		//Type2: access methods from the object passed as parameters in the same method
		//(obj, args) -> obj.methodname(args) becomes Classname::methodname
		//Since 2 inputs involved, we will use BiFunction to show how it works.
		//using lambda
		BiFunction<Students, Double, Students> objBiFn1 = (stud1, marks) -> {
			stud1.setMarksCustom(marks);
			return stud1;
		};
		objBiFn1.apply(objStudent1, 50.5);
		System.out.println("Type2: using lambda:: " + objStudents);
		BiFunction<Students, Double, Students> objBiFn2 = Students::setMarksCustom;
		objBiFn2.apply(objStudent1, 60.5);
		System.out.println("Type2: using method expr:: " + objStudents);
		
		//Type4: using contructor references
		//(args) -> new ClassName(args) to ClassName::new
		//since we are dealing with construction new object, we use supplier to create the object
		//for default constructor
		//usign lambda
		Supplier<Students> objSupplier1 = () -> new Students();
		objSupplier1.get();
		//using method expr
		Supplier<Students> objSupplier2 =  Students::new;
		objSupplier2.get();
		
		//now we will see how to invoke parameterised constructor
		//so we need to pass 4 args, so we need to create a custom Functional interface QuadInterface to hold 4 values
		//using lambda
		QuadInterface objQuad1 = (name, rollno, section, marks) -> new Students(name, rollno, section, marks);
		objQuad1.create("Kumar", 3, "A", 89.34);
		//using method expr
		QuadInterface objQuad2 = Students::new;
		objQuad1.create("Chandru", 4, "A", 99.34);
	}
	
	//for Type3
	public Double add(double num1, double num2) {
		return num1+num2;
	}
	
	//for Type1
	public static Double sub(double num1) {
		return num1-2;
	}

	public static void main(String[] args) {
		MethodReferenceTester objMethodReferenceTester = new MethodReferenceTester();

	}

}
