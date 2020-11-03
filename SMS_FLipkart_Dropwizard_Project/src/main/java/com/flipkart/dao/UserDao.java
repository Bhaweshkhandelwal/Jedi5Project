package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;

public interface UserDao {
	public ArrayList<Course> viewCourses(); 
	public boolean registerUser(User user);
}
