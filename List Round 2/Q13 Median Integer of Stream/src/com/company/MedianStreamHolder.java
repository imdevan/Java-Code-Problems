package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Devan on 4/2/2015.
 */
public class MedianStreamHolder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    Integer median;

    public MedianStreamHolder(){
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());

        median = 0;
    }

    public void add(Integer num){
        minHeap.add(num);
        while(minHeap.size() > maxHeap.size())
        {
            maxHeap.add(minHeap.poll());
        }
        median = maxHeap.peek();
    }

    public class MaxHeapComparator implements Comparator<Integer>
    {
        public int compare( Integer x, Integer y )
        {
            return y - x;
        }
    }
}
