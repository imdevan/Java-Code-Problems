package com.company;

/**
 * Created by Devan on 12/27/2014.
 */
public class Node {
    Integer val;
    Node left, right;
    public Node()
    {
        val = null; left = null; right = null;
    }
    public Node(int v)
    {
        val = v; left = null; right = null;
    }
    public void add(int v)
    {
        if(val == null)
            val = v;

        if(v >= val)
            if(right != null)
                right.add(v);
            else
                right = new Node(v);
        else if(v < val)
            if(left != null)
                left.add(v);
            else
                left = new Node(v);
    }

    public void print()
    {
        if(left != null)
            left.print();

        printv();

        if(right != null)
            right.print();
    }

    public void printv()
    {
        System.out.print(val + " ");
    }
}
