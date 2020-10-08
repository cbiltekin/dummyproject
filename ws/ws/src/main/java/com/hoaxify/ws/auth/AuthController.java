package com.hoaxify.ws.auth;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import com.hoaxify.ws.error.ApiError;
import com.hoaxify.ws.shared.CurrentUser;
import com.hoaxify.ws.shared.Views;
import com.hoaxify.ws.shared.Views.Sensitive;
import com.hoaxify.ws.user.User;
import com.hoaxify.ws.user.UserRepository;

@RestController
public class AuthController {
	@Autowired
	UserRepository userRepository;
	
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@PostMapping("/api/1.0/auth")
	@JsonView(Views.Base.class) //işaretli fieldları jsonda göster
	ResponseEntity<?> handleAuthentication(@CurrentUser User user) {
		return ResponseEntity.ok(user);
	}
}
