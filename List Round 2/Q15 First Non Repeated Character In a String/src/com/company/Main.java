package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String s ="This is our test string";
        Character c = firstNonRepeatedCharacter(s);

        System.out.println(c);
    }


    private static Character firstNonRepeatedCharacter(String s) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            Character c = Character.toLowerCase(s.charAt(i));
            if(hm.containsKey(c))
                hm.put(c, hm.get(c)+1);
            else
                hm.put(c, 1);
        }

        for(int i = 0; i < s.length(); i++) {
            Character c = Character.toLowerCase(s.charAt(i));
            if (hm.get(c) == 1)
                return c;
        }

        return null; // Throw error
    }
}
