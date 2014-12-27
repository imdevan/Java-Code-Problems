package com.company;

import java.util.Random;

public class Main {

    // Given an integer array, one element occurs odd number of times
    // and all otheres have even occurrences. Find the element with odd occurrences
    public static int findOddElement(int [] a)
    {
        int r = 0;

        for(int i : a)
            r ^= i;

        return r;
    }

    public static void main(String[] args) {

        // Generate Test case
        // ------------------------------------
        int [] a = {1,1,2,3,3,4,4,5,5};

        int r = findOddElement(a);

        System.out.println("Test: ");
        for(int i: a) System.out.print(i);
        System.out.println("\nResult: ");
        System.out.println(r);

    }
}
