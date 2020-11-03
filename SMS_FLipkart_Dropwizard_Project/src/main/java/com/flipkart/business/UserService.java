package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;

public interface UserService {
	
	public ArrayList<Course> viewCourses(); 
	public boolean registerUser(User user);
}
