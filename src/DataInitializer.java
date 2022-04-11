

public class DataInitializer {
	
	public DynamicArray<Track> initializeAll() {    // This method initialize all track obj
		CSVReader reader = new CSVReader();			//ect with using initializer method. returns 
		DynamicArray<Integer> tempArray = new DynamicArray<>();	// Dynamic array with track objects
		DynamicArray<Track> tempTrack = new DynamicArray<>();
		
		tempArray = reader.readData();
		
		for (int i = 0; i < tempArray.getSize(); i+=4) {
			tempTrack.addItem(initializer(tempArray.getItem(i),
					tempArray.getItem(i+1),
					tempArray.getItem(i+2), 
					tempArray.getItem(i+3)));
		}
		return tempTrack;	
	}
										//this method calls track constructor for creating object
	public Track initializer(int genre_id, int track_id, int track_duration, int track_popularity) {
		Track track = new Track(genre_id, track_id, track_duration, track_popularity);
		return track;
	}
	
}
