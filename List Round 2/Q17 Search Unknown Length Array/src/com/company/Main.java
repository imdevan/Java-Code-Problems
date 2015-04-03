package com.company;

public class Main {
    /**
     * Given a sorted array of unknown length and a number to search for, return
     * the index of the number in the array. Accessing an element out of bounds
     * throws exception. If the number occurs multiple times,
     * return the index of any occurrence. If it isn’t present, return -1.
     * @param args
     */

    public static void main(String[] args) {
        int num = 20;
        Integer[] array = {1,2,3,5,7,8,9,20};

        int numIndex = findIndexOfNum(array, num);
        System.out.println(numIndex);
    }

    private static int findIndexOfNum(Integer[] array, Integer num) {
        int index = 0;
        int lastIndex = 0;
        int exp = 0;
        while(array[index] != null){
            lastIndex = index;
            index = (int) Math.pow(2, exp++);

            try {
                if (array[index] == null)
                    break;

                else if (array[index] > num)
                    break;

                else if (array[index] == num)
                    return index;
            }
            catch (Exception e){
                break;
            }
        }

        // Binary search between last index and index
        while(lastIndex < index){
            int mid = (index - lastIndex)/2 + lastIndex;
            try {
                if (array[index] == null) {
                    index = mid;
                    continue;
                }

                if (array[mid] == num)
                    return mid;
                else if (array[mid] > num)
                    lastIndex = mid + 1;
                else if (array[mid] < num)
                    index = mid;
            }catch (Exception e){
                index = mid;
                continue;
            }
        }


        return -1; // number not found
    }
}
