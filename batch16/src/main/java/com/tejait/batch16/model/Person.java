package com.tejait.batch16.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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

@OneToMany(mappedBy ="ordPer",cascade = CascadeType.ALL )
private List<Orders> orders;

@ManyToMany
@JoinTable(
		name="person_item",
		joinColumns = @JoinColumn(name="pid"),
		inverseJoinColumns = @JoinColumn(name="iid")
		)
private List<Items> items;
}
