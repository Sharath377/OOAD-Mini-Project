package com.example.fitnesstracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fitnesstracker.model.ClassData;
@Repository
public interface ClassDataRepository extends JpaRepository<ClassData, Long> {
	@Query("SELECT f FROM ClassData f WHERE f.className=?1")
	public ClassData getClass(String className);

}
