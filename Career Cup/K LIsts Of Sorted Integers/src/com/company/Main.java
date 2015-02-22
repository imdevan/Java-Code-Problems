package com.company;

/*
    Career cup problem:
    Find the shortest range in a list of sorted lists
    ex:

*/


import java.util.*;

public class Main{

    public static Result shortestRange(List<List<Integer>> lists){
        Result result = null;

        int start = -1, end = -1;
        int rDiff = Integer.MAX_VALUE;
        int k = lists.size();

        PriorityQueue<Data> pQueue = new PriorityQueue<Data>();
        SortedSet<Data> entries = new TreeSet<Data>();
        Map<Integer, Data> listNoAndEntry = new HashMap<Integer, Data>();

        for(int i = 0; i < k; i++)
            pQueue.add(new Data(lists.get(i).remove(0), i));

        while(!pQueue.isEmpty()){
            Data minData = pQueue.remove();

            if(lists.get(minData.list).size() > 0)
                pQueue.add(new Data(lists.get(minData.list).remove(0), minData.list));

            if(listNoAndEntry.size() == k){

                Data first = entries.first();
                if((entries.last().val - first.val) +1 < rDiff){
                    start = first.val;
                    end = entries.last().val;
                }
                entries.remove(first);
                listNoAndEntry.remove(first.list);
            }

            if(listNoAndEntry.containsKey(minData.list))
                entries.remove(listNoAndEntry.remove(minData.list));

            listNoAndEntry.put(minData.list, minData);
            entries.add(minData);
        }

        if(listNoAndEntry.size() == k){

            Data first = entries.first();
            if((entries.last().val - first.val) +1 < rDiff){
                start = first.val;
                end = entries.last().val;
            }
            entries.remove(first);
            listNoAndEntry.remove(first.list);
        }

        result = new Result(start, end);
        return result;


    }

    public static Result shortestRange2(List<List<Integer>> lists) {

        // Keep track of range elements
        SortedSet<Data> mh = new TreeSet<Data>();
        for(int i = 0; i  < lists.size(); i++)
            mh.add(new Data(lists.get(i).remove(0), i));

        // Keep track of range
        int shortestRange = Integer.MAX_VALUE, start = -1, end = -1;

        // Iterate across lists until one is empty
        while(true){

            // Pop smallest element
            Data curr = mh.first();
            mh.remove(mh.first());

            // Stop if the end off a list is reached
            if(lists.get(curr.list).size() <= 0)
                break;

            // Add next element to set
            mh.add(new Data(lists.get(curr.list).remove(0), curr.list));

            // Compare current range to shortest
            if((mh.last().val - mh.first().val) < shortestRange)
            {
                start = mh.first().val;
                end = mh.last().val;
                shortestRange = end - start;
            }
        }

        return new Result(start, end);
    }

        public static void main(String[] args){

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(4);
        list1.add(10);
        list1.add(15);
        list1.add(24);
        list1.add(26);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(0);
        list2.add(9);
        list2.add(12);
        list2.add(20);
        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(5);
        list3.add(18);
        list3.add(22);
        list3.add(30);

        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        Result result = shortestRange2(lists);
        System.out.println(result.startRange + ", " + result.endRange);

    }
}