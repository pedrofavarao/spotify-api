package com.spotifyApi.domain.service.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spotifyApi.domain.dto.UserDto;
import com.spotifyApi.domain.model.User;
import com.spotifyApi.domain.model.mapper.UserMapper;
import com.spotifyApi.domain.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.userRepository.findByEmail(username).get();
	}
	@Override
	public UserDto createUser(UserDto userDto) {
		try {
			User user = UserMapper.dtoToUser(userDto);
			user.setPassword(passwordEncoder.encode(userDto.password()));

			User userCreated = this.userRepository.save(user);
			return new UserDto(userCreated.getId(), userCreated.getName(), userCreated.getEmail(), null);
		} catch (Exception e) {
			throw new RuntimeException("Error to create user. " + e.getMessage());
		}
	}

}