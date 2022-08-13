package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.entity.UserDetailEntity;




@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Integer> {
	
	@Query("select t from UserDetailEntity t where t.userId=?1  ")
	public UserDetailEntity  findByUserId(Integer userId);
	
	@Query("select t from UserDetailEntity t where t.recordStatus =?1    ")
	public List<UserDetailEntity> getAllByStatus(String recordStatus );
	
	@Query("select t from UserDetailEntity t where t.cId=?1  ")
	public UserDetailEntity  findBycId(Integer cId);
	
	@Query("select t from UserDetailEntity t where t.userId=?1  ")
	public UserDetailEntity  findUserDetailByUserId(Integer userId);
	
	
	

}
