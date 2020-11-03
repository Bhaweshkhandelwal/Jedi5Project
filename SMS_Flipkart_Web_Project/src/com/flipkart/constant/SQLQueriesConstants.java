package com.flipkart.constant;

public class SQLQueriesConstants {
	
	//Admin queries
	public static final String DELETE_USER_QUERRY = "DELETE from user where userName = ?";
	public static final String CHECK_USERNAME_QUERY = "SELECT COUNT(*) from login WHERE userName = ?";
	public static final String ADD_NEW_USER_QUERRY = "INSERT into user(userName,role,emailAddress,firstName,lastName) values (?,?,?,?,?)";
	public static final String ADD_NEW_USER_LOGIN_QUERRY = "INSERT into login(userName,isApproved) values(?,?)";
	public static final String UPDATE_USER_EMAIL_ADDRESS_QUERRY = "UPDATE user SET emailAddress = ? WHERE userName = ?";
	public static final String UPDATE_USER_FIRSTNAME_QUERRY ="UPDATE user SET firstName = ? WHERE userName = ?" ;
	public static final String UPDATE_USER_LASTNAME_QUERRY = "UPDATE user SET lastName = ? WHERE userName = ?";
	public static final String VIEW_ADMIN_QUERY = "SELECT * from user u INNER JOIN admin a ON u.userName = a.userName WHERE u.userName = ?";
	public static final String ADD_COURSE_QUERY = "INSERT into course(courseName, courseID, courseDescription) values (?,?,?)";
	public static final String DELETE_COURSE_QUERY = "DELETE from course WHERE courseID = ? ";
	public static final String ASSIGN_COURSE_TO_PROFESSOR_QUERY = "INSERT into professor_course(courseID,professorID) values(?,?)";
	public static final String APPROVE_USER_REGISTRATION = "UPDATE login SET isApproved = 1 WHERE userName = ?";
	
	
	//User queries
	public static final String VIEW_COURSE_LIST_QUERRY = "SELECT courseName,courseID,courseDescription from course";
	
	
	//Student queries
	public static final String SELECT_COURSE_QUERRY = "INSERT into student_course(studentID,courseID) values (?,?)";
	public static final String DROP_COURSE_QUERRY = "DELETE from student_course WHERE studentID = ? AND courseID = ?";
	public static final String VIEW_GRADE_QUERRY = "SELECT courseID,grade from student_course where studentID = ?";
	
	//Professor queries
	public static final String VIEW_STUDENT_LIST_QUERRY = "SELECT * from (student_course sc INNER JOIN student s ON s.studentID = sc.studentID INNER JOIN user u ON u.userName = s.userName) WHERE courseID = ? ";
	public static final String RECORD_GRADE_QUERRY = "UPDATE student_course SET grade = ? WHERE studentID = ? AND courseID = ?";
	public static final String VIEW_COURSE_QUERRY = "SELECT * from course where courseID = ? LIMIT 1";
	public static final String VIEW_PROFESSOR_QUERY = "SELECT * from user u INNER JOIN professor p ON u.userName = p.userName WHERE u.userName = ?";
	
	//Authentication queries
	public static final String CHECK_USER_CREDENTIALS_QUERY = "SELECT * from login where userName = ? AND password = ? LIMIT 1";
	public static final String GET_USER_DETAILS = "SELECT * from user WHERE userName = ? LIMIT 1";
	public static final String GET_STUDENT_QUERY = "SELECT * from student WHERE userName = ?";

	


	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
