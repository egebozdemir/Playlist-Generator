
public class Bag<T> implements IBag<T> {
	
	private DynamicArray<T> bag;
	private int capacity;			// total capacity
	private int currentSize;  // current size default = 0
	
	public Bag(int capacity) {
		
		this.capacity = capacity;
		bag = new DynamicArray<T>();
		currentSize = 0;
	}

	@Override
	public boolean add(T itemT) {
		
		if (!this.isFull()) {
			bag.addItem(itemT);
			if (itemT instanceof Track) {
				this.currentSize += ((Track) itemT).getTrack_duration();
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(T itemT) {
		if (!this.isEmpty()) {
			bag.removeItemByName(itemT);
			if (itemT instanceof Track) {
				this.currentSize -= ((Track) itemT).getTrack_duration();
			}
			return true;
		}
		return false;
	}
	@SuppressWarnings("unchecked")
	public Track removeMostPopularTrack() {
		Track track = null, removedTrack = null;
		int popularity = 0;
		for (int i = 0; i < bag.getSize(); i++) {
			track = (Track) bag.getItem(i);
			if (popularity < track.getTrack_popularity()) {
				popularity = track.getTrack_popularity();
				removedTrack = track;	
			}
		}
		this.currentSize -= removedTrack.getTrack_duration();
		bag.removeItemByName((T) removedTrack);
		return removedTrack;
	}
	@Override
	public int getCurrrentSize() {
	
		return this.currentSize;
	}
	
	public int getNumberOfItems() {
		return bag.getSize();
	}
	
	@Override
	public boolean isEmpty() {
		if (this.currentSize == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (this.currentSize >= this.capacity) {
			return true;
		}
		return false;
	}


	@Override
	public boolean contains(T itemT) {
		for (int i = 0; i < bag.getSize(); i++) {
			if (bag.getItem(i).equals(itemT)) {
				return true;
			}
		}
		return false;
	}
	
	
	public int getAveragePopularityTracks() {
		int popularity = 0;
		int mean;
		for (int i = 0; i < bag.getSize(); i++) {
			popularity = popularity + ((Track)bag.getItem(i)).getTrack_popularity();
		}
		if (bag.getSize() == 0) {
			mean = popularity/1;
		}else {
			mean = popularity/bag.getSize();
		}
		
		return mean;
	}

	@Override
	public String toString() {
		return "Bag [bag=" + bag + "]";
	}

	public void displayAll() {
		
		for (int i = 0; i < bag.getSize(); i++) {
			
			System.out.println(bag.getItem(i).toString());
			
		}
		
	}

	public int getCapacity() {
		return capacity;
	}
}
