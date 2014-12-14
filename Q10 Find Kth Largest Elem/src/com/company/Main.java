package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static int cheatyFindK(int[] a, int k)
    {
        Arrays.sort(a);
        return a[k-1];
    }

    // proper implementation
    // ------------------------------------------------------------------
    // Helper function to swap variables
    public static void swap(int[] a, int upper, int lower)
    {
        int temp = a[lower];
        a[lower] = a[upper];
        a[upper] = temp;
    }
    // Helper function to get randomInt
    public static int randomInt(int lowerBound, int upperBound)
    {
        Random r = new Random();
        return r.nextInt(upperBound - lowerBound) + lowerBound;
    }

    // Partition funciton called to return new pIndex
    public static Integer partition(int[] a, int start, int end, int pivotIndex)
    {
        if(start >= end)
        {
            return null;
        }

        int pivot = a[pivotIndex];
        int swapIndex = start;

        swap(a, pivotIndex, end);


        for(int i = start; i < end; i++)
            if(a[i] <= pivot)
            {
                // Swap a[i] and a[swapIndex]
                swap(a, i, swapIndex);
                swapIndex++;
            }

        swap(a, swapIndex, end);

        return swapIndex;
    }

    public static int halfSort(int[]a, int start, int end, int k)
    {
        if(start == end)
            return a[start];

        int pivotIndex = randomInt(start, end);
        pivotIndex = partition(a, start, end, pivotIndex);
        int rank = pivotIndex +1;

        if(rank == k)
            return a[pivotIndex];
        else if(rank > k)
            return halfSort(a, 0, pivotIndex, k);
        else
            return halfSort(a, pivotIndex-1, end, k);
    }

    public static int findKlargest(int [] a, int k)
    {
        return halfSort(a, 0, a.length-1, k);
    }

    public static void main(String[] args)
    {
        // Test array
        int[] testA = {3,1,2,1,4};
        int k = 3;

        System.out.println("Proper Method");
        System.out.println(findKlargest(testA, k));

        System.out.println("Cheat-y Method");
        System.out.println(cheatyFindK(testA, k));


    }
}
