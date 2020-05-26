package com.java.main;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.java.annotationTypes.MarkerAnnotation;
import com.java.annotationTypes.MultiValuesAnnotation;
import com.java.annotationTypes.SingleValueAnnotation;
import com.java.model.Employee;

public class TestCustomAnnotations {

	public static void main(String[] args) {
		testSingleValueAnnotation();
		testMuliValuesAnnotation();
		testMarkerAnnotation();

	}
	
	 static int testSingleValueAnnotation(){
		Employee emp = new Employee();
		SingleValueAnnotation sva = null;
		try {
			Method m = emp.getClass().getMethod("setTotalEmployees");
			sva = m.getAnnotation(SingleValueAnnotation.class);
			System.out.printf("total no of employess : %d%n", sva.value());
			
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return (sva != null) ? sva.value() :  0;
	}
	 
	static void testMuliValuesAnnotation() {
		Class<Employee> empClass = Employee.class;
		MultiValuesAnnotation mva = null;
		try {
			if(empClass.isAnnotationPresent(MultiValuesAnnotation.class)) {
				Annotation annotation = empClass.getAnnotation(MultiValuesAnnotation.class);
				mva = (MultiValuesAnnotation) annotation;
				System.out.printf("employee name is %s%n", mva.name());
				System.out.printf("employee age is  %s%n", mva.age());
				System.out.printf("employee is at  %s position %n", mva.position());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@MarkerAnnotation
	public static void testMarkerAnnotation() {
		TestCustomAnnotations custAnn = new TestCustomAnnotations();
		try {
			Method mt = custAnn.getClass().getMethod("testMarkerAnnotation");
			System.out.println(mt.isAnnotationPresent(MarkerAnnotation.class));
			if(mt.isAnnotationPresent(MarkerAnnotation.class)) {
				System.out.printf("%s%n", "Custom Marker annotation present");
			}
		} catch (NoSuchMethodException | SecurityException e1) {
			e1.printStackTrace();
		}
	}
	
}
