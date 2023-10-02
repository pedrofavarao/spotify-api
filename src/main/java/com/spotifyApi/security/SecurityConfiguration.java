package com.spotifyApi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spotifyApi.util.constant.PathConstants;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
    private final SecurityFilter securityFilter;

	public SecurityConfiguration(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, PathConstants.BASE_PATH_AUTH_LOGIN).permitAll()
                .requestMatchers(HttpMethod.POST, PathConstants.BASE_PATH_AUTH_SUBSCRIBE).permitAll()
                .requestMatchers(HttpMethod.GET, "/musics/**").permitAll()
                .anyRequest().authenticated().and()
                .addFilterBefore(this.securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
