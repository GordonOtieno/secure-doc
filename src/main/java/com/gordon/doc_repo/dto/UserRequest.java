package com.gordon.doc_repo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {
	@NotEmpty(message = "First name Cannot be Empty or null")
	private String firstname;
	@NotEmpty(message = "Last name Cannot be Empty or null")
	private String lastName;
	@NotEmpty(message = "Email Cannot be Empty or null")
	@Email(message = "Invalid email address")
	private String email;
	@NotEmpty(message = "Password Cannot be Empty or null")
	private String password;
	private String bio;
	private String phone;

}
