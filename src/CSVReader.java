import java.io.*;
import java.util.Scanner;

public class CSVReader {
	
	private final String path = "tracks.txt";  // this class has one method for reading data
												// from file. It will  be parsed and returns
	public DynamicArray<Integer> readData() {	// dynamic array of Integer type
		DynamicArray<Integer> array = new DynamicArray<>();
		try {
			
			Scanner scanner = new Scanner(new File(path));
			scanner.useDelimiter(",");
													// path variable takes relative path.
			while (scanner.hasNext()) {
				
				String data = scanner.nextLine();
				String[] values = data.split(",");
				array.addItem(Integer.parseInt(values[0]));
				array.addItem(Integer.parseInt(values[1]));
				array.addItem(Integer.parseInt(values[2]));
				array.addItem(Integer.parseInt(values[3]));
				
		}
			scanner.close();
		}catch (FileNotFoundException e) {
			System.err.println("Error : " + e.getMessage());
			e.printStackTrace();
		}
		return array;
		}	
}