package com.company;

// Problem: Find all permuations of a word
// Ex: "ALM" -> {"ALM", "LAM", "LMA", "MLA", "MAL"}

import java.util.ArrayList;

public class Main {

    public static ArrayList<String> getAllPerms(String s){
        ArrayList<String> r = new ArrayList<String>();
        if(s.length() <= 1)
        {
            r.add(s);
            return r;
        }

        // Remove a letter
        char c = s.charAt(0);

        // Get all permutations of substring
        ArrayList<String> perms = getAllPerms(s.substring(1));

        // Add removed letter to all perms of substring
        for(String word : perms)
            for(int i =0; i <= word.length(); i++)
                r.add(word.substring(0,i) + c + word.substring(i));

        return r;
    }
    public static void main(String[] args) {
        // Test string
        String alm = "ALM";

        for(String s: getAllPerms(alm))
            System.out.println(s);
    }
}
