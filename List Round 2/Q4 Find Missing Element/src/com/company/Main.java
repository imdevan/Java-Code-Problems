package com.company;

public class Main {

    /**
     * Given two arrays find which element is missing in the second array
     * @param args
     */
    public static void main(String[] args) {
        int[] array1 = {4, 1, 0, 3};
        int[] array2 = {4, 0, 3};

        int missingElement = findMissingElement(array1, array2);

        System.out.printf("Missing element: %d", missingElement);
    }

    private static int findMissingElement(int[] array1, int[] array2) {

        int missingElement = 0;

        for(int num: array1)
            missingElement ^= num;
        for(int num: array2)
            missingElement ^= num;

        return missingElement;
    }
}
