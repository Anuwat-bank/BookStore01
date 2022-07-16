package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.entity.OrderDetailEntity;



@Repository
public interface OrderDetailRepository  extends JpaRepository<OrderDetailEntity, Integer>{

}
