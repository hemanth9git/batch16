package com.tejait.batch16.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejait.batch16.model.TransactionHistory;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionHistory, Integer>{
	
	public List<TransactionHistory> findByAppid(Integer appId);

}
