package Homework01;
//Jake Powers
public class Movie {
	private String name;
	private int year;
	private int rating; //0-5
	private String director;
	private double boxOfficeGross;
	
	public Movie() {
		this.name = this.director = "no name";
		this.year = 2000;
		this.rating = 1;
		this.boxOfficeGross = 500.0;
	}
	public Movie(String xName, int xYear, int xRating, String xDirector, double xBoxOfficeGross) {
		this.setName(xName);
		this.setYear(xYear);
		this.setRating(xRating);
		this.setDirector(xDirector);
		this.setBoxOfficeGross(xBoxOfficeGross);
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String xName) {
		this.name = xName;
	}
	public int getYear() {
		return this.year;
	}
	public void setYear(int xYear) {
		if (xYear > 0)
			this.year = xYear;
	}
	public int getRating() {
		return this.rating;
	}
	public void setRating(int xRating) {
		if (xRating > 0 && xRating < 6) 
			this.rating = xRating;
	}
	public String getDirector() {
		return this.director;
	}
	public void setDirector(String xDirector) {
		this.director = xDirector;
	}
	public double getBoxOfficeGross() {
		return this.boxOfficeGross;
	}
	public void setBoxOfficeGross(double xBoxOfficeRating) {
		if (boxOfficeGross > 0)
			this.boxOfficeGross = xBoxOfficeRating;
	}
	
	public boolean titleEquals(String xTitle) {
		return xTitle == this.name;
	}
	public boolean directorEquals(String xDirector) {
		return xDirector == this.director;
	}
	public boolean yearEquals(int xYear) {
		return xYear == this.year;
	}
	public boolean ratingEquals(int xRating) {
		return xRating == this.rating;
	}
	
	public boolean equals(Movie xMovie) {
		return (xMovie.getName().equals(this.name) && 
			xMovie.getYear() == this.year &&
			xMovie.getRating() == this.rating &&
			xMovie.getDirector().equals(this.director) &&
			xMovie.getBoxOfficeGross() == this.boxOfficeGross);
	}
	public String toString() {
		return "Name: "+this.name+"\tYear: "+this.year+"\tRating: "+this.rating+"\tDirector: "+this.director+"\tBox Office Gross: $"+this.boxOfficeGross;
	}
	
}
