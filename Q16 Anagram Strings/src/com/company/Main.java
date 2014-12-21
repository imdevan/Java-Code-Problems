package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    // Given 2 strings check if they are anagrams of one another
    // ignore space, punctuation, or capitalization
    public static boolean anagrams(String s1, String s2)
    {
        // Get alphabet
        HashSet<Character> alpha = getAlphabet();

        // Hashmap to store charcters
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        // Iterate across first string
        for(int i = 0; i < s1.length(); i++)
        {
            char c = Character.toLowerCase(s1.charAt(i));
            if (hm.containsKey(c))
                hm.put(c, hm.get(c) + 1);
            else if(alpha.contains(c))
                hm.put(c, 1);
        }

        // Iterate across second string
        for(int i = 0; i< s2.length(); i++)
        {
            char c = Character.toLowerCase(s2.charAt(i));
            if(hm.containsKey(c))
                hm.put(c, hm.get(c) -1);
            else if(alpha.contains(c))
                return false;
        }

        // Iterate across hashmap
        for(char c: hm.keySet())
            if(hm.get(c) != 0)
                return false;

        return true;
    }

    // Utility function to get alphabet
    public static HashSet<Character> getAlphabet()
    {
        // Get alphabet in hashset form
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        HashSet<Character> a = new HashSet<Character>();
        for(char c : alphabet)
            a.add(c);

        return a;
    }


    public static void main(String[] args) {

        System.out.println("Test should return true");
        System.out.println(
                anagrams("abc!@#&^%  d", "dcab")
        );
    }
}
