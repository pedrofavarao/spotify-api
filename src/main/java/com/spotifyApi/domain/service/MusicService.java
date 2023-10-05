package com.spotifyApi.domain.service;

import org.springframework.stereotype.Service;

import com.spotifyApi.domain.model.Music;
import com.spotifyApi.domain.repository.MusicRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MusicService{
	MusicRepository musicRepository;
	
	public Music save(Music music) {
		return musicRepository.save(music);
	}
	
	public void delete(Long musicId){
		musicRepository.deleteById(musicId);
	}
	
	public Music atualizarParcial(Long musicId, Music music) {
		Music musicInDatabase = musicRepository.findById(musicId).get();
		
		if(music.getTrackName() != null) musicInDatabase.setTrackName(music.getTrackName());
		if(music.getArtistName() != null) musicInDatabase.setArtistName(music.getArtistName());
		if(music.getArtistCount() != null) musicInDatabase.setArtistCount(music.getArtistCount());
		if(music.getReleasedYear() != null) musicInDatabase.setReleasedYear(music.getReleasedYear());
		if(music.getReleasedMonth() != null) musicInDatabase.setReleasedMonth(music.getReleasedMonth());
		if(music.getReleasedDay() != null) musicInDatabase.setReleasedDay(music.getReleasedDay());
		if(music.getInSpotifyPlaylists() != null) musicInDatabase.setInSpotifyPlaylists(music.getInSpotifyPlaylists());
		if(music.getInSpotifyCharts() != null) musicInDatabase.setInSpotifyCharts(music.getInSpotifyCharts());
		if(music.getStreams() != null) musicInDatabase.setStreams(music.getStreams());
		if(music.getInApplePlaylists() != null) musicInDatabase.setInApplePlaylists(music.getInApplePlaylists());
		if(music.getInAppleCharts() != null) musicInDatabase.setInAppleCharts(music.getInAppleCharts());
		if(music.getInDeezerPlaylists() != null) musicInDatabase.setInDeezerPlaylists(music.getInDeezerPlaylists());
		if(music.getInDeezerCharts() != null) musicInDatabase.setInDeezerCharts(music.getInDeezerCharts());
		if(music.getInShazamCharts() != null) musicInDatabase.setInShazamCharts(music.getInShazamCharts());
		if(music.getBpm() != null) musicInDatabase.setBpm(music.getBpm());
		if(music.getKey() != null) musicInDatabase.setKey(music.getKey());
		if(music.getMode() != null) musicInDatabase.setMode(music.getMode());
		if(music.getDanceability() != null) musicInDatabase.setDanceability(music.getDanceability());
		if(music.getValence() != null) musicInDatabase.setValence(music.getValence());
		if(music.getEnergy() != null) musicInDatabase.setEnergy(music.getEnergy());
		if(music.getAcousticness() != null) musicInDatabase.setAcousticness(music.getAcousticness());
		if(music.getInstrumentalness() != null) musicInDatabase.setInstrumentalness(music.getInstrumentalness());
		if(music.getLiveness() != null) musicInDatabase.setLiveness(music.getLiveness());
		if(music.getSpeechiness() != null) musicInDatabase.setSpeechiness(music.getSpeechiness());
		
		return this.save(musicInDatabase);
	}
}
