package com.example.fitnesstracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.fitnesstracker.model.food;
import com.example.fitnesstracker.model.user;
import com.example.fitnesstracker.service.FoodService;
import com.example.fitnesstracker.service.UserService;
import com.example.fitnesstracker.model.foodeaten;
import com.example.fitnesstracker.service.foodeatenservice;
import com.example.fitnesstracker.repository.ClassDataRepository;
import com.example.fitnesstracker.model.ClassData;
import com.example.fitnesstracker.service.ClassDataService;

import com.example.fitnesstracker.model.Bookings;
import com.example.fitnesstracker.repository.BookingsRepository;
import com.example.fitnesstracker.service.BookingsService;


@Controller
public class ClassController {

	@Autowired
	private UserService userservice;
	private ClassDataService ClassDataservice;
	private BookingsService bookingsservice;
	
	public ClassController(UserService userservice,ClassDataService ClassDataservice,BookingsService bookingsservice) {
		super();
		this.userservice=userservice;
		this.ClassDataservice=ClassDataservice;
		this.bookingsservice=bookingsservice;
	}
	
	
	
	 
	
	

}