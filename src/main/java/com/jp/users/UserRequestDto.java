package com.jp.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequestDto {	
	
	@Email
	private String email;
	
	@NotBlank(message = "Password should not be Null or Empty")
	@Size(min = 2,max = 10,message="Please enter valid password")
	private String password;

	public UserRequestDto() {

	}

	public UserRequestDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
