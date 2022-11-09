package com.youthfulGlass.usecases;

import java.util.Scanner;

import com.youthfulGlass.dao.CourseDao;
import com.youthfulGlass.dao.CourseDaoImpl;
import com.youthfulGlass.exception.CourseException;
import com.youthfulGlass.model.Course;

public class CourseDetails {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter the course ID: ");
		int course_id = sc.nextInt();
		
		CourseDao dao = new CourseDaoImpl();
		
		try {
			Course course =  dao.getDetailsCourse(course_id);
			System.out.println("course name is "+course.getCourse_name());
			System.out.println("total seats available in the course are "+course.getTotal_seat());
			System.out.println("remaining seats available in the course are "+course.getremaining_seats());
			System.out.println("the fees of the course is "+course.getCoursefee()+" rupees");
			System.out.println("for registering in this "+course.getCourse_name()+" the token/ID number is "+course.getCourse_id());
			
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
