package com.java8.lesson3InnerClass;

public class ParentClass {
	
	//normal inner class
	//create a class inside the parent class and access it with the parent object in the main method.
	//cannot be directly instantiated without the parent object.
	//class name will be Parentclass$NormalInnerclass.class
	class NormalInnerClass {
		
	}
	
	//anonymous inner class- as name specifies we are not going to give name, instead directly create an object for the interface
	//the class create will be ParentClass$1.class
	//we will use it in a constructor. Runnable is an interface and the object is created using new object.
	ParentClass() {
		Runnable objRunnable = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		Thread objThread = new Thread(objRunnable);
		objThread.start();
	}
	
	//static inner class
	//its similar to the normal inner class, instead it will use public static key work.
	//difference is we no need parent object to instantiate the static inner class, directly we can isntantiate.
	//class name will be ParentClass$ChildStaticInnerClass.class
	//It is used in builder design pattern
	public static class ChildStaticInnerClass {
		
	}
	
	//inner class inside a method
	//the instance variable or the parameter can be used inside the class, but cannot attempt to change the value
	//the variables are final or effectively final
	//the class name will be like ParentClass$1ChildInnerClassInsideMethod.class
	public void intantiateInnerClass(int abc) {
		class ChildInnerClassInsideMethod {
//			abc++;
		}
		ChildInnerClassInsideMethod objChildInnerClassInsideMethod = new ChildInnerClassInsideMethod();
	}

	public static void main(String[] args) {
		
		//ways to instantiate the normal inner class
		ParentClass objParentClass = new ParentClass();
		NormalInnerClass objNormalInnerClass = objParentClass.new NormalInnerClass();
		
		//ways to instantiate the static inner class
		ChildStaticInnerClass objChildStaticInnerClass = new ChildStaticInnerClass();
	}

}
