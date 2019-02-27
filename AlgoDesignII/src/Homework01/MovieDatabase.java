package Homework01;
//Jake Powers
import java.io.*;
import java.util.*;
public class MovieDatabase {
	public static final String DELIM = "\t";
	GenLL<Movie> movieDB = new GenLL<Movie>();
	public MovieDatabase() {
		
	}
	
	public void addMovie(String xName, int xYear, int xRating, String xDirector, double xBoxGross) {
		Movie newMovie = new Movie(xName, xYear, xRating, xDirector, xBoxGross);
		movieDB.insert(newMovie);
	}
	public void removeMovie(String xName) {
		Movie deletedMovie = new Movie();
		deletedMovie.setName(xName);
		movieDB.resetCurrent();
		while (!deletedMovie.titleEquals(xName))
			movieDB.gotoNext();
		if (movieDB.getCurrent() != null) {
			movieDB.deleteCurrent();
			movieDB.resetCurrent();
			return;
		}
		System.out.println("Movie Not Found.");	
	}
	public Movie searchTitle(String xName) {
		movieDB.resetCurrent();
		System.out.println(xName);
		while (movieDB.hasMore()) {
			if (movieDB.getCurrent().getName().equals(xName))
				return movieDB.getCurrent();
		movieDB.gotoNext();
		}
		System.out.println("Movie Not Found.");
		return null;
	}
	public void searchDirector(String xName) {
		GenLL<Movie> directedBy = new GenLL<Movie>();
		movieDB.resetCurrent();
		while (movieDB.hasMore()) {
			//System.out.println("Ran");
			if (movieDB.getCurrent().getDirector().equals(xName)) {
				directedBy.insert(movieDB.getCurrent());
				//System.out.println("Found one.");
			}
			movieDB.gotoNext();
		}
		movieDB.resetCurrent();
		directedBy.print();
	}
	public void searchYear(int xYear) {
		GenLL<Movie> releasedIn = new GenLL<Movie>();
		movieDB.resetCurrent();
		while (movieDB.hasMore()) {
			//System.out.println("Ran");
			if (movieDB.getCurrent().getYear() == xYear) {
				releasedIn.insert(movieDB.getCurrent());
			}
			movieDB.gotoNext();
		}
		movieDB.resetCurrent();
		releasedIn.print();
	}
	public void searchRating(int xRating) {
		GenLL<Movie> rated = new GenLL<Movie>();
		movieDB.resetCurrent();
		while (movieDB.hasMore()) {
			//System.out.println("Ran");
			if (movieDB.getCurrent().getRating() == xRating) {
				rated.insert(movieDB.getCurrent());
			}
			movieDB.gotoNext();
		}
		rated.print();
	}
	public void printAll() {
		movieDB.print();
	}
	
	public void readFile(String fileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			int movieCount = 0;
			while(fileScanner.hasNextLine())
			{
				fileScanner.nextLine();
				movieCount++;
			}
			if(movieCount <= 0) {
				System.out.print("No movies in file.");
				fileScanner.close();
				return;
			}
				
			//Creates the return array, resets the file scanner, and populates the array
			String[] bufferValueArr;
			fileScanner = new Scanner(new File(fileName));
			for(int i=0;i<movieCount;i++)
			{
				//System.out.println("loop has run "+i);
				if(!fileScanner.hasNextLine()) {
					System.out.println("No next Line.");
					break;
				}
					
				bufferValueArr = fileScanner.nextLine().split(DELIM);
				if (bufferValueArr.length != 5) {
					System.out.println("length is "+bufferValueArr.length);
					continue;
				}
					
				Movie newMovie = new Movie(bufferValueArr[0], 
											Integer.parseInt(bufferValueArr[1]),
											Integer.parseInt(bufferValueArr[2]),
											bufferValueArr[3],
											Double.parseDouble(bufferValueArr[4]));
				movieDB.insert(newMovie);
			 }
			System.out.println(movieCount+" movies added.");
			fileScanner.close();
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return;
	}
	public void writeDBFile(String xFileName) {
		try {
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(xFileName));
			movieDB.resetCurrent();
			while (movieDB.getCurrent() != null) {
				fileWriter.println(movieDB.getCurrent().getName()+DELIM+movieDB.getCurrent().getYear()+DELIM+movieDB.getCurrent().getRating()+DELIM+movieDB.getCurrent().getDirector()+DELIM+movieDB.getCurrent().getBoxOfficeGross());
				movieDB.gotoNext();
			}
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
