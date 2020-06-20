
/*
class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.setData(data);
		this.next = null;
	}



}
* */
public class Solution {
	public static LinkedListNode<Integer> sortEvenOdd(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> oddH = null;
        LinkedListNode<Integer> oddT = null;
        LinkedListNode<Integer> evenH = null;
        LinkedListNode<Integer> evenT = null;
        
        while (head != null){
            if (head.data%2 != 0){
                if (oddH == null){
                    oddH = head;
                    oddT = head;
                }else{
                    oddT.next = head;
                    oddT = oddT.next;
                }
            }else{
                if (evenH == null){
                    evenH = head;
                    evenT = head;
                }else{
                    evenT.next = head;
                    evenT = evenT.next;
                }
            }
            head = head.next;
        }
        if (evenT == null){
            oddT.next =null;
            return oddH;
        }
        if (oddT == null){
            evenT.next = null;
            return evenH;
        }
        evenT.next = null;
        oddT.next = evenH;
        return oddH;

	}
}

//MAIN



import java.util.Scanner;

class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data=data;
		this.next = null;
	}
}

public class Runner {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(Solution.sortEvenOdd(input()));
	}

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
}
