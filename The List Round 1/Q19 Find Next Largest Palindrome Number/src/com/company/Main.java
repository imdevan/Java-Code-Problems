package com.company;


public class Main
{
    public static int findNextLargestPallindrome(int n)
    {

        int length = String.valueOf(n).length();

        String leftHalf = getLeftHalf(n);
        String rightHalf = reverse(leftHalf);
        char middle = getMiddle(n);

        int incr, newN;


        // Concatinate to form new number
        if(length %2 == 0)
        {
            incr = (int) (1.1 * Math.pow(10, length/2));
            newN = Integer.parseInt(leftHalf + rightHalf);
        }
        else
        {
            incr = (int) Math.pow(10, length/2);
            newN = Integer.parseInt(leftHalf + middle + rightHalf);
        }

        if(newN >= n)
            return newN;
        else if(middle != '9')
            return newN + incr;
        else
            return findNextLargestPallindrome(newN);
    }

    public static String getLeftHalf(int n)
    {
        String sn = String.valueOf(n);
        return sn.substring(0, sn.length()/2);
    }

    public static String reverse(String s)
    {
        String r = "";

        for(int i = 0; i < s.length(); i++)
            r += s.charAt(s.length() -1 - i);

        return r;
    }
    public static char getMiddle(int n)
    {
        String sn = String.valueOf(n);
        return sn.charAt(sn.length()/2);
    }
    public static void main(String[] args)
    {
        int test = 432145;
        int result = findNextLargestPallindrome(test);

        System.out.format("Test: %d \nResult: %d", test, result);
    }
}