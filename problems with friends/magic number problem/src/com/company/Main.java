package com.company;

import java.util.HashMap;

public class Main {

    // calculate the number of magic numbers from 000000 to 999999
    // magic number is a number where the sum of the first 3 digits
    // equals the sum off the last three digits

    public static void sop(int n){  System.out.println(n); }
    public static void sop(String n){  System.out.println(n); }

    public static int getDigitSum(int n){
        int r = 0;
        char [] ca = String.valueOf(n).toCharArray();
        for(int i = 0; i < ca.length; i++)
            r += Integer.parseInt(String.valueOf(ca[ca.length-1-i])) * Math.pow(10,i);

        return r;
    }




    public static int getNumberOfMagicNumbers(int n){
        int count = 0;

        // Get first half of n
        int half = 0;
        char [] ca = String.valueOf(n).toCharArray();
        for(int i = 0; i < ca.length/2; i++)
            half += Integer.parseInt(String.valueOf(ca[ca.length-1-i])) * Math.pow(10,i);

        // Make array to save sums
        int arr[] = new int[getDigitSum(half)];

        // Calculate sums for first half of n
        for(int i = 0; i < half; i++){
            int sum = getDigitSum(i);
             arr[sum]++;
        }

        // Add all sums to count
        for(int num : arr)
            count += num;

        return count;
    }

    public static int getDigitSum(int s, int e, int n){
        // Create array from size e - s inclusive
        int r = 0;
        String stringN = String.valueOf(n);

        for(int i = s; i <= e; i++){
            if(stringN.length() > i)
                r += 0;
            else
                r += Integer.parseInt(String.valueOf(stringN.charAt(i)));
        }
        return r;
    }

    public static int getNoM(int n){
        int count= 0;
        for(int i = 0; i <= n; i++){
            int sum1 = getDigitSum(0,2,n);
            int sum2 = getDigitSum(3,5,n);
            if(sum1 == sum2)
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
	// write your code here
        int n = 999999;
        int result = getNoM(n);

        System.out.println(result);

    }
}
