package com.example.fitnesstracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.example.fitnesstracker.model.water;


public interface waterrepository extends JpaRepository<water, Long> {

	@Query("SELECT f FROM water f WHERE f.username=?1")
	List<water> findbyUserName(String username);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM water f WHERE f.username=?1")
	public void resetwater(@Param("username") String username);
	

}
