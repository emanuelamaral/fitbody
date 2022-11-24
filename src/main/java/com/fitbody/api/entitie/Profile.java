package com.fitbody.api.entitie;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fitbody.api.enums.CurrentGoalWeight;
import com.fitbody.api.enums.Gender;
import com.fitbody.api.enums.NivelActivity;

@Entity
@Table(name = "tb_profile")
public class Profile implements Serializable{
	
	private static final long serialVersionUID = -5079886984191066075L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userProfileId;
	
	@Column(nullable = false)
	private Integer height;
	
	@Column(nullable = false)
	private Double weight;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CurrentGoalWeight currentWeight;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private NivelActivity nivelActivity;
	 
	@Column(nullable = false)
	private Date birthday;
	
	@Column(nullable = false)
	private Double weightGoal;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="userProfile_id")
	private List<Goals> goals;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="userProfile_id")
	private List<TrainingSheet> trainingSheet;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="userProfile_id")
	private List<PhysicalActivity> physicalActivity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="waterConsume_id")
	private WaterConsume waterConsume_id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="userProfile_id")
	private List<BodyMensure> bodyMensure;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="userProfile_id")
	private List<Meal> meals;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="userProfile_id")
	private List<Food> foods;
	
	public Profile() {
		
	}

	public Profile(Integer userProfileId, Integer height, Double weight, CurrentGoalWeight currentWeight, NivelActivity nivelActivity,
			Date birthday, Double weightGoal, Gender gender, List<Goals> goals, List<TrainingSheet> trainingSheet,
			List<PhysicalActivity> physicalActivity, List<BodyMensure> bodyMensure,WaterConsume waterConsume, List<Meal> meals, List<Food> foods) {
		this.userProfileId = userProfileId;
		this.height = height;
		this.weight = weight;
		this.currentWeight = currentWeight;
		this.nivelActivity = nivelActivity;
		this.birthday = birthday;
		this.weightGoal = weightGoal;
		this.gender = gender;
		this.goals = goals;
		this.trainingSheet = trainingSheet;
		this.physicalActivity = physicalActivity;
		this.bodyMensure = bodyMensure;
		this.waterConsume_id = waterConsume;
		this.meals = meals;
		this.foods = foods;
	}

	public Integer getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Integer userProfileId) {
		this.userProfileId = userProfileId;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public CurrentGoalWeight getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(CurrentGoalWeight currentWeight) {
		this.currentWeight = currentWeight;
	}

	public NivelActivity getNivelActivity() {
		return nivelActivity;
	}

	public void setNivelActivity(NivelActivity nivelActivity) {
		this.nivelActivity = nivelActivity;
	}

	public String getBirthday() {
		String day = " ";
		String month = " ";
		String year = " ";
		try {
			month = convertMonth();
			day = birthday.toString().split(" ")[2];
			year = birthday.toString().split(" ")[5];
			
			String formatedBirthday = day + "/" + month + "/" + year;
			
			return formatedBirthday;
		}catch(Exception e) {
			String formatedBirthday = birthday.toString().split(" ")[0];
			
			day = formatedBirthday.split("-")[2];
			month = formatedBirthday.split("-")[1];
			year = formatedBirthday.split("-")[0];

			return day + "/" + month + "/" + year;

		}

	}

	public void setBirthday(String birthday) {
		SimpleDateFormat birthdayFormated = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			this.birthday = birthdayFormated.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Double getWeightGoal() {
		return weightGoal;
	}

	public void setWeightGoal(Double weightGoal) {
		this.weightGoal = weightGoal;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public List<Goals> getGoals() {
		return goals;
	}

	public void setGoals(List<Goals> goals) {
		this.goals = goals;
	}

	public List<TrainingSheet> getTrainingSheet() {
		return trainingSheet;
	}

	public void setTrainingSheet(List<TrainingSheet> trainingSheet) {
		this.trainingSheet = trainingSheet;
	}

	public List<PhysicalActivity> getPhysicalActivity() {
		return physicalActivity;
	}

	public void setPhysicalActivity(List<PhysicalActivity> physicalActivity) {
		this.physicalActivity = physicalActivity;
	}

	public List<BodyMensure> getBodyMensure() {
		return bodyMensure;
	}

	public void setBodyMensure(List<BodyMensure> bodyMensure) {
		this.bodyMensure = bodyMensure;
	}

	public WaterConsume getWaterConsume() {
		return waterConsume_id;
	}

	public void setWaterConsume(WaterConsume waterConsume) {
		this.waterConsume_id = waterConsume;
	}
	
	public List<Meal> getMeals(){
		return meals;
	}
	
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	
	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userProfileId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return Objects.equals(userProfileId, other.userProfileId);
	}
	
	private String convertMonth() {
		String month = birthday.toString().split(" ")[1];
		
		if(month.compareTo("Jan") == 0) {
			month = "01";
		}
		else if(month.compareTo("Feb") == 0) {
			month = "02";
		}
		else if(month.compareTo("Mar") == 0) {
			month = "03";
		}
		else if(month.compareTo("Apr") == 0) {
			month = "04";
		}
		else if(month.compareTo("May") == 0) {
			month = "05";
		}
		else if(month.compareTo("Jun") == 0) {
			month = "06";
		}
		else if(month.compareTo("Jul") == 0) {
			month = "07";
		}
		else if(month.compareTo("Aug") == 0) {
			month = "08";
		}
		else if(month.compareTo("Sep") == 0) {
			month = "09";
		}
		else if(month.compareTo("Oct") == 0) {
			month = "10";
		}
		else if(month.compareTo("Nov") == 0) {
			month = "11";
		}
		else if(month.compareTo("Dec") == 0) {
			month = "12";
		}
		
		return month;
	}

}
