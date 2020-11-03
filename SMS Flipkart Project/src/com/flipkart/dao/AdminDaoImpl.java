package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.exception.UserNameNotAvailableException;
import com.flipkart.utils.DBUtils;

public class AdminDaoImpl implements AdminDao {

	private static Logger logger = Logger.getLogger(AdminDaoImpl.class);
	Connection connection = DBUtils.getConnection(); 
	
	@Override
	public boolean addUser(User user) {
		PreparedStatement stmt = null;
		try{
			stmt = connection.prepareStatement(SQLQueriesConstants.CHECK_USERNAME_QUERY);
			stmt.setString(1, user.getUserName());
			ResultSet result = stmt.executeQuery();
			while(result.next())
			{
				if(result.getInt(1) > 0)
				{
					throw new UserNameNotAvailableException();
				}
			}
			stmt = connection.prepareStatement(SQLQueriesConstants.ADD_NEW_USER_QUERRY);
			stmt.setString(1, user.getUserName());
			stmt.setInt(2, user.getRole());
			stmt.setString(3,user.getEmailAddress());
			stmt.setString(4,user.getFirstName());
			stmt.setString(5,user.getLastName());
			stmt.executeUpdate();
			stmt = connection.prepareStatement(SQLQueriesConstants.ADD_NEW_USER_LOGIN_QUERRY);
			stmt.setString(1, user.getUserName());
			stmt.setInt(2, 1);
			stmt.executeUpdate();
			return true;
		}catch(UserNameNotAvailableException ex){
			logger.error("UserName not availaible"+ex.getMessage());
		}catch(SQLException ex){
			logger.error(ex.getMessage());
		}catch(Exception ex)
		{
			logger.error(ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteUser(String userName) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		try{
			stmt = connection.prepareStatement(SQLQueriesConstants.DELETE_USER_QUERRY);
			stmt.setString(1, userName);
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
	public boolean updateUser(User user, int updateChoice) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		try{
			if(updateChoice == 1){
				stmt = connection.prepareStatement(SQLQueriesConstants.UPDATE_USER_EMAIL_ADDRESS_QUERRY);
				stmt.setString(1, user.getEmailAddress());
				stmt.setString(2, user.getUserName());
				stmt.executeUpdate();
			}else if(updateChoice == 2){
				stmt = connection.prepareStatement(SQLQueriesConstants.UPDATE_USER_FIRSTNAME_QUERRY);
				stmt.setString(1, user.getFirstName());
				stmt.setString(2, user.getUserName());
				stmt.executeUpdate();
			}else{
				stmt = connection.prepareStatement(SQLQueriesConstants.UPDATE_USER_LASTNAME_QUERRY);
				stmt.setString(1, user.getLastName());
				stmt.setString(2, user.getUserName());
				stmt.executeUpdate();
			}
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
	public Admin getAdmin(String userName) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		Admin admin = null;
		try{
			stmt = connection.prepareStatement(SQLQueriesConstants.VIEW_ADMIN_QUERY);
			stmt.setString(1, userName);
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				admin = new Admin();
				admin.setAdminID(result.getInt("adminID"));
				admin.setAdminDescription(result.getString("adminDescription"));
				admin.setFirstName(result.getString("firstName"));
				admin.setLastName(result.getString("lastName"));
				admin.setEmailAddress(result.getString("emailAddress"));
				admin.setUserID(result.getInt("userID"));
				admin.setUserName(userName);
				admin.setRole(1);
			}
			return admin;
		}catch(SQLException ex){
			logger.error(ex.getMessage());
		}catch(Exception ex)
		{
			logger.error(ex.getMessage());
		}
		return null;
	}

	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		try{
			stmt = connection.prepareStatement(SQLQueriesConstants.ADD_COURSE_QUERY);
			stmt.setString(1, course.getCourseName());
			stmt.setInt(2, course.getCourseID());
			stmt.setString(3, course.getCourseDescription());
			int result = stmt.executeUpdate();
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
	public boolean deleteCourse(int courseID) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		try{
			stmt = connection.prepareStatement(SQLQueriesConstants.DELETE_COURSE_QUERY);
			stmt.setInt(1, courseID);
			int result = stmt.executeUpdate();
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
	public boolean assignCourseToProfessor(int courseID, int professorID) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		try{
			stmt = connection.prepareStatement(SQLQueriesConstants.ASSIGN_COURSE_TO_PROFESSOR_QUERY);
			stmt.setInt(1, courseID);
			stmt.setInt(2, professorID);
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
	public boolean approveUserRegistration(String userName) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		try{
			stmt = connection.prepareStatement(SQLQueriesConstants.APPROVE_USER_REGISTRATION);
			stmt.setString(1, userName);
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

	

}
