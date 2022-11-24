package com.fitbody.api.entitie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_body_mensure")
public class BodyMensure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bodyMensureId;
	
	private String bodyPart;
	private Double mensure;
	
	private Integer userProfile_id;

	public BodyMensure() {
		
	}

	public BodyMensure(Integer bodyMensureId, String bodyPart, Double mensure, Integer userProfile_id) {
		this.bodyMensureId = bodyMensureId;
		this.bodyPart = bodyPart;
		this.mensure = mensure;
		this.userProfile_id = userProfile_id;
	}

	public Integer getBodyMensureId() {
		return bodyMensureId;
	}

	public void setBodyMensureId(Integer bodyMensureId) {
		this.bodyMensureId = bodyMensureId;
	}

	public String getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}

	public Double getMensure() {
		return mensure;
	}

	public void setMensure(Double mensure) {
		this.mensure = mensure;
	}

	public Integer getUserProfile_id() {
		return userProfile_id;
	}

	public void setUserProfile_id(Integer userProfile_id) {
		this.userProfile_id = userProfile_id;
	}
	
	
}
