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

import com.fitbody.api.auth.UserAuth;
import com.fitbody.api.entitie.Profile;
import com.fitbody.api.entitie.User;
import com.fitbody.api.repository.UserRegisterRepository;

@RestController
@RequestMapping("/user")
public class UserRegisterController {
	
	@Autowired
	private UserRegisterRepository userRepository;
	
	@GetMapping
	public ArrayList<User> getAllUser(){
		return (ArrayList<User>) userRepository.findAll();
	}
	
	@GetMapping("/findid/{id}")
	public User getById(@PathVariable Integer id) {
		return userRepository.findById(id).get();
	}
	
	@GetMapping("/findemail/{email}")
	public User getByEmail(@PathVariable String email) {
		
		String emailVerify = null;
		ArrayList<User> users = getAllUser();
		
		for(int i = 0; i < users.size(); i++) {
			emailVerify = users.get(i).getEmail();
			if(emailVerify.compareTo(email) == 0) {
				return userRepository.findById(users.get(i).getUserId()).get();
				
			}
		}
		
		return null;
		
	}
	
	@PostMapping("/authentication")
	public User authUser(@RequestBody UserAuth userAuth) {
		
		User user = getByEmail(userAuth.getEmail());
		if(user != null) {
			if(user.getPassword().compareTo(userAuth.getPassword()) == 0) {
				return getById(user.getUserId()); 
			}
		} 
		
		return null;
	}
	
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public User insertUserRegister(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PutMapping("/{id}")
	public User updateUserRegister(@PathVariable Integer id, @RequestBody User user) {
		User userUpdated = getById(id);
		userUpdated.setUserName(user.getUserName());
		userUpdated.setPassword(user.getPassword());
		return userRepository.save(userUpdated);
		
	}
	
	@PutMapping("/change_user_profileid/{id}")
	public User updateUserProfileId(@PathVariable Integer id, @RequestBody Profile userProfile) {
		User userUpdated = getById(id);
		userUpdated.setUserProfile_id(userProfile);
		return userRepository.save(userUpdated);
	}
	
	
	
	@DeleteMapping("/{id}")
	public User deleteUserRegister(@PathVariable Integer id) {
		User deletedUser = getById(id);
		userRepository.deleteById(id);
		return deletedUser;
	}
	
}
