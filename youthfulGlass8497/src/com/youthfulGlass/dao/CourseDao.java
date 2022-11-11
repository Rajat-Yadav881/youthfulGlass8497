package com.youthfulGlass.dao;

import java.util.List;

import com.youthfulGlass.exception.BatchException;
import com.youthfulGlass.exception.CourseException;
import com.youthfulGlass.exception.StudentException;
import com.youthfulGlass.model.BatchStudent;
import com.youthfulGlass.model.Course;
import com.youthfulGlass.model.Student;

public interface CourseDao {

	public String addCourse(Course course) throws CourseException;
	
	public String updateFee(int course_id,int course_fee)throws CourseException;
	
	public String deleteCourse(int course_id)throws CourseException;
	
	public Course getDetailsCourse(int course_id)throws CourseException;
	
	public String createBatchUnderCourse(Student student,int course_id,String course_name)throws CourseException;
	
	public String allocateStudent(int student_id,String course_name ) throws StudentException , BatchException;
	
	public String updateSeats(int course_id,int remaining_seats) throws CourseException;
	
	public List<BatchStudent> getAllStudentUnderCourse(String course_name);
	
	
}
