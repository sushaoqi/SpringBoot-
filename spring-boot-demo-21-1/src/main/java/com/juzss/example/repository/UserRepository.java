package com.juzss.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juzss.example.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
