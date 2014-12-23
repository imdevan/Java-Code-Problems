package com.company;

import java.util.*;

public class Main {

    public static void print(String s)
    {
        System.out.print(s);
    }

    public static void printReverseLevelOrder(Node tree)
    {
        int clc = 1, nlc = 0, i = 0;
        Node cn;
        ArrayList<Node> q = new ArrayList<Node>();
        Stack<Integer> s = new Stack<Integer>();

        q.add(tree);
        s.push(1);

        while(i < q.size())
        {
            cn = q.get(i);
            clc--;

            if(cn.left != null)
            {
                q.add(cn.left);
                nlc++;
            }
            if(cn.right != null)
            {
                q.add(cn.right);
                nlc++;
            }
            if(clc == 0)
            {
                if(nlc != 0)
                    s.push(nlc);

                clc = nlc;
                nlc = 0;
            }
            i++;
        }

        int printCurrentLast = q.size();
        int printCurrentFirst =  q.size()-1;
        while(printCurrentFirst > 0)
        {
            printCurrentFirst = printCurrentLast - s.pop();

            for(int j = printCurrentFirst; j < printCurrentLast; j++)
                print(q.get(j).val + " ");

            print("\n");
            printCurrentLast = printCurrentFirst;
        }
    }
    public static void main(String[] args) {
        Node t = new Node();
        t.add(3);
        t.add(2);
        t.add(1);
        t.add(6);
        t.add(5);
        t.add(4);
        t.add(2);

        System.out.println("Tree Test: ");
        t.print();

        print("\n\n");

        System.out.println("Tree Level Order Print Test: ");
        printReverseLevelOrder(t);
    }
}
