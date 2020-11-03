/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;

/**
 * @author bhawesh
 *
 */
public interface StudentService {
	
	public boolean selectCourse(int studentID, int CourseID);
	public boolean dropCourse(int studentID, int courseID);
	public ArrayList<Grade> viewGrades(int studentID);
	public Student getStudent(String userName);
}
