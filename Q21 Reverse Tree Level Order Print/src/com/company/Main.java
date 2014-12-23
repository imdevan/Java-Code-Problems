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
                s.push(nlc);
                clc = nlc;
                nlc = 0;
            }
        }

        int printCurrentLast = q.size()-1;
        int printCurrentFirst =  q.size()-1;
        while(printCurrentFirst >= 0)
        {
            printCurrentFirst = printCurrentLast - s.pop();

            for(int j = printCurrentFirst; j < printCurrentLast; j++)
                print(q.get(j) + " ");

            print("\n");
            printCurrentLast = printCurrentFirst;
        }


    }
    public static void main(String[] args) {
	// write your code here
    }
}
