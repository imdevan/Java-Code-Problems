package com.company;

public class Main {

    /**
     * Convert array in place using constant extra space
     * @param args
     */

    public static void main(String[] args) {
	// write your code here
        String[] stringArray = {"a1", "a2", "a3", "b1","b2", "b3", "c1", "c2", "c3"};


        System.out.println("Test Case:");
        for(String s :stringArray)
            System.out.println(s);

        convertArray(stringArray, 3, 3);

        System.out.println("Result:");
        for(String s :stringArray)
            System.out.println(s);
    }

    private static void convertArray(String[] stringArray, int k, int n) {
        /**
         * convert to a1,b1,c1,..., an, bn, cn
         */
        int swapIndex = 0;
        for(int i = 1; i < stringArray.length; i++){

            swapIndex = getSwapIndex(i, n, k);
            while(swapIndex < i ) {
                swapIndex = getSwapIndex(swapIndex, n, k);
            }

            swap(stringArray, swapIndex, i);
        }

    }

    private static void swap(String[] stringArray, int swapIndex, int i) {
        String temp = stringArray[swapIndex];
        stringArray[swapIndex]  = stringArray[i];
        stringArray[i] = temp;
    }

    private static int getSwapIndex(int i, int n, int k) {
        // k = num of alpha
        // n = different alpha
        return (i%k)*n + i/k;
    }
}
