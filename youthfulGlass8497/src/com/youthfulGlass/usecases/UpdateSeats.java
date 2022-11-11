package com.youthfulGlass.usecases;

import java.util.Scanner;

import com.youthfulGlass.dao.CourseDao;
import com.youthfulGlass.dao.CourseDaoImpl;
import com.youthfulGlass.exception.CourseException;

public class UpdateSeats {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the course ID: ");
		int course_id = sc.nextInt();
		
		System.out.print("Enter the remaining_seats : ");
		int remaining_seats  = sc.nextInt();
		
		CourseDao courseDao = new CourseDaoImpl();
		
		try {
			String message = courseDao.updateSeats(course_id, remaining_seats);
			System.out.println(message);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
