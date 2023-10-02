package com.spotifyApi.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDto(
		
	Long id,
	
	@NotBlank(message = "Name is required.")
    String name,
		
	@NotBlank(message = "Email is required.")
	@Email
	String email,
	
	@NotBlank(message = "Password is required.")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	String password
		
		
) {}
