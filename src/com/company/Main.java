package com.company;
// Write a function condense_meeting_times() that takes an array of meeting time ranges
// and returns an array of condensed ranges.

import java.util.ArrayList;
import java.util.HashMap;

//   Example:  [(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)]
//   Returns:  [(0, 1), (3, 8), (9, 12)]

//   Simpler:
//   Example:  [(3, 5), (4, 8), (10, 12), (9, 10)]
//   Returns:  [(3, 8), (9, 12)]
public class Main {

    private static Integer[][] condense_meeting_times(Integer[][] mt){
        // working set
        ArrayList<Integer[]> ws = new ArrayList<Integer[]>();
        boolean found = false;

        for(int i = 0; i < mt.length; i++)
        {
            Integer[] c = mt[i];
            for(Integer[] p : ws) // p = pair
            {
                if(p[0] <= c[0] || c[0] <=   p[1] ||p[0] <= c[1] || c[1] <=   p[1] )
                {
                    p[0] = Math.min(c[0], p[0]);
                    p[1] = Math.max(c[1], p[1]);
                    found = true;
                    break;
                }
            }
            if(found)
                found = false;
            else
                ws.add(c);
        }


        // Return as array
        Integer[][] r = new Integer[ws.size()][2];
        for(int i = 0; i < ws.size(); i++)
            r[i] = ws.get(i);
        return r;
    }
    public static void main(String[] args) {
	// write your code here
        Integer[][] test = {{0, 1}, {3, 5}, {4, 8}, {10, 12}, {9, 10}};
        Integer[][] result = condense_meeting_times(test);

        for(int i = 0; i < result.length; i++)
        {
            System.out.printf("(%d, %d)", result[i][0], result[i][1]);
        }

    }
}
