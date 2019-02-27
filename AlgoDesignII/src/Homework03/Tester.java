package Homework03;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rerun = "";
		Scanner key = new Scanner(System.in);
		while (!rerun.equalsIgnoreCase("true")) {
			mapCreator map = new mapCreator();
			LLQueue<String> commands = new LLQueue<String>();
			boolean cont = true;
			String nextCommand;
			System.out.println("Welcome to the Robot Simulator.\nEnter the file name for the board.");
			String boardLoc = key.nextLine();
			map.initializeMap(boardLoc); //Initializing the board
			System.out.println("Please Enter the file name for the Commands.");
			String robotComm = key.nextLine();
			String[] commandsBuffer = readFile(robotComm);
			for (int i = 0; i < commandsBuffer.length; i++)
				commands.enqueue(commandsBuffer[i]); //Assigning the commands to the queue
			//commands.print();
			map.printMap();
			System.out.println("Entering the Simulation."); //Matrix reference
			for(int i = 0; i<commandsBuffer.length; i++) {
				if (cont == false) {
					break;
				}
				System.out.println("Command "+i);
				nextCommand = commands.dequeue();
				switch(nextCommand) {
				case "Move Down": //If the next command is move down
					System.out.println("Moving Down.");
					cont = map.moveDown();
					if (cont == false)
						break;
					map.printMap();
					break;
				case "Move Up": //If the next command is move up
					System.out.println("Moving Up.");
					cont = map.moveUp();
					if (cont == false)
						break;
					map.printMap();
					break;
				case "Move Left": //If the next command is move left
					System.out.println("Moving Left.");
					cont = map.moveLeft();
					if (cont == false)
						break;
					map.printMap();
					break;
				case "Move Right": //If the next command is move right
					System.out.println("Moving Right.");
					cont = map.moveRight();
					if (cont == false)
						break;
					map.printMap();
					break;
				}//else do nothing
			}
			System.out.println("Simulation End.\nQuit? Enter 'true' to quit or hit enter to run another simulation.");
			rerun = key.nextLine();//rerun the code
		}
	}
	
	
	public static String[] readFile(String fileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			int numLines = 0;
			while(fileScanner.hasNextLine())
			{
				fileScanner.nextLine();
				numLines++;
			}
			
			if(numLines <= 0) {
				fileScanner.close();
				return null;
			}
				
			String[] retArr = new String[numLines];
			fileScanner = new Scanner(new File(fileName));
			for(int i=0;i<retArr.length;i++)
			{
				if(!fileScanner.hasNextLine())
					break;
				retArr[i] = fileScanner.nextLine();
			}
			fileScanner.close();
			return retArr;
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
}
