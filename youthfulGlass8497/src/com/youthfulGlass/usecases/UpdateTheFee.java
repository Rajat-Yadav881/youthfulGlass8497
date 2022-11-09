package com.youthfulGlass.usecases;

import java.util.Scanner;

import com.youthfulGlass.dao.CourseDao;
import com.youthfulGlass.dao.CourseDaoImpl;
import com.youthfulGlass.exception.CourseException;


public class UpdateTheFee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter the course ID: ");
		int course_id = sc.nextInt();
		System.out.print("Enter the course fee: ");
		int coursefee = sc.nextInt();
		
		
		CourseDao dao = new CourseDaoImpl();
		try {
			String message = dao.updateFee(course_id, coursefee);
			System.out.println(message);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		
		
	}
}
