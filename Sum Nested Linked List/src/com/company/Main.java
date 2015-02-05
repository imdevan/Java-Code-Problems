package com.company;

public class Main {
    public static int sumEmbededLinkedList(LinkedList l, int level){
        int sum = 0;

        // If the node contains a number
        if(l.isInt())
            sum += level * l.intV;

        // If the node contains a list
        if(l.isList())
            sum += sumEmbededLinkedList(l.listV, level+1);

        // If the node contains a next
        if(l.hasNext())
            sum += sumEmbededLinkedList(l.next, level);

        // Probably not neccessary
        return sum;
    }
    public static int sumLinkedList(LinkedList l){
        return sumEmbededLinkedList(l.next, 1);
    }
    //  test case:
    //  {1, 2,{1,{4}}, 4}
    //  1 + 2 + 1*2 + 4*3 + 4
    //  return: 21
    public static void main(String[] args) {
        LinkedList test = new LinkedList();
        LinkedList em1 = new LinkedList();
        LinkedList em2 = new LinkedList();

        em2.add(4);
        em1.add(1);
        em1.add(em2);

        test.add(1);
        test.add(2);
        test.add(em1);
        test.add(4);

        int result = sumLinkedList(test);

        System.out.println(result);
    }
}
