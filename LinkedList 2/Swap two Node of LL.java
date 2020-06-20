


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
public class Solution {
	public static  LinkedListNode<Integer> swap_nodes(LinkedListNode<Integer> head,int i,int j){
		LinkedListNode<Integer> left = head;
        LinkedListNode<Integer> right = head;
        LinkedListNode<Integer> tempL;
        LinkedListNode<Integer> tempR;
        LinkedListNode<Integer> temp;
        LinkedListNode<Integer> size = head;
        int swap;
        int k = 0;
        
        while (size != null){
            size = size.next;
            k++;
        }
        if (i >= k || j>=k){
            return null;
        }

        if (i == j){
            return null;
        }
        if (i>j){
            swap = i;
            i = j;
            j = swap;
        }
        
        if (i==0){
            for (int x=1;x<j;x++){
                right = right.next;
            }
            tempR = right.next;
            right.next = left;
        	temp = left.next;
            left.next = tempR.next;
            tempR.next = temp;
            return tempR;
        }
        
        for (int x=1;x<i;x++){
            left = left.next;
            right = right.next;
        }
        tempL = left.next;
        
        for (int y=0;y<j-i;y++){
            right = right.next;
        }
        tempR = right.next;
        
        left.next = tempR;
        right.next = tempL;
        temp = tempR.next;
        tempR.next = tempL.next;
        tempL.next = temp;
        
        
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
public class Runner {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		print(Solution.swap_nodes(input(), s.nextInt(), s.nextInt()));
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
			System.out.print(head.getData() + " ");
			head = head.next;
		}
	}

}
