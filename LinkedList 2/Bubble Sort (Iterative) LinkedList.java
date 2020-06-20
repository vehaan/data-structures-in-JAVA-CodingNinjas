
public class Solution {

    
    public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> node){
        LinkedListNode<Integer> header = node;
        boolean isChanged = true;
        if(node != null && node.next != null){
            int i = 0;
            while(isChanged) {
                LinkedListNode<Integer> prevNode = null;
                LinkedListNode<Integer> current = header;
                LinkedListNode<Integer> nextNode = current.next;
                isChanged = false;
                while (current.next != null) {
                    if (current.data > nextNode.data) {
                        if (header == current) {
                            header = nextNode;
                        } else {
                            prevNode.next = nextNode;
                        }
                        current.next = nextNode.next;
                        nextNode.next = current;
                        isChanged = true;
                        current = nextNode;
                    }
                    prevNode = current;
                    current = prevNode.next;
                    nextNode = current.next;
                }
            }

        }
        return header;
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
	private static Scanner s= new Scanner(System.in);
	public static LinkedListNode<Integer> input() {
		int data = s.nextInt();

		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		while (data!=-1) {
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
		print(Solution.bubbleSort(input()));
	}
}
