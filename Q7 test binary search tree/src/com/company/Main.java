package com.company;

public class Main {

    //
    public static boolean isBST(Node head, int min, int max){

        // Termination condition when the function reaches the bottom of the tree
        if(head == null)
            return true;

        // check if value is legal
        else if(head.val < min || head.val > max)
            return false;

        // Otherwise, recur on left and right children
        else
            return isBST(head.left, min, head.val)
                    && isBST(head.right, head.val, max);
    }

    public static boolean isBST(Node head){
        // Call helper function with min and max possible integers
        return isBST(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {

        // Create test tree
        Node testTree = new Node(5);
        testTree.add(6);
        testTree.add(5);
        testTree.add(3);
        testTree.add(23);
        testTree.add(25);
        testTree.add(32);
        testTree.add(4);

        testTree.print();

        // Print true if the testTree is  BST (Binary Search Tree)
        System.out.print(isBST(testTree));
    }
}
