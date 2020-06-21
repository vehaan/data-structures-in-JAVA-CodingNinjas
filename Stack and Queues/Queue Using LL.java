/***************
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		Queue<Integer> st = new Queue<Integer>();

		int choice = s.nextInt();
		int input;

		while (choice !=-1) {
			if(choice == 1) {
				input = s.nextInt();
				st.enqueue(input);
			}
			else if(choice == 2) {
				try {
					System.out.println(st.dequeue());
				} catch (QueueEmptyException e) {
					System.out.println(-1);
				}
			}
			else if(choice == 3) {
				try {
					System.out.println(st.front());
				} catch (QueueEmptyException e) {
					System.out.println(-1);
				}
			}
			else if(choice == 4) {
				System.out.println(st.size());
			}
			else if(choice == 5) {
				System.out.println(st.isEmpty());
			}
			choice = s.nextInt();
		}
	}
}

class Node<T> {
	T data;
	Node<T> next;

	public Node(T data) {
		this.data = data;
	}
}


 ***********/
public class Queue<T> {
    
    Node<T> head;
    Node<T> tail;
    int size;

	public Queue() {
        head = null;
        tail = null;
        size = 0;
	}

	public void enqueue(T data) {
        Node<T> temp = new Node<>(data);
        if (size == 0){
            head = temp;
            tail = temp;
        }else{
            tail.next = temp;
            tail = tail.next;
        }
        size++;

	}

	public int size() {
        return size;

	}

	public boolean isEmpty() {
        return size == 0;

	}

	public T dequeue() throws QueueEmptyException {
        if (size == 0){
            throw new QueueEmptyException();
        }
        T temp = head.data;
        head = head.next;
        size--;
        return temp;

	}

	public T front() throws QueueEmptyException {
        if (size == 0){
            throw new QueueEmptyException();
        }
        return head.data;

	}
}

class QueueEmptyException extends Exception{
    
}

//MAIN

import java.util.Scanner;

class Node<T> {
	T data;
	Node<T> next;

	public Node(T data) {
		this.data = data;
	}
}

public class Runner {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		Queue<Integer> st = new Queue<Integer>();

		int choice = s.nextInt();
		int input;

		while (choice !=-1) {
			if(choice == 1) {
				input = s.nextInt();
				st.enqueue(input);
			}
			else if(choice == 2) {
				try {
					System.out.println(st.dequeue());
				} catch (QueueEmptyException e) {
					System.out.println(-1);
				}
			}
			else if(choice == 3) {
				try {
					System.out.println(st.front());
				} catch (QueueEmptyException e) {
					System.out.println(-1);
				}
			}
			else if(choice == 4) {
				System.out.println(st.size());
			}
			else if(choice == 5) {
				System.out.println(st.isEmpty());
			}
			choice = s.nextInt();
		}
	}
}
