/**
 * 
 */
package com.flipkart.app;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.business.AdminService;
import com.flipkart.business.AdminServiceImpl;
import com.flipkart.business.AuthenticationService;
import com.flipkart.business.AuthenticationServiceImpl;
import com.flipkart.business.ProfessorService;
import com.flipkart.business.ProfessorServiceImpl;
import com.flipkart.business.StudentService;
import com.flipkart.business.StudentServiceImpl;
import com.flipkart.business.UserService;
import com.flipkart.business.UserServiceImpl;
import com.flipkart.exception.UserNotFoundException;

/**
 * @author bhawesh
 *
 */
public class SMSApplicationClient {

	/**
	 * @param args
	 */
	
	static Logger logger = Logger.getLogger(SMSApplicationClient.class);
	
	/*
	 * method to show choices to new user
	 */
	public static void showChoices()
	{
		logger.info("Enter your choice: ");
		logger.info("0 :- Exit ");
		logger.info("1 :- Login User ");
		logger.info("2 :- Register User ");
		
	}
	
	/*
	 * method to show choices to admin
	 */
	public static void showAdminChoices()
	{
		logger.info("Enter your choice: ");
		logger.info("0 :- Logout");
		logger.info("1 :- Add User");
		logger.info("2 :- Delete User");
		logger.info("3 :- Update User");
		logger.info("4 :- View Courses");
		logger.info("5 :- Add Course");
		logger.info("6 :- Delete Course");
		logger.info("7 :- Assign Course to Professor");
		logger.info("8 :- Approve User Registration");
	}
	
	
	/*
	 * method to show choices to update user properties .
	 */
	public static void showUpdateUserChoices()
	{
		logger.info("What do you want to update ?");
		logger.info("1 :- emailAddress");
		logger.info("2 :- firstName");
		logger.info("3 :- lastName");
		
	}
	
	
	/*
	 * method to show choices to student .
	 */
	public static void showStudentChoices()
	{
		logger.info("Enter your choice : ");
		logger.info("0 :- Logout");
		logger.info("1 :- Select Course");
		logger.info("2 :- Drop Course");
		logger.info("3 :- View Grades");
	}
	
	/*
	 * method to show choices to professor
	 */
	public static void showProfessorChoices()
	{
		logger.info("Enter your choice : ");
		logger.info("0 :- Logout");
		logger.info("1 :- Record Grade");
		logger.info("2 :- View Student List");
		logger.info("3 :- View Course");
	}
	
	/*
	 * method to show choices for different role options
	 */
	public static void showRoleOptions()
	{
		logger.info("1 :- Admin");
		logger.info("2 :- Student");
		logger.info("3 :- Professor");
	}
	
	
	
	public static void main(String[] args) throws UserNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		SMSApplicationClient  smsApplicationClient = new SMSApplicationClient();
		
		// All interface reference objects are here.
		AuthenticationService authenticationService = new AuthenticationServiceImpl();
		UserService userService = new UserServiceImpl();
		AdminService adminService = new AdminServiceImpl();
		StudentService studentService = new StudentServiceImpl();
		ProfessorService professorService = new ProfessorServiceImpl();
		
		// Objects of all bean classes are declared here
		User user = new User();
		Course course = new Course();
		
		// All variables are declared here 
		int studentID, courseID, grade;
		String userName;
		boolean status;
		
		
		int choice = -1;
		do{
			showChoices();
			choice = scan.nextInt();
			switch(choice){
			case 0:
				break;
			case 1:
				logger.info("Enter the userName: ");
				userName = scan.next();
				logger.info("Enter the password: ");
				String password = scan.next();
				
				user = authenticationService.login(userName, password);
				if(user == null)
				{
					break;
				}
				else
				{
					
					int userRole = user.getRole();
					switch(userRole){
					case 1: //for admin
						
						Admin admin = adminService.getAdmin(userName);
						int adminChoice = -1;
						do{
							showAdminChoices();
							adminChoice = scan.nextInt();
							switch(adminChoice){
							case 0://logout
								logger.info("Successfully logged out .");
								authenticationService.logout();
								break;
							case 1://addUser
								User user1 = new User();
								logger.info("Enter the userName: ");
								user1.setUserName(scan.next());;
								logger.info("Enter the role: ");
								showRoleOptions();
								user1.setUserID(scan.nextInt());
								logger.info("Enter the First Name: ");
								user1.setFirstName(scan.next());
								logger.info("Enter the Last Name: ");
								user1.setLastName(scan.next());
								logger.info("Enter the email address: ");
								user1.setEmailAddress(scan.next());
								status = adminService.addUser(user1);
								if(status == false){
									logger.info("User courld not be added");
								}else{
									logger.info("User added successfully !!!");
								}
								break;
							case 2://deleteUser
								logger.info("Enter the userName: ");
								status = adminService.deleteUser(scan.next());
								if(status == true ){
									logger.info("User deleted successfully !!!.");
								}else{
									logger.info("User could not be deleted");
								}
							
								break;
							case 3://updateUser
								logger.info("Enter the userName: ");
								user.setUserName(scan.next());
								showUpdateUserChoices();
								int updateChoice = scan.nextInt();
								switch(updateChoice){
								case 1:
									logger.info("Enter new emailAddress: ");
									user.setEmailAddress(scan.next());
									break;
								case 2 :
									logger.info("Enter new firstName: ");
									user.setFirstName((scan.next()));
									break;
								case 3 :
									logger.info("Enter new lastName: ");
									user.setLastName(scan.next());
									break;
								}
								status = adminService.updateUser(user, updateChoice);
								if(status == true)
								{
									logger.info("User updated successfully.");
								}else
								{
									logger.info("Updation failed");
								}
								break;
							case 4://viewCourses
								ArrayList<Course> courseList = userService.viewCourses();
								if(courseList.size() == 0){
									logger.info("No courses are present.");
								}
								for(Course course1 : courseList){
									logger.info("courseID: " + course1.getCourseID() + "\t" + "courseName: " + course1.getCourseName() + "\t" + "courseDescription: " + course1.getCourseDescription());
								}
								break;
							case 5://addCourse
								logger.info("Enter the course name : ");
								course.setCourseName(scan.next());
								logger.info("Enter the course description : ");
								course.setCourseDescription(scan.next());
								logger.info("Enter the courseID : ");
								course.setCourseID(scan.nextInt());
								status = adminService.addCourse(course);
								if(status == true)
								{
									logger.info("Course added successfully.");
								}else
								{
									logger.info("Course could not be added.");
								}
								break;
							case 6://deleteCourse
								logger.info("Enter the courseID: ");
								courseID = scan.nextInt();
								status = adminService.deleteCourse(courseID);
								if(status == true)
								{
									logger.info("Course deleted successfully.");
								}else
								{
									logger.info("Course could not be deleted.");
								}
								break;
							case 7://assignCourseToProfessor
								logger.info("Enter the courseID: ");
								courseID =  scan.nextInt();
								logger.info("Enter the professorID: ");
								int professorID = scan.nextInt();
								status = adminService.assignCourseToProfessor(courseID, professorID);
								if(status == true)
								{
									logger.info("Course with courseID : " + courseID + " has been successfully assigned to professor with professorID: " + professorID);
								}else
								{
									logger.info("Course could not be assigned.");
								}
								break;
							case 8://approveUserRegistration
								logger.info("Enter the userName: ");
								userName = scan.next();
								status = adminService.approveUserRegistration(userName);
								if(status == true)
								{
									logger.info("Reguistration of user with userName : " + userName + "has been approved.");
								}else
								{
									logger.info("Registration could not be approved.");
								}
								break;
							}
						}while(adminChoice != 0);
						break;
						
						
					case 2: //for student
							
							Student student = studentService.getStudent(userName);
							int studentChoice = -1;
							boolean result ;
							do{
								showStudentChoices();
								studentChoice = scan.nextInt();
								switch(studentChoice){
								case 0: 
									break;
								case 1:
									logger.info("Enter the courseID : ");
									courseID = scan.nextInt();
									status = studentService.selectCourse(student.getStudentID(), courseID);
									if(status == true){
										logger.info("Course with courseID: " + courseID + " is successfully selected." );
									}
									else
									{
										logger.info("Course with courseID: " + courseID + " could not be selected" );
									}
									break;
								case 2:
									logger.info("Enter the courseID : ");
									courseID = scan.nextInt();
									status = studentService.dropCourse(student.getStudentID(), courseID);
									if(status == true){
										logger.info("Course with courseID: " + courseID + " is successfully dropped." );
									}
									else{
										logger.info("Course with courseID: " + courseID + " could not be dropped." );
									}
										
									break;
								case 3:
									ArrayList<Grade> grades = studentService.viewGrades(student.getStudentID());
									logger.info("courseID" + "\t" + "grade") ;
									
									for(Grade gradeEntry : grades)
									{
										logger.info(gradeEntry.getCourseID() + "\t\t" + gradeEntry.getGrade());
									}
									break;
								}
							}while(studentChoice != 0);
						break;
					case 3: //for professor
						
						Professor professor = professorService.getProfessor(userName);
						int professorChoice = -1;
						do{
							showProfessorChoices();
							professorChoice = scan.nextInt();
							switch(professorChoice){
							case 0:
								break;
							case 1://recordGrade
								logger.info("Enter the studentID: ");
								studentID = scan.nextInt();
								logger.info("Enter the courseID: ");
								courseID = scan.nextInt();
								logger.info("Enter the grade: ");
								grade = scan.nextInt();
								status= professorService.recordGrade(courseID, studentID, grade);
								if(status == true){
									logger.info("Grade recorded successfully." );
								}
								else
								{
									logger.info("Grade could not be recorded. " );
								}
								break;
							case 2:// viewStudentList
								logger.info("Enter the courseID: ");
								courseID = scan.nextInt();
								ArrayList<Student> studentList = professorService.viewStudentList(courseID);
								for(Student student1: studentList){
									logger.info("studentID " + "\t" + "Department" + "\t" + "Semester");
									logger.info(student1.getStudentID() + "\t\t" + student1.getDepartment() + "\t\t" + student1.getSemester());
								}
								break;
							case 3:// viewCourse
								logger.info("Enter the courseID: ");
								courseID = scan.nextInt();
								course = professorService.viewCourse(courseID);
								logger.info("courseID " + "\t" + "Course Name" + "\t" + "Course Descrition");
								logger.info(course.getCourseID() + "\t\t" + course.getCourseName() + "\t\t" + course.getCourseDescription());
								break;
							}
						}while(professorChoice != 0);
						
						break;
					}
				}
				break;
			case 2:
				
				logger.info("Enter the userName: ");
				user.setUserName(scan.next());
				logger.info("Enter the role: ");
				showRoleOptions();
				user.setUserID(scan.nextInt());
				logger.info("Enter the First Name: ");
				user.setFirstName(scan.next());
				logger.info("Enter the Last Name: ");
				user.setLastName(scan.next());
				logger.info("Enter the email address: ");
				user.setEmailAddress(scan.next());
				status = userService.registerUser(user);
				if(status){
					logger.info("Registration is successful!!!");
				}else{
					logger.info("Registration Failed!!!");
				}
				break;
			}
			
		}while(choice != 0);
				
		
		

}
}
