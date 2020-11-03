package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.ProfessorDao;
import com.flipkart.dao.ProfessorDaoImpl;

public class ProfessorServiceImpl implements  ProfessorService{

	ProfessorDao professorDao = new ProfessorDaoImpl();
	Professor professor = null;
	ArrayList< Student > studentList = null;
	Course course = null;
	/*
	 * (non-Javadoc)
	 * @see com.flipkart.business.ProfessorService#viewCourse(int)
	 * This method details of course with specific courseID.
	 */
	@Override
	public Course viewCourse(int courseID) {
		// TODO Auto-generated method stub
		course = professorDao.viewCourse(courseID);
		return course;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.flipkart.business.ProfessorService#viewStudentList(int)
	 * This method returns list of all students enrolled in course with specific courseID.
	 */
	@Override
	public ArrayList<Student> viewStudentList(int courseID) {
		// TODO Auto-generated method stub
		studentList = professorDao.viewStudentList(courseID);
		return studentList;
	}

	/*
	 * (non-Javadoc)
	 * @see com.flipkart.business.ProfessorService#recordGrade(int, int, int)
	 * This method records the grade of a specific student for specific course and returns true on success and false on failure.
	 */
	@Override
	public boolean recordGrade(int courseID, int studentID, int grade) {
		// TODO Auto-generated method stub
		
		boolean result = professorDao.recordGrade(courseID, studentID, grade);
		return result;
		
	}
	/*
	 * (non-Javadoc)
	 * @see com.flipkart.business.ProfessorService#getProfessor(java.lang.String)
	 * This method returns the professor object with specific userName.
	 */
	@Override
	public Professor getProfessor(String userName) {
		// TODO Auto-generated method stub
		professor = professorDao.getProfessor(userName);
		return professor;
	}
	
}
