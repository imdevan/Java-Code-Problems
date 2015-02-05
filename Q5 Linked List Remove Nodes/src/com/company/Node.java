package com.company;

/**
 * Created by Devan on 12/10/2014.
 */
public class Node {
    Integer val;
    Node next;

    // Constructor for head Node
    public Node(){
        val = null;
        next = null;
    }

    // Constructor for new node in list
    public Node(int v){
        val = v;
        next = null;
    }

    // Add Node to linked list
    public void add(int v){
        if(next != null)
            next.add(v);
        else
            next = new Node(v);
    }

    // Print Linked List
    public void print(){
        if(next == null)
            return;
        System.out.print(next.val + " ");
        next.print();
    }

    // Print reverse
    public void printr(){
        if(next == null)
            return;

        next.printr();


        System.out.print(next.val + " ");
    }
}
