/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.dao.AdminDao;
import com.flipkart.dao.AdminDaoImpl;

/**
 * @author bhawesh
 *
 */
public class AdminServiceImpl implements AdminService {

	AdminDao adminDao = new AdminDaoImpl();
	boolean status;
	
	/*
	 * (non-Javadoc)
	 * @see com.flipkart.business.AdminService#addUser(com.flipkart.bean.User)
	 * This method adds user and returns true on successful addition and false on failure.
	 */
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		status = adminDao.addUser(user);
		return status;
	}
	/*
	 * (non-Javadoc)
	 * @see com.flipkart.business.AdminService#deleteUser(java.lang.String)
	 * This method deletes user and returns true on successful deletion and false on failure.
	 */
	@Override
	public boolean deleteUser(String userName) {
		// TODO Auto-generated method stub
		status = adminDao.deleteUser(userName);
		return status;
	}
	/*
	 * (non-Javadoc)
	 * @see com.flipkart.business.AdminService#updateUser(com.flipkart.bean.User, int)
	 * This method updates user and returns true on successful updation and false on failure.
	 */
	@Override
	public boolean updateUser(User user, int updateChoice) {
		// TODO Auto-generated method stub
		status = adminDao.updateUser(user,updateChoice);
		return status;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.flipkart.business.AdminService#getAdmin(java.lang.String)
	 * This method returns an admin object with respective userName.
	 */
	@Override
	public Admin getAdmin(String userName) {
		// TODO Auto-generated method stub
		AdminDao adminDao = new AdminDaoImpl();
		Admin admin = adminDao.getAdmin(userName);
		return admin;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.flipkart.business.AdminService#addCourse(com.flipkart.bean.Course)
	 * This method adds a new course and returns true on successful addition and false on failure.
	 */
	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		status = adminDao.addCourse(course);
		return status;
	}

	/*
	 * (non-Javadoc)
	 * @see com.flipkart.business.AdminService#deleteCourse(int)
	 * This method deletes course and returns true on successful deletion and false on failure.
	 */
	@Override
	public boolean deleteCourse(int courseID) {
		// TODO Auto-generated method stub
		boolean status = adminDao.deleteCourse(courseID);
		return status;
	}

	/*
	 * (non-Javadoc)
	 * @see com.flipkart.business.AdminService#assignCourseToProfessor(int, int)
	 * This method assigns course to professor and returns true on successful assignation and false on failure.
	 */
	@Override
	public boolean assignCourseToProfessor(int courseID, int professorID) {
		// TODO Auto-generated method stub
		status = adminDao.assignCourseToProfessor(courseID, professorID);
		return status;
	}

	@Override
	public boolean approveUserRegistration(String userName) {
		// TODO Auto-generated method stub
		status = adminDao.approveUserRegistration(userName);
		return status;
	}


	

	
}
