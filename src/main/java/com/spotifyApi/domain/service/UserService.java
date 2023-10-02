package com.spotifyApi.domain.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spotifyApi.domain.model.User;
import com.spotifyApi.domain.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Component
public class UserService {
	private UserRepository userRepository;
	private PasswordEncoder encoder;
	
	public User salvar(User user){
		user.setPassword(this.encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
}
