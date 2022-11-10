package com.youthfulGlass.utility;

import java.sql.Connection;
import java.util.Scanner;

import com.youthfulGlass.usecases.AllocateStudentUnderCourse;
import com.youthfulGlass.usecases.BatchUnderCourse;
import com.youthfulGlass.usecases.CourseDetails;
import com.youthfulGlass.usecases.DeleteTheCourseData;
import com.youthfulGlass.usecases.GetAllCourses;
import com.youthfulGlass.usecases.GetAllStudents;
import com.youthfulGlass.usecases.LoginStudent;
import com.youthfulGlass.usecases.SetStudentDetails;
import com.youthfulGlass.usecases.SetTheCourse;
import com.youthfulGlass.usecases.UpdateDetailsByUser;
import com.youthfulGlass.usecases.UpdateSeats;
import com.youthfulGlass.usecases.UpdateTheFee;

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
		System.out.println("3.Exit");
		System.out.println("-----------------------");
		System.out.println();
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-");
		int choice = sc.nextInt();
		
		while(choice!=3) {
			switch (choice) {
			case 1: {
				System.out.println("========================");
				
				System.out.println("1.Login registered Admin");
				System.out.println("2.Exit");
				System.out.println("========================");
				int choice101 = sc.nextInt();
				switch (choice101) {
				case 1: {
					String username = "myRoot";
					String password = "root";
					
					System.out.print("Enter the username: ");
					String username101  = sc.next();
					
					System.out.print("Enter the Password: ");
					String password101 = sc.next();
					
					if(username101 == username && password101 == password) {
						System.out.println("Login successfull...");
						System.out.println();
						System.out.println("========================");
						System.out.println("1.Add the course");
						System.out.println("2.Update the fees");
						System.out.println("3.Delete the course");
						System.out.println("4.Get the details of the course");
						System.out.println("5.Create Batch Under the course");
						System.out.println("6.Allocate Student");
						System.out.println("7.Update the Seats in the course");
						System.out.println("8.Get all the details of student under the course");
						System.out.println("========================");
						
						int choice111 = sc.nextInt();
						
						switch (choice111) {
						case 1: {		
							System.out.println("1.Add the course");
							SetTheCourse.main(null);
							break;
						}
						case 2: {	
							System.out.println("2.Update the fees");
							UpdateTheFee.main(null);
							break;
						}
						case 3: {
							System.out.println("3.Delete the course");
							DeleteTheCourseData.main(null);
							break;
						}
						case 4: {	
							System.out.println("4.Get the details of the course");
							CourseDetails.main(null);
							break;
						}
						case 5: {	
							System.out.println("5.Create Batch Under the course");
							BatchUnderCourse.main(null);
							break;
						}
						case 6: {	
							System.out.println("6.Allocate Student");
							AllocateStudentUnderCourse.main(null);
							break;
						}
						case 7: {
							System.out.println("7.Update the Seats in the course");
							UpdateSeats.main(null);
							break;
						}
						case 8: {	
							System.out.println("8.Get all the details of student under the course");
							GetAllStudents.main(null);
							break;
						}
						
						default:
							throw new IllegalArgumentException("Unexpected value: " + choice111);
						}
						
						
					}else {
						throw new IllegalArgumentException("Unexpected value");
					}
					break;
				}
				case 2: {
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice101);
				
				}
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
			case 3: {
				System.out.println("Thankyou...");
				break;		
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
		
		
				
	}
}
