package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;

public interface StudentDao {
	public boolean selectCourse(int studentID, int courseID);
	public boolean dropCourse(int studentID, int courseID);
	public ArrayList<Grade> viewGrades(int studentID);
	public Student getStudent(String userName);
}
