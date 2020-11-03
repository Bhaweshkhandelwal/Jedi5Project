package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

public class StudentDaoImpl implements StudentDao {

	private static Logger logger = Logger.getLogger(StudentDaoImpl.class);
	Connection connection = DBUtils.getConnection(); 
	
	@Override
	public boolean selectCourse(int studentID, int courseID) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		try{
			stmt = connection.prepareStatement(SQLQueriesConstants.SELECT_COURSE_QUERRY);
			stmt.setInt(1, studentID);
			stmt.setInt(2, courseID);
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
	public boolean dropCourse(int studentID, int courseID) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		try{
			stmt = connection.prepareStatement(SQLQueriesConstants.DROP_COURSE_QUERRY);
			stmt.setInt(1, studentID);
			stmt.setInt(2, courseID);
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
	public ArrayList<Grade> viewGrades(int studentID) {
		// TODO Auto-generated method stub
		ArrayList<Grade> grades = new ArrayList<Grade>();
		PreparedStatement stmt = null;
		try{
			stmt = connection.prepareStatement(SQLQueriesConstants.VIEW_GRADE_QUERRY);
			stmt.setInt(1, studentID);
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				Grade grade = new Grade();
				grade.setCourseID(result.getInt("courseID"));
				grade.setGrade(result.getInt("grade"));
				grade.setStudentID(studentID);
				grades.add(grade);
			}
		}catch(SQLException ex){
			logger.error(ex.getMessage());
		}catch(Exception ex)
		{
			logger.error(ex.getMessage());
		}
		
		return grades;
	}

	@Override
	public Student getStudent(String userName) {
		PreparedStatement stmt = null;
		Student student = null;
		try{
			stmt = connection.prepareStatement(SQLQueriesConstants.GET_STUDENT_QUERY);
			stmt.setString(1, userName);
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				student = new Student();
				student.setDepartment(result.getString("department"));
				student.setSemester(result.getInt("semester"));
				student.setStudentID(result.getInt("studentID"));
			}
		}catch(SQLException ex){
			logger.error(ex.getMessage());
		}catch(Exception ex)
		{
			logger.error(ex.getMessage());
		}
		return student;
	}

}
