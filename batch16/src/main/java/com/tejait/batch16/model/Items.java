package com.tejait.batch16.model;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
@RequestMapping("items_b16")
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int iid;
private String itemName;
private int price;
@JsonIgnore
@ManyToMany(mappedBy = "items",cascade = CascadeType.ALL)
private List<Person> itmPerson;
}
