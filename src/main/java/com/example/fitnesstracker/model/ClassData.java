package com.example.fitnesstracker.model;

import jakarta.persistence.*;


@Entity
@Table(name = "classes")
public class ClassData {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	   @Column(name = "class_name")
	    public String className;
	   @Column(name = "class_type")
	    public String classType;
	   @Column(name = "description")
	   public String Description;
	   @Column(name = "trainer")
	   public String Trainer;
	   public int count;
	   public String time;
	   
	   public ClassData() {
	   }
	   
	   public ClassData(String className,String classType, String Description,String Trainer,int count,String time) {
		   super();
		   this.className=className;
		   this.classType=classType;
		   this.Description=Description;
		   this.Trainer=Trainer;
		   this.count=count;
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
	   public String getDescription() {
		   return Description;
	   }
	   public void setDescription(String Description) {
		   this.Description=Description;
	   }
	   public String getTrainer() {
		   return Trainer;
	   }
	   public void setTrainer(String Trainer) {
		   this.Trainer=Trainer;
	   }
	   public int getCount() {
		   return count;
	   }
	   public void setCount(int count) {
		   this.count=count;
	   }
	   public String getTime() {
		   return time;
	   }
	   public void setTime(String time) {
		   this.time=time;
	   }
}
