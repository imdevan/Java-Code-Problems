package com.company;

/**
 * Created by Devan on 3/31/2015.
 */
public class ContSum {
    /**
     * Return the largest continuous sum
     * When the current sum becoes negative, start with a new current sum
     * @param intArray
     * @return
     */
    public static int findSum(int[] intArray){
        int largestSum = 0;
        int currentSum = 0;

        for(int num: intArray){
            currentSum = Math.max(currentSum+num, num);
            largestSum = Math.max(currentSum, largestSum);
        }

        return largestSum;
    }
}
