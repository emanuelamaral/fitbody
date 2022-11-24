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

import com.fitbody.api.entitie.Calorie;
import com.fitbody.api.repository.CalorieRepository;

@RestController
@RequestMapping("/calorie")
public class CalorieController {

	@Autowired
	private CalorieRepository calorieRepository;
	
	@GetMapping
	public List<Calorie> getAllCalorie(){
		return calorieRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Calorie getByIdCalorie(@PathVariable Integer id) {
		return calorieRepository.findById(id).get();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Calorie insertCalorie(@RequestBody Calorie calories) {
		return calorieRepository.save(calories);
	}
	
	@PutMapping("/{id}")
	public Calorie updateCalorie(@PathVariable Integer id, @RequestBody Calorie newCalorie) {
		Calorie updatedCalorie = getByIdCalorie(id);
		updatedCalorie.setCalories(newCalorie.getCalories());
		return calorieRepository.save(updatedCalorie);
	}
	
	@DeleteMapping("/{id}")
	public Calorie deleteCalorie(@PathVariable Integer id) {
		Calorie deletedCalorie = getByIdCalorie(id);
		calorieRepository.deleteById(id);
		return deletedCalorie;
	}
}
