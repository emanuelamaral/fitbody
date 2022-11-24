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

import com.fitbody.api.entitie.Progress;
import com.fitbody.api.repository.ProgressRepository;

@RestController
@RequestMapping("/progress")
public class ProgressController {
	
	@Autowired
	private ProgressRepository progressRepository;
	
	@GetMapping
	public List<Progress> getallProgress(){
		return progressRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Progress getByIdProgress(@PathVariable Integer id) {
		return progressRepository.findById(id).get();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Progress insertProgress(@RequestBody Progress progress) {
		return progressRepository.save(progress);
	}
	
	@PutMapping("/{id}")
	public Progress updateProgress(@PathVariable Integer id, @RequestBody Progress newProgress) {
		Progress updatedProgress = getByIdProgress(id);
		updatedProgress.setCurrentWeight(newProgress.getCurrentWeight());
		updatedProgress.setUserProfile(newProgress.getUserProfile());
		return progressRepository.save(updatedProgress);
	}
	
	@DeleteMapping("/{id}")
	public Progress deleteProgress(@PathVariable Integer id) {
		Progress deletedProgress = getByIdProgress(id);
		progressRepository.deleteById(id);
		return deletedProgress;
	}
}
