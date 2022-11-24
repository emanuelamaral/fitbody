package com.fitbody.api.controller;

import java.util.ArrayList;
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

import com.fitbody.api.entitie.BodyMensure;
import com.fitbody.api.repository.BodyMensureRepository;

@RestController
@RequestMapping("/bodymensure")
public class BodyMensureController {
	
	@Autowired
	private BodyMensureRepository bodyRepository;
	
	@GetMapping
	public ArrayList<BodyMensure> getAllBodyMensure(){
		return (ArrayList<BodyMensure>) bodyRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public BodyMensure getByIdBodyMensure(@PathVariable Integer id) {
		return bodyRepository.findById(id).get();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ArrayList<BodyMensure> insertBodyMensure(@RequestBody ArrayList<BodyMensure> bodyMensure) {
		return (ArrayList<BodyMensure>) bodyRepository.saveAll(bodyMensure);
	}
	
	@PutMapping("/{id}")
	public BodyMensure updateBodyMensure(@PathVariable Integer id, @RequestBody BodyMensure newBodyMensure) {
		BodyMensure updatedBody = getByIdBodyMensure(id);
		updatedBody.setBodyPart(newBodyMensure.getBodyPart());
		updatedBody.setMensure(newBodyMensure.getMensure());
		return bodyRepository.save(updatedBody);
	}
	
	@DeleteMapping("/{id}")
	public BodyMensure deleteBodyMensure(@PathVariable Integer id){
		BodyMensure deleteBody = getByIdBodyMensure(id);
		bodyRepository.deleteById(id);
		return deleteBody;
		
	}
	
}
