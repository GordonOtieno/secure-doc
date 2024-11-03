package com.gordon.doc_repo.controller;

import java.net.URI;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gordon.doc_repo.dto.Response;
import com.gordon.doc_repo.dto.UserRequest;
import com.gordon.doc_repo.entity.UserEntity;
import com.gordon.doc_repo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.gordon.doc_repo.utils.RequestUtils;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
	private final UserService userservice;
	
	@PostMapping("/register")
	public ResponseEntity<Response> saveUser(@RequestBody @Valid UserRequest user,HttpServletRequest request){
		userservice.createUser(user.getFirstname(), user.getLastName(), user.getEmail(), user.getPassword());
	
		return ResponseEntity.created(getUri()).body(RequestUtils.getResponse(request,emptyMap(), "Account Created. Check your email to enable your Account",HttpStatus.CREATED));
		
	}

	private Map<?, ?> emptyMap() {
		// TODO Auto-generated method stub
		return null;
	}

	private URI getUri() {
		// TODO Auto-generated method stub
		return URI.create("");
	}

}
