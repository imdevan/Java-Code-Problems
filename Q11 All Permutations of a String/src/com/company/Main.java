package com.company;

import java.util.ArrayList;

public class Main {

    public static ArrayList<String> findAllPermuations(String s)
    {
        // Result ArrayList
        ArrayList<String> r = new ArrayList<String>();

        // Termination case
        if(s.length() <= 1)
        {
            r.add(s);
            return r;
        }

        // Remove one character from string
        char c = s.charAt(0);

        // Find all permuations of length N-1
        ArrayList<String> permList = findAllPermuations(s.substring(1));

        // Iterate over permuations
        for(String perm : permList)
            // Insert char into each place of permuation
            for(int i = 0; i <= perm.length(); i++)
                r.add(
                        perm.substring(0,i) + c + perm.substring(i)
                );

        // Return result
        return r;
    }

    public static void main(String[] args) {
        // Test String
        String test = "alm";

        // Result
        System.out.print(findAllPermuations(test).toString());
    }
}
