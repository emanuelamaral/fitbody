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

import com.fitbody.api.entitie.PhysicalActivity;
import com.fitbody.api.repository.PhysicalActivityRepository;

@RestController
@RequestMapping("/physicalact")
public class PhysicalActivityController {
	
	@Autowired
	private PhysicalActivityRepository physicalRepository;
	
	@GetMapping
	public ArrayList<PhysicalActivity> getAllPhysicalActivity(){
		return (ArrayList<PhysicalActivity>) physicalRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public PhysicalActivity getByIdPhysicalActivity(@PathVariable Integer id) {
		return physicalRepository.findById(id).get();
	}
	
	@GetMapping("/getallby_userprofileid/{id}")
	public ArrayList<PhysicalActivity> getAllByUserProfileId(@PathVariable Integer id){
		ArrayList<PhysicalActivity> physicalAct = getAllPhysicalActivity();
		ArrayList<PhysicalActivity> newPhysicalAct = new ArrayList <PhysicalActivity>();
		
		for(PhysicalActivity p: physicalAct) {
			if(p.getUserProfile_id() == id) {
				newPhysicalAct.add(p);
			}
			
		}
		
		return newPhysicalAct;
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public PhysicalActivity insertPhysicalActivity(@RequestBody PhysicalActivity physical) {
		return physicalRepository.save(physical);
	}
	
	@PutMapping("/{id}")
	public PhysicalActivity updatePhysicalActivity(@PathVariable Integer id, @RequestBody PhysicalActivity physical) {
		PhysicalActivity updatedPhysical = getByIdPhysicalActivity(id);
		updatedPhysical.setCalories(physical.getCalories());
		updatedPhysical.setTypeOfActivity(physical.getTypeOfActivity());
		updatedPhysical.setTime(physical.getTime());
		return physicalRepository.save(updatedPhysical);
	}
	
	@DeleteMapping("/{id}")
	public PhysicalActivity deletePhysicalActivity(@PathVariable Integer id) {
		PhysicalActivity deletedPhysical = getByIdPhysicalActivity(id);
		physicalRepository.deleteById(id);
		return deletedPhysical;
	}
}
