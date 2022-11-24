package com.fitbody.api.entitie;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_progress")
public class Progress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer progressId;
	private Double currentWeight;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userProfile_id")
	private Profile userProfile;
	
	public Progress() {
	
	}
	
	public Progress(Integer progressId, Double currentWeight, Profile userProfile) {
		this.progressId = progressId;
		this.currentWeight = currentWeight;
		this.userProfile = userProfile;
	}

	public Integer getProgressId() {
		return progressId;
	}

	public void setProgressId(Integer progressId) {
		this.progressId = progressId;
	}

	public Double getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(Double currentWeight) {
		this.currentWeight = currentWeight;
	}

	public Profile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(Profile userProfile) {
		this.userProfile = userProfile;
	}

	@Override
	public int hashCode() {
		return Objects.hash(progressId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Progress other = (Progress) obj;
		return Objects.equals(progressId, other.progressId);
	}
	
	
	
}
