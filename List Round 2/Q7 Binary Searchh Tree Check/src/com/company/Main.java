package com.company;

public class Main {

    public static boolean checkBST(Node t){
        return checkBST(t, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkBST(Node t, int minValue, int maxValue) {

        // Null values are valid trees
        if(t == null)
            return true;

        // Check value
        if(t.val > maxValue)
            return false;
        if(t.val < minValue)
            return false;


        // check left sub-tree & right sub-tree
        return checkBST(t.left, minValue, t.val) && checkBST(t.right, t.val, maxValue);
    }

    public static void main(String[] args) {
        Node tree = new Node();
        tree.add(5);
        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(7);
        tree.add(3);
        tree.add(4);
        tree.add(8);

        System.out.print(checkBST(tree));


    }
}
