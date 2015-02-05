package com.company;

import java.util.*;

/*
        Problem:
        In a paint program canvas (represented by a nxn matrix) where the colors are represented by ints (1-5)
        Given a point, return the number of colors that are the same came color that are touching the point
 */
public class Main {

    // Helper function to get the neighbors of a point on a canvas with the same color
    public static ArrayList<Integer[]> getNeighbors(Integer[] p, Integer[][]grid, Integer color)
    {
        ArrayList<Integer[]> neighbors = new ArrayList<Integer[]>();
        int x = p[0], y = p[1];
        Integer[] newP = new Integer[2];

        // Left
        if(grid[x-1][y] != null && grid[x-1][y] == color)
        {
            newP[0] = x-1;
            newP[1] = y;
            neighbors.add(newP);
        }

        // Right
        if(grid[x+1][y] != null && grid[x+1][y] == color)
        {
            newP[0] = x+1;
            newP[1] = y;
            neighbors.add(newP);
        }

        // Bottom
        if(grid[x][y-1] != null && grid[x][y-1] == color)
        {
            newP[0] = x;
            newP[1] = y-1;
            neighbors.add(newP);
        }

        // Top
        if(grid[x][y+1] != null && grid[x][y+1] == color)
        {
            newP[0] = x;
            newP[1] = y+1;
            neighbors.add(newP);
        }

        return neighbors;
    }

    public static Integer findNumberOfSimilarAdjacent(Integer [][] grid, int x, int y)
    {
        // Variables to use later
        Integer count = 0, color;
        Integer[] point = {x, y};
        color = grid[x][y];

        // Hashset to store visited points
        HashSet<Integer[]> seen = new HashSet<Integer[]>();
        Queue<Integer[]> next = new LinkedList<Integer[]>();
        next.add(point);

        //
        while(next.size() != 0)
        {
            Integer[] c = next.remove();

            // If current point is not null on the canvas and the same color
            // Actually, I don't think this if statement is necessary with the way they neighbor function is implemented
            if(grid[c[0]][c[1]] != null && grid[c[0]][c[1]] == color)
            {
                // Increase count
                count++;

                // Get neighbors of point
                for(Integer[] points : getNeighbors(c, grid, color))
                    // If the points aren't in seen
                    if(!seen.contains(points))
                    {
                        // Add neighbor to seen and next
                        seen.add(points);
                        next.add(points);
                    }

            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        // Canvas to test
        Integer[][] canvas = new Integer[20][20];

        // Fill canvas with random values
        Random r = new Random();
        for(int i = 0; i < canvas.length; i ++)
            for(int j = 0; j < canvas[0].length; j++)
                canvas[i][j] = r.nextInt(2);

        // Point to test
        int[] point = {10, 10};

        // Test function
        Integer result = findNumberOfSimilarAdjacent(canvas, point[0], point[1]);

        // Print canvas
        System.out.println("Test Canvas: ");
        for(int i = 0; i < canvas.length; i ++) {
            for (int j = 0; j < canvas[0].length; j++){
                if(i == point[0] && j == point[1])
                    System.out.printf(" *%d* ", canvas[i][j]);
                else
                    System.out.printf(" %d ", canvas[i][j]);
            }
            System.out.println("");
        }

        // Print test
        System.out.println("Test Point: ");
        System.out.println("Point: " + point[0] + " " + point[1] + " Color: " + canvas[point[0]][point[1]] );

        // Print result
        System.out.println("Result: ");
        System.out.println(result);
    }
}
