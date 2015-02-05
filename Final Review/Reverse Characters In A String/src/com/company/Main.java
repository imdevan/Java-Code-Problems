package com.company;

// Problem: Reverse characters in a string, but not the words
// Ex: "Hey there" -> "yeH ereht"

public class Main {

    public static String getReverseSub(char[] ca, int s, int e) {
        String r = "";

        // Account for last letter
        if(e == ca.length-1)
            r += ca[e];

        // Add characters in reverse order
        for (int i = e - 1; i >= s; i--)
        {
            if(i >= ca.length || i < 0) return null;

            r += ca[i];
        }

        return r;
    }
    public static String reverseString(String s){
        // String to return
        String r = "";
        char[] sa = s.toCharArray();
        int wordPos = 0;
        int spacePos = 0;
        char c;

        for(int i = 0; i < sa.length; i++)
            if(sa[i] == ' ' || i == sa.length-1)
            {
                r += getReverseSub(sa, wordPos, i) + " ";
                wordPos = i+1;
            }

        return r;
    }

    public static void main(String[] args) {
        // Test String
        String t = "Hey there";
        String r = reverseString(t);

        System.out.print(r);
    }
}
