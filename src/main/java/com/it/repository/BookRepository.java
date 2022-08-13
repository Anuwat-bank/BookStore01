package com.it.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.entity.BookEntity;
import com.it.entity.OrderEntity;



@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
	@Query("select t from BookEntity t where t.cId = ?1 and t.recordStatus = '1'    ")
	public List<BookEntity> getAllBycId(Integer cId );
	
	@Query("select t from BookEntity t where t.cId = ?1     ")
	public BookEntity saveBookBycId(Integer cId );
	
}
