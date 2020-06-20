
/*
class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.setData(data);
		this.next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
* */
public class solution {
	public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
        LinkedListNode<Integer> tail = head;
        LinkedListNode<Integer> temp = head;
        if (M == 0){
            return null;
        }
        
        while (temp != null && tail != null){
            for (int i=1;i<M;i++){
                if(temp == null){
                    break;
                }
                temp = temp.next;
                
                if (tail.next == null){
                    break;
                }
                tail = tail.next;
            }
            for (int i=0;i<=N;i++){
                if(temp == null){
                    break;
                }
                temp = temp.next;
            }
            tail.next = temp;
            tail = tail.next;
        }
        return head;

	}
}

//MAIN

import java.util.Scanner;
class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.setData(data);
		this.next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
public class Main {


	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(solution.skipMdeleteN(input(), s.nextInt(), s.nextInt()));
	}

	public static void print(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.next;
		}
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

}
