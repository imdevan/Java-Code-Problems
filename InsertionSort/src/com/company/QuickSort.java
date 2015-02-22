package com.company;

import java.util.Random;

/**
 * Created by Devan on 2/4/2015.
 */
public class QuickSort {

    private static void swap(int[] a, int p, int q){
        int temp = a[p];
        a[p] = a[q];
        a[q] = temp;
    }

    private static int getPivotIndex(int[] a, int s, int e){

        // Generate three random index's within range of 0 and the array length
        Random random = new Random();
        int r1, r2, r3;
        r1 = random.nextInt(e - s) + s;
        r2 = random.nextInt(e - s) + s;
        r3 = random.nextInt(e - s) + s;

        // Get return index of median value
        if(Math.min(a[r2], a[r3]) < a[r1]  && a[r1] > Math.max(a[r2], a[r3]))
        {
            return r1;
        } else if (Math.min(a[r1], a[r3]) < a[r2]  && a[r2] > Math.max(a[r1], a[r3])) {
            return r2;
        } else {
            return r3;
        }
    }

    private static void quickSort(int[] a, int s, int e)
    {
        if(s >= e || a.length < 2) return;

        // Get pivot index
        int pi = getPivotIndex(a, s, e);

        // Sort this part of the array
        int pivot = a[pi];
        int swapi = s;

        swap(a, pi, e-1);

        for(int i = s; i < e; i++){
            if(a[i] < pivot){
                swap(a, swapi, i);
                swapi++;
            }
        }

        swap(a, swapi, e-1);

        // Sort everything to the left of the pivot
        quickSort(a, s, swapi-1);

        // Soft everything to the right of the pivot
        quickSort(a, swapi+1, e);
    }
    public static void sort(int[] a) {
        // Sort array on pivot
        quickSort(a, 0, a.length);
    }
}
