package com.company;

import java.util.Random;

public class Main {



    public static void main(String[] args) {
        int[] testArray = {4,2,3,1};
        int k = 2;
        int result = findKthLargestElement(testArray, k);

        System.out.println(result);
    }

    private static int findKthLargestElement(int[] testArray, int k) {


        // Invalid k
        if (testArray.length < k)
            return -1;

        return findKthLargestElement(testArray, 0, testArray.length-1, k);
    }

    private static int findKthLargestElement(int[] a, int start, int end, int k) {
        // Get pivot
        int pi = getPivotIndex(a, start, end);
        int piv = a[pi];
        int si = 0;

        // Put pivot in safe place (the end)
        swap(a,pi,end);

        // Iterate from start to end
        for(int i = start; i < end; i++){
            if(a[i] < piv)
                swap(a, si++, i);
        }

        // Put pivot at end of sorted section
        swap(a, si, end);

        // Check Rank
        int rank = si+1;
        if(rank == k)
            return a[si];
        else if(rank < k)
            return findKthLargestElement(a, si, end, k);
        else
            return findKthLargestElement(a, start, si, k);
    }

    private static void swap(int[] a, int pi, int end) {
        int temp = a[pi];
        a[pi] = a[end];
        a[end] = temp;
    }

    private static int getPivotIndex(int[] a, int start, int end) {
        // Get three random pivot indicies
        Random r = new Random();
        int pi1 = r.nextInt(end  - start) + start;
        int pi2 = r.nextInt(end  - start) + start;
        int pi3 = r.nextInt(end  - start) + start;

        // Return median
        if(a[pi1] > Math.min(a[pi2],a[pi3]) && a[pi1] < Math.max(a[pi2],a[pi3]))
            return pi1;
        else if(a[pi2] > Math.min(a[pi1],a[pi3]) && a[pi2] < Math.max(a[pi1],a[pi3]))
            return pi2;
        else
            return pi3;
    }

}
