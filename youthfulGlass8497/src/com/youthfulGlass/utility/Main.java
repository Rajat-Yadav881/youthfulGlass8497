package com.youthfulGlass.utility;

import java.sql.Connection;
import java.util.Scanner;

import com.youthfulGlass.usecases.GetAllCourses;
import com.youthfulGlass.usecases.LoginStudent;
import com.youthfulGlass.usecases.SetStudentDetails;
import com.youthfulGlass.usecases.UpdateDetailsByUser;

public class Main {
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Connection conn = DBAUtility.provideConnection();
		
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println();
		System.out.println("Select Adim/Student");
		System.out.println("-----------------------");
		System.out.println("1.Admin");
		System.out.println("2.Student");
		System.out.println("-----------------------");
		System.out.println();
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-");
		
		
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1: {
			break;		
		}
		case 2: {
			System.out.println("========================");
			System.out.println("1.Register new Student");
			System.out.println("2.Login registered Student");
			System.out.println("========================");
			int choice301 = sc.nextInt();
			switch (choice301) {
			case 1: {
				SetStudentDetails.main(null);
				break;
			}
			case 2: {
				LoginStudent.main(null);
				System.out.println("========================");
				System.out.println("1.Update the details of logged Student");
				System.out.println("2.All information of All the Courses");
				System.out.println("========================");
				
				int choice311 = sc.nextInt();
				switch (choice311) {
				case 1: {
					UpdateDetailsByUser.main(null);
					break;
				}
				case 2: {
					GetAllCourses.main(null);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice311);
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice301);
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
				
	}
}
