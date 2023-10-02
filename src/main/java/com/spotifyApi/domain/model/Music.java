package com.spotifyApi.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name = "most_streamed_songs")
public class Music {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "track_name")
	private String trackName;
	
	@Column(name = "artist_name")
	private String artistName;
	
	@Column(name = "artist_count")
	private Long artistCount;
	
	@Column(name = "released_year")
	private Long releasedYear;
	
	@Column(name = "released_month")
	private Long releasedMonth;
	
	@Column(name = "released_day")
	private Long releasedDay;
	
	@Column(name = "in_spotify_playlists")
	private Long inSpotifyPlaylists;
	
	@Column(name = "in_spotify_charts")
	private Long inSpotifyCharts;
	
	@Column(name = "streams")
	private Long streams;
	
	@Column(name = "in_apple_playlists")
	private Long inApplePlaylists;
	
	@Column(name = "in_apple_charts")
	private Long inAppleCharts;
	
	@Column(name = "in_deezer_playlists")
	private Long inDeezerPlaylists;
	
	@Column(name = "in_deezer_charts")
	private Long inDeezerCharts;
	
	@Column(name = "in_shazam_charts")
	private Long inShazamCharts;
	
	@Column(name = "bpm")
	private Long bpm;
	
	@Column(name = "key_song")
	private String key;
	
	@Column(name = "mode")
	private String mode;
	
	@Column(name = "danceability_percent")
	private Long danceability;
	
	@Column(name = "valence_percent")
	private Long valence;
	
	@Column(name = "energy_percent")
	private Long energy;
	
	@Column(name = "acousticness_percent")
	private Long acousticness;
	
	@Column(name = "instrumentalness_percent")
	private Long instrumentalness;
	
	@Column(name = "liveness_percent")
	private Long liveness;
	
	@Column(name = "speechiness_percent")
	private Long speechiness;
}
