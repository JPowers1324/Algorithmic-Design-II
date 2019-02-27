package Homework03;
//Jake Powers
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class mapCreator {
	public mapCreator() {
		
	}
	char[][] map = new char[10][10]; //Initializing the map array
	int xCoord = 0;
	int yCoord = 0;
	public char[][] getMap() {
		return map;
	}
	public void initializeMap(String fileName) {
		try {
				Scanner fileScanner = new Scanner(new File(fileName));
				//Creates the fileScanner and assigns each line to a char array at map position i
				fileScanner = new Scanner(new File(fileName));
				for(int i=0;i<10;i++) {
					if(!fileScanner.hasNextLine())
						break;
					char[] row = fileScanner.nextLine().toCharArray();
					map[i] = row;
					
				}
			fileScanner.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		map[0][0] = 'O';
	}
	public void printMap() { //Printing the array of the map
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println("");
		}
	}
	public boolean moveDown() { //Moving down by 1 position
		if (this.yCoord+1 < 10) {
			if (map[this.yCoord+1][this.xCoord] == '_') {
				map[this.yCoord+1][this.xCoord] = 'O';
				map[this.yCoord][this.xCoord] = '_';
				this.yCoord += 1;
				//System.out.println("Pos is now "+this.xCoord+","+this.yCoord);
				return true;
			}
		}
		System.out.println("The robot Crashed!");
		return false;
	}
	public boolean moveUp() { //Moving up by 1 position
		if (this.yCoord - 1 >= 0) {
			if (map[this.yCoord-1][this.xCoord] == '_') {
				map[this.yCoord-1][this.xCoord] = 'O';
				map[this.yCoord][this.xCoord] = '_';
				this.yCoord -= 1;
				//System.out.println("Pos is now "+this.xCoord+","+this.yCoord);
				return true;
			}
		}
		System.out.println("The robot Crashed!");
		return false;
	}
	public boolean moveLeft() { // Moving left by 1 position
		if (this.xCoord - 1 >= 0) {
			if (map[this.yCoord][this.xCoord-1] == '_') {
				map[this.yCoord][this.xCoord-1] = 'O';
				map[this.yCoord][this.xCoord] = '_';
				this.xCoord -= 1;
				//System.out.println("Pos is now "+this.xCoord+","+this.yCoord);
				return true;
			}
		}
		System.out.println("The robot Crashed!");
		return false;
	}
	public boolean moveRight() { //Moving right by 1 position
		if (this.xCoord + 1 < 10) {
			if (map[this.yCoord][this.xCoord+1] == '_') {
				map[this.yCoord][this.xCoord+1] = 'O';
				map[this.yCoord][this.xCoord] = '_';
				this.xCoord += 1;
				//System.out.println("Pos is now "+this.xCoord+","+this.yCoord);
				return true;
			}
		}
		
		System.out.println("The robot Crashed!");
		return false;
	}
}
