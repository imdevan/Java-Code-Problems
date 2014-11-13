import java.util.*;

// Find largest conutniuous sum of array
// of positive & negative integers. If num
// in array is larger than sum restart sum.

public class FindMaxSum{

	private static int largestContinousSum(int[] a){
		int currSum = 0, maxSum = 0;

		for(int num : a){
			currSum = Math.max(currSum + num, num);
			maxSum = Math.max(currSum, maxSum);
		}

		System.out.println("Largest Continuous Sum = " + maxSum);
		return maxSum;
	}

	public static void main(String [] args){
		int testSize = 20;
		int [] testArray = {5, 2, -31, 2, -12,31,4,3,41,1,-23,12,4,-13,12,3,-1,2,1,-12};

		// Printing regular sum for testing
		int sum = 0;
		for(int num : testArray)
			sum += num;

		System.out.println("Sum = " + sum);

		int maxSum = largestContinousSum(testArray);
		

	}

}