package com.company;

import sun.awt.image.ImageWatched;

import java.io.CharConversionException;
import java.util.*;

public class Main {

    public static LinkedList<Integer> getSubList(LinkedList<Integer> ll, int f, int e)
    {
        LinkedList<Integer> r = new LinkedList<Integer>();

        if(f < ll.size() && e > f && e <= ll.size())
            for(int i = f; i < e; i++)
                r.add(ll.get(i));

        return r;
    }

    // Given an integer find the next highest number with the same digits
    public static int nextlargest(int num)
    {
        // Variables used later for computation
        int swap, pivot, size, r = 0;

       // Convert To a linked list of each digit
        String [] s = String.valueOf(num).split("");
        LinkedList<Integer> ll = new LinkedList<Integer>(), lsub = new LinkedList<Integer>();
        for(String si : s)
            ll.add(Integer.parseInt(si));

        // Iterate across linked list of ints
        for(int i = ll.size()-2; i >= 0; i--)
        {
            if(ll.get(i) < ll.get(i+1))
            {
                // Get sorted sublist starting from current position
                lsub = getSubList(ll, i, ll.size());
                Collections.sort(lsub);

                // Get element to swap with pivot
                pivot = lsub.get(0); // pivot
                swap = lsub.get(1);  // elem to swap with pivot

                // Swap pivot with swap in main linked list
                ll.set(ll.indexOf(swap), pivot);
                ll.set(i, swap);

                // Sort sublist after swapped pivot
                lsub = getSubList(ll, i+1, ll.size());
                Collections.sort(lsub);

                // Add Everything together
                size = ll.size();
                for(int j = 0; j < ll.size() - lsub.size(); j++)
                    r += ll.get(j) * Math.pow(10, --size);

                for(int j = 0; j < lsub.size(); j++)
                    r += lsub.get(j) * Math.pow(10, --size);

                return r;
            }
        }

        return num;
    }

    public static void main(String[] args)
    {
        // Test
        int t = 12543;
        int newT = nextlargest(t);

        System.out.println(newT);
    }
}
