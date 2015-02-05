package com.company;

import java.util.HashSet;

public class Main {

    public static HashSet<Integer> findArrayPairs(int[] a, int k)
    {
        if(a.length < 2) return null;

        HashSet<Integer> output = new HashSet<Integer>();
        HashSet<Integer> seen = new HashSet<Integer>();
        int target;

        for(int num : a)
        {
            target = k - num;
            if(seen.contains(target))
            {
                output.add(num);
                output.add(target);
            }
            seen.add(num);
        }
        return output;
    }

    public static void main(String[] args)
    {
        // Test array
        int [] a = {1,2,1,2,4,5,6};
        int k = 5;

        HashSet<Integer> output = findArrayPairs(a,k);
        System.out.println(output.toString());
    }
}
