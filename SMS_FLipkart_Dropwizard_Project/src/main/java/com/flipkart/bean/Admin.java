package com.flipkart.bean;

public class Admin extends User{
	
	int adminID;
	String adminDescription;
	
	/**
	 * @return the adminDescription
	 */
	public String getAdminDescription() {
		return adminDescription;
	}

	/**
	 * @param adminDescription the adminDescription to set
	 */
	public void setAdminDescription(String adminDescription) {
		this.adminDescription = adminDescription;
	}

	/**
	 * @return the adminID
	 */
	public int getAdminID() {
		return adminID;
	}

	/**
	 * @param adminID the adminID to set
	 */
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	
	
}
