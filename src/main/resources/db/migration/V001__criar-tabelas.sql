create table most_streamed_songs(
	id bigint not null auto_increment,
	track_name varchar(255),
	artist_name varchar(255),
	artist_count varchar(255),
	released_year bigint,
	released_month bigint,
	released_day bigint,
	in_spotify_playlists bigint,
	in_spotify_charts bigint,
	streams bigint,
	in_apple_playlists bigint,
	in_apple_charts bigint,
	in_deezer_playlists bigint,
	in_deezer_charts bigint,
	in_shazam_charts bigint,
	bpm bigint,
	key_song varchar(5),
	mode varchar(255),
	danceability_percent bigint,
	valence_percent bigint,
	energy_percent bigint,
	acousticness_percent varchar(255),
	instrumentalness_percent bigint,
	liveness_percent bigint,
	speechiness_percent bigint,
		
	primary key (id)
);

create table user (
	id bigint not null auto_increment,
	name varchar(255)not null,
	email varchar(255) not null unique,
	password varchar(255)not null,
	
	primary key (id)
);
