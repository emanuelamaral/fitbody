package com.fitbody.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitbody.api.entitie.Goals;
import com.fitbody.api.repository.GoalsRepository;

@RestController
@RequestMapping("/goals")
public class GoalsController {
	
	@Autowired
	private GoalsRepository goalsRepository;
	
	@GetMapping
	public List<Goals> getAllGoals(){
		return goalsRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Goals getByIdGoals(@PathVariable Integer id) {
		return goalsRepository.findById(id).get();
	}
	
	@PostMapping
	public Goals insertGoals(@RequestBody Goals goal) {
		return goalsRepository.save(goal);
	}
	
	@PutMapping("/{id}")
	public Goals updateGoals(@PathVariable Integer id, @RequestBody Goals goal) {
		Goals updatedGoals = getByIdGoals(id);
		updatedGoals.setDate(goal.getDate());
		updatedGoals.setGoalsDescription(goal.getGoalsDescription());
		updatedGoals.setGoalsType(goal.getGoalsType());
		return goalsRepository.save(goal);
	}
	
	@DeleteMapping("/{id}")
	public Goals deleteGoals(@PathVariable Integer id) {
		Goals deletedGoals = getByIdGoals(id);
		goalsRepository.deleteById(id);
		return deletedGoals;
	}
}
