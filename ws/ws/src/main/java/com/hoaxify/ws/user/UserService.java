package com.hoaxify.ws.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	UserRepository userRepository;
	
	PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}


	public void save(User user) {
		String encyrptedPassword = this.passwordEncoder.encode(user.getPassword());
		user.setPassword(encyrptedPassword);
		userRepository.save(user);
		
	}

}
