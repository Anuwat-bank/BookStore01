package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.entity.ReasonEntity;



@Repository
public interface ReasonRepository extends JpaRepository<ReasonEntity, Integer> {

}
