package com.tejait.batch16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejait.batch16.model.BusinessProduct;

@Repository
public interface BusinessProductRepository extends JpaRepository<BusinessProduct,Integer> {

	public BusinessProduct findByAppid(Integer appid);
}
