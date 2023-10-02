package com.spotifyApi.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginDto (

        @NotBlank(message = "Email is required.")
        String email,

        @NotBlank(message = "Password is required.")
        String password
) { }
