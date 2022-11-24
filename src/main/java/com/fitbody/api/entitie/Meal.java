package com.fitbody.api.entitie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_meal")
public class Meal{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mealId;
	
	@Column(nullable = false)
	private String mealName;
	
	@Column(nullable = false)
	private Date mealTime;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="meal_id")
	private List<Food> food;
	
	private Double calorie;
	
	private Integer userProfile_id;
	
	public Meal() {
		
	}

	public Meal(Integer mealId, String mealName, Integer quantityOfMeals, Date mealTime, List<Food> food, Double calorie, Integer userProfile_id) {
		this.mealId = mealId;
		this.mealName = mealName;
		this.mealTime = mealTime;
		this.food = food;
		this.calorie = calorie;
		this.userProfile_id = userProfile_id;
	}

	public Integer getMealId() {
		return mealId;
	}

	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public String getMealTime() {
		String hour = " ";
		String minutes = " ";
		String hourFormated = " ";
	
		try {
			hourFormated = mealTime.toString().split(" ")[3];
			hour = hourFormated.split(":")[0];
			minutes = hourFormated.split(":")[1];
			
			return 	hour + ":" + minutes;
			
		}catch(Exception e) {
			hourFormated = mealTime.toString().split(" ")[1];
			minutes = hourFormated.split(":")[1];
			hour = hourFormated.split(":")[0];
			
			return hour + ":" + minutes;
		}
		
	}

	public void setMealTime(String mealTime) {
		SimpleDateFormat formatHour = new SimpleDateFormat("HH:mm");
		try {
			this.mealTime = formatHour.parse(mealTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public List<Food> getFood() {
		return food;
	}

	public void setFood(List<Food> food) {
		this.food = food;
	}

	public Double getCalorie() {
		return calorie;
	}

	public void setCalorie(Double calorie) {
		this.calorie = calorie;
	}

	public Integer getUserProfile_id() {
		return userProfile_id;
	}

	public void setUserProfile_id(Integer userProfile_id) {
		this.userProfile_id = userProfile_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mealId, mealTime);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meal other = (Meal) obj;
		return Objects.equals(mealId, other.mealId) && Objects.equals(mealTime, other.mealTime);
	}
}
