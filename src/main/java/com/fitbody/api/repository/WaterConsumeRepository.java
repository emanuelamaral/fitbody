package com.fitbody.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitbody.api.entitie.WaterConsume;

@Repository
public interface WaterConsumeRepository extends JpaRepository<WaterConsume, Integer>{

}
