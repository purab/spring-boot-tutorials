package com.pkharat.smart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pkharat.smart.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
