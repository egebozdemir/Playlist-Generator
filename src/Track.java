
public class Track {
	
	private int genre_id = 0;			// Basic entity class for tracks.
	private int track_id = 0;
	private int track_duration;
	private int track_popularity;
	
	public Track(int genre_id, int track_id, int track_duration, int track_popularity) {
		
		this.genre_id = genre_id;
		this.track_id = track_id;
		this.track_duration = track_duration;
		this.track_popularity = track_popularity;
		
	}

	public int getGenre_id() {
		return genre_id;
	}

	public int getTrack_id() {
		return track_id;
	}

	public int getTrack_duration() {
		return track_duration;
	}

	public int getTrack_popularity() {
		return track_popularity;
	}

	@Override
	public String toString() {
		return "Track [genre_id=" + genre_id + ", track_id=" + track_id + ", track_duration=" + track_duration
				+ ", track_popularity=" + track_popularity + "]";
	}
	
	
}
