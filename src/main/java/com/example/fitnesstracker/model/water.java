package com.example.fitnesstracker.model;


import java.util.Date;

import jakarta.persistence.*;


@Entity
@Table(name = "water")
public class water {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
	

    @Column(name = "time")
    public String consumedtime;
    
    @Column(name="amount")
    public float amount;
    
    public String username;
    
    public water() {
    	
    }
    public water(String consumedtime,float amount,String username) {
    	this.consumedtime=consumedtime;
    	this.amount=amount;
    	this.username=username;
    	
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTime() {
    	return consumedtime;
    }
    public void setTime(String consumedtime) {
    	this.consumedtime=consumedtime;
    }
    public float getamount() {
    	return amount;
    }
    public void setamount(float amount) {
    	this.amount=amount;
    	}
    public String getUserName() {
    	return username;
    }
    public void setUserName(String username) {
    	this.username=username;
    }
    
}
