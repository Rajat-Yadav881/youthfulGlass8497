package com.youthfulGlass.usecases;

import java.util.Scanner;

public class StudentSetterLogin {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		boolean x = true;
		
		
		while(x) {	
			LoginStudent.main(null);
			System.out.println("========================");
			System.out.println("1.Update the details of logged Student");
			System.out.println("2.All information of All the Courses");
			System.out.println("3.Back");
			System.out.println("========================");
			
			int choice311 = sc1.nextInt();
			switch (choice311) {
			case 1: {
				UpdateDetailsByUser.main(null);
				break;
			}
			case 2: {
				GetAllCourses.main(null);
				break;
			}
			case 3 :{
				x = false;
				break;
			}
			default:
				System.out.println("Unexpected value: " + choice311);
				break;
			}
		}
		
	}
}
