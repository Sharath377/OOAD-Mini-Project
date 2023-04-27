package com.example.fitnesstracker.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fitnesstracker.model.Bookings;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Long>{
	
	@Query("SELECT DISTINCT f FROM Bookings f WHERE f.username=?1")
	List<Bookings> findByUsername(String username);

}
