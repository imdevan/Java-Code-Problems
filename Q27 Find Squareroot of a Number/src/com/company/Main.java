package com.company;

public class Main {
    public static int sqrt(int num)
    {
        if(num < 0)
            // Throw value error
            return -1;

        if(num == 1)
            return 1;

        for(int i = 0; i < 1 + num/2; i++)
        {
            int ii = i+1;
            if(i*i <= num && ii*ii >=num)
                return i;
        }

        // no sqrt?
        return num;
    }

    public static int sqrtb(int num) {
        if (num < 0)
            // throw value error
            return -1;
        if (num == 1)
            return 1;

        // Binary search implementation
        int low = 0, high = 1+num/2, mid = low + (high - low) / 2;
        while (low+1 < high)
        {
            int mid1 = mid+1;
            if(mid*mid <= num && mid1*mid1 >= num)
                return mid;
            else if(mid*mid > num)// value too high
                high = mid;
            else if(mid*mid < num) // value too low
                low = mid;

            mid = low + (high - low)/2;
        }

        // no sqrt?
        return num;
    }


    public static void main(String[] args)
    {
        int test = 10;
        int result = sqrtb(test);

        System.out.format("Test: %d Result: %d", test, result);
    }
}
