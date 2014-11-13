// Given 2 strings: str1, str2, and str3
// Str3 is said to be a shuffle of str1 and str2
// if it can be formed by interleaving the characters of str1 
// and str2 in a way that maintains the the left to right
// ordering of the characters from each string.

// For example, given str1 = "abc" and str2 = "def"
// str3 = "dabecf"

// Write a function that detects wether str3 is a valid shuffle
import java.util.*;

public class CombineStringsTest {
	
	private static boolean niaveCombineStringsTest(String str1, String str2, String str3){
		// niave approach 
		// iterate accross each astring for each character in str3
		
		// Time Complexity: O(n) Space Complexity: O(1)

		boolean rt = true;
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		int str1i = 0;
		int str2i = 0;
		char c;

		if(str1.length() + str2.length() != str3.length())
			return false;

		for(int i = 0; i < str3.length(); i++){
			c = str3.charAt(i);

			if(str1i < str1.length() && str1.charAt(str1i) == c){
				System.out.println("char found in s1");
				str1i++;
			}
			else if(str2i < str2.length() && str2.charAt(str2i) == c){
				System.out.println("char found in s2");
				str2i++;
			}
			else{
				return true;
			}
		}


		System.out.println("niave");
		return rt;
	}

	public static void main(String [] args){
		String str1 = "abc";
		String str2 = "def";
		String str3 = "dabecf";

		boolean testResult1 = niaveCombineStringsTest(str1, str2, str3);
		System.out.println(testResult1);

		// boolean testResult2 = combineStringsTest(str1, str2, str3);
		// System.out.println(testResult2);
	}
}