package com.tejait.batch16.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //the spring knows this is the entity class
@Table(name="employee_b16") // By default the java creates the table with the class name 
//If we want our custom name we have to mention the annotation @Table(name="Table_name")
//The above will create the table with the custom table name 
public class Employee {

	@Id //Used to mention the primary key in the table 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	//we can just use the annotation but we have some exceptions in creating the relationships
	//So we hvae to mention the above for the autoincrement operation
	 private int id;
	 private String fname;
	 private String lname;
	 private String fullname;
	 private String dept;
	 private int age;
	 private long salary;
	 private String empCode;
	 
	 public int getId() {
		 return id;
	 }
	 public void setId(int id) {
		 this.id = id;
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
	 public String getFullname() {
		 return fullname;
	 }
	 public void setFullname(String fullname) {
		 this.fullname = fullname;
	 }
	 public String getDept() {
		 return dept;
	 }
	 public void setDept(String dept) {
		 this.dept = dept;
	 }
	 public int getAge() {
		 return age;
	 }
	 public void setAge(int age) {
		 this.age = age;
	 }
	 public long getSalary() {
		 return salary;
	 }
	 public void setSalary(long salary) {
		 this.salary = salary;
	 }
	 public String getEmpCode() {
		 return empCode;
	 }
	 public void setEmpCode(String empCode) {
		 this.empCode = empCode;
	 }
	 
}
