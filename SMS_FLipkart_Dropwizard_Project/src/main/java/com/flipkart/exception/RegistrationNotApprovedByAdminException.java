/**
 * 
 */
package com.flipkart.exception;

/**
 * @author bhawesh
 *
 */
public class RegistrationNotApprovedByAdminException extends Exception{
	
	public String getMessage(){
			
			return  "    Your registration has not been approved by the admin. You will be able to login once your registration is approved.";
		}
}
