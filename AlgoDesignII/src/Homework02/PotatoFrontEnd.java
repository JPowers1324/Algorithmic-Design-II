package Homework02;
//Jake Powers
import java.util.Scanner;
import java.util.Random;
public class PotatoFrontEnd {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenLLCirc<player> players = new GenLLCirc<player>();
		Scanner key = new Scanner(System.in);
		int numPlayers;
		String cont = "Y";

		while (!cont.equalsIgnoreCase("stop")) { //Looping game
			System.out.println("Welcome to the Hot Potato Game.");
			System.out.println("Please enter the number of players playing (Minimum of 2 players.)");
			numPlayers = key.nextInt(); //Assigning total number of players
			if (numPlayers < 2) { //Checking for invalid number of players
				System.out.println("Sorry, this is a multiplayer only game. Come back with friends.");
				System.exit(0);
			}
			key.nextLine();
			for (int i = 1; i < numPlayers + 1; i++) { //Assigning names of players 
				System.out.println("Please enter the name of player "+i);
				player p = new player(key.nextLine());
				players.insert(p); //Adding players to Linked List
			}
			potatoGame(players); //Running the actual game
			System.out.println("Would you like to play again? Type stop to end the game.");
			cont = key.nextLine();
			System.out.println("\n\n\n\n\n\n");
		}
	}
	public static void potatoGame(GenLLCirc<player> players) {
		Scanner key = new Scanner(System.in);
		Random r = new Random();
		int potTimeToBlow;
		int timeHeld;
		
		potTimeToBlow = r.nextInt(180);
		GenLLCirc<player> playersInGame = new GenLLCirc<player>();
		players.resetCurrent();
		for (int i = 0; i < players.getSize(); i++) { //cloning players into playersInGame
			playersInGame.insert(players.getCurrent());
			players.gotoNext();
		}
		while (playersInGame.getSize() != 1) { //Continues to run until one player remains
			System.out.println(playersInGame.getCurrent().getPlayerName()+" Enter a number form 1 - 10 corresponding to the number of seconds to hold the potato.");
			timeHeld = key.nextInt(); //Player is inserting time holding potato
			if (timeHeld > 10 || timeHeld < 1) { //Error checking for time held
				timeHeld = 10;
				System.out.println("Your time was defaulted to 10.");
			}
			potTimeToBlow -= timeHeld;
			if (potTimeToBlow < 0) { //Checking if timer is over, if so deleting player and restarting timer
				System.out.println("HOT POTATO! "+playersInGame.getCurrent().getPlayerName()+" YOU LOSE.");
				playersInGame.deleteCurrent();
				potTimeToBlow = r.nextInt(180);
				continue;
			}
			System.out.println(playersInGame.getCurrent().getPlayerName()+" is safe. For now...\n");
			playersInGame.gotoNext();
		}
		System.out.println("Congratulations "+playersInGame.getCurrent().getPlayerName()+". You Win!");
	}
}
