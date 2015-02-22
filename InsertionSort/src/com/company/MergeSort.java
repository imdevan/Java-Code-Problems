package com.company;

import java.util.ArrayList;

/**
 * Created by Devan on 2/3/2015.
 */
public class MergeSort {

    private static int[] leftHalf(int [] array)
    {
        int size1 = array.length/2;
        int[]left = new int[size1];
        for(int i = 0; i < size1; i++)
        {
            left[i] = array[i];
        }
        return left;
    }

    private static int[] rightHalf(int[] array)
    {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for(int i = 0; i < size2; i++)
        {
            right[i] = array[i + size1];
        }
        return right;
    }

    private static void merge(int [] result, int[] left, int[] right)
    {
        int i1 = 0;
        int i2 = 0;

        for(int i = 0; i < result.length; i++)
        {
         if(i2 >= right.length || (i1 < left.length && left[i1] <= right[i2]))
         {
             result[i] = left[i1];
             i1++;
         }
         else
         {
            result[i] = right[i2];
             i2++;
         }
        }
    }

    public static void sort(int[]a)
    {
        if(a.length < 2) return;

        // split the array into two halves
        int[] left = leftHalf(a);
        int[] right = rightHalf(a);

        // Recursively sort the two halves
        sort(left);
        sort(right);

        // Merge the sorted halves into a sorted whole
        merge(a, left, right);
    }

}
