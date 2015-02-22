package com.company;

import java.util.Random;

public class Main {

    // util function to generate a sequence array
    public static int[] seqArray(int l)
    {
        int [] a = new int[l];
        for(int i = 0; i < a.length; i++)
        {
            a[i] = i+1;
        }
        return a;
    }

    // util function to print array
    public static void printIntArray(int [] a)
    {
        System.out.print("[");
        for(int i = 0; i < a.length; i ++)
            if(i < a.length-1)
                System.out.printf("%d, ", a[i]);
            else
                System.out.print(a[i]);
        System.out.println("]");
    }

    public static int rand(int i){
        Random r = new Random();
        return r.nextInt(i+1);
    }

    // utility function to get subset
    public static int[] getSubSet(int [] n, int m)
    {
        // Generate subset
        int [] sub = new int [m];
        for(int i = 0; i < sub.length; i++){
            sub[i] = n[i];
        }
        return sub;
    }

    // function to generate random subset
    public static int[] randomSubset(int [] n, int m)
    {
        // Generate subset using first m elements of array
        int [] sub = getSubSet(n, m);

        // Iterate across the rest of the array
        // for 'fairness'
        for(int i = m; i < n.length; i++){
            int k = rand(n.length);
            if(k < m)
                sub[k] = n[i];
        }

        return sub;
    }

    public static void main(String[] args) {
        int[] a = seqArray(10), result = randomSubset(a, 5);

        System.out.println("Test:");
        printIntArray(a);
        System.out.println("Result:");
        printIntArray(result);
    }
}
