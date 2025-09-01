package com.jspiders.user_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.user_app.entity.AdharCard;
import com.jspiders.user_app.service.AdharService;

@RestController
@RequestMapping("/adhar")
public class AdharController {

//	@Autowired
//	private AdharService adharService;
//	
//	@PostMapping("/register")
//	public ResponseEntity<?> registerAdhar(@RequestBody AdharCard adhar,@RequestParam int userId){
//		return new ResponseEntity<>(adharService.registerAdhar(adhar,userId),HttpStatus.CREATED);
//	}
}
