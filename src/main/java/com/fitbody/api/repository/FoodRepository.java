package com.fitbody.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitbody.api.entitie.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer>{

}
