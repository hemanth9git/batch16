package com.tejait.batch16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejait.batch16.model.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer>{

}
