package com.example2.motor2.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example2.motor2.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {}