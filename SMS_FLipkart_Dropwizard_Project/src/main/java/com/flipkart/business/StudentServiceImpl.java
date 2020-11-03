/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.dao.StudentDao;
import com.flipkart.dao.StudentDaoImpl;

/**
 * @author bhawesh
 *
 */
public class StudentServiceImpl implements StudentService{

	StudentDao studentDao = new StudentDaoImpl();
	boolean result;
	
	/*
	 * (non-Javadoc)
	 * @see com.flipkart.business.StudentService#selectCourse(int, int)
	 * This method is for a student to enroll into a course and returns true on success and false on failure.
	 */
	@Override
	public boolean selectCourse(int studentID, int courseID) {
		// TODO Auto-generated method stub
		result = studentDao.selectCourse(studentID, courseID);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see com.flipkart.business.StudentService#dropCourse(int, int)
	 * This method is for a student to drop a course and returns true on success and false on failure.
	 */
	@Override
	public boolean dropCourse(int studentID, int courseID) {
		// TODO Auto-generated method stub
		result = studentDao.dropCourse(studentID, courseID);
		return result;
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.flipkart.business.StudentService#viewGrades(int)
	 * This method is for a student to view grade and returns grades of all courses in which a particular student is registered.
	 */
	@Override
	public ArrayList<Grade> viewGrades(int studentID) {
		// TODO Auto-generated method stub
		ArrayList<Grade> grades = studentDao.viewGrades(studentID);
		return grades;
	}

	/*
	 * (non-Javadoc)
	 * @see com.flipkart.business.StudentService#getStudent(java.lang.String)
	 * This method returns an object of type Student with a specific userName.
	 */
	@Override
	public Student getStudent(String userName) {
		// TODO Auto-generated method stub
		Student student = studentDao.getStudent(userName);
		return student;
	}
	
}
