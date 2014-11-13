import java.util.*;

// Removes instances of a value from linked list
// This is simplified by Java's implementation of linked list and lack of C style pointers. 

// Time Complexity: O(n) Space Complexity: O(1)



public class RemoveLinkedListNode {

	public static void removeLinkedListNode(LinkedList<Integer> l, int rmv){

		if(l.size() == 0)return;	
		// if head is equal to remove value
		// while(l.element() != null && l.element() == rmv){
		// 	l.remove();
		// }

		// Iterate over list
		// Remove occurances of rmv value
		ListIterator<Integer> testIter = l.listIterator();
		while(testIter.hasNext()){
			if(testIter.next() == rmv){
				testIter.remove();
			}
		}

		// Print result to test
		ListIterator<Integer> printIter = l.listIterator();
		while(printIter.hasNext()){
			System.out.println(printIter.next());
		}

	}

	public static void main(String [] arg){
		// Test list
		LinkedList<Integer> testList = new LinkedList<Integer>();
		testList.add(5);
		testList.add(5);
		testList.add(1);
		testList.add(4);
		testList.add(5);
		testList.add(3);

		// test function
		removeLinkedListNode(testList, 5);
	}
}