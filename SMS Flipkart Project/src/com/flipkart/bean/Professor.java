package com.flipkart.bean;

public class Professor extends User{
	public int professorID;
	public String department;

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the professorID
	 */
	public int getProfessorID() {
		return professorID;
	}

	/**
	 * @param professorID the professorID to set
	 */
	public void setProfessorID(int professorID) {
		this.professorID = professorID;
	}
}
