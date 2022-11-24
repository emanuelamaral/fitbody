package com.fitbody.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitbody.api.entitie.PhysicalActivity;

@Repository
public interface PhysicalActivityRepository extends JpaRepository<PhysicalActivity, Integer>{

}
