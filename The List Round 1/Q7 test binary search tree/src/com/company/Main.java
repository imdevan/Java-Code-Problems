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

        int[] test = {154,97,63,149,2,34,147,64,100,20,40,67,51,93,72,158,136,35,33,156,10,75,99,42,49,30,77,128,54,44,76,151,146,23,68,80,21,36,50,139,82,159,117,167,85,173,144,152,28,1,168,18,157,171,71,15,112,155,94,3,102,174,121,135,16,109,113,41,26,84,115,120,104,163,166,56,161,8,32,88,170,129,140,116,133,79,101,92,57,58,124,162,45,73,95,90,47,19,108,4,125,172,141,70,43,110,86,12,17,37,160,5,169,24,29,48,130,165,150,61,138,11,66,52,119,69,13,164,148,62,126,7,145,27,14,81,131,60,91,114,96,74,143,132,25,31,55,103,9,118,123,106,122,65,111,6,127,142,105,137,134,153,89,39,83,46,53,59,22,38,98,78,107,87,0};
        // Create test tree
        Node testTree = new Node(154);

        for(int i = 1; i < test.length; i++)
        {
            testTree.add(test[i]);
        }

        testTree.print();

        // Print true if the testTree is  BST (Binary Search Tree)
        System.out.print(isBST(testTree));
    }
}
