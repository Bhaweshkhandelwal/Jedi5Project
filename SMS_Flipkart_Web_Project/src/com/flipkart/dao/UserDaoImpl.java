package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.exception.UserNameNotAvailableException;
import com.flipkart.utils.DBUtils;

import org.apache.log4j.Logger;

public class UserDaoImpl implements UserDao{

	private static Logger logger = Logger.getLogger(UserDaoImpl.class);
	Connection connection = DBUtils.getConnection();
	
	
	@Override
	public ArrayList<Course> viewCourses() {
		// TODO Auto-generated method stub
		
		ArrayList<Course> courseList = new ArrayList<Course>();
		
		PreparedStatement stmt = null;
		try{
			stmt = connection.prepareStatement(SQLQueriesConstants.VIEW_COURSE_LIST_QUERRY);
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				Course course = new Course();
				course.setCourseID(result.getInt("courseID"));
				course.setCourseDescription(result.getString("courseDescription"));
				course.setCourseName(result.getString("courseName"));
				courseList.add(course);
			}
			stmt.executeQuery();
		}catch(SQLException ex){
			logger.error(ex.getMessage());
		}catch(Exception ex)
		{
			logger.error(ex.getMessage());
		}
		return courseList;
	}


	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
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
			stmt.setInt(2, 0);
			stmt.executeUpdate();
			return true;
		}catch(UserNameNotAvailableException ex){
			logger.error(ex.getMessage());
		}
		catch(SQLException ex){
			logger.error(ex.getMessage());
		}catch(Exception ex)
		{
			logger.error(ex.getMessage());
		}
		return false;
	}
	
	
	
	

}
