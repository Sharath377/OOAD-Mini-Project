package com.example.fitnesstracker.controller;

import java.util.List;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.context.SecurityContext;
import java.text.SimpleDateFormat;


import com.example.fitnesstracker.model.food;
import com.example.fitnesstracker.model.user;
import com.example.fitnesstracker.model.water;
import com.example.fitnesstracker.service.waterservice;
import com.example.fitnesstracker.service.FoodService;
import com.example.fitnesstracker.service.UserService;
import com.example.fitnesstracker.model.foodeaten;
import com.example.fitnesstracker.service.foodeatenservice;
import com.example.fitnesstracker.repository.ClassDataRepository;
import com.example.fitnesstracker.model.Bookings;
import com.example.fitnesstracker.model.ClassData;
import com.example.fitnesstracker.service.ClassDataService;
import com.example.fitnesstracker.service.BookingsService;
@Controller

public class IndexController {
	
	private UserService userService;
	@Autowired
    private FoodService foodService;
	private foodeatenservice foodeatenservice;
	private ClassDataService ClassDataservice;
	private BookingsService bookingsservice;
	private waterservice waterservice;
	public IndexController(UserService userService,FoodService foodService, foodeatenservice foodeatenservice,ClassDataService ClassDataservice,BookingsService bookingsservice,waterservice waterservice) {
		super();
		this.userService = userService;
		this.foodService = foodService;
		this.foodeatenservice=foodeatenservice;
		this.ClassDataservice=ClassDataservice;
		this.bookingsservice=bookingsservice;
		this.waterservice = waterservice;
	}
	
	private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	@GetMapping("/food")
	public String foodPage(Model model) {
		String nametemp1= returnUserName();
		List<food> foods = foodService.findAllFood();
		List<foodeaten> foodeatenlist= foodeatenservice.listusereaten(nametemp1);
		model.addAttribute("food",new food());
		model.addAttribute("foodeaten",new foodeaten());
		model.addAttribute("listfood", foods);
		model.addAttribute("listfoodeaten",foodeatenlist);
		
	    return "food";
		
		
	}
	
	@GetMapping("/classdata")
	public String classpage(Model model) {
		ClassDataRepository repo = null;
		List<ClassData> classes = ClassDataservice.findAllClasses();
		model.addAttribute("listclasses",classes);
		return "classes";
		
	}
	
	@GetMapping("/viewbookings")
	public String bookings(Model model) {
		String name = returnUserName();
		List<Bookings> classesbooked = bookingsservice.getBookings(name);
		model.addAttribute("listbookings",classesbooked);
		return "viewbookings";
		
	}
	@GetMapping("/water")
	public String water(Model model) {
		String user = returnUserName();
		List<water> waterlist= waterservice.listuserwater(user);
		model.addAttribute("water",new water());
		model.addAttribute("listwater",waterlist);
		return "water";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savefood(@ModelAttribute("foodeaten")foodeaten foodeaten,food food,Model model){
		float calories;
		String name;
		name = foodeaten.getFoodName();
		food foodtemp = foodService.getFoodByName(name);
		foodeaten.setCalories(foodtemp.getCalories());
		
		/*System.out.println(foodeaten.foodName);
		System.out.println(name =="Idly");
		if(name.equals("Idly")) {
			foodeaten.setCalories(100);
		}
	
		else if(name.equals("Burger")) {
			foodeaten.setCalories(100);
		}
		else {
			foodeaten.calories = 200;
		}*/
		
		if(foodeaten.getQuantity()>1) {
			foodeaten.calories=foodeaten.calories*foodeaten.quantity;
		}
		String nametemp= returnUserName();
		foodeaten.setUserName(nametemp);
		foodeatenservice.save(foodeaten);
		List<food> foods = foodService.findAllFood();
		List<foodeaten> foodeatenlist= foodeatenservice.listusereaten(nametemp);
		model.addAttribute("listfood", foods);
		
		model.addAttribute("listfoodeaten",foodeatenlist);
        return "food";
    }
	
	@RequestMapping(value = "/savewater", method = RequestMethod.POST)
	public String savewater(@ModelAttribute("water")water water,Model model) {
		float quantity;
		String username1;
		username1 = returnUserName();
		water.setUserName(username1);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		water.setTime(sdf3.format(timestamp));
		System.out.println(water.getamount());
		waterservice.save(water);
		List<water> waterlist= waterservice.listuserwater(username1);
		model.addAttribute("water",new water());
		model.addAttribute("listwater",waterlist);
		return "water";
	}
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public String bookclass(@PathVariable(name = "id") long id,@ModelAttribute("bookings")Bookings Bookings,ClassData classdata,Model model) {
		 ClassData std = ClassDataservice.get(id);/*gets class data by id*/
		 	if(std.getCount()==0) {
	        Bookings booking = new Bookings();
	        booking.setclassName(std.getclassName());
	        booking.setclassType(std.getclassType());
	        booking.setTrainer(std.getTrainer());
	        String name = returnUserName();
	        booking.setUserName(name);
	        booking.setTime(std.getTime());
	        std.setCount(1);
	        
	        
	        bookingsservice.saveBooking(booking);
	        List<ClassData> classes = ClassDataservice.findAllClasses();
			model.addAttribute("listclasses",classes);
			return "classes";
		 	}
		 	List<ClassData> classes = ClassDataservice.findAllClasses();
			model.addAttribute("listclasses",classes);
			return "classes";
		 	
		
	}
	@RequestMapping(value = "/cancel/{id}", method = RequestMethod.GET)
	public String cancelclass(@PathVariable(name = "id") long id,@ModelAttribute("bookings")Bookings Bookings,ClassData classdata,Model model) {
		bookingsservice.delete(id);
		String name = returnUserName();
		List<Bookings> classesbooked = bookingsservice.getBookings(name);
		model.addAttribute("listbookings",classesbooked);
		return "viewbookings";
		
		
	}
	
	@GetMapping("/reset")
	public String resetfood(Model model) {
		String nametemp2=returnUserName();
		foodeatenservice.reset(nametemp2);
		List<food> foods = foodService.findAllFood();
		List<foodeaten> foodeatenlist= foodeatenservice.listusereaten(nametemp2);
		model.addAttribute("food",new food());
		model.addAttribute("foodeaten",new foodeaten());
		model.addAttribute("listfood", foods);
		model.addAttribute("listfoodeaten",foodeatenlist);
		
		
		return "food";
	}
	
    @GetMapping("/resetwater")
	public String resetwater(Model model) {
		String nametemp3 = returnUserName();
		waterservice.reset(nametemp3);
		List<water> waterlist= waterservice.listuserwater(nametemp3);
		model.addAttribute("water",new water());
		model.addAttribute("listwater",waterlist);
		return "water";
		
		
	}
	private String returnUserName() {
		
        Authentication user = SecurityContextHolder.getContext().getAuthentication();
		String username = user.getName();
		return username;
	}
    }
	
	


