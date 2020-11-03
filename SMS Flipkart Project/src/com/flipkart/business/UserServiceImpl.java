package com.flipkart.business;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.dao.UserDao;
import com.flipkart.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
	
	
	UserDao userDao = new UserDaoImpl();
	
	

	@Override
	public ArrayList<Course> viewCourses() {
		ArrayList<Course> courseList = userDao.viewCourses();
		return courseList;
	}



	@Override
	public boolean registerUser(User user) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		boolean result = userDao.registerUser(user);
		return result;
	}

	


	
}
