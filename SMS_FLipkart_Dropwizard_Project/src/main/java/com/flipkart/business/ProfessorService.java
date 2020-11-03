package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public interface ProfessorService {
	
	public Course viewCourse(int courseID);
	public ArrayList< Student > viewStudentList(int courseID);
	public boolean recordGrade(int courseID, int studentID, int grade);
	public Professor getProfessor(String userName);
	
}
