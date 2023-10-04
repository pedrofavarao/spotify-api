package com.spotifyApi.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spotifyApi.domain.model.Music;
import com.spotifyApi.domain.repository.MusicRepository;
import com.spotifyApi.domain.service.MusicService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/musics")
public class MusicController {
	@Autowired
	private MusicRepository musicRepository;
	@Autowired
	public MusicService musicService;
	
	@GetMapping
	public List<Music> listar(Music music){
		System.out.println("${jwt.token.secret}");
		return musicRepository.findAll();
	}
	
	@GetMapping("/{musicId}")
	public ResponseEntity<Music> buscar(@PathVariable Long musicId){
		return musicRepository.findById(musicId)
		.map(song -> ResponseEntity.ok(song))
		.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/trackName/{trackName}")
	public List<Music> buscarPorMusica(@PathVariable String trackName){
		return musicRepository.findByTrackNameContaining(trackName);
	}
	
	@GetMapping("/artistName/{artistName}")
	public List<Music> buscarPorArtista(@PathVariable String artistName){
		return musicRepository.findByArtistNameContaining(artistName);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Music adicionar(@Valid @RequestBody Music music) {
		return musicRepository.save(music);
	}
	
	@DeleteMapping("/{musicId}")
	public ResponseEntity<Void> deletar(@PathVariable Long musicId){
		if(!musicRepository.existsById(musicId)) {
			return ResponseEntity.notFound().build();
		}
		musicService.delete(musicId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{musicId}")
	public ResponseEntity<Music> atualizar(@Valid @PathVariable Long musicId,@RequestBody Music music){
		if(!musicRepository.existsById(musicId)) {
			return ResponseEntity.notFound().build();
		}
		music.setId(musicId);
		music = musicRepository.save(music);
		return ResponseEntity.ok(music);
	}
	
	@PatchMapping("/{musicId}")
	public ResponseEntity<Music> atualizarParcial(@Valid @PathVariable Long musicId,@RequestBody Music music){
		
		if(!musicRepository.existsById(musicId)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(musicService.atualizarParcial(musicId, music));
	}
}
