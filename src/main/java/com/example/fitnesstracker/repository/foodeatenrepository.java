package com.example.fitnesstracker.repository;
import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.fitnesstracker.model.foodeaten;


@Repository
public interface foodeatenrepository extends JpaRepository<foodeaten,Long> {
	
	@Query("SELECT f FROM foodeaten f WHERE f.username=?1")
	List<foodeaten> findbyUserName(String username);
	@Transactional
	@Modifying
	@Query("DELETE FROM foodeaten f WHERE f.username=?1")
	public void reset(@Param("username") String username);
	

}
