package Lab01;
//Jake Powers
import java.util.Random;
public class mineCounter {

	public static final int gridSize = 10;
	public static final int numBombs = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		
		//Generate Board
		System.out.println("Creating Empty Board");
		char[][] grid = new char[gridSize][gridSize];
		
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				grid[i][j] = '-';
			}
		}

		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				System.out.print(grid[i][j] + " ");
			}
		System.out.println("\n");
		}
		
		
		//Placing Bombs
		System.out.println("Placing Mines");
		for (int b = 0; b < numBombs; b++) {
			int bombX = r.nextInt(gridSize);
			int bombY = r.nextInt(gridSize);
			while (grid[bombX][bombY] != '-') { //Checking if there is currently a bomb in that location
				bombX = r.nextInt(gridSize);
				bombY = r.nextInt(gridSize);
			}
			grid[bombX][bombY] = '*';
			
		}
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				System.out.print(grid[i][j] + " ");
				if (grid[i][j] != '*') {
					grid[i][j] = '0';
				}
			}
		System.out.println("\n");
		}


		//Counting Bombs
		System.out.println("Performing Mine Count");
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				if (grid[i][j] == '*') {
					for (int l = (i - 1); l < (i + 2); l++) {
						for (int m = (j - 1); m < (j + 2); m++) {
							if (m < gridSize && m >= 0 && l < gridSize && l >= 0) { //Checking bound exceptions
								if (grid[l][m] != '*') {
									grid[l][m] += 1;
								}
							}
							
						}
					}
				}
			}
		}
		
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				System.out.print(grid[i][j]+ " ");
			}
		System.out.println("\n");
		}
	}

}
