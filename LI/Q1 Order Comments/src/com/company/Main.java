package com.company;

// Order comments
// Given an array of un ordered comments
// Order the array so that the parent always comes before the child
// comments each have an id and a parent id

import java.util.*;

public class Main {

    // Print comment array
    public static void printComments(Comment[] ca){
        for(Comment c : ca)
            System.out.printf("Comment {%d, %d}", c.parentId, c.id);
        System.out.println("");
    }

    // Order comment array
    public static void orderComments(Comment[] ca){
        // Hashmap that uses parentID of commenets as key
        // Each value is a list of comments that share a parent id
        HashMap<Integer, ArrayList<Comment>> cMap = new HashMap<Integer, ArrayList<Comment>>();

        // Iterate across comments and add to hashmap
        for(Comment c : ca)
            if(cMap.containsKey(c.parentId))
                cMap.get(c.parentId).add(c);
            else{
                cMap.put(c.parentId, new ArrayList<Comment>());
                cMap.get(c.parentId).add(c);
            }

        // BFS of parents id to add elements back to array
        Queue<Comment> cQueue = new LinkedList<Comment>();
        HashSet<Integer> cSet = new HashSet<Integer>();

        // Add comments with no parents to queue
        for(Comment c : cMap.get(null))
            cQueue.add(c);

        int index = 0;
        // Visit each of there children and add them to the queue
        while(cQueue.size() > 0){
            // Set current to first comment in queue
            Comment c = cQueue.poll();

            // Do nothing if comment has already been visited
            if(cSet.contains(c.id))
                continue;

            // Set current position in comment array to current comment
            ca[index++] = c;

            // Add the current comment's children to the queue
            if(cMap.get(c.id) != null)
                for(Comment child : cMap.get(c.id))
                        cQueue.add(child);

            // Set the current comment as seen
            cSet.add(c.id);
        }
    }

    public static void main(String[] args) {
        Comment[] ca = new Comment[10];
        ca[0] = new Comment(1,null);
        ca[1] = new Comment(2,4);
        ca[2] = new Comment(3,5);
        ca[3] = new Comment(4,null);
        ca[4] = new Comment(5,2);
        ca[5] = new Comment(6,1);
        ca[6] = new Comment(7,6);
        ca[7] = new Comment(8,7);
        ca[8] = new Comment(9,7);
        ca[9] = new Comment(10,6);

        printComments(ca);
        orderComments(ca);
        printComments(ca);

    }
}
