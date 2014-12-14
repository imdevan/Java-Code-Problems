package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    // "Brute Force" cheatty way
    // TC: O(nlogn) SC: O(1)
    public static int findKLargest(int[] a, int k)
    {
        Arrays.sort(a);
        return a[k-1];
    }

    // faster
    // TC: O(logn) SC: O(n)
    public static void swap(int a, int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }

    // modified selection sort
    public static int partition1(int[] a,int start, int end, int pivotIndex)
    {
        // Swap pivotindex and end positions
        swap(a[end], a[pivotIndex]);

        int pivot = a[end];
        int swapIndex = start;

        for(int i = start; i <= end; i++)
            if(a[i] <= pivot)
            {
                swap(a[swapIndex], a[i]);
                swapIndex++;
            }

        swap(a[end], a[swapIndex]);
        return swapIndex;
    }

    // Using Selection sort algorithm
    public static int halfSort(int[] a, int start, int end, int k)
    {
        if(start == end)
            return a[start];

        // Random Pivot index
        Random r = new Random();
        int pivotIndex = r.nextInt(end - start) + start;

        pivotIndex = partition1(a, start, end, pivotIndex);
        int rank = pivotIndex + 1;

        if(rank == k)
            return a[pivotIndex];
        else if(rank > k)
            return halfSort(a, start, pivotIndex-, k);
        else
            return halfSort(a, pivotIndex, end, k-rank);

    }

    public static int myFindKLargest(int [] a, int k)
    {
        if(k < 1 || k > a.length)
            return -1;

        return halfSort(a, 0, a.length-1, k);
    }





    public static void main(String[] args)
    {
	    // Test array
        int [] testArray = {3,1,2,1,4,3,4,1,2,5,24,5,2,4,23,51,4,6234,2,461};
        int k = 15;

//        int simpleSol = findKLargest(testArray,k);
        int elegantSol = myFindKLargest(testArray, k);

        // Should print 5
//        System.out.println();
        System.out.println(elegantSol);
//
//        for(int elm : testArray)
//            System.out.println(elm);

    }
}
