package Homework00;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

//Jake Powers

public class Showcase {
	public final String DELIM = "\t";
	public Prize[] PrizeList;
	public Prize[] randPrizes;
	Random r = new Random();
	
	public Showcase(String fileName) {
		PrizeList = new Prize[readFile(fileName).length];
		PrizeList = fillList(readFile(fileName));
	}
	
	public Prize[] fillList(String[] stringArr) {
		String[] bufferArr = new String[1];
		double bufferPrice;
		for (int i = 0; i < stringArr.length; i++) {
			if (stringArr[i].contains(DELIM)) {
				bufferArr = stringArr[i].split(DELIM);
				bufferPrice = Integer.parseInt((bufferArr[1]));
				Prize p = new Prize(bufferArr[0],bufferPrice);
				PrizeList[i] = p;
			}
			else
				continue;
		}
		return PrizeList;
	}
	
	public Prize[] randomPrizes() {
		randPrizes = new Prize[5];
		for (int i = 0; i < 5; i++) {
			randPrizes[i] = PrizeList[r.nextInt(PrizeList.length)];
		}
		return randPrizes;
	}
	
	public static String[] readFile(String fileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			int prizeCount = 0;
			while(fileScanner.hasNextLine())
			{
				fileScanner.nextLine();
				prizeCount++;
			}
			
			if(prizeCount <= 0)
				return null;
			//Creates the return array, resets the file scanner, and populates the array
			String[] retArr = new String[prizeCount];
			fileScanner = new Scanner(new File(fileName));
			for(int i=0;i<retArr.length;i++)
			{
				if(!fileScanner.hasNextLine())
					break;
				retArr[i] = fileScanner.nextLine();
			}
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
	/*
	public void printArr() {
		for (int i = 0; i < PrizeList.length; i++) {
			System.out.println(PrizeList[i].print());
		}
	}
	*/
}
