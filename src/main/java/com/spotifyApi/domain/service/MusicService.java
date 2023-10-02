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
		Music musicTemp = musicRepository.findById(musicId).orElse(null);
		
		if(music.getTrackName() != null) musicTemp.setTrackName(music.getTrackName());
		if(music.getArtistName() != null) musicTemp.setArtistName(music.getArtistName());
		if(music.getArtistCount() != null) musicTemp.setArtistCount(music.getArtistCount());
		if(music.getReleasedYear() != null) musicTemp.setReleasedYear(music.getReleasedYear());
		if(music.getReleasedMonth() != null) musicTemp.setReleasedMonth(music.getReleasedMonth());
		if(music.getReleasedDay() != null) musicTemp.setReleasedDay(music.getReleasedDay());
		if(music.getInSpotifyPlaylists() != null) musicTemp.setInSpotifyPlaylists(music.getInSpotifyPlaylists());
		if(music.getInSpotifyCharts() != null) musicTemp.setInSpotifyCharts(music.getInSpotifyCharts());
		if(music.getStreams() != null) musicTemp.setStreams(music.getStreams());
		if(music.getInApplePlaylists() != null) musicTemp.setInApplePlaylists(music.getInApplePlaylists());
		if(music.getInAppleCharts() != null) musicTemp.setInAppleCharts(music.getInAppleCharts());
		if(music.getInDeezerPlaylists() != null) musicTemp.setInDeezerPlaylists(music.getInDeezerPlaylists());
		if(music.getInDeezerCharts() != null) musicTemp.setInDeezerCharts(music.getInDeezerCharts());
		if(music.getInShazamCharts() != null) musicTemp.setInShazamCharts(music.getInShazamCharts());
		if(music.getBpm() != null) musicTemp.setBpm(music.getBpm());
		if(music.getKey() != null) musicTemp.setKey(music.getKey());
		if(music.getMode() != null) musicTemp.setMode(music.getMode());
		if(music.getDanceability() != null) musicTemp.setDanceability(music.getDanceability());
		if(music.getValence() != null) musicTemp.setValence(music.getValence());
		if(music.getEnergy() != null) musicTemp.setEnergy(music.getEnergy());
		if(music.getAcousticness() != null) musicTemp.setAcousticness(music.getAcousticness());
		if(music.getInstrumentalness() != null) musicTemp.setInstrumentalness(music.getInstrumentalness());
		if(music.getLiveness() != null) musicTemp.setLiveness(music.getLiveness());
		if(music.getSpeechiness() != null) musicTemp.setSpeechiness(music.getSpeechiness());
		
		return musicRepository.save(musicTemp);
	}
}
