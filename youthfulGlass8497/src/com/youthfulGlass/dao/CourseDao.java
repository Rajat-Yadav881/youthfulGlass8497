package com.youthfulGlass.dao;

import com.youthfulGlass.exception.CourseException;
import com.youthfulGlass.model.Course;

public interface CourseDao {

	public String addCourse(Course course) throws CourseException;
	
	public String updateFee(int course_id,int course_fee)throws CourseException;
	
	public String deleteCourse(int course_id)throws CourseException;
	
	public Course getDetailsCourse(int course_id)throws CourseException;
	
	
}
