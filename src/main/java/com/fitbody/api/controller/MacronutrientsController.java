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

import com.fitbody.api.entitie.Macronutrients;
import com.fitbody.api.repository.MacronutrientsRepository;

@RestController
@RequestMapping("/macro")
public class MacronutrientsController {

	@Autowired
	private MacronutrientsRepository macroRepository;
	
	@GetMapping
	public List<Macronutrients> getAllProtein(){
		return macroRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Macronutrients getByIdMacro(@PathVariable Integer id) {
		return macroRepository.findById(id).get();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Macronutrients insertMacronutrients(@RequestBody Macronutrients macro) {
		return macroRepository.save(macro);
	}
	
	@PutMapping("/{id}")
	public Macronutrients updateMacronutrients(@PathVariable Integer id, @RequestBody Macronutrients newMacro) {
		Macronutrients updatedMacro = getByIdMacro(id);
		updatedMacro.setProtein(newMacro.getProtein());
		updatedMacro.setCarbohydrate(newMacro.getCarbohydrate());
		updatedMacro.setFat(newMacro.getFat());
		return updatedMacro;
	}
	
	@DeleteMapping("/{id}")
	public Macronutrients deleteMacronutrients(@PathVariable Integer id) {
		Macronutrients deletedMacro = getByIdMacro(id);
		macroRepository.deleteById(id);
		return deletedMacro;
	}
}
