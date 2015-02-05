package com.company;

// Given an array: [a1, .., aN, b1, .., bN, c1, .., cN]
// Convert to [a1, b1, c1, .., aN, bN, cN]

public class Main {
    public static int getIndex(int i, int N, int l)
    {
        return (i%l)*N + i/l;
    }

    public static void convertArray(String [] a, int N, int l)
    {
        int si; // swap index
        String swap;

        // Iterate across array
        for(int i = 0; i < a.length; i++)
        {
            si = getIndex(i, N, l);
            while(si < i)
                si = getIndex(si, N, l);

            // swap elements
            swap = a[si];
            a[si] = a[i];
            a[i] = swap;
        }
    }
    public static void main(String[] args) {
        String [] test = {"a1", "a2", "b1", "b2", "c1", "c2"};
        int N = 2;
        int l = 3;


        for(String s: test)
            System.out.println(s);

        convertArray(test, N, l);

        for(String s: test)
            System.out.println(s);
    }
}
