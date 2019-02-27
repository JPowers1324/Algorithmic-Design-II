package Lab02;
//Jake Powers
public class WordHelper {
	
	public static String[] sortByVowels(String[] xVowels) { //Sorting random values by Vowel
		String[] sortVowels = xVowels.clone(); //Cloning original array
		int numVowels1;
		int numVowels2;
		String wordInArrayBuffer;
		for (int i = 0; i < sortVowels.length; i++) {
			for(int j = 0; j < sortVowels.length; j++) {
				//Placeholder variables for number of vowels in word x
				numVowels1 = 0;
				numVowels2 = 0;
				if (j == sortVowels.length - 1) {
					break;
				}
				for (int v = 0; v < sortVowels[j].length(); v++) { //Testing all cases of vowels
					if (sortVowels[j].charAt(v) == 'a' || sortVowels[j].charAt(v) == 'A' || 
						sortVowels[j].charAt(v) == 'e' || sortVowels[j].charAt(v) == 'E' || 
						sortVowels[j].charAt(v) == 'i' || sortVowels[j].charAt(v) == 'I' || 
						sortVowels[j].charAt(v) == 'o' || sortVowels[j].charAt(v) == 'O' || 
						sortVowels[j].charAt(v) == 'u' || sortVowels[j].charAt(v) == 'U' || 
						sortVowels[j].charAt(v) == 'y' || sortVowels[j].charAt(v) == 'Y') {
						numVowels1++;
					}
				}
				for (int v = 0; v < sortVowels[j+1].length(); v++) {
					if (sortVowels[j+1].charAt(v) == 'a' || sortVowels[j+1].charAt(v) == 'A' || 
						sortVowels[j+1].charAt(v) == 'e' || sortVowels[j+1].charAt(v) == 'E' || 
						sortVowels[j+1].charAt(v) == 'i' || sortVowels[j+1].charAt(v) == 'I' || 
						sortVowels[j+1].charAt(v) == 'o' || sortVowels[j+1].charAt(v) == 'O' || 
						sortVowels[j+1].charAt(v) == 'u' || sortVowels[j+1].charAt(v) == 'U' || 
						sortVowels[j+1].charAt(v) == 'y' || sortVowels[j+1].charAt(v) == 'Y') {
							numVowels2++;
					}
				}
				if (numVowels1 > numVowels2) { //reassigning values
					wordInArrayBuffer = sortVowels[j];
					sortVowels[j] = sortVowels[j+1];
					sortVowels[j+1] = wordInArrayBuffer;
				}
				
			}
		}
		return sortVowels;
	}
	
	public static String[] sortByConsonants(String[] xConsonants) {
		String[] sortCon = xConsonants.clone(); //Cloning orignal array
		int numConsonants1;
		int numConsonants2;
		String wordInArrayBuffer;
		for (int i = 0; i < sortCon.length; i++) {
			for(int j = 0; j < sortCon.length; j++) {
				//Placeholder variables for num consonants in word x
				numConsonants1 = 0;
				numConsonants2 = 0;
				if (j == sortCon.length - 1) {
					break;
				}
				for (int v = 0; v < sortCon[j].length(); v++) { //checking number of consonants
					if (sortCon[j].charAt(v) != 'a' || sortCon[j].charAt(v) != 'A' || 
						sortCon[j].charAt(v) != 'e' || sortCon[j].charAt(v) != 'E' || 
						sortCon[j].charAt(v) != 'i' || sortCon[j].charAt(v) != 'I' || 
						sortCon[j].charAt(v) != 'o' || sortCon[j].charAt(v) != 'O' || 
						sortCon[j].charAt(v) != 'u' || sortCon[j].charAt(v) != 'U' || 
						sortCon[j].charAt(v) != 'y' || sortCon[j].charAt(v) != 'Y') {
							numConsonants1++;
					}
				}
				for (int v = 0; v < sortCon[j+1].length(); v++) {
					if (sortCon[j+1].charAt(v) != 'a' || sortCon[j+1].charAt(v) != 'A' || 
						sortCon[j+1].charAt(v) != 'e' || sortCon[j+1].charAt(v) != 'E' || 
						sortCon[j+1].charAt(v) != 'i' || sortCon[j+1].charAt(v) != 'I' || 
						sortCon[j+1].charAt(v) != 'o' || sortCon[j+1].charAt(v) != 'O' || 
						sortCon[j+1].charAt(v) != 'u' || sortCon[j+1].charAt(v) != 'U' || 
						sortCon[j+1].charAt(v) != 'y' || sortCon[j+1].charAt(v) != 'Y') {
							numConsonants2++;
					}
				}
				if (numConsonants1 > numConsonants2) { //Swaping words in array
					wordInArrayBuffer = sortCon[j];
					sortCon[j] = sortCon[j+1];
					sortCon[j+1] = wordInArrayBuffer;
				}
				
			}
		}
		return sortCon;
	}
	
	
	public static String[] sortByLength(String[] sortLength) { //Sorting by Length
		String[] sortLen = sortLength.clone(); //Cloning the original array
		String wordInArrayBuffer;
		for (int i = 0; i < sortLen.length; i++) {
			for (int j = 0; j < sortLen.length; j++) { //Looping twice to sort all words in array
				if (j == sortLen.length - 1) { //Testing for out of bounds case
					break;
				}
				if (sortLen[j].length() > sortLen[j+1].length()) { //Swaping words in array
						wordInArrayBuffer = sortLen[j];
						sortLen[j] = sortLen[j+1];
						sortLen[j+1] = wordInArrayBuffer;
				}	
			}
			
		}
		return sortLen;
	}
}
