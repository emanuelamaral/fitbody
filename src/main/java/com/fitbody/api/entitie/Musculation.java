package com.fitbody.api.entitie;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_musculation")
public class Musculation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer musculationId;
	
	@Column(nullable = false)
	private String nameOfExercise;
	
	@Column(nullable = false)
	private Integer reps;
	
	@Column(nullable = false)
	private Integer series;
	
	@Column(nullable = false)
	private String bodyPart;
	
	public Musculation() {
		
	}

	public Musculation(Integer musculationId, String nameOfExercise, Integer reps, Integer series, String bodyPart) {
		this.musculationId = musculationId;
		this.nameOfExercise = nameOfExercise;
		this.reps = reps;
		this.series = series;
		this.bodyPart = bodyPart;
	}

	public Integer getMusculationId() {
		return musculationId;
	}

	public void setMusculationId(Integer musculationId) {
		this.musculationId = musculationId;
	}

	public String getNameOfExercise() {
		return nameOfExercise;
	}

	public void setNameOfExercise(String nameOfExercise) {
		this.nameOfExercise = nameOfExercise;
	}

	public Integer getReps() {
		return reps;
	}

	public void setReps(Integer reps) {
		this.reps = reps;
	}

	public Integer getSeries() {
		return series;
	}

	public void setSeries(Integer series) {
		this.series = series;
	}

	public String getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}

	@Override
	public int hashCode() {
		return Objects.hash(musculationId, nameOfExercise);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musculation other = (Musculation) obj;
		return Objects.equals(musculationId, other.musculationId)
				&& Objects.equals(nameOfExercise, other.nameOfExercise);
	}
}
