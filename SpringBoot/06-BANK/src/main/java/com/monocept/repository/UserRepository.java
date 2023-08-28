package com.monocept.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
