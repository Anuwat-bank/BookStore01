package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.entity.BankEntity;




@Repository
public interface BankRepository extends JpaRepository<BankEntity, Integer> {
	@Query("select t from BankEntity t where t.userId=?1  ")
	public List<BankEntity> findByUserId(Integer userId);
	
}
