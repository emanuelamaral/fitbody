package com.fitbody.api.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fitbody.api.entitie.TrainingSheet;
import com.fitbody.api.repository.TrainingSheetRepository;

@RestController
@RequestMapping("/training")
public class TrainingSheetController {
	
	@Autowired
	private TrainingSheetRepository trainingRepository;
	
	@GetMapping
	public ArrayList<TrainingSheet> getAllTrainingSheet(){
		return (ArrayList<TrainingSheet>) trainingRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public TrainingSheet getByIdTrainingSheet(@PathVariable Integer id) {
		return trainingRepository.findById(id).get();
	}
	
	@GetMapping("/gettrainingsheet/{id}/{dayOfWeek}/{nameActivity}")
	public ArrayList<TrainingSheet> getTrainingSheet(@PathVariable Integer id, @PathVariable String dayOfWeek, @PathVariable String nameActivity){
		ArrayList <TrainingSheet> allTrainingSheet = getAllTrainingSheet();
		ArrayList <TrainingSheet> profileAllTrainingSheet = new ArrayList<>();
		
		for(TrainingSheet t : allTrainingSheet) {
			if(t.getUserProfile_id() == id && t.getDayOfWeek().toString().compareTo(dayOfWeek.toUpperCase()) == 0
					&& t.getNameActivity().toString().compareTo(nameActivity.toUpperCase()) == 0) {
				profileAllTrainingSheet.add(t);
			}
		}
		return profileAllTrainingSheet;
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public TrainingSheet insertTrainingSheet(@RequestBody TrainingSheet trainingSheet) {
		return trainingRepository.save(trainingSheet);
	}
	
	@PutMapping("/{id}")
	public TrainingSheet updateTrainingSheet(@PathVariable Integer id, @RequestBody TrainingSheet newTrainingSheet) {
		TrainingSheet updatedTraining = getByIdTrainingSheet(id);
		updatedTraining.setDayOfWeek(newTrainingSheet.getDayOfWeek());
		updatedTraining.setNameActivity(newTrainingSheet.getNameActivity());
		updatedTraining.setNameOfExercise(newTrainingSheet.getNameOfExercise());
		updatedTraining.setHourOfTraining(newTrainingSheet.getHourOfTraining());
		updatedTraining.setTime(newTrainingSheet.getTime());
		updatedTraining.setUserProfile_id(newTrainingSheet.getUserProfile_id());
		return trainingRepository.save(updatedTraining);
	}
	
	@DeleteMapping("/{id}")
	public TrainingSheet deleteTrainingSheet(@PathVariable Integer id) {
		TrainingSheet deletedTraining = getByIdTrainingSheet(id);
		trainingRepository.deleteById(id);
		return deletedTraining;
	}
}
