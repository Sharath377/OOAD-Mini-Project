package com.example.fitnesstracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.fitnesstracker.model.foodeaten;
import com.example.fitnesstracker.repository.foodeatenrepository;

@Service
public class foodeatenservice {
	@Autowired
	private foodeatenrepository repo;
	public List<foodeaten> listAll() {
        return repo.findAll();
    }
	public void save(foodeaten std) {
        repo.save(std);
    }
	 public foodeaten get(long id) {
	        return repo.findById(id).get();
	    }
	 public List<foodeaten> listusereaten(String username){
		 return repo.findbyUserName(username);
	 }
	 public void reset(String username) {
		 repo.reset(username);
	 }
}
