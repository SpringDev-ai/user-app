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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

/**
 * @author Vikram Pal
 * 
 *         This is the UserController class which handles HTTP requests related
 *         to user operations.
 * @RestController annotation indicates that this class is a RESTful
 *                 controller. @RequestMapping("/user") specifies the base URL
 *                 for all endpoints in this controller.
 */

@RestController
@RequestMapping("/user")
public class UserController {

// Injecting UserService to handle business logic.
	@Autowired
	private UserService userService;

	/**
	 * Registers a new user.
	 * 
	 * @param user, The user object to be registered, validated using @Valid
	 *              annotation.
	 * @return ResponseEntity containing the response structure and HTTP status.
	 *         ApiDocumentation annotations are used to describe the endpoint.
	 */

	@Operation(summary = "Register a new user", description = "Registers a new user with the provided details.")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "User created successfully"),
		                 	@ApiResponse(responseCode = "400", description = "Invalid input data") })
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
		ResponseStructure<User> structure = userService.registerUser(user);
		return new ResponseEntity<>(structure, HttpStatus.CREATED);
	}

	/**
	 * Fetches a user by their ID.
	 * 
	 * @param userId
	 * @return ResponseEntity with user data and HTTP status.
	 */

	@Operation(summary = "Get user by ID", description = "Fetches a user by their unique ID.")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "User found"),
			                @ApiResponse(responseCode = "404", description = "User not found") })
	@GetMapping("/getUser")
	public ResponseEntity<?> getUserById(@RequestParam int userId) {
		ResponseStructure<Optional<User>> structure = userService.getUserById(userId);
		return new ResponseEntity<>(structure, HttpStatus.FOUND);
	}

	/**
	 * Fetches all users.
	 * 
	 * @return ResponseEntity with list of users and HTTP status.
	 */

	@Operation(summary = "Get all users", description = "Fetches a list of all registered users.")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Users found"),
		                   	@ApiResponse(responseCode = "404", description = "No users found") })
	@GetMapping("/getAllUser")
	public ResponseEntity<?> getAllUser() {
		ResponseStructure<List<User>> structure = userService.getAllUser();
		return new ResponseEntity<>(structure, HttpStatus.FOUND);
	}

	/**
	 * Updates an existing user.
	 * 
	 * @param user,   The user object with updated details.
	 * @param userId, The ID of the user to be updated.
	 * @return ResponseEntity with updated user data and HTTP status.
	 */

	@Operation(summary = "Update user", description = "Updates an existing user's details.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "User updated successfully"),
			                @ApiResponse(responseCode = "404", description = "User not found"),
			                @ApiResponse(responseCode = "400", description = "Invalid input data") })
	@PutMapping("/update") // localhost:8080/user/update?userId=id
	public ResponseEntity<?> updateUser(@RequestBody User user, @RequestParam int userId) {
		ResponseStructure<User> structure = userService.updateUser(user, userId);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	/**
	 * Deletes a user by their ID.
	 * 
	 * @param userId, The ID of the user to be deleted.
	 * @return ResponseEntity with deletion status and HTTP status.
	 */

	@Operation(summary = "Delete user", description = "Deletes a user by their unique ID.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "User deleted successfully"),
		                   	@ApiResponse(responseCode = "404", description = "User not found") })
	@DeleteMapping("/delete") // localhost:8080/user/delete?userId=id
	public ResponseEntity<?> deleteUser(@RequestParam int userId) {
		ResponseStructure<String> structure = userService.deleteUser(userId);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	/**
	 * Fetches users in a paginated manner.
	 * 
	 * @param pageNo, The page number to fetch.
	 * @return ResponseEntity with paginated user data and HTTP status.
	 */

	@Operation(summary = "Get users by page", description = "Fetches users in a paginated manner.")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Users found"),
			                @ApiResponse(responseCode = "404", description = "No users found") })
	@GetMapping("/getUserPage") // localhost:8080/user/getUserPage?pageNo=2
	public ResponseEntity<?> getUserByPage(@RequestParam int pageNo) {
		ResponseStructure<Page<User>> structure = userService.getUserByPage(pageNo);
		return new ResponseEntity<>(structure, HttpStatus.FOUND);
	}

	/**
	 * Authenticates a user based on email and password.
	 * 
	 * @param user, The user object containing email and password.
	 * @return ResponseEntity with authentication status and HTTP status.
	 */
	@Operation(summary = "User login", description = "Authenticates a user with email and password.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Login successful"),
		                	@ApiResponse(responseCode = "401", description = "Invalid credentials") })
	@PostMapping("/login") // localhost:8080/user/login
	public ResponseEntity<?> login(@RequestBody User user) {
		ResponseStructure<Optional<User>> structure = userService.login(user.getUserEmail(), user.getUserPassword());
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

}
