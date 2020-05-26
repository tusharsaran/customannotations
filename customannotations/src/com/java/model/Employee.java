package com.java.model;

import com.java.annotationTypes.MultiValuesAnnotation;
import com.java.annotationTypes.SingleValueAnnotation;
import com.java.annotationTypes.MultiValuesAnnotation.Position;

@MultiValuesAnnotation(name = "Aaru", age = 2, position = Position.SENIOR)
public class Employee {

	@SingleValueAnnotation
	public void setTotalEmployees() {
		System.out.println("total employees count");
	}
	
	
	public void setEmployeeDetails() {
		
	}
}
