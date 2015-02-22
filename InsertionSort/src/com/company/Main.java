package com.company;

public class Main {

    public static void printArray(int[] a){
        System.out.print("[");
        for(int i = 0; i < a.length; i ++)
        {
            System.out.print(a[i]);
            if(i < a.length-1)
                System.out.print(", ");
        }
        System.out.print("]");
    }
    public static void main(String[] args) {
	// write your code here
        int[] test = {12,4,1,5,5,6};
        int[] test2 = {6,3,9,4};
        int[] test3 = {6,3,9,4};

        // Insertion sort
        System.out.println("Insertion Sort Test: ");
        printArray(test);

        InsertionSort.sort(test);
        System.out.println("\nResult: ");
        printArray(test);

        // Merge sort
        System.out.println("\n\nMerge Sort Test: ");
        printArray(test2);

        MergeSort.sort(test2);
        System.out.println("\nResult: ");
        printArray(test2);

        // Quick sort
        System.out.println("\n\nQuick Sort Test: ");
        printArray(test3);

        QuickSort.sort(test3);
        System.out.println("\nResult: ");
        printArray(test3);



    }
}
