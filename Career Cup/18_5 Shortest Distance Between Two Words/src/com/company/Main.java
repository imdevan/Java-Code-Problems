package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {


    public static int findShortestDistance(String wordA, String wordB, ArrayList<String[]> la){
        int shortestDistance = Integer.MAX_VALUE, wordAPos = -1, wordBPos = -1, wordCount = 0;

        for(String[] line : la){
            for(String cw: line){

                wordCount++;
                boolean ea = cw.equals(wordA), eb = cw.equals(wordB);

                if(ea || eb){

                    if(eb)
                        wordBPos = wordCount;

                    else if(ea)
                        wordAPos = wordCount;

                    int currentDistance = Math.abs(wordAPos - wordBPos);

                    if(currentDistance < shortestDistance)
                        shortestDistance = currentDistance;
                }
            }
        }

        return shortestDistance;
    }

    public static void mapAllWords(String word, HashMap<String, HashMap<String, Integer>> wm, ArrayList<String[]> la ){
        int firstWord1 = 0, firstWord2 = 0;
        wm.put(word, new HashMap<String, Integer>());

        for(int i = 0; i < la.size(); i++){

            String[] currLine = la.get(i);

            for(int j = 0; j < currLine.length; j++){
                if(!wm.get(word).containsKey(currLine[j]))
                {
                    wm.get(word).put(currLine[j], findShortestDistance(word, currLine[j], la));
                }
            }
        }
    }

    public static ArrayList<String[]> getGraphOfWords(String fileName) throws IOException{

        ArrayList<String[]> lines = new ArrayList<String[]>();

        for (String line : Files.readAllLines(Paths.get(fileName))){

            String[] words = line.split(" ");
            lines.add(words);
        }

        return lines;
    }

    public static HashMap<String, HashMap<String, Integer>> precompileText(String fileName) throws IOException {

        HashMap<String, HashMap<String, Integer>> wordMap = new HashMap<String, HashMap<String, Integer>>();

        // For each word in the file get the shortest distance from that word to each other word in the file
        ArrayList<String[]> lineArrayList = getGraphOfWords("test.txt");

        for(int i = 0; i < lineArrayList.size(); i++){

            String[] currLine = lineArrayList.get(i);

            for(int j = 0; j < currLine.length; j++){

                if(!wordMap.containsKey(currLine[j])){
                    mapAllWords(currLine[j], wordMap, lineArrayList);
                }
            }
        }


        return wordMap;
    }
    public static void main(String[] args) throws IOException{

        // For each word in the file get the shortest distance from that word to each other word in the file
        ArrayList<String[]> lineArrayList = getGraphOfWords("test.txt");
        System.out.println(findShortestDistance("test", "though", lineArrayList));


        // Precompiling all words into a Hashmap
        // Time: O(n^3) Space: O(n^2)
        HashMap<String, HashMap<String, Integer>> wordMap = precompileText("test.txt");

        // Retrieval from Hashmap for each word
        // Time: O(1)
        System.out.println(wordMap.get("test").get("though"));

    }
}
