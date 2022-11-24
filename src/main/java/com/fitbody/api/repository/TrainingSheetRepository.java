package com.fitbody.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitbody.api.entitie.TrainingSheet;

@Repository
public interface TrainingSheetRepository extends JpaRepository<TrainingSheet, Integer>{

}
