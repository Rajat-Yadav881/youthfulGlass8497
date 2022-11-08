package com.youthfulGlass.model;

public class Student {

	private int student_id;
	private String student_name;
	private String date_of_birth;
	private String parent_name;
	private String address;
	private String contact_no;
	private String mail;
	private String gender;
	private String identification;
	private String date_of_join;
	private String password;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int student_id, String student_name, String date_of_birth, String parent_name, String address,
			String contact_no, String mail, String gender, String identification, String date_of_join,
			String password) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.date_of_birth = date_of_birth;
		this.parent_name = parent_name;
		this.address = address;
		this.contact_no = contact_no;
		this.mail = mail;
		this.gender = gender;
		this.identification = identification;
		this.date_of_join = date_of_join;
		this.password = password;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getDate_of_join() {
		return date_of_join;
	}

	public void setDate_of_join(String date_of_join) {
		this.date_of_join = date_of_join;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", date_of_birth="
				+ date_of_birth + ", parent_name=" + parent_name + ", address=" + address + ", contact_no=" + contact_no
				+ ", mail=" + mail + ", gender=" + gender + ", identification=" + identification + ", date_of_join="
				+ date_of_join + ", password=" + password + "]";
	}
	
	
	
}
