import java.util.*;
import java.util.Arrays;
import java.util.Arrays.*;

// public class Pair <F,S>{
// 	private F first;
// 	private S second;


// 	public Pair(F first, S second){
// 		this.first = first;
// 		this.second = second;
// 	}

// 	public F getFirst(){return first;}
// 	public S getSecond(){return second;}

// }


public class Findarraypairs
{

	public static HashSet findarraypairs(int[] a, int k){
		if(a.length < 2) return null	;

		HashSet output = new HashSet();
		HashSet seen = new HashSet();
		int target;

		for(int i : a){
			target = k - i;

			if(seen.contains(target)){
				output.add(target);
				output.add(i);
			}
			else{
				seen.add(i);
			}
		}
		return output;
	}

	public static void main(String [] args){
		int [] testarray = {1, 1, 2, 3, 4, 6};
		int k = 5;


		HashSet output = findarraypairs(testarray, k);
		System.out.println(output.toString());
	}
}