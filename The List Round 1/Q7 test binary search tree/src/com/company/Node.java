package com.company;

/**
 * Created by Devan on 12/10/2014.
 */
public class Node {
    int val;
    Node left, right;

    public Node(int v){
        val = v;
        left = right = null;
    }

    // Add node to tree
    public void add(int v){
        if(v >= val)
            if(right != null)
                right.add(v);
            else
                right = new Node(v);

        else
            if(left != null)
                left.add(v);
            else
                left = new Node(v);
    }

    // Print tree in order
    public void print(){
        if(left != null)
            left.print();

        System.out.println(val);

        if(right != null)
            right.print();
    }
}
