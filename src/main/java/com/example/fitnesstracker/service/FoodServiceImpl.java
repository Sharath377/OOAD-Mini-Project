package com.example.fitnesstracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fitnesstracker.model.food;
import com.example.fitnesstracker.model.user;
import com.example.fitnesstracker.repository.FoodRepository;
import com.example.fitnesstracker.repository.UserRepository;
import com.example.fitnesstracker.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {
	
	private FoodRepository foodRepository;
	public FoodServiceImpl(FoodRepository foodRepository) {
		super();
		this.foodRepository = foodRepository;
	}
	
	 @Override
	    public float CalculateCalories(food food) {
	    	float quantity = food.getQuantity();
	    	float calories = food.getCalories();
	    	
	    	float result = quantity*calories;
	    	
	    	
	        return result;
	    }

	    @Override
	    public List<food> findAllFood() {
	        return foodRepository.findAll();
	    }



	@Override
	public food getFoodByName(String foodName) {
		// TODO Auto-generated method stub
		food food=foodRepository.getFood(foodName);
		return food;
	}


}
