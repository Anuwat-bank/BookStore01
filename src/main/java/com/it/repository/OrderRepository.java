package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.entity.OrderEntity;



@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

}
