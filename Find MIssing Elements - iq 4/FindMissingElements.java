import java.util.*;

public class FindMissingElements{

	// Given an array of ints
	// Shufffle it and remove one of the elements
	// Find which element is missing

	private static int niaveFindMissingElements(int [] a1, int [] a2){
		// This method uses a hashtable to store the values of a1 
		// then tests the values in the hashtable against a2
		// if the value from a2 is in the hashtable then the key is removed
		// the remainin key is the missing value

		// Time complexity: O(n) Space Complexity: O(n)

		Hashtable<Integer, Integer> testHash = new Hashtable<Integer,Integer>();

		for(int i : a1){
			testHash.put(i, 1);
		}

		for(int i : a2){
			if(testHash.get(i) != null){
				testHash.remove(i);
			}
		}

		int rInt = 0; 
		for(int i : testHash.keySet()){
			rInt =  i;
		}

		System.out.println("Niave");
		return rInt;

	}
	private static int elegantFindMissingElements(int [] a1, int [] a2){
		// This method uses boolean logic to compare each intiger in the array
		// XOR each int, the unique value will be remaining
		// assumes all positive (non 0 integers)

		// Time complexity: O(n) Space complexity: O(1)

		int testInt = 0;

		for(int i : a1)
			testInt ^= i;

		for(int i : a2)
			testInt ^= i;

		System.out.println("Elegant");
		return testInt;
	}

	public static void main(String [] args){
		int [] a1 = {1, 2, 3, 5, 6, 13, 25, 11, 23}; 
		int [] a2 = {1, 2, 3, 5, 6, 13, 11, 23}; 

		// Should return 25
		System.out.println(niaveFindMissingElements(a1, a2));
		System.out.println(elegantFindMissingElements(a1,a2));
	}
}