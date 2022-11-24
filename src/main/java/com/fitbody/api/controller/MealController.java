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

import com.fitbody.api.entitie.Food;
import com.fitbody.api.entitie.Meal;
import com.fitbody.api.repository.MealRepository;

@RestController
@RequestMapping("/meal")
public class MealController {
	
	@Autowired
	private MealRepository mealRepository;
	
	@GetMapping
	public ArrayList<Meal> getAllMeal(){
		return (ArrayList<Meal>) mealRepository.findAll();
	}
	
	@GetMapping("/getallby_userprofileid/{id}")
	public ArrayList<Meal> getAllByUserProfileId(@PathVariable Integer id){
		ArrayList<Meal> meals = getAllMeal();
		ArrayList<Meal> userMeals = new ArrayList<>();
		
		for(Meal m: meals) {
			if(m.getUserProfile_id() == id) {
				userMeals.add(m);
			}
		}
		
		return userMeals;
	}
	
	@GetMapping("/getbyname/{mealName}")
	public Meal getByName(@PathVariable String mealName) {
		ArrayList<Meal> meals = getAllMeal();
		
		for(Meal m: meals) {
			if(m.getMealName().compareTo(mealName) == 0) {
				return m;
			}
		}
		
		return null;
	}
	
	@GetMapping("/{id}")
	public Meal getByIdMeal(@PathVariable Integer id) {
		return mealRepository.findById(id).get();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ArrayList<Meal> insertMeal(@RequestBody ArrayList<Meal> meal) {
		return (ArrayList<Meal>) mealRepository.saveAll(meal);
	}
	
	@PutMapping("/addfood_to_meal/{id}")
	public Meal addFoodToMeal(@PathVariable Integer id, @RequestBody ArrayList<Food> food){
		Meal meal = getByIdMeal(id);
		
		meal.setFood(food);
		
		return mealRepository.save(meal);
	}
	
	@PutMapping("/{id}")
	public Meal updateMeal(@PathVariable Integer id, @RequestBody Meal newMeal) {
		Meal updatedMeal = getByIdMeal(id);
		updatedMeal.setMealName(newMeal.getMealName());
		updatedMeal.setMealTime(newMeal.getMealTime());
		updatedMeal.setFood(newMeal.getFood());
		updatedMeal.setCalorie(newMeal.getCalorie());
		return mealRepository.save(updatedMeal);
	}
	
	@DeleteMapping("/{id}")
	public Meal deleteMeal(@PathVariable Integer id){
		Meal deletedMeal = getByIdMeal(id);
		mealRepository.deleteById(id);
		return deletedMeal;
	}
	
	
}
