package com.youthfulGlass.utility;

import java.sql.Connection;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.youthfulGlass.usecases.AdminLogin;
//import com.youthfulGlass.usecases.AllocateStudentUnderCourse;
//import com.youthfulGlass.usecases.BatchUnderCourse;
//import com.youthfulGlass.usecases.CourseDetails;
//import com.youthfulGlass.usecases.DeleteTheCourseData;
//import com.youthfulGlass.usecases.UpdateSeats;
//import com.youthfulGlass.usecases.UpdateTheFee;
//import com.youthfulGlass.usecases.GetAllStudents;
//import com.youthfulGlass.usecases.SetTheCourse;
import com.youthfulGlass.usecases.GetAllCourses;
import com.youthfulGlass.usecases.LoginStudent;
import com.youthfulGlass.usecases.SetStudentDetails;
import com.youthfulGlass.usecases.UpdateDetailsByUser;


public class Main {
	
//	static {
//		System.out.println("Welcome to here!");
//	}
		
	public static synchronized  void main(String[] args) {
		 new Thread(new Runnable() {
	            @Override
	            public void run() {
	                master();               
	            }
	        }).start();
	        System.out.println("Welcome to the Automated Student Ragisteration System");
	        try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		
		@SuppressWarnings("unused")
		Connection conn1 = DBAUtility.provideConnection();
		boolean mainBool = true;
		while(mainBool) {
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-");
			System.out.println();
			System.out.println("Select Adim/Student");
			System.out.println("-----------------------");
			System.out.println("1.Admin");
			System.out.println("2.Student");
			System.out.println("3.Exit");
			System.out.println("-----------------------");
			System.out.println();
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-");
			int choice = sc1.nextInt();
				switch (choice) {
				case 1: {
					AdminLogin.main(null);				
					break;
				}
				case 2: {
					System.out.println("========================");
					System.out.println("1.Register new Student");
					System.out.println("2.Login registered Student");
					System.out.println("========================");
					int choice301 = sc1.nextInt();
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
						default:
							System.out.println("Unexpected value: " + choice311);
							break;
						}
						break;
					}
					default:
						System.out.println("Unexpected value: " + choice301);
						break;
					}
					break;
				}
				case 3: {
					mainBool = false;
					break;		
				}
				default:
					System.out.println("Unexpected value: " + choice);
					break;
				}

		}
				
	}
	public static synchronized void master() {
		System.out.println("Thankyou for visiting...");
	}
}
