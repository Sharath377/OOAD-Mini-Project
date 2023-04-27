package com.example.fitnesstracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fitnesstracker.model.water;
import com.example.fitnesstracker.repository.waterrepository;


@Service
public class waterservice {
	@Autowired
	private waterrepository repo;
	public List<water> listAll() {
		return repo.findAll();
	}
	public void save(water water) {
		repo.save(water);
	}
	public water get(Long id) {
		return repo.findById(id).get();
		}
	public List<water> listuserwater(String username){
		return repo.findbyUserName(username);
	}
	public void reset(String username) {
		 repo.resetwater(username);
	 }
	

}
