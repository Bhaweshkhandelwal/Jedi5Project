package com.flipkart.exception;

public class CourseNotFoundException extends Exception{

	public String getMessage(){
			
			return  "    The course that you are looking for is not available. Please enter valid courseID.";
		}
}
