package com.example.fitnesstracker.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.fitnesstracker.model.food;
import com.example.fitnesstracker.model.foodeaten;
import com.example.fitnesstracker.service.FoodService;
import com.example.fitnesstracker.service.UserService;
import com.example.fitnesstracker.service.foodeatenservice;


public class FoodController {
	
	private FoodService foodService;
	private foodeatenservice foodeatenservice;

	public FoodController(FoodService foodService) {
		super();
		this.foodService = foodService;
		
	}
	
	


}
