package com.company;

import java.util.ArrayList;

public class Main {

    public static int getIndexOfNum(int [] na, int n)
    {
        int in, ex; in = 0; ex = 0;

        // Check array indecies 2, 4, 8 , .. , 2^N
        while(true)
        {
            try
            {
                if(in > na.length)
                    throw new IndexOutOfBoundsException();

                else if(na[in] == n)
                    return in;
                else if(na[in] < n)
                {in = (int) Math.pow(2, ex); ex++;}
                else
                    break;
            }
            catch (Exception e)
            {
                System.out.println(e.toString());
                break;
            }
        }

        // Binary Search
        int left = in/2 +1;
        int right = in -1;
        int mid;
        while(left < right)
        {
            try
            {
                mid = (left +right) /2;
                if(right > na.length || left > na.length)
                    throw new IndexOutOfBoundsException();
                else if(na[mid] == n)
                    return mid;
                else if(na[mid] < n)
                    left = mid +1;
                else
                    right = mid -1;
            }
            catch (Exception e)
            {
                in--;
                left = in /2 +1;
                right = in -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // Test variables
        int [] testArray = {1,2,4,5,6,7,8,9};
        int test  = 6;

        System.out.println(getIndexOfNum(testArray,test));
    }
}
