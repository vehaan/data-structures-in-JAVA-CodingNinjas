/*************** 
 * Following is the Node class already written 
class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	public Node(T data) {
		this.data = data;
	}
}
 ***************/

public class Solution {
    static int n = 0;

	public static LinkedListNode<Integer> deleteIthNodeRec(LinkedListNode<Integer> head, int i){
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
        LinkedListNode<Integer> temp = head;
        
		if (n == i-1 && temp.next != null){
            temp.next = temp.next.next;
            return head;
        }
        
        if (temp.next != null){
            temp = temp.next;
    	    n++;
        }else{
            if (i == 0){
                return null;
            }
            return head;
        }
        
        deleteIthNodeRec(temp,i);
        return head;
        
	}
}

//MAIN

import java.util.Scanner;

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;
	
	public LinkedListNode(T data) {
		this.data = data;
	}
}

public class Runner {
	
	static Scanner s = new Scanner(System.in);
	
	public static LinkedListNode<Integer> takeInput() {
		LinkedListNode<Integer> head = null, tail = null;
		int data = s.nextInt();
		while(data != -1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}
	
	public static void print(LinkedListNode<Integer> head){
		while(head != null){
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LinkedListNode<Integer> head = takeInput();
		int pos = s.nextInt();
		head = Solution.deleteIthNodeRec(head, pos);
		print(head);
	}
}