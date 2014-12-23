package com.company;

/**
 * Created by Devan on 12/23/2014.
 */
public class Node {
    Integer val;
    Node left, right;

    public Node()
    {
        val = null;
        left = null;
        right = null;
    }
    public Node (int v)
    {
        val = v;
        left = null;
        right = null;
    }
    public void add(int v)
    {
        if(val == null)
            val = v;
        else
            if(v < val)
                if(left == null)
                    left = new Node (v);
                else
                    left.add(v);
            else
                if(right == null)
                    right = new Node(v);
                else
                    right.add(v);
    }
    public void printv()
    {
        System.out.print(val);
    }
    public void print()
    {
        if(left != null)
            left.print();

        System.out.print(val);

        if(right != null)
            right.print();
    }
}
