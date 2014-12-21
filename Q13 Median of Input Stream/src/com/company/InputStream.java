package com.company;

/**
 * Created by Devan on 12/20/2014.
 * InputStream is minHeap focused,
 * meaning that if the trees are uneven, there should be more elements in minHeap
 */
public class InputStream {
    MinHeap minHeap;
    MaxHeap maxHeap;
    int size;

    public InputStream()
    {
        minHeap = new MinHeap();
        maxHeap = new MaxHeap();
        size = 0;
    }

    public int getMedian()
    {
        return (size%2 == 0) ? minHeap.getFirst() : average();
    }

    public void add(int n)
    {
        if(size % 2 == 0)
        {
            maxHeap.add(n);
            size++;
            if(minHeap.size() == 0)
                return;
            if(maxHeap.getFirst() > minHeap.getFirst())
                swapHead(minHeap, maxHeap);
        }
        else
        {
            maxHeap.add(n);
            minHeap.add(maxHeap.pop());
            size++;
        }
    }
    protected void swapHead(Heap h1, Heap h2)
    {
        int toH1 = h2.pop();
        int toH2 = h1.pop();

        h1.add(toH1);
        h2.add(toH2);
    }
    protected int average()
    {
        if(maxHeap.size() + minHeap.size() > 1)
            return maxHeap.getFirst() + minHeap.getFirst() / 2;
        else
            return minHeap.size();
    }

    protected int getSize()
    {
        return size;
    }
}
