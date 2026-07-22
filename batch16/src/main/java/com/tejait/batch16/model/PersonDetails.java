package com.tejait.batch16.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import lombok.Setter;

@Entity
@Table(name = "persondetails")
@Data
@Setter
@Getter
@AllArgsConstructor
public class PersonDetails {
	
	@Id
	private int id;
	private String ename;
	private String nationality;
	private int age;
	private String mail;
	private String gender;
	private int appid;
	
	public PersonDetails() {

	}

}
