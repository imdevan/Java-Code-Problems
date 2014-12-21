package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Stack;

public class Main {

    public static boolean checkBalancedParenthesis(String s)
    {
        // Initial test
        if(s.length() == 0) return true;
        if(s.length() %2 != 0) return false;

        // Hashtable to look up proper characters
        HashMap<Character, Character> cc = new HashMap<Character, Character>();
        cc.put('(', ')');
        cc.put('[', ']');
        cc.put('{', '}');

        // Stack to store first half of string
        Stack<Character> cs = new Stack<Character>();

        // check if first half of string is valid and put in stack
        for(int i = 0; i < s.length()/2; i ++)
            if(cc.containsKey(s.charAt(i)))
                cs.add(s.charAt(i));
            else
                return false;

        // Pop first half of string and validate with second half of string
        for(int i = s.length()/2; i < s.length(); i++)
            if(cc.get(cs.pop()) != s.charAt(i))
                return false;

        return true;
    }
    public static void main(String[] args) {

        System.out.println("Test1 - Should be true:");
        System.out.println(checkBalancedParenthesis("([{}])"));

        System.out.println("Test1 - Should be false:");
        System.out.println(checkBalancedParenthesis("([]){"));

        System.out.println("Test1 - Should be false:");
        System.out.println(checkBalancedParenthesis("([)]"));

    }
}
