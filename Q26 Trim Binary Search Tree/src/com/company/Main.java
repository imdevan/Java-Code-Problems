package com.company;

import java.util.Random;

public class Main {

    public static void print(String s){System.out.print(s);}

    public static Node trimBST(Node tree, int min, int max)
    {
        if(tree == null)
            return tree;

        tree.left = trimBST(tree.left, min, max);
        tree.right = trimBST(tree.right, min,max);

        if(min <= tree.val && tree.val <= max)
            return tree;

        else if(tree.val < min)
            return tree.right;

        else if(tree.val > max)
            return tree.left;

        else
        {
            print("Invalid Value");
            return null;
        }
    }

    public static void main(String[] args) {
        // Create test tree
        Node tree = new Node();
        tree.add(1);
        tree.add(2);
        tree.add(4);
        tree.add(24);
        tree.add(5);
        Random r = new Random();
        for(int i = 0; i < 50; i++)
            tree.add(r.nextInt(100));

        print("Test Case: \n");
        tree.print();

        print("\nResult: \n");
        tree = trimBST(tree, 2, 5);
        tree.print();

    }
}
