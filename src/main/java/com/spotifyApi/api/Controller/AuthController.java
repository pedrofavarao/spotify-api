package com.spotifyApi.api.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.spotifyApi.domain.dto.AuthLoginDto;
import com.spotifyApi.domain.dto.JwtDto;
import com.spotifyApi.domain.dto.UserDto;
import com.spotifyApi.domain.model.User;
import com.spotifyApi.domain.service.auth.AuthService;
import com.spotifyApi.security.TokenService;
import com.spotifyApi.util.constant.PathConstants;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = PathConstants.BASE_PATH_AUTH, produces = "application/json", consumes = "application/json")
public class AuthController {

	private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final AuthService authService;

    public AuthController(
            TokenService tokenService,
            AuthenticationManager authenticationManager,
            AuthService authService
    ) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.authService = authService;
    }

    @PostMapping("/subscribe")
    @ResponseStatus(HttpStatus.CREATED)
    public JwtDto createUser(@RequestBody @Valid UserDto userDto, UriComponentsBuilder uriComponentsBuilder){
        UserDto createdUser = this.authService.createUser(userDto);
        String tokenJwt = this.tokenService.generateToken(createdUser);
        return new JwtDto(tokenJwt);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@RequestBody AuthLoginDto authLoginDto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authLoginDto.email(), authLoginDto.password());
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        String tokenJwt = this.tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new JwtDto(tokenJwt));
    }
}
