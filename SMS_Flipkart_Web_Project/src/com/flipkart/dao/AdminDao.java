package com.flipkart.dao;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.User;

public interface AdminDao {
	public boolean addUser(User user);
	public boolean deleteUser(String userName);
	public boolean updateUser(User user, int updateChoice);
	public Admin getAdmin(String userName);
	public boolean addCourse(Course course);
	public boolean deleteCourse(int courseID);
	public boolean assignCourseToProfessor(int courseID, int professorID);
	public boolean approveUserRegistration(String userName);
}
