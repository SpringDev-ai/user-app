package com.jspiders.user_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.user_app.entity.User;
import com.jspiders.user_app.service.UserService;
import com.jspiders.user_app.util.ResponseStructure;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		ResponseStructure<User> structure = userService.registerUser(user);
		return new ResponseEntity<>(structure, HttpStatus.CREATED);
	}

	@GetMapping("/getUser")
	public ResponseEntity<?> getUserById(@RequestParam int userId) {
		ResponseStructure<Optional<User>> structure = userService.getUserById(userId);
		return new ResponseEntity<>(structure, HttpStatus.FOUND);
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<?> getAllUser() {
		ResponseStructure<List<User>> structure = userService.getAllUser();
		return new ResponseEntity<>(structure, HttpStatus.FOUND);
	}

	@PutMapping("/update") // localhost:8080/user/update?userId=id
	public ResponseEntity<?> updateUser(@RequestBody User user, @RequestParam int userId) {
		ResponseStructure<User> structure = userService.updateUser(user, userId);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@DeleteMapping("/delete") // localhost:8080/user/delete?userId=id
	public ResponseEntity<?> deleteUser(@RequestParam int userId) {
		ResponseStructure<String> structure = userService.deleteUser(userId);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	@GetMapping("/getUserPage") // localhost:8080/user/getUserPage?pageNo=2
	public ResponseEntity<?> getUserByPage(@RequestParam int pageNo) {
		ResponseStructure<Page<User>> structure = userService.getUserByPage(pageNo);
		return new ResponseEntity<>(structure, HttpStatus.FOUND);
	}

}
