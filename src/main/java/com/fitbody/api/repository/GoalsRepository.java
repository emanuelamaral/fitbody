package com.fitbody.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitbody.api.entitie.Goals;

@Repository
public interface GoalsRepository extends JpaRepository<Goals, Integer>{

}
