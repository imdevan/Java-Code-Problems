package com.company;

import java.util.HashMap;
import java.util.Stack;

public class Main {


    public static void main(String[] args) {
        String s = "({[]})";
        boolean r = checkBalancedParentheses(s);
        System.out.println(r);
    }

    private static boolean checkBalancedParentheses(String s) {
        HashMap<Character, Character> closeSet = new HashMap<Character, Character>();
        closeSet.put('}', '{');
        closeSet.put(']', '[');
        closeSet.put(')', '(');

        Stack<Character> stack = new Stack<Character>();

        for(Character c : s.toCharArray()){

            // open parentheses
            if(!closeSet.containsKey(c))
                stack.push(c);

            // Invalid string
            else if(closeSet.get(c) != stack.pop())
                return false;
        }

        return true;
    }
}
