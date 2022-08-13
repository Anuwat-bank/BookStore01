package com.it.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.it.entity.RefundEntity;



@Repository
public interface RefundRepository extends JpaRepository<RefundEntity, Integer> {
	
	@Query("select t from RefundEntity t where t.userId=?1  ")
	public List<RefundEntity> findByUserId(Integer userId);

}
