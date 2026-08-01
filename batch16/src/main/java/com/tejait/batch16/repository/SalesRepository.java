package com.tejait.batch16.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejait.batch16.model.SalesReport;

@Repository
public interface SalesRepository extends JpaRepository<SalesReport, Integer>{
	
	List<SalesReport> findByAppid(Integer appid);

}
