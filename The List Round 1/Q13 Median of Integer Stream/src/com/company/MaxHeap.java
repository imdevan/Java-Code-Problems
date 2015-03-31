package com.company;

import java.util.ArrayList;

/**
 * Created by Devan on 12/18/2014.
 */
public class MaxHeap {
    ArrayList<Integer> data;

    public MaxHeap()
    {
        data = new ArrayList<Integer>();
    }

    public void insert(int value)
    {
        data.add(value);
        siftUp(data.size()-1);
    }

    private int getParentIndex(int ni)
    {
        return (ni%2 == 0)? (ni/2 - 1) : ni/2;
    }
    private int getChildIndex(int ni, int child)
    {
        return ni*2 + (ni + child)%2;
    }
    private void siftUp(int ni)
    {
        int pi, tmp;
        if(ni != 0)
        {
            // Get parent index
            pi = getParentIndex(ni);
            if(data.get(pi) > data.get(ni))
            {
                // Swap values of parent and current node
                tmp = data.get(pi);
                data.set(pi, data.get(ni));
                data.set(ni, tmp);

                // Call recursively until node is at top of heap
                siftUp(pi);
            }
        }
    }
}
