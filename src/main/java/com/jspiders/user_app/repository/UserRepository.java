package com.jspiders.user_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.user_app.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
