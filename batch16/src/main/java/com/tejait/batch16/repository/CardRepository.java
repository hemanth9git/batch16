package com.tejait.batch16.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tejait.batch16.model.CardDtls;

public interface CardRepository extends JpaRepository<CardDtls, Integer>{

}
