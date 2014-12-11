package com.company;

/*
    The Question:
    We are given 3 strings: str1, str2, and str3.
    Str3 is said to be a shuffle of str1 and str2
    if it can be formed by interleaving the characters
    of str1 and str2 in a way that maintains the left
    to right ordering of the characters from each string.

    For example, given str1=”abc” and str2=”def”, str3=”dabecf”

    is a valid shuffle since it preserves the character ordering of the two strings.
    So, given these 3 strings write a function that detects whether str3 is a valid shuffle of str1 and str2.


    - See more at: http://www.ardendertat.com/2011/10/10/programming-interview-questions-6-combine-two-strings/#sthash.llR6hVsb.dpuf
 */
public class Main {

    public static boolean isValidShuffle(String s1, String s2, String s3){

        // Check obvious cases
        if(s1.length() + s2.length() != s3.length())
            return false;
        else if(s3.length() == 0)
            return true;

        // Counters to track progress iterating through strings
        int i1, i2, i3;
        i1 = i2 = i3 = 0;

        // Iterate over strings
        while(i3 != s3.length()){

            if(i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)){
                i1++;
            }
            else if(i2 < s1.length() && s2.charAt(i2) == s3.charAt(i3)){
                i2++;
            }
            else
                return false;


            i3++;
        }
        return true;
    }

    public static void main(String[] args) {
	// write your code here
        String test1 = "abc";
        String test2 = "def";
        String test3 = "dabecf";

        boolean isValid = isValidShuffle(test1, test2, test3);

        System.out.println(isValid);
    }
}
