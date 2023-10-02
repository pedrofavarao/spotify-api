package com.spotifyApi.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spotifyApi.domain.model.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long>{
	List<Music> findByTrackName(String trackName);
	List<Music> findByTrackNameContaining(String trackName);
	List<Music> findByArtistNameContaining(String artistName);
}
