/**
 * 
 */
package com.java8.lesson1runtimeannot;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
/**
 * @author dineshvkc-v
 * a runtime annotation with 1 variables.
 *
 */
public @interface SampleRunTimeAnnotationExample {
	
    int price();
    String desc();    
}
