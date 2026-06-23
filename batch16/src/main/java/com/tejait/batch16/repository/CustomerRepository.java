package com.tejait.batch16.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tejait.batch16.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
