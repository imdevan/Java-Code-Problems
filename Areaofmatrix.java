import java.util.*;


public class Areaofmatrix{
	// areas assumed to be given four points within the matrix 
	// a b
	// c d

	private static int niavesum(int[][] m, int[] a, int[] b){
		int sum = 0;

		for(int i = a[0]; i < b[0]; i++){
			for(int j = a[1]; j < b[1]; j++){
				sum += m[i][j];
			}
		}

		System.out.println(sum);
		return sum;
	}

	private static int[][] precompilesums(int[][] m){
		int[][] rm =  new int[m.length][m[0].length];
		int sum; 

		// iterate across matrix
		for(int i = 0; i < m.length; i++){
			for(int j = 0; j < m[i].length; j++ ){

				sum = 0;
				// calculate sum at each cell in matrix
				for(int _i = 0; _i < i; _i++){
					for(int _j = 0; _j < j; _j++){
						sum += m[_i][_j];
					}
				}

				rm[i][j] = sum;
			}
		}

		return rm;
	}

	private static int elegantsum(int[][] m, int[] a, int[] b, int[][] pcSums){
		// a[0] b[0]
		// a[1] b[1]
		// Sum (ab) = sum(b[0]b[1]) - sum (a[0]b[1]) - sum (b[0]a[1]) + sum(a[0]a[1])
		int sum = pcSums[b[0]][b[1]] - pcSums[a[0]][b[1]] - pcSums[b[0]][a[1]] + pcSums[a[0]][a[1]];

		System.out.println(sum);
		return sum;
	}

	public static void main(String [] args){

		// test variables
		int testSize = 100;
		int[][] testMatrix = new int[testSize][testSize];
		Random randTest = new Random();

		// set test matrix
		for(int i = 0; i < testSize; i++){
			for(int j = 0; j < testSize; j++){
				testMatrix[i][j] = randTest.nextInt(100);
			}
		}

 		int [] a = {1,2};
		int [] b = {4,10};

		int niavesum = niavesum(testMatrix, a, b);
		int[][] precompiledsums = precompilesums(testMatrix);
		int elegantsum = elegantsum(testMatrix, a, b, precompiledsums);
	}
}