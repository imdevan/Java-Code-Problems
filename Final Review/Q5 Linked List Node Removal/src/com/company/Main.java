package com.company;

// Problem: Given a linked list and ann integer value remove any nodes with that value
public class Main {

    public static void removeNodes(Node list, int v) {
        // Termination condition
        if (list.next == null)
            return;

            // If val == v
        else if (list.next.val == v)
            if (list.next.next != null) {
                list.next = list.next.next;
                removeNodes(list, v);
            } else
                list.next = null;

            // Otherwise recur
        else
            removeNodes(list.next, v);
    }

    public static void main(String[] args) {
        Node list = new Node();
        int[] v = {5, 1, 4, 5, 5, 6, 2, 4, 3, 5, 5};
        list.addArray(v);

        removeNodes(list, 5);
        list.print();
    }
}
