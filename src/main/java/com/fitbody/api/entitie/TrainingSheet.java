package com.fitbody.api.entitie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fitbody.api.enums.DayOfWeek;
import com.fitbody.api.enums.PhysicalActivities;

@Entity
@Table(name = "tb_training_sheet")
public class TrainingSheet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trainingSheetId;
	
	@Enumerated(EnumType.STRING)
	private DayOfWeek dayOfWeek;
	
	private Integer time;
	
	private String nameOfExercise;
	
	@Column(nullable = false)
	private Date hourOfTraining;
	       
	@Enumerated(EnumType.STRING)
	private PhysicalActivities nameActivity;

	private Integer userProfile_id;
	
	public TrainingSheet() {
		
	}

	public TrainingSheet(Integer trainingSheetId, DayOfWeek dayOfWeek, Integer time,
			String nameOfExercise, Date hourOfTraining, PhysicalActivities nameActivity,
			Integer userProfile_id) {
		
		this.trainingSheetId = trainingSheetId;
		this.dayOfWeek = dayOfWeek;
		this.time = time;
		this.nameOfExercise = nameOfExercise;
		this.hourOfTraining = hourOfTraining;
		this.nameActivity = nameActivity;
		this.userProfile_id = userProfile_id;
	}

	public Integer getTrainingSheetId() {
		return trainingSheetId;
	}

	public void setTrainingSheetId(Integer trainingSheetId) {
		this.trainingSheetId = trainingSheetId;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	
	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getNameOfExercise() {
		return nameOfExercise;
	}

	public void setNameOfExercise(String nameOfExercise) {
		this.nameOfExercise = nameOfExercise;
	}
	
	public String getHourOfTraining() {
		String hour = " ";
		String minutes = " ";
		String hourFormated = " ";
	
		try {
			hourFormated = hourOfTraining.toString().split(" ")[3];
			hour = hourFormated.split(":")[0];
			minutes = hourFormated.split(":")[1];
			
			return 	hour + ":" + minutes;
			
		}catch(Exception e) {
			hourFormated = hourOfTraining.toString().split(" ")[1];
			minutes = hourFormated.split(":")[1];
			hour = hourFormated.split(":")[0];
			
			return hour + ":" + minutes;
		}
		
	}

	public void setHourOfTraining(String hourOfTraining) {
		SimpleDateFormat formatHour = new SimpleDateFormat("HH:mm");
		try {
			this.hourOfTraining = formatHour.parse(hourOfTraining);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public PhysicalActivities getNameActivity() {
		return nameActivity;
	}

	public void setNameActivity(PhysicalActivities nameActivity) {
		this.nameActivity = nameActivity;
	}

	public Integer getUserProfile_id() {
		return userProfile_id;
	}

	public void setUserProfile_id(Integer userProfile_id) {
		this.userProfile_id = userProfile_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dayOfWeek, trainingSheetId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainingSheet other = (TrainingSheet) obj;
		return Objects.equals(dayOfWeek, other.dayOfWeek)
				&& Objects.equals(trainingSheetId, other.trainingSheetId);
	}
	
}
