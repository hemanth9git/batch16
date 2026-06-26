package com.tejait.batch16.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="person_b16")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int pid;
private String name;
private int age;

//Cascade is for rolling back 
//If the pan entity is created and the person entity is not created then there might 
//be a problem occured. So the data have to rollback is the person entity is not created 
//So to rollback the data we use cascade type
//ROllBack means not creating both the entities if one failed to create 
@OneToOne(mappedBy = "perPan",cascade = CascadeType.ALL)
private Pan pan;

}
