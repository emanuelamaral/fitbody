package com.fitbody.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitbody.api.entitie.Musculation;

@Repository
public interface MusculationRepository extends JpaRepository<Musculation, Integer>{

}
