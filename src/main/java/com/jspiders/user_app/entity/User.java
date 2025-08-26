package com.jspiders.user_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
//	@NotNull(message = "name can not be null")
//	@NotEmpty(message = "name can not be Empty")
	@NotBlank(message = "field must not contain empty,null,")
	@Size(min = 3, max = 255)
	@Pattern(regexp = "^[A-Za-z]*$")
	private String userName;
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid email format")
	private String userEmail;
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
//			 message = "Password must contain at least one digit, one lowercase letter, "
//					 + "one uppercase letter, one special character, no whitespace, "
//					 + "and be at least 8 characters long")
	private String userPassword;
	@Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Invalid contact number")
	private String userContact;
	private String address;
//	@Positive
//	@Max(value = 100)
//	@Min(value = 1)
//	private int age;

}
