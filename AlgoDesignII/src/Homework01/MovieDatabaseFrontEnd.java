package Homework01;
//Jake Powers
import java.util.Scanner;
public class MovieDatabaseFrontEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		
		MovieDatabase movieDB = new MovieDatabase();
		int choice = 1;
		
		System.out.println("Welcome to the Movie Database. Please select what you want to do.");
		while (choice != 0) {
			System.out.println("Enter 1: To Add a Movie\r\n" + 
					"Enter 2: To Remove a Movie by its Title\r\n" + 
					"Enter 3: To search for a Title\r\n" + 
					"Enter 4: To search for moves by a Director\r\n" + 
					"Enter 5: To search for movies of a given Year\r\n" + 
					"Enter 6: To search for movies of a certain Rating\r\n" + 
					"Enter 7: To print out all movies\r\n" + 
					"Enter 8: To print to a database file\r\n" + 
					"Enter 9: To load a database file\r\n" + 
					"Enter 0: To quit\r\n");
			choice = key.nextInt();
			key.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Please enter the 'name, year, rating, director, and box office gross' of the movie.");
				String buffer = key.nextLine();
				String[] bufferArray = buffer.split(", ");
				if (bufferArray.length == 5) {
					String title = bufferArray[0];
					int year = Integer.parseInt(bufferArray[1]);
					int rating = Integer.parseInt(bufferArray[2]);
					String director = bufferArray[3];
					double GDP = Double.parseDouble(bufferArray[4]);
					for (int i = 0; i < bufferArray.length; i++) {
						System.out.println(bufferArray[i]+"\t");
					}
					movieDB.addMovie(title, year, rating, director, GDP);
					System.out.println("Movie Added.");
					break;
				}
				System.out.println("Format incorrect, please try again.");
				for (int i = 0; i < bufferArray.length; i++) {
					System.out.println(bufferArray[i]);
				}
				break;
			case 2:
				System.out.println("Please enter the Title of the movie you wish to delete.");
				movieDB.removeMovie(key.nextLine());
				System.out.println("Movie deleted.");
				break;
			case 3:
				System.out.println("Please enter the title of the movie you are searching for.");
				Movie bufferMovie = movieDB.searchTitle(key.nextLine());
				if (bufferMovie != null)
					System.out.println(bufferMovie.toString());
				break;
			case 4:
				System.out.println("Please enter the Director of the movie(s) you are searching for.");
				movieDB.searchDirector(key.nextLine());
				break;
			case 5:
				System.out.println("Please enter the Year that the movie(s) you are searching for were released in.");
				movieDB.searchYear(key.nextInt());
				break;
			case 6:
				System.out.println("Please enter the Rating that the movie(s) you are searching for were given.");
				movieDB.searchRating(key.nextInt());
				break;
			case 7:
				movieDB.printAll();
				break;
			case 8:
				System.out.println("Please enter the Name of the file you wish to write.");
				movieDB.writeDBFile(key.nextLine());
				break;
			case 9:
				System.out.println("Please enter the Name of the file you wish to load.");
				movieDB.readFile(key.nextLine());
				break;
			case 0:
				break;
			default:
				System.out.println("Please enter another value.");
				break;
			}
		}
		
	}

}
