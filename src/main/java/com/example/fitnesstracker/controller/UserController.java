package com.example.fitnesstracker.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.fitnesstracker.model.user;
import com.example.fitnesstracker.service.UserService;


@Controller
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	
	// handler method to handle list students and return model and view
	@GetMapping("/login")
	public String startPage(Model model) {
		user user = new user();
		model.addAttribute("user",user);
		return "login";
	}
	@GetMapping("/newlogin")
	public String startPage1(Model model) {
		user user = new user();
		model.addAttribute("user",user);
		return "newlogin";
	}
	
	@GetMapping("/")
	public String home(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      	String name = auth.getName(); //get logged in username
			
      	model.addAttribute("username", name);
		return "index";
	}
	
//	@PostMapping("/login")
//	public String login(@ModelAttribute("user") User user) {
////		User existingUser = userService.getUserByPhone(user.getPhone());
//		return "redirect:/new_page/{phone}(phone = user.getPhone())"; 
//	}
	
//	@GetMapping("/new_page/{phone}")
//	public String newpage(@PathVariable String phone, Model model) {
//		model.addAttribute("user",userService.getUserByPhone(phone));
//		return "new_page";
//	}
//	
	
	@GetMapping("/registration")
	public String createAccount(Model model) {
		// create user object to hold student form data
		user user = new user();
		model.addAttribute("user",user);
		return "create_acc";
	}
	
	
	
//	@PostMapping()
//	public String saveUser(@ModelAttribute("user") User user) {
//		userService.saveUser(user);
//		return "redirect:/start";
//	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") user user) {
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    
	    userService.saveUser(user);
	     
	    return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String listUsers(Model model) {
	    List<user> listUsers = userService.findAllUsers();
	    model.addAttribute("listUsers", listUsers);
	    return "index";
	}
}