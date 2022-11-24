package com.fitbody.api.entitie;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fitbody.api.enums.PhysicalActivities;

@Entity
@Table(name = "tb_physical_activity")
public class PhysicalActivity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer physicalAtivityId;
	
	@Enumerated(EnumType.STRING)
	private PhysicalActivities typeOfActivity;
	
	private Integer time;
	
	private Double calories;
	
	private Integer userProfile_id;
	
	public PhysicalActivity() {
		
	}

	public PhysicalActivity(Integer physicalAtivityId, PhysicalActivities typeOfActivity, Integer time,
			Double calories, Integer userProfile_id) {
		this.physicalAtivityId = physicalAtivityId;
		this.typeOfActivity = typeOfActivity;
		this.time = time;
		this.calories = calories;
		this.userProfile_id = userProfile_id;
		
	}

	public Integer getPhysicalAtivityId() {
		return physicalAtivityId;
	}

	public void setPhysicalAtivityId(Integer physicalAtivityId) {
		this.physicalAtivityId = physicalAtivityId;
	}
	
	public PhysicalActivities getTypeOfActivity() {
		return typeOfActivity;
	}

	public void setTypeOfActivity(PhysicalActivities typeOfActivity) {
		this.typeOfActivity = typeOfActivity;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Double getCalories() {
		return calories;
	}

	public void setCalories(Double calories) {
		this.calories = calories;
	}
	
	public Integer getUserProfile_id() {
		return userProfile_id;
	}

	public void setUserProfile_id(Integer userProfile_id) {
		this.userProfile_id = userProfile_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(physicalAtivityId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhysicalActivity other = (PhysicalActivity) obj;
		return Objects.equals(physicalAtivityId, other.physicalAtivityId);
	}
}
