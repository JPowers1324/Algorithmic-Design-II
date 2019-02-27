package Homework00;
import java.util.*;
import java.io.*;
//Jake Powers
public class ShowcaseGame {
	public static final String fileName = "prizeList.txt";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Showcase show = new Showcase(fileName);
		Scanner key = new Scanner(System.in);
		String cont = "yes";
		Prize[] randPrizes;
		double userGuess;
		double totalCost = 0;
		
		
		System.out.println("Welcome to the Showcase Showdown!");
		while (cont.equalsIgnoreCase("Yes")) {
			randPrizes = show.randomPrizes();
			System.out.println("Your Prizes are: ");
			for (int i = 0; i < randPrizes.length; i++) {
				System.out.println(randPrizes[i].getName());
				totalCost += randPrizes[i].getPrize();
			}
			System.out.println("Total Cost is :"+totalCost);
			System.out.println("You must guess the total cost of all without going over.\nEnter your guess.");
			userGuess = key.nextDouble();
			System.out.println("You guessed "+userGuess+", but the actual price was "+totalCost);
			if (userGuess > totalCost + 2000) {
				System.out.println("Your guess was over. You Lose!");
			}
			else if (userGuess < totalCost - 2000) {
				System.out.println("Your guess was too low. You Lose!");
			}
			else {
				System.out.println("Your guess was under! You Win!");
			}
			
			System.out.println("Would you like to play again? Enter 'Yes' to continue.");
			cont = key.nextLine();
			System.out.println(cont);
			key.nextLine();
		}
	}
	
	
}
