package com.example.fitnesstracker.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fitnesstracker.model.food;
import com.example.fitnesstracker.model.user;

@Repository
public interface FoodRepository extends JpaRepository<food,Long>{
	@Query("SELECT f FROM food f WHERE f.foodName=?1")
	public food getFood(String foodName);
}
