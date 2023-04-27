package com.example.fitnesstracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "bookings")
public class Bookings {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "class_name")
    public String className;
   @Column(name = "class_type")
    public String classType;
   
   @Column(name = "trainer")
   public String Trainer;
   @Column(name="username")
   public String username;
   public String time;
   
   public Bookings() {
   }
   
   public Bookings(String className,String classType, String Trainer, String username,String time) {
	   super();
	   this.className=className;
	   this.classType=classType;
	   this.username=username;
	   this.Trainer=Trainer;
	   this.time=time;
   }
   
   public Long getId() {
	   return id;
   }
   public void setId(Long id){
	   this.id= id;
	   }
   public String getclassName() {
	   return className;
   }
   public void setclassName(String className) {
	   this.className=className;
   }
   public String getclassType() {
	   return classType;
   }
   public void setclassType(String classType) {
	   this.classType=classType;
   }
   public String getTrainer() {
	   return Trainer;
   }
   public void setTrainer(String Trainer) {
	   this.Trainer=Trainer;
   }
   public String getUserName() {
	   return username;
   }
   public void setUserName(String username) {
	   this.username=username;
   }
   public void setTime(String time) {
	   this.time=time;
   }
   public String getTime() {
	   return time;
   }

}
