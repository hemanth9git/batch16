package com.tejait.batch16.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data //Automated setters and getters and also overriding the toString() method
@Entity
@Table(name="pan_b16")
public class Pan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int pnid;
private String panNum;
//private Date createdAt;

@JsonIgnore//It stops jumping from pan To person and terminates the cycle
@OneToOne//To establish the one to one relationship we have to use the @OneToOne annotation
@JoinColumn(name="pn_fkid")//We have to create the foreign key to communicate with 
//The both entities have to communicate so to create the foreign key we have 
// @JoinColumn annotation and in the annotation we have to give the name for foreign key
private Person perPan;

}
