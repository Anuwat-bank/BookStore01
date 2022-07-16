package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.entity.TrackEntity;



@Repository
public interface TrackRepository extends JpaRepository<TrackEntity, Integer> {

}
