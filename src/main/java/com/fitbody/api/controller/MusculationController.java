package com.fitbody.api.controller;

import java.util.List;

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

import com.fitbody.api.entitie.Musculation;
import com.fitbody.api.repository.MusculationRepository;

@RestController
@RequestMapping("/musculation")
public class MusculationController {
	
	@Autowired
	private MusculationRepository musculationRepository;
	
	@GetMapping
	public List<Musculation> getAllMusculation(){
		return musculationRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Musculation getByIdMusculation(@PathVariable Integer id) {
		return musculationRepository.findById(id).get();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Musculation insertMusculation(@RequestBody Musculation musculation) {
		return musculationRepository.save(musculation);
	}
	
	@PutMapping("/{id}")
	public Musculation updateBodyMensure(@PathVariable Integer id, @RequestBody Musculation newMusculation) {
		Musculation updatedMusculation = getByIdMusculation(id);
		updatedMusculation.setBodyPart(newMusculation.getBodyPart());
		updatedMusculation.setReps(newMusculation.getReps());
		updatedMusculation.setSeries(newMusculation.getSeries());
		updatedMusculation.setNameOfExercise(newMusculation.getNameOfExercise());
		return musculationRepository.save(updatedMusculation);
	}
	
	@DeleteMapping("/{id}")
	public Musculation deleteMusculation(@PathVariable Integer id){
		Musculation deleteMusculation = getByIdMusculation(id);
		musculationRepository.deleteById(id);
		return deleteMusculation;
		
	}
}
