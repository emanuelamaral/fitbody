package com.fitbody.api.entitie;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fitbody.api.enums.GoalsType;

@Entity
@Table(name = "tb_goals")
public class Goals {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer goalsId;
	
	private String goalsDescription;
	private Date date;
	
	@Enumerated
	private GoalsType goalsType;

	
	public Goals() {
		
	}

	public Goals(Integer goalsId, String goalsDescription, Date date, GoalsType goalsType) {
		this.goalsId = goalsId;
		this.goalsDescription = goalsDescription;
		this.date = date;
		this.goalsType = goalsType;
	}

	public Integer getGoalsId() {
		return goalsId;
	}

	public void setGoalsId(Integer goalsId) {
		this.goalsId = goalsId;
	}

	public String getGoalsDescription() {
		return goalsDescription;
	}

	public void setGoalsDescription(String goalsDescription) {
		this.goalsDescription = goalsDescription;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public GoalsType getGoalsType() {
		return goalsType;
	}

	public void setGoalsType(GoalsType goalsType) {
		this.goalsType = goalsType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(goalsId, goalsType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goals other = (Goals) obj;
		return Objects.equals(goalsId, other.goalsId) && goalsType == other.goalsType;
	}
}
