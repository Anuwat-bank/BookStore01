package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.entity.OrderDetailEntity;
import com.it.entity.OrderEntity;




@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
	
	@Query("select t from OrderEntity t where t.recordStatus = ?1    ")
	public List<OrderEntity> getAllOrderByRecord(String recordStatus);

	public List<OrderEntity> findByUserId(Integer userId);
	
	@Query("select t from OrderEntity t where t.orderId = ?1  ")
	public OrderEntity  findByOrderId(Integer orderId);
	
	@Query("select t from OrderEntity t where t.cId = ?1  ")
	public List<OrderEntity> findByCid(Integer cId);
}
