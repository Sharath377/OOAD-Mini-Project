package com.example.fitnesstracker.model;



import jakarta.persistence.*;

@Entity
@Table(name = "food_eaten")

public class foodeaten {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name = "food_name")
    public String foodName;

    @Column(name = "calories")
    public float calories;

    public float quantity;
    public String username;
    
    public foodeaten() {

    }

    public foodeaten(String foodName,float quantity) {
    	
        this.foodName = foodName;
       
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }
    public void setUserName(String username) {
    	this.username=username;
    }
    public String getUserName() {
    	return username;
    }

}
