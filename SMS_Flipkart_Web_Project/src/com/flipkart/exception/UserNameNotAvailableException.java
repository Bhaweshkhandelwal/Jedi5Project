/**
 * 
 */
package com.flipkart.exception;

/**
 * @author bhawesh
 *
 */
public class UserNameNotAvailableException extends Exception {
	
	public String getMessage(){
		
		return  "  The userName that you entered is not available. Choose another userName.";
	}
}
