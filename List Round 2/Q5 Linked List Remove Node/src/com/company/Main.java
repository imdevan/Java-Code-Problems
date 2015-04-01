package com.company;

public class Main {

    public static void removeFromList(Node n, int k){
        if(n.next == null)
            return;

        else if(n.next.val == k){
            if(n.next.next != null){
                n.next = n.next.next;
            }
            else
                n.next = null;


            removeFromList(n, k);
        }

        else if(n.next != null)
            removeFromList(n.next, k);
    }


    public static void main(String[] args) {

        // Variables to test
        Node list = new Node();
        int[] listArray = {5, 3, 1, 5, 5};
        for(int num : listArray)
            list.add(num);
        int k = 5;

        // Test remove from list function
        removeFromList(list, k);

        // Print result
        list.print();
    }
}
