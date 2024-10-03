package com.jp.users;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@PostMapping
	public String createUser(@Valid @RequestBody UserRequestDto request) {
		return "Request Received";
	}

}
