package com.fitbody.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitbody.api.entitie.BodyMensure;

@Repository
public interface BodyMensureRepository extends JpaRepository<BodyMensure, Integer>{

}
