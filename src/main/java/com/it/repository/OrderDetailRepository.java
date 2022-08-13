package com.it.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.entity.OrderDetailEntity;
import com.it.entity.OrderEntity;




@Repository
public interface OrderDetailRepository  extends JpaRepository<OrderDetailEntity, Integer>{
	
	@Query("select t from OrderDetailEntity t where t.orderId = ?1  ")
	public OrderDetailEntity  findByOrderId(Integer orderId);
	
	@Query("select t from OrderDetailEntity t where t.orderId = ?1 and t.recordStatus = '1'    ")
	public OrderDetailEntity getAllOrderByUserId(Integer orderId );
	
	

}
