package com.fitbody.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitbody.api.entitie.Calorie;

@Repository
public interface CalorieRepository extends JpaRepository<Calorie, Integer>{

}
