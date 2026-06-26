package com.tejait.batch16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejait.batch16.model.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
