package com.company;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.util.HashMap;

public class Main {

    public static char firstHMap(String s)
    {
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();

        for(char c : s.toCharArray())
            h.put(c, (h.containsKey(c)) ? h.get(c)+1: 1 );

        for(char c : s.toCharArray())
            if(h.get(c)== 1)
                return c;

        return ' ';
    }
    public static char firstNonRepeatingChar(String s)
    {
        char last = ' ';
        for(int i = 0; i < s.length(); i++)
        {
            if(i == 0)
            {
                last = s.charAt(i);
                continue;
            }
            else if(i < s.length()-1)
            {
                if(s.charAt(i) == s.charAt(i+1) || s.charAt(i) == last)
                {
                    last = s.charAt(i);
                    continue;
                }
                else
                    return s.charAt(i);
            }
            else if(i > 0)
            {
                if(s.charAt(i) == last)
                {
                    last = s.charAt(i);
                    continue;
                }
                else
                    return s.charAt(i);
            }
        }

        return last;
    }
    public static void main(String[] args) {
        String test = "ccssiijfsa;dlfkjajflloopp";

        System.out.println("Test string " + test);
        System.out.println(firstNonRepeatingChar(test));
        System.out.println(firstHMap(test));

    }
}
