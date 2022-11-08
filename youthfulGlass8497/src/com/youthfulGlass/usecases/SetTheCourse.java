package com.youthfulGlass.usecases;

import java.util.Scanner;

import com.youthfulGlass.dao.CourseDao;
import com.youthfulGlass.dao.CourseDaoImpl;
import com.youthfulGlass.exception.CourseException;
import com.youthfulGlass.model.Course;

public class SetTheCourse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter the course ID: ");
		int course_id = sc.nextInt();
		System.out.print("Enter the course name: ");
		String course_name = sc.next();
		System.out.print("Enter the total seat: ");
		int total_seat = sc.nextInt();
		System.out.print("Enter the course fees: ");
		int course_fee = sc.nextInt();
		System.out.print("Enter the remaning seat: ");
		int remaning_seat = sc.nextInt();
		
		Course course = new Course();
		course.setCourse_id(course_id);
		course.setCourse_name(course_name);
		course.setTotal_seat(total_seat);
		course.setCoursefee(course_fee);
		course.setremaining_seats(remaning_seat);
		
		CourseDao dao = new CourseDaoImpl();
		
		try {
			String result = dao.addCourse(course);
			System.out.println(result);
		} catch (CourseException e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
}
