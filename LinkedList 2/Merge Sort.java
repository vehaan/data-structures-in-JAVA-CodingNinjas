
public class Solution {

	public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> h) {
		// write your code here

        // Base case : if head is null 
        if (h == null || h.next == null) { 
            return h; 
        } 
  
        // get the middle of the list 
        LinkedListNode<Integer> middle = getMiddle(h); 
        LinkedListNode<Integer> nextofmiddle = middle.next; 
  
        // set the next of middle node to null 
        middle.next = null; 
  
        // Apply mergeSort on left list 
        LinkedListNode<Integer> left = mergeSort(h); 
  
        // Apply mergeSort on right list 
        LinkedListNode<Integer> right = mergeSort(nextofmiddle); 
  
        // Merge the left and right lists 
        LinkedListNode<Integer> sortedlist = sortedMerge(left, right); 
        return sortedlist; 
    } 
  
    
    public static LinkedListNode<Integer> sortedMerge(LinkedListNode<Integer> a, LinkedListNode<Integer> b) 
    { 
        LinkedListNode<Integer> result = null; 
        /* Base cases */
        if (a == null) 
            return b; 
        if (b == null) 
            return a; 
  
        /* Pick either a or b, and recur */
        if (a.data <= b.data) { 
            result = a; 
            result.next = sortedMerge(a.next, b); 
        } 
        else { 
            result = b; 
            result.next = sortedMerge(a, b.next); 
        } 
        return result; 
    } 
  
 
    // Utility function to get the middle of the linked list 
    public static LinkedListNode<Integer> getMiddle(LinkedListNode<Integer> head) 
    { 
        if (head == null) 
            return head; 
  
        LinkedListNode<Integer> slow = head, fast = head; 
  
        while (fast.next != null && fast.next.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
        } 
        return slow; 
    } 

}

//MAIN

import java.util.Scanner;
class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
		this.next = null;
	}
}

public class Runner {
	private static Scanner s = new Scanner(System.in);

	public static LinkedListNode<Integer> input() {
		int data = s.nextInt();

		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		while (data != -1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}

	public static void print(LinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {

		print(Solution.mergeSort(input()));

	}
}
