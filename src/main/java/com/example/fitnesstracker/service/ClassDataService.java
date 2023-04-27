package com.example.fitnesstracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fitnesstracker.model.ClassData;
import com.example.fitnesstracker.model.user;
import com.example.fitnesstracker.repository.ClassDataRepository;
import com.example.fitnesstracker.repository.FoodRepository;
import com.example.fitnesstracker.repository.UserRepository;
import com.example.fitnesstracker.service.FoodService;

@Service
public class ClassDataService {
	
	private ClassDataRepository ClassDataRepository;
	public ClassDataService(ClassDataRepository ClassDataRepository) {
		super();
		this.ClassDataRepository = ClassDataRepository;
	}

    
    public List<ClassData> findAllClasses() {
        return ClassDataRepository.findAll();
    }
    public ClassData get(Long id) {
    	return ClassDataRepository.findById(id).get();
    }
    public ClassData findClass(String className) {
    	return ClassDataRepository.getClass(className);
    }
}
