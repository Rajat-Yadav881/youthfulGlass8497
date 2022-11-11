package com.youthfulGlass.dao;

import java.util.List;

import com.youthfulGlass.exception.CourseException;
import com.youthfulGlass.exception.StudentException;
import com.youthfulGlass.model.Course;
import com.youthfulGlass.model.Student;

public interface StudentDao {
	
	public String setDetails(Student student)throws StudentException;
	
	public String loginStudent(String mail,String password)throws StudentException;
	
	public String UpdateDetails(Student student)throws StudentException;
	
	public List<Course> getAllCourses()throws StudentException,CourseException;
	
}
