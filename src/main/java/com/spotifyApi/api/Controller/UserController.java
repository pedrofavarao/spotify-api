package com.spotifyApi.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spotifyApi.domain.model.User;
import com.spotifyApi.domain.repository.UserRepository;
import com.spotifyApi.domain.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> listar(){
		return userRepository.findAll();
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> buscarPorId(@PathVariable Long userId) {
		return userRepository.findById(userId)
				.map(user -> ResponseEntity.ok(user))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deletar(@PathVariable Long userId){
		if(!userRepository.existsById(userId)) return ResponseEntity.notFound().build();
		userRepository.deleteById(userId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{userId}")
	public ResponseEntity<User> atualizar(@Valid @PathVariable Long userId,@RequestBody User user){
		if(!userRepository.existsById(userId)) {
			return ResponseEntity.notFound().build();
		}
		user.setId(userId);
		user = userService.save(user);
		return ResponseEntity.ok(user);
	}
	
	@PatchMapping("/{userId}")
	public ResponseEntity<User> atualizarParcial(@Valid @PathVariable Long userId,@RequestBody User user){
		
		if(!userRepository.existsById(userId)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userService.atualizarParcial(userId, user));
	}
}
