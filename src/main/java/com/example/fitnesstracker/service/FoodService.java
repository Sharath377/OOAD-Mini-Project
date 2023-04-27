package com.example.fitnesstracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.fitnesstracker.model.food;
import com.example.fitnesstracker.model.user;
import com.example.fitnesstracker.repository.FoodRepository;
public interface FoodService {

	List<food> findAllFood();
	food getFoodByName(String foodName);
	float CalculateCalories(food food);
	
}
