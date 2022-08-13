package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.entity.OrderEntity;
import com.it.entity.UserDetailEntity;
import com.it.entity.UserEntity;

@Repository
public interface  UserRepository  extends JpaRepository<UserEntity, Integer>{
	
	@Query("select t from UserEntity t where t.username = ?1 and  t.password  = ?2  ")
	public UserEntity  getByUserNamePassword(String username, String password);
	
	@Query("select t from UserEntity t where t.roleId = ?1    ")
	public List<UserEntity> getAllByRoleId(Integer roleId);
	
	public List<OrderEntity> findByUserId(Integer userId);
	
	
	

}
