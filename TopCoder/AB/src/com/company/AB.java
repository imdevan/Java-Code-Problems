package com.company; /**
 * Created by Devan on 3/30/2015.
 *//**
 string has exactly N characters, each of which is either 'A' or 'B'
 the string s has exactly K pairs (i,j) (0 <= i < j <= N-1) such that s[i] = 'A' & s[j] = 'B'
 - N will be between 2 and 50, inclusive.
 - K will be between 0 and N(N-1)/2, inclusive.
 */
public class AB{
    public static String createString(int N, int K){
        // Invalid arguments
        if( N < 2 || N > 50 || K < 0 || K > N*(N-1)/2 )
            return "";

        int halfN = (int)Math.floor((float)N/(float)2);

        // K is too large for given N
        int maxNumberOfPairs = halfN* (N - halfN);
        if(K > maxNumberOfPairs)
            return "";

        // StringBuilder to create string to be returned
        StringBuilder sb = new StringBuilder();

        // No pairs
        if(K == 0){
            for(int i = 0; i < N; i++)
                sb.append('B');
            return sb.toString();
        }

        int numberOfAs = 0, numberOfBs = 0;
        // Find two numbers that sum to pair count
        for(int i = 0; i <= halfN; i++){
            for(int j = 0; j <= halfN+1; j++){
                if(i * j == K && i + j <= N){
                    numberOfAs = i;
                    numberOfBs = j;
                }
            }
        }

        int  pairCount = 0;
        // Add that many B's and A's to the end of the string
        for(int i = 0; i < numberOfBs; i++){
            sb.append('B');
            pairCount++;
        }
        for(int i = 0; i < numberOfAs; i++){
            sb.append('A');
            pairCount++;
        }

        // Make the rest B's
        for(int i = pairCount; i < N; i++){
            sb.append('B');
        }

        // Put sb in proper orientation
        sb.reverse();

        // return string
        return sb.toString();
    }
}