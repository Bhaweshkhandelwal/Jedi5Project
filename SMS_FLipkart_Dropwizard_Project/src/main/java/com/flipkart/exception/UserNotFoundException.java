package com.flipkart.exception;

public class UserNotFoundException extends Exception{
	
	public String getMessage(){
			
			return  "   The userName that you entered is not registered. Enter valid userName.";
		}
}
