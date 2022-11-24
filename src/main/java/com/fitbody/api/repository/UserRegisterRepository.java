package com.fitbody.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fitbody.api.entitie.User;

@Repository
public interface UserRegisterRepository extends JpaRepository<User, Integer>{

}
