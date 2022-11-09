package com.youthfulGlass.usecases;

import java.util.Scanner;

import com.youthfulGlass.dao.CourseDao;
import com.youthfulGlass.dao.CourseDaoImpl;
import com.youthfulGlass.exception.CourseException;

public class DeleteTheCourseData {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter the course ID: ");
		int course_id = sc.nextInt();
		
		CourseDao courseDao = new CourseDaoImpl();
		
		try {
			String message = courseDao.deleteCourse(course_id);
			System.out.println(message);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
}
