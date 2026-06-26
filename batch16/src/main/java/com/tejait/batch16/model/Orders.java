package com.tejait.batch16.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="orders_b16")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int ordId;
private String orderName;
private String orderStatus;

@JsonIgnore
@ManyToOne
@JoinColumn(name="ord_fkid")
private Person ordPer;
}
