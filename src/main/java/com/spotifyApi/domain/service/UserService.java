package com.spotifyApi.domain.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spotifyApi.domain.model.User;
import com.spotifyApi.domain.repository.UserRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Component
public class UserService {
	private UserRepository userRepository;
	private PasswordEncoder encoder;
	
	public User save(User user){
		user.setPassword(this.encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public User atualizarParcial(@Valid Long userId, User user) {
		User userInDatabase = userRepository.findById(userId).get();

		if(user.getEmail() != null) userInDatabase.setEmail(user.getEmail());
		if(user.getName() != null) userInDatabase.setName(user.getName());
		if(user.getPassword() != null) userInDatabase.setPassword(user.getPassword());
		return this.save(userInDatabase);
	}
	
}
