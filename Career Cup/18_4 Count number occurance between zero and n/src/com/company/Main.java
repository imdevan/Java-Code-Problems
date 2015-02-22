package com.company;

public class Main {

    public static char intToChar(int i)
    {
        return String.valueOf(i).toCharArray()[0];
    }

    public static char[] intToCharArray(int i)
    {
        return String.valueOf(i).toCharArray();
    }

    public static int  numberofnums(int n, int inttofind)
    {
        int count = 0;
        char chartofind = intToChar(inttofind);

        for(int i = 0; i <= n; i ++)
            for(char ch : intToCharArray(i))
                if(ch == chartofind)
                    count++;

        return count;
    }
    public static void main(String[] args) {
        int test = 25, inttofind = 2, result = numberofnums(test, inttofind);
        System.out.printf("test: %d, int to find: %d, result: %d", test, inttofind, result);
    }
}
