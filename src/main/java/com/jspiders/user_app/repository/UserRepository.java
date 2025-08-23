package com.jspiders.user_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.user_app.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserEmail(String email);
	Optional<User> findByUserName(String name);
}
