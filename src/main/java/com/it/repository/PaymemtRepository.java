package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.entity.OrderDetailEntity;
import com.it.entity.PaymentEntity;




@Repository
public interface PaymemtRepository extends JpaRepository<PaymentEntity, Integer > {
	
	

	@Query("select t from PaymentEntity t where t.orderId = ?1  ")
	public PaymentEntity  findPaymentByOrderId(Integer orderId);
}
