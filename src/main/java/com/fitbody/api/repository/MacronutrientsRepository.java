package com.fitbody.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitbody.api.entitie.Macronutrients;

@Repository
public interface MacronutrientsRepository extends JpaRepository<Macronutrients, Integer>{

}
