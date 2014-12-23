package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    // Because I'm to lazy to write
    public static void print(String s)
    {
        System.out.print(s);
    }

    public static void levelOrderPrint(Node tree)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree);
        int currentLevelCount = 1, nextLevelCount = 0;
        Node currentNode;

        while(queue.size() != 0)
        {
            currentNode = queue.remove();
            currentNode.printv();
            currentLevelCount--;
            if(currentNode.left != null)
            {
                nextLevelCount++;
                queue.add(currentNode.left);
            }
            if(currentNode.right != null)
            {
                nextLevelCount++;
                queue.add(currentNode.right);
            }
            if(currentLevelCount == 0)
            {
                print("\n");
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
            else
                print(" ");
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
        levelOrderPrint(t);
    }
}
