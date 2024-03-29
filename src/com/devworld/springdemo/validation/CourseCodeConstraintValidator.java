package com.devworld.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements 
	ConstraintValidator<CourseCode, String> {
	
	public String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		System.out.println("coursePrefix: " + coursePrefix);
		System.out.println("Course Code: " + theCode);
		boolean result;
		if(theCode != null) {
			result = theCode.startsWith(coursePrefix);
		} else {
			result = true;
		}
		
		return result;
	}

}
