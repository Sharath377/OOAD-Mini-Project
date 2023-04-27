package com.example.fitnesstracker.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;
import com.example.fitnesstracker.model.user;
import com.example.fitnesstracker.repository.UserRepository;


public interface UserService extends UserDetailsService{
	user saveUser(user user);
	user getUserById(Long id);
	List<user> findAllUsers();
}
