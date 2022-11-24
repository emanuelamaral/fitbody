package com.fitbody.api.controller;

import java.text.SimpleDateFormat;
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

import com.fitbody.api.entitie.Profile;
import com.fitbody.api.entitie.WaterConsume;
import com.fitbody.api.repository.UserProfileRepository;

@RestController
@RequestMapping("/user/profile")
public class UserProfileController {
	
	SimpleDateFormat birthdayFormated = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private UserProfileRepository userRepository;
	
	@GetMapping
	public List<Profile> getAllUserProfile(){
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Profile getByIdUserProfile(@PathVariable Integer id) {
		return userRepository.findById(id).get();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Profile insertUserProfile(@RequestBody Profile user) {
		return userRepository.save(user);
	}
	
	@PutMapping("/{id}")
	public Profile updateUserProfile(@PathVariable Integer id, @RequestBody Profile newUser) {
		Profile updatedUser = getByIdUserProfile(id);
		updatedUser.setBodyMensure(newUser.getBodyMensure());
		updatedUser.setGender(newUser.getGender());
		updatedUser.setGoals(newUser.getGoals());
		updatedUser.setHeight(newUser.getHeight());
		updatedUser.setCurrentWeight(newUser.getCurrentWeight());
		updatedUser.setNivelActivity(newUser.getNivelActivity());
		updatedUser.setBirthday(newUser.getBirthday());
		updatedUser.setWeightGoal(newUser.getWeightGoal());
		updatedUser.setPhysicalActivity(newUser.getPhysicalActivity());
		updatedUser.setTrainingSheet(newUser.getTrainingSheet());
		updatedUser.setWaterConsume(newUser.getWaterConsume());
		updatedUser.setWeight(newUser.getWeight());
		return userRepository.save(updatedUser);
	}
	
	@PutMapping("/waterconsume_id/{id}")
	public Profile updateUserProfileXWaterConsume(@PathVariable Integer id, @RequestBody WaterConsume newWaterConsume) {
		Profile updatedUser = getByIdUserProfile(id);
		updatedUser.setWaterConsume(newWaterConsume);
		return userRepository.save(updatedUser);
	}

	@DeleteMapping("/{id}")
	public Profile deleteUserProfile(@PathVariable Integer id) {
		Profile deletedUser = getByIdUserProfile(id);
		userRepository.deleteById(id);
		return deletedUser;
	}
}
