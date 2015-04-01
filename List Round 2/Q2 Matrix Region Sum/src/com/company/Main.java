package com.company;

import javafx.util.Pair;

import java.util.Random;

public class Main {


    public static int[][] preCompileMatrixSums(int[][] integerMartrix){
        int currentSum = 0;
        int rSize = integerMartrix.length;
        int cSize = integerMartrix[0].length;
        int[][] sumMatrix = new int[cSize][rSize];
        int colSum = 0, rowSum = 0;

        // calculate first value
        sumMatrix[0][0] = integerMartrix[0][0];


        // calculate top sums
        for(int col = 1; col < rSize; col++)
            sumMatrix[0][col] = sumMatrix[0][col-1] + integerMartrix[0][col];

        // calculate left row
        for(int row = 1; row < cSize; row++)
            sumMatrix[row][0] = sumMatrix[row-1][0] + integerMartrix[row][0];

        // calculate remaining sums
        for(int col = 1; col < rSize; col++){
            colSum = integerMartrix[0][col];
            for(int row = 1; row < cSize; row++){
                sumMatrix[row][col] += sumMatrix[row][col-1] + integerMartrix[row][col] + colSum;
                colSum += integerMartrix[row][col];
            }
        }

        return sumMatrix;
    }

    public static int getSumBetweenPoints(int[][] im, Pair<Integer,Integer> a, Pair<Integer,Integer> b){

        int sumA = (a.getKey() == 0 || a.getValue() == 0)? 0 : im[a.getKey()][a.getValue()];
        int sumB = (a.getValue() == 0)? 0 : im[a.getKey()][b.getValue()];
        int sumC = (a.getKey() == 0)? 0 : im[b.getKey()][a.getValue()];
        int sumD = im[b.getKey()][b.getValue()];

        return sumD - sumB - sumC + sumA;
    }

    public static void main(String[] args) {
        // Initialize test matrix
        int mSize = 3;
        int[][] integerMatrix = new int[mSize][mSize];
        Random r = new Random();
        for(int i = 0; i < mSize; i++){
            for(int j = 0; j < mSize; j++){
                // integerMatrix[i][j] = r.nextInt(mSize+1);
                integerMatrix[i][j] = 1;
            }
        }

        // Precompile sums of matrix

        int[][] sumMatrix = preCompileMatrixSums(integerMatrix);

        // Calculate sum of matrix between two points
        Pair<Integer,Integer> a = new Pair<Integer, Integer>(0, 0);
        Pair<Integer,Integer> b = new Pair<Integer, Integer>(2, 2);
        int sum = getSumBetweenPoints(sumMatrix, a, b);

        System.out.printf("Matrix total sum: %d\n", sumMatrix[mSize-1][mSize-1]);
        System.out.printf("Matrix sum a: %d b: %d c: %d d: %d\n",
                sumMatrix[a.getKey()][a.getValue()],
                sumMatrix[a.getKey()][b.getValue()],
                sumMatrix[b.getKey()][a.getValue()],
                sumMatrix[b.getKey()][b.getValue()]);

        System.out.printf("Matrix calculated sum: %d\n", sum);

    }
}
