package com.fitbody.api.entitie;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_food")
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer foodId;
	
	@Column(nullable = false)
	private String foodName;
	private Double weightFood;
	
	private Integer userProfile_id;
	private Integer meal_id;
	
	
	
	public Food() {
		
	}

	public Food(Integer foodId, String foodDescription, Double weightFood, Integer userProfile_id, Integer meal_id) {
		this.foodId = foodId;
		this.foodName = foodDescription;
		this.weightFood = weightFood;
		this.meal_id = meal_id;
		this.userProfile_id = userProfile_id;
	
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Double getWeightFood() {
		return weightFood;
	}

	public void setWeightFood(Double weightFood) {
		this.weightFood = weightFood;
	}

	public Integer getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(Integer meal_id) {
		this.meal_id = meal_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(foodName, foodId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		return Objects.equals(foodName, other.foodName) && Objects.equals(foodId, other.foodId);
	}

	public Integer getUserProfile_id() {
		return userProfile_id;
	}

	public void setUserProfile_id(Integer userProfile_id) {
		this.userProfile_id = userProfile_id;
	}
	
}
