package com.company;

// Ex: 125 -> 131

public class Main {

    public static int getInt(char[] c)
    {
        int num = 0;
        for(int i = 0; i < c.length; i++)
        {
            num += Integer.parseInt(String.valueOf(c[i])) * Math.pow(10, c.length-i-1);
        }

        return num;
    }
    public static int nextLargestP(int num)
    {
        String s = String.valueOf(num);
        char[] c = s.toCharArray();
        int middle, newN;

        // Set right half equal to left half
        for(int i = 0; i < c.length/2; i++)
        {
            c[c.length-1-i] = c[i];
        }

        // Increase the middle number
        if(c.length % 2 == 0) // even
        {
            middle = (int) (1.1 * Math.pow(10, c.length/2));
            newN = getInt(c);
        }
        else
        {
            middle = (int) (Math.pow(10, c.length/2));
            newN = getInt(c);
        }

        if(newN > num)
            return newN;
        else if(c[c.length/2] != '9')
            return newN + middle;
        else
            return nextLargestP(newN);
    }
    public static void main(String[] args) {
        System.out.print(nextLargestP(125));
    }
}
