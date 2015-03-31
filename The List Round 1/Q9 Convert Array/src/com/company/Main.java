package com.company;

// Given an array [a1, a2, ..., aN, b1, b2, ..., bN, c1, c2, ..., cN]
// - See more at: http://www.ardendertat.com/2012/01/09/programming-interview-questions/#sthash.DuLTXtVB.dpuf

public class Main {

    // Helper function to get index
    public static int getIndex(int setI, int N, int setOf){
        return (setI % setOf)*N + setI / setOf;
    }
    public static void convertArray(String [] a, int N){
        int getIndex;
        int setOf = a.length / N;
        String temp; // for swapping

        for(int setI = 0; setI < a.length; setI++)
        {
            getIndex = getIndex(setI, N, setOf);
            while (getIndex < setI)
                getIndex = getIndex(getIndex, N, setOf);

            // Swap element
            temp = a[setI];
            a[setI] = a[getIndex];
            a[getIndex] = temp;
        }
    }

    public static void main(String[] args) {

        // Test array
        String [] testArray = {"a1", "a2", "a3", "b1", "b2", "b3", "c1", "c2", "c3"};

        // Print test case
        System.out.println("Test Case:");
        for(String elm : testArray)
            System.out.print(elm + " ");

        // Call function
        convertArray(testArray, 3);

        // Print test case
        System.out.println("\n\nResult of ConvertArry():");
        for(String elm : testArray)
            System.out.print(elm + " ");
    }
}
