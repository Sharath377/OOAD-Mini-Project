package com.example.fitnesstracker.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.fitnesstracker.model.user;
import com.example.fitnesstracker.repository.UserRepository;
import com.example.fitnesstracker.service.UserService;

@Service
public class UserServiceImpl implements UserService{

private UserRepository userRepository;
public UserServiceImpl(UserRepository userRepository) {
	super();
	this.userRepository = userRepository;
}

   

    @Override
    public user saveUser(user user) {
    	user.getBmi();
        return userRepository.save(user);
    }

    @Override
    public List<user> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public user getUserById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

//    @Override
//    public User getUserByPhone(String phone) {
//        return userRepository.findByPhone(phone);
//
//    }


}