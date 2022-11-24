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

import com.fitbody.api.entitie.Food;
import com.fitbody.api.repository.FoodRepository;

@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private FoodRepository foodRepository;

	@GetMapping
	public ArrayList<Food> getAllFood() {
		return (ArrayList<Food>) foodRepository.findAll();
	}

	@GetMapping("/{id}")
	public Food getByIdFood(@PathVariable Integer id) {
		return foodRepository.findById(id).get();
	}

	@GetMapping("/getallfoods_byuserprofile_id/{id}")
	public ArrayList<Food> getAllFoodByUserProfileId(@PathVariable Integer id){
		ArrayList<Food> allFoods = getAllFood();
		ArrayList<Food> allFoodsByUser = new ArrayList<>();
		
		for(Food f: allFoods){
			if(f.getUserProfile_id() == id) {
				allFoodsByUser.add(f);
			}
		}
		
		return allFoodsByUser;
	}
	
	@GetMapping("/getallfoods_bymeal_id/{id}")
	public ArrayList<Food> getAllFoodsByMealId(@PathVariable Integer id){
		ArrayList<Food> allFoods = getAllFood();
		ArrayList<Food> allFoodsByMeal = new ArrayList<>();
		
		for(Food f: allFoods){
			if(f.getMeal_id() == id) {
				allFoodsByMeal.add(f);
			}
		}
		
		return allFoodsByMeal;
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ArrayList<Food> insertFood(@RequestBody ArrayList<Food> food) {
		return (ArrayList<Food>) this.foodRepository.saveAll(food);
	}

	@PutMapping("/{id}")
	public Food updateFood(@PathVariable Integer id, @RequestBody Food newFood) {
		Food updatedFood = getByIdFood(id);
		updatedFood.setFoodName(newFood.getFoodName());
		updatedFood.setWeightFood(newFood.getWeightFood());
		return foodRepository.save(updatedFood);
	}

	@DeleteMapping("/{id}")
	public Food deleteFood(@PathVariable Integer id) {
		Food deletedFood = getByIdFood(id);
		foodRepository.deleteById(id);
		return deletedFood;
	}
}
