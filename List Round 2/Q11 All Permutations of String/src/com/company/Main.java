package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        String s = "the";
        ArrayList<String> perms = getAllPerms(s);
        for(String perm : perms)
            System.out.println(perm);
    }

    private static ArrayList<String> getAllPerms(String s) {
        //  Using a hashset to avoid words being recorded twice
        HashSet<String> hs = new HashSet<String>();

        // base cases
        if(s.length() == 0)
            return new ArrayList<String>(hs);
        if(s.length() == 1) {
            hs.add(s);
            return  new ArrayList<String>(hs);
        }

        // String for doing string manipulation
        StringBuilder sb = new StringBuilder();

        // Get all sub permuatations of s
        for(int i = 0; i < s.length(); i++){
            // Remove char from string
            String sub = s.substring(0,i) + s.substring(i+1);
            char c = s.charAt(i);

            // Get all permutations of substring
            for(String subString : getAllPerms(sub)){

                // Add char back to each position of substring permutations
                for(int j = 0; j < subString.length(); j++){

                    // Add to permutation set
                    hs.add(subString.substring(0, j) + c + subString.substring(j));
                }
            }
        }

        // Add letter that was removed to each substring
        return  new ArrayList<String>(hs);
    }
}
