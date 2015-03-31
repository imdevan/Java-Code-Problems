package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    // Cheat-y implementation
    // ------------------------------------------------------------------
    public static int cheatyFindK(int[] a, int k)
    {
        Arrays.sort(a);
        return a[k-1];
    }

    // Proper implementation
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


    // Median of medians implementation
    // ------------------------------------------------------------------
    public static int partition2(int[] a, int s, int e, int p)
    {
        int swi = s;
        for(int i = s; i < e; i ++)
            if(a[i] <= p)
            {
                swap(a, swi, i);
                swi++;
            }

        swap(a, swi, e);
        return swi;
    }
    public static int findKLargestWithMedianOfMedians(int [] a, int s, int e, int k)
    {
        int length = e-s+1;
        if(k<=1|| k >=length)
            return -1;
        else if (length <= 5)
            return a[s+ k-1];

        int numOfMedians = length/5;

        int [] medians = new int[numOfMedians];

        for(int i = 0; i < numOfMedians; i ++)
            medians[i] = findKLargestWithMedianOfMedians(a, s+5*1, s+(i+1)*5-1, k);

        int pivot = findKLargestWithMedianOfMedians(medians, 0, medians.length-1, medians.length/2 + 1);

        int pivotIndex = partition2(a, s, e, k);
        int rank = pivotIndex +1;

        if(rank == k)
            return a[pivotIndex];
        else if(rank >= k)
            return findKLargestWithMedianOfMedians(a, 0, pivotIndex, k);
        else
            return findKLargestWithMedianOfMedians(a, pivotIndex+1, e, k-rank);
    }

    public static int findKLargestMofM(int [] a, int k)
    {
        return findKLargestWithMedianOfMedians(a, 0, a.length-1, k);
    }

    public static void main(String[] args)
    {
        // Test array
        int[] testA = {3,1,2,1,4,3,5135,32,2,5,5,4,2,12,2,5,3,54,34,7,1,34};
        int k = 3;

        System.out.println("Proper Method");
        System.out.println(findKlargest(testA, k));


        System.out.println("Cheat-y Method");
        System.out.println(cheatyFindK(testA, k));

        System.out.println("Median Of Medians Method");
        System.out.println(findKLargestMofM(testA, k));


    }
}
