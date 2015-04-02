package com.company;

import java.util.HashMap;

public class Main {


    public static void main(String[] args) {

        boolean anagrams = stringsAreAnagrams("Eleven plus two", "Twelve plus one");
        System.out.println(anagrams);
    }

    private static boolean stringsAreAnagrams(String s1, String s2) {
        HashMap<Character, Integer> s1Map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> s2Map = new HashMap<Character, Integer>();

        for(Character i : s1.toCharArray()) {
            char c = Character.toLowerCase(i);
            if(!Alpha.isAlpha(c))
                continue;
            if(s1Map.containsKey(c))
                s1Map.put(c, s1Map.get(c)+1);
            else
                s1Map.put(c, 1);
        }


        for(Character i : s2.toCharArray()) {
            char c = Character.toLowerCase(i);
            if(!Alpha.isAlpha(c))
                continue;
            if(s2Map.containsKey(c))
                s2Map.put(c,s2Map.get(c)+1);
            else
                s2Map.put(c, 1);
        }


        for(Character c : s1Map.keySet()) {
            if(s2Map.get(c) != s1Map.get(c))
                return false;
        }

        return true;
    }
}
