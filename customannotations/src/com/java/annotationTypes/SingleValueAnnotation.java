package com.java.annotationTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * Method should not have any throws clauses
 * Method should return one of the following: primitive data types, String, Class, enum or array of these data types.
 * Method should not have any parameter.
 * We should attach @ just before interface keyword to define annotation.
 * It may assign a default value to the method
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SingleValueAnnotation {
	
	int value() default 20;
	
}
