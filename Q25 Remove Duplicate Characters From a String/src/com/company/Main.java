package com.company;

import java.util.HashSet;

public class Main {

    public static String removeDuplicates(String s)
    {
        String r = "";
        HashSet<Character> hs = new HashSet<Character>();

        for(int i = 0; i < s.length(); i++)
            if(!hs.contains(s.charAt(i)))
            {
                r += s.charAt(i);
                hs.add(s.charAt(i));
            }

        return r;
    }
    public static void main(String[] args) {
	    // Test String
        String s = "Tree Traversal";

        // Should print "Tre avsl
        System.out.println(removeDuplicates(s));
    }
}
