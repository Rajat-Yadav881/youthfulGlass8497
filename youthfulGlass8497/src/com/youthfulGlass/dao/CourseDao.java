package com.youthfulGlass.dao;

import com.youthfulGlass.exception.CourseException;
import com.youthfulGlass.model.Course;

public interface CourseDao {

	public String addCourse(Course course) throws CourseException;
	
	
}
