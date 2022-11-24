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

import com.fitbody.api.entitie.WaterConsume;
import com.fitbody.api.repository.WaterConsumeRepository;

@RestController
@RequestMapping("/water")
public class WaterConsumeController {
	
	@Autowired
	private WaterConsumeRepository waterRepository;
	
	@GetMapping
	public List<WaterConsume> getAllWater(){
		return waterRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public WaterConsume getByIdWaterConsume(@PathVariable Integer id){
		return waterRepository.findById(id).get();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public WaterConsume insertWateerConsume(@RequestBody WaterConsume waterConsume) {
		return waterRepository.save(waterConsume);
	}
	
	@PutMapping("/{id}")
	public WaterConsume updateWaterConsume(@PathVariable Integer id, @RequestBody WaterConsume newWaterConsume) {
		WaterConsume updatedWaterConsume = getByIdWaterConsume(id);
		updatedWaterConsume.setWaterConsumedPerDay(newWaterConsume.getWaterConsumedPerDay());
		return waterRepository.save(updatedWaterConsume);
	}
	
	@DeleteMapping("/{id}")
	public WaterConsume deleteWaterConsume(@PathVariable Integer id) {
		WaterConsume deletedWaterConsume = getByIdWaterConsume(id);
		waterRepository.deleteById(id);
		return deletedWaterConsume;
	}
}
