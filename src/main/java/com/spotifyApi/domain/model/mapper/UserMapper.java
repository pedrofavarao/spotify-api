package com.spotifyApi.domain.model.mapper;

import com.spotifyApi.domain.dto.UserDto;
import com.spotifyApi.domain.model.User;

public class UserMapper {

    public static User dtoToUser(UserDto userDto) {
    	User user = new User(userDto.name(), userDto.email(), userDto.password());
		return user;
    }
    
    public static UserDto userToDto(User user) {
    	UserDto userDto = new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    	return userDto;
    }
}
