package com.tejait.batch16.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //telling that this are the properties of student table
@Table(name="students_b16")
public class Student {

	@Id
	private int Roll_Number;
	private String fname;
	private String lname;
	private String fullName;
	private String Section;
	private long Mobile_Number;
	private String email;
	private double CGPA;
	
	public int getRoll_Number() {
		return Roll_Number;
	}
	public void setRoll_Number(int roll_Number) {
		Roll_Number = roll_Number;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getSection() {
		return Section;
	}
	public void setSection(String section) {
		Section = section;
	}
	public long getMobile_Number() {
		return Mobile_Number;
	}
	public void setMobile_Number(long mobile_Number) {
		Mobile_Number = mobile_Number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getCGPA() {
		return CGPA;
	}
	public void setCGPA(double CGPA) {
		this.CGPA = CGPA;
	}
	
}
