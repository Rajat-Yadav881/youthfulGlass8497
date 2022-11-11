package com.youthfulGlass.usecases;

import java.util.List;
import java.util.Scanner;

import com.youthfulGlass.dao.CourseDao;
import com.youthfulGlass.dao.CourseDaoImpl;
import com.youthfulGlass.model.BatchStudent;

public class GetAllStudents {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("View Student of Every Batch");
		
		System.out.print("Enter the course_name: ");
		String course_name = sc.next();
	
		
		
		
		CourseDao courseDao = new CourseDaoImpl();
		List<BatchStudent> arr = courseDao.getAllStudentUnderCourse(course_name);
		
		arr.forEach(s -> System.out.println(s));
		
	}
}
