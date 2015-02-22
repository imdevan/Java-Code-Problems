package com.company;

import java.util.ArrayList;

public class Main {

    public static void printArray(int[] a){
        System.out.print("[");
        for(int i = 0; i < a.length; i++)
        {
            System.out.print(a[i]);
            if(i < a.length-1)
                System.out.print(", ");
        }
        System.out.print("]");
    }

    public static int[] convertToIntArray(ArrayList<Integer> c){
        int[] r = new int[c.size()];
        for(int i = 0; i < r.length; i++)
            r[i] = c.get(i);
        return r;
    }

    public static int[] findLCS(int[]a , int[] b){
        ArrayList<Integer> lc = new ArrayList<Integer>();
        int count = 0;
        while(count < a.length)
        {
            // Make new subsequence
            ArrayList<Integer> current = new ArrayList<Integer>();
            int seqAPos = count;
            int seqBPos = 0;
            while(seqAPos < a.length)
            {
                // Iterate through for each sub sequence
                for(int i = seqBPos; i < b.length; i++)
                {
                    if(a[seqAPos] == b[i])
                    {
                        current.add(b[i]);
                        seqBPos = i+1;
                        break;
                    }
                }
                seqAPos++;
            }

            if(current.size() > lc.size())
                lc = current;

            count++;
        }

        return convertToIntArray(lc);
    }

    public static void main(String[] args) {
    // Determine an LCS of arrays
        int[] a = {1,0,0,1,0,1,0,1};
        int[] b = {0,1,0,1,1,0,1,1,0};
        int[] lcs = findLCS(a, b);

        printArray(lcs);
    }
}
