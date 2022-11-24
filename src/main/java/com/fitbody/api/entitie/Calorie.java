package com.fitbody.api.entitie;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_calorie")
public class Calorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer calorieID;
	
	@Column(nullable = false)
	private Double calories;
	
	public Calorie() {
		
	}
	
	public Calorie(Integer calorieID, Double calories) {
		this.calorieID = calorieID;
		this.calories = calories;
	}

	public Integer getCalorieID() {
		return calorieID;
	}

	public void setCalorieID(Integer calorieID) {
		this.calorieID = calorieID;
	}

	public Double getCalories() {
		return calories;
	}

	public void setCalories(Double calories) {
		this.calories = calories;
	}

	@Override
	public int hashCode() {
		return Objects.hash(calorieID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calorie other = (Calorie) obj;
		return Objects.equals(calorieID, other.calorieID);
	}
	
}
