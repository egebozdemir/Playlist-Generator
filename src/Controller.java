import java.util.Scanner;

public class Controller {
	
	@SuppressWarnings("rawtypes")
	public Bag[] createGenres() {				// this methods creates separate collection
		Bag[] bagArray = new Bag[6];		// of tracks.
		
		Bag<Track> acousticBag = new Bag<>(Integer.MAX_VALUE);
		Bag<Track> instrumentalBag = new Bag<>(Integer.MAX_VALUE);
		Bag<Track> rockBag = new Bag<>(Integer.MAX_VALUE);
		Bag<Track> rapBag = new Bag<>(Integer.MAX_VALUE);
		Bag<Track> jazzBag = new Bag<>(Integer.MAX_VALUE);
		Bag<Track> popBag = new Bag<>(Integer.MAX_VALUE);
		
		DataInitializer dInitializer = new DataInitializer();
		DynamicArray<Track> temp = new DynamicArray<>();
		
		temp = dInitializer.initializeAll(); // initializing track objects
		
		for (int i = 0; i < temp.getSize(); i++) {
			int key = temp.getItem(i).getGenre_id();
			switch (key) {
			case 1:
				acousticBag.add(temp.getItem(i));
				break;
			case 2:
				instrumentalBag.add(temp.getItem(i));
				break;
			case 3:
				rockBag.add(temp.getItem(i));
				break;
			case 4:
				rapBag.add(temp.getItem(i));
				break;
			case 5:
				jazzBag.add(temp.getItem(i));
				break;
			case 6:
				popBag.add(temp.getItem(i));
				break;
			default:
				System.out.println("Error. Illegal Argument.");
				break;
			}
		}
		
		bagArray[0] = acousticBag;
		bagArray[1] = instrumentalBag;
		bagArray[2] = rockBag;
		bagArray[3] = rapBag;
		bagArray[4] = jazzBag;
		bagArray[5] = popBag;
		
		return bagArray;	// returns array of genres
	}
	
	public Bag<Track> createPlaylist(int type) {
		
		Bag<Track> playlist = null;			// creates playlist based on user input
		
		switch (type) {
		case 1:
			playlist = new Bag<>(2700); // Sleeping
			System.out.println("\nSelected playlist is SLEEPING");
			break;
		case 2:
			playlist = new Bag<>(3600); // Work out
			System.out.println("\nSelected playlist is WORKOUT");
			break;
		case 3:
			playlist = new Bag<>(5400); // Dining
			System.out.println("\nSelected playlist is DINING");
			break;
		case 4:
			playlist = new Bag<>(7200); //Meditation
			System.out.println("\nSelected playlist is MEDITATION");
			break;
		case 5:
			playlist = new Bag<>(10800); //Road Trip
			System.out.println("\nSelected playlist is ROAD TRIP");
			break;
		default:
			throw new IllegalArgumentException();
		}
		return playlist;
	}
	
	public void fillPlaylist(int playlistType, Bag<Track>[] genres,
											   Bag<Track> playlist) {
		int f,s,t;
		switch (playlistType) {			// fills playlist based on suitbale genre
		case 1:
			f=1;s=0;t=4;
			break;
		case 2:
			f=3;s=2;t=5;
			break;
		case 3:
			f=4;s=0;t=1;
			break;
		case 4:
			f=1;s=0;t=4;
			break;
		case 5:
			f=2;s=5;t=0;
			break;
		default:
			throw new IllegalArgumentException();
		}
		
		while (!playlist.isFull()) {
			
			if(!genres[f].isEmpty()) {
				playlist.add(genres[f].removeMostPopularTrack());	
			}
			else if (!genres[s].isEmpty()) {
				playlist.add(genres[s].removeMostPopularTrack());
			}
			else if (!genres[t].isEmpty()) {
				playlist.add(genres[t].removeMostPopularTrack());
			}else {
				System.out.println("All track filled to the playlists.");
				break;
			}	
		}		
	}
	
	public void runApp() {				// some printing and input things.
		
		Scanner scanner = new Scanner(System.in);
		int input = -1;
		Bag<Track>[] genres = createGenres();
		
		System.out.println("\nAcoustic Genre --> " +
				genres[0].getNumberOfItems() + " tracks with "
				+ genres[0].getCurrrentSize() + " duration time (seconds)");
		System.out.println("Instrumental Genre --> " +
				genres[1].getNumberOfItems() + " tracks with "
				+ genres[1].getCurrrentSize() + " duration time (seconds)");
		System.out.println("Rock Genre --> " +
				genres[2].getNumberOfItems() + " tracks with "
				+ genres[2].getCurrrentSize() + " duration time (seconds)");
		System.out.println("Rap Genre --> " +
				genres[3].getNumberOfItems() + " tracks with "
				+ genres[3].getCurrrentSize() + " duration time (seconds)");
		System.out.println("Jazz Genre --> " +
				genres[4].getNumberOfItems() + " tracks with "
				+ genres[4].getCurrrentSize() + " duration time (seconds)");
		System.out.println("Pop Genre --> " +
				genres[5].getNumberOfItems() + " tracks with "
				+ genres[5].getCurrrentSize() + " duration time (seconds)\n");
		System.out.println("Enter type of Playlist [1-5]. Type 0 "
				+ "for exit -> ");
		input = scanner.nextInt();
		@SuppressWarnings("unchecked")
		Bag<Track> playlist = null;
		while (!(input==0)) {
			
			if(input==1 || input==2 || input==3 || input==4 || input==5){

				playlist = createPlaylist(input);
				fillPlaylist(input, genres, playlist); 
				System.out.println("\nSelected Playlist includes --> " +
						playlist.getNumberOfItems() + " tracks with "
						+ playlist.getCurrrentSize() + " duration time (seconds)" + 
						" with the " + playlist.getAveragePopularityTracks() +
						" average popularity.");
				System.out.println("\n*****************************************************");
				System.out.println("\nAcoustic Genre --> " +
						genres[0].getNumberOfItems() + " tracks with "
						+ genres[0].getCurrrentSize() + " duration time (seconds)");
				System.out.println("Instrumental Genre --> " +
						genres[1].getNumberOfItems() + " tracks with "
						+ genres[1].getCurrrentSize() + " duration time (seconds)");
				System.out.println("Rock Genre --> " +
						genres[2].getNumberOfItems() + " tracks with "
						+ genres[2].getCurrrentSize() + " duration time (seconds)");
				System.out.println("Rap Genre --> " +
						genres[3].getNumberOfItems() + " tracks with "
						+ genres[3].getCurrrentSize() + " duration time (seconds)");
				System.out.println("Jazz Genre --> " +
						genres[4].getNumberOfItems() + " tracks with "
						+ genres[4].getCurrrentSize() + " duration time (seconds)");
				System.out.println("Pop Genre --> " +
						genres[5].getNumberOfItems() + " tracks with "
						+ genres[5].getCurrrentSize() + " duration time (seconds)\n");
				
				System.out.println("\nEnter type of Playlist [1-5]."
						+ " Type 0 for exit -> ");
				input = scanner.nextInt();
			}else {
				System.out.println("\nWrong input. Enter type of Playlist"
						+ " [1-5]. Type 0 for exit -> ");
				input = scanner.nextInt();
			}	
		}
		scanner.close();	
	}
}
