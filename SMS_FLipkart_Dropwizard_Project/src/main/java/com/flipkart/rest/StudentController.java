/**
 * 
 */
package com.flipkart.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Grade;
import com.flipkart.bean.Student;
import com.flipkart.business.StudentService;
import com.flipkart.business.StudentServiceImpl;

/**
 * @author bhawesh
 *
 */
@Path(value="/student")
public class StudentController {
	
	StudentService studentService = new StudentServiceImpl();
	
	
	@GET
	@Path("/viewGrades/{studentID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewGrades(@PathParam("studentID") int studentID)
	{
		
		 ArrayList<Grade> grades= studentService.viewGrades(studentID);
		 return Response.status(200).entity(grades).build();
	}
	
	
	@PUT
	@Path("/selectCourse")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCourse(Grade grade){
		
		
		boolean result = studentService.selectCourse(grade.getCourseID(), grade.getStudentID());
		if(result == true)
		{
			return Response.status(200).entity("Student with studentID: " + grade.getStudentID() + " has been successfully enrolled in course with courseID: "+ grade.getCourseID()).build();
		}
		else
		{
			return Response.status(200).entity("Student with studentID: " + grade.getStudentID() + " could not be enrolled in course with courseID: "+ grade.getCourseID()).build(); 
		}
		
	}
	
	
	@DELETE
	@Path("/dropCourse")
	@Consumes("application/json")
	public Response dropCourse(Grade grade){
		
		
		boolean result = studentService.dropCourse(grade.getStudentID(), grade.getCourseID());
		if(result == true)
		{
			return Response.status(200).entity("Student with studentID: " + grade.getStudentID() + " has  successfully dropped course with courseID: "+ grade.getCourseID()).build();
		}
		else
		{
			return Response.status(200).entity("Student with studentID: " + grade.getStudentID() + " could not drop course with courseID: "+ grade.getCourseID()).build(); 
		}
		
	}
	
	
}
