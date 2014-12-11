package com.company;

public class Main {

    public static void removeVal(Node n, int v) {
        if (n.next == null)
            return;
        else if (n.next.val == v)
            if (n.next.next == null)
                n.next = null;
            else {
                n.next = n.next.next;
                removeVal(n, v);
            }

        else
            removeVal(n.next, v);
    }

    public static void main(String[] args) {
        // Create test linked list
        Node testList = new Node();
        testList.add(5);
        testList.add(6);
        testList.add(5);
        testList.add(5);
        testList.add(3);
        testList.add(2);
        testList.add(5);

        // Print initial test case
        System.out.println("Test List");
        testList.print();

        // Call function to test
        removeVal(testList, 5);

        // Print test after removing 5
        System.out.println("After removing '5'");
        testList.print();
    }
}