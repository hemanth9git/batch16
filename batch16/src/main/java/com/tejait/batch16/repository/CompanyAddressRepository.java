package com.tejait.batch16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejait.batch16.model.CompanyAddress;

@Repository
public interface CompanyAddressRepository extends JpaRepository<CompanyAddress, Integer> {

	public CompanyAddress findByAppId(Integer appid);
}
