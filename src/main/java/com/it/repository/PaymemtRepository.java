package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.entity.PaymentEntity;



@Repository
public interface PaymemtRepository extends JpaRepository<PaymentEntity, String> {

}
