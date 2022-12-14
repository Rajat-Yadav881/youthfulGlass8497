package com.youthfulGlass.model;

public class Course {
	
	
	private int course_id;
	private String course_name;
	private int total_seat;
	private int coursefee;
	private int remaining_seats;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Course(int course_id, String course_name, int total_seat, int coursefee,int remaining_seats) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.total_seat = total_seat;
		this.coursefee = coursefee;
		this.remaining_seats = remaining_seats;
	}


	public int getCourse_id() {
		return course_id;
	}


	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}


	public String getCourse_name() {
		return course_name;
	}


	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}


	public int getTotal_seat() {
		return total_seat;
	}


	public void setTotal_seat(int total_seat) {
		this.total_seat = total_seat;
	}


	public int getCoursefee() {
		return coursefee;
	}


	public void setCoursefee(int coursefee) {
		this.coursefee = coursefee;
	}
	
	public int getremaining_seats() {
		return remaining_seats;
	}


	public void setremaining_seats(int remaining_seats) {
		this.remaining_seats = remaining_seats;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", total_seat=" + total_seat
				+ ", coursefee=" + coursefee +", remaining_seats=" + remaining_seats + "]";
	}
	
	
	
	
}
