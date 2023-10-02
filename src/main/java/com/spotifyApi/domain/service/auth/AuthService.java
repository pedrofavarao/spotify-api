package com.spotifyApi.domain.service.auth;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.spotifyApi.domain.dto.UserDto;

@Service
public interface AuthService extends UserDetailsService {
	UserDto createUser(UserDto userDto);
}
