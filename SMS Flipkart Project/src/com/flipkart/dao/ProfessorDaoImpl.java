package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

public class ProfessorDaoImpl implements ProfessorDao {

	
	private static Logger logger = Logger.getLogger(AdminDaoImpl.class);
	Connection connection = DBUtils.getConnection(); 
	
	@Override
	public Course viewCourse(int courseID) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		Course course = null;
		try{
			stmt = connection.prepareStatement(SQLQueriesConstants.VIEW_COURSE_QUERRY);
			stmt.setInt(1, courseID);
			ResultSet result = stmt.executeQuery();
			while(result.next())
			{
				course = new Course();
				course.setCourseDescription(result.getString("courseDescription"));
				course.setCourseID(courseID);
				course.setCourseName(result.getString("courseName"));
			}
		}catch(SQLException ex){
			logger.error(ex.getMessage());
		}catch(Exception ex)
		{
			logger.error(ex.getMessage());
		}
		return course;
	}

	@Override
	public ArrayList<Student> viewStudentList(int courseID) {
		// TODO Auto-generated method stub
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		PreparedStatement stmt = null;
		try{
			stmt = connection.prepareStatement(SQLQueriesConstants.VIEW_STUDENT_LIST_QUERRY);
			stmt.setInt(1, courseID);
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				Student student = new Student();
				student.setDepartment(result.getString("department"));
				student.setStudentID(result.getInt("studentID"));
				student.setSemester(result.getInt("semester"));
				student.setUserName(result.getString("userName"));
				student.setEmailAddress(result.getString("emailAddress"));
				student.setFirstName(result.getString("firstName"));
				student.setLastName(result.getString("lastName"));
				student.setUserID(result.getInt("userID"));
				student.setRole(2);
				studentList.add(student);
			}
		}catch(SQLException ex){
			logger.error(ex.getMessage());
		}catch(Exception ex)
		{
			logger.error(ex.getMessage());
		}
		return studentList;
	}

	@Override
	public boolean recordGrade(int courseID, int studentID, int grade) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		
		try{
			stmt = connection.prepareStatement(SQLQueriesConstants.RECORD_GRADE_QUERRY);
			stmt.setInt(1, grade);
			stmt.setInt(2, studentID);
			stmt.setInt(3, courseID);
			stmt.executeUpdate();
			return true;
		}catch(SQLException ex){
			logger.error(ex.getMessage());
		}catch(Exception ex)
		{
			logger.error(ex.getMessage());
		}
		return false;
		
	}

	@Override
	public Professor getProfessor(String userName) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		Professor professor = null;
		try{
			stmt = connection.prepareStatement(SQLQueriesConstants.VIEW_PROFESSOR_QUERY);
			stmt.setString(1, userName);
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				professor = new Professor();
				professor.setDepartment(result.getString("department"));
				professor.setEmailAddress(result.getString("emailAddress"));
				professor.setFirstName(result.getString("firstName"));
				professor.setLastName(result.getString("lastName"));
				professor.setProfessorID(result.getInt("professorID"));
				professor.setRole(3);
				professor.setUserID(result.getInt("userID"));
				professor.setUserName(userName);
			}
		}catch(SQLException ex){
			logger.error(ex.getMessage());
		}catch(Exception ex)
		{
			logger.error(ex.getMessage());
		}
		return professor;
	}

}
