//Jake Powers
package Lab00;
import java.util.Random;
public class Lab00 {
	
	public static final int arrSize = 4;
	public static void main(String[] args) {
		Random r = new Random();
		//Creating and populating the large array
		System.out.println("Initial Matrix");
		int[][] mat = new int[arrSize][arrSize];
		for (int i = 0; i < arrSize; i++) {
			for (int j = 0; j < arrSize; j++) {
				mat[i][j] = r.nextInt(9);
				System.out.print(mat[i][j]+"\t");
			}
		System.out.println();
		}
		//buffer used to track avg values
		double buffer;
		int x = 0;
		int y = 0;
		//Creating small array and calculating avg
		System.out.println("Result Matrix");
		double[][] smallMat = new double[arrSize / 2][arrSize / 2];
		for (int m = 0; m < (arrSize) ; m+=arrSize / 2) {
			for (int n = 0; n < (arrSize) ; n+=arrSize / 2) {
				buffer = 0;
				for (int i = m; i < m + (arrSize / 2); i++) {
					for (int j = n; j < n + (arrSize / 2); j++) {
						buffer += mat[i][j];
						
					}				
				}
				buffer /= arrSize;
				smallMat[y][x] = buffer;
				x++;
			}
		x = 0;
		y++;
		}
		//Printing Array
		for (int i = 0; i < arrSize / 2; i++) {
			for (int j = 0; j < arrSize / 2; j++) {
				System.out.print(smallMat[i][j]);
				System.out.print("\t");
			}
			System.out.println("");
			}
		
		
		
		
	}

}
