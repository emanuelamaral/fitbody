package com.fitbody.api.entitie;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_water_consume")
public class WaterConsume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer waterConsumeId;
	
	private Double waterConsumedPerDay;
	
	private Double goalWaterConsumePerDay;
	
	public WaterConsume() {
		
	}

	public WaterConsume(Integer waterConsumeId, Double waterConsumedPerDay, Double goalWaterConsumePerDay) {
		this.waterConsumeId = waterConsumeId;
		this.waterConsumedPerDay = waterConsumedPerDay;
		this.goalWaterConsumePerDay = goalWaterConsumePerDay;
	}

	public Integer getWaterConsumeId() {
		return waterConsumeId;
	}

	public void setWaterConsumeId(Integer waterConsumeId) {
		this.waterConsumeId = waterConsumeId;
	}

	public Double getWaterConsumedPerDay() {
		return waterConsumedPerDay;
	}

	public void setWaterConsumedPerDay(Double waterConsumedPerDay) {
		this.waterConsumedPerDay = waterConsumedPerDay;
	}
	
	public Double getGoalWaterConsumePerDay() {
		return goalWaterConsumePerDay;
	}

	public void setGoalWaterConsumePerDay(Double goalWaterConsumePerDay) {
		this.goalWaterConsumePerDay = goalWaterConsumePerDay;
	}

	@Override
	public int hashCode() {
		return Objects.hash(waterConsumeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WaterConsume other = (WaterConsume) obj;
		return Objects.equals(waterConsumeId, other.waterConsumeId);
	}
}
