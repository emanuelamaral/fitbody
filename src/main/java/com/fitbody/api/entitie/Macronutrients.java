package com.fitbody.api.entitie;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_macronutrients")
public class Macronutrients {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer macroId;
	private Double protein;
	private Double carbohydrate;
	private Double fat;
	
	public Macronutrients () {
		
	}

	public Macronutrients(Integer macroId, Double protein, Double carbohydrate, Double fat) {
		this.macroId = macroId;
		this.protein = protein;
		this.carbohydrate = carbohydrate;
		this.fat = fat;
	}

	public Integer getMacroId() {
		return macroId;
	}

	public void setMacroId(Integer macroId) {
		this.macroId = macroId;
	}

	public Double getProtein() {
		return protein;
	}

	public void setProtein(Double protein) {
		this.protein = protein;
	}

	public Double getCarbohydrate() {
		return carbohydrate;
	}

	public void setCarbohydrate(Double carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	public Double getFat() {
		return fat;
	}

	public void setFat(Double fat) {
		this.fat = fat;
	}

	@Override
	public int hashCode() {
		return Objects.hash(macroId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Macronutrients other = (Macronutrients) obj;
		return Objects.equals(macroId, other.macroId);
	}
}
