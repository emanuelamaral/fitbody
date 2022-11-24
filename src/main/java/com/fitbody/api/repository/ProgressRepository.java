package com.fitbody.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitbody.api.entitie.Progress;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Integer>{

}
