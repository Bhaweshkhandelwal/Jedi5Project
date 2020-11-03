package com.flipkart.exception;

public class CourseCatalogNotFoundException extends Exception {
	
	/**
	 * 
	 */
public String getMessage(){
		
		return  "   CourseCatalog that you are looking for is not available. Enter valid catalogID.";
	}

}
