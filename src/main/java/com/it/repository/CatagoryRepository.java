package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.entity.CatagoryEntity;



@Repository
public interface CatagoryRepository extends JpaRepository<CatagoryEntity, Integer> {

}
