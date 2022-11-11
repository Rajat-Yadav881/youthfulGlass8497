package com.youthfulGlass.usecases;

import java.util.List;

import com.youthfulGlass.dao.StudentDao;
import com.youthfulGlass.dao.StudentDaoImpl;
import com.youthfulGlass.exception.CourseException;
import com.youthfulGlass.exception.StudentException;
import com.youthfulGlass.model.Course;

public class GetAllCourses {
	public static void main(String[] args) {
		
		StudentDao dao = new StudentDaoImpl();
//		 try {
			List<Course> arr;
			try {
				arr = dao.getAllCourses();
				arr.forEach(s -> System.out.println(s));
			} catch (CourseException|StudentException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			
			
			
			
			
//		} catch (StudentException e) {
//			// TODO Auto-generated catch block
//			e.getMessage();
//		}	
		
	}
}
