
import java.util.*;
public class Solution {

    /*	Binary Tree Node class
 * 
 * class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
	*/

    public static void nodesSumToS(BinaryTreeNode<Integer> root, int sum) {
        // Write your code here
        nodeSum(root,sum,root);
        // int n = numNodes(root);
        // int arr[] = new int[n];
        // nodeSum(root,sum,arr,0);
        // Arrays.sort(arr);
        // System.out.println(arr[0]);
        // int i=0,j=arr.length-1;
        // while (j>i){
        //     if (arr[i] + arr[j] == sum){
        //         System.out.println(arr[i] +" "+arr[j]);
        //     }
        //     if (arr[i] + arr[j] < sum){
        //         i++;
        //         continue;
        //     }
        //     if (arr[i] + arr[j] > sum){
        //         j--;
        //     }
        // }
    }

    // public static void nodeSum(BinaryTreeNode<Integer> root,int sum, int[] arr,int i){
    //     if (root == null){
    //         return;
    //     }
    //     arr[i] = root.data;
    //     nodeSum(root.left,sum,arr,i+1);
    //     nodeSum(root.right,sum,arr,i+1);
    // }

    //     public static int numNodes(BinaryTreeNode<Integer> root){
    //         		int count = 0;
    // 		if (root != null) {
    // 			count++;
    // 		count += numNodes(root.left);
    // 		count += numNodes(root.right);
    // 		}

    // 		return count;
    //     }
    public static void nodeSum(BinaryTreeNode<Integer> current,int sum,BinaryTreeNode<Integer> root){
        if (current == null){
            return;
        }
        if(root == null){
            return ;
        }
        if(current.data != Integer.MIN_VALUE){
            if (find (root,sum - current.data)){
                System.out.println(((current.data < sum - current.data)? current.data : sum - current.data) +" "+
                                   ((current.data > sum - current.data)? current.data : sum - current.data))  ;
                 
                current.data = Integer.MIN_VALUE;		//Strike off the traversed node not the node which is not traversed yet 
            }
            nodeSum(current.left,sum,root);
            nodeSum(current.right,sum,root);
        }

    }

    private static boolean find(BinaryTreeNode<Integer> root,int k){
        if (root == null){
            return false;
        }
        if (root.data == k){
            // root.data = Integer.MIN_VALUE;
            return true;
        }

        boolean l = find (root.left,k);
        boolean r = find (root.right,k);

        if (l || r){
            return true;
        }else
        	return false;
    }
}

//THE SECOND METHOD IS COMMENTED. TRY TO RUN IT LATER

//MAIN

import java.util.Scanner;

class QueueEmptyException extends Exception {
}

class Queue<T> {

	class Node<T> {
		T data;
		Node<T> next;
		Node(T data){
			this.data = data;
		}
	}

	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public T front() throws QueueEmptyException{
		if(size == 0){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}

		return head.data;
	}


	public void enqueue(T element){
		Node<T> newNode = new Node<T>(element);

		if(head == null){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = newNode;
			tail = newNode;
		}

		size++;
	}

	public T dequeue() throws QueueEmptyException{
		if(head == null){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		if(head == tail){
			tail = null;
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
}

class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}

public class Runner {
	static Scanner s = new Scanner(System.in);
 static int sum ;
	public static BinaryTreeNode<Integer> takeInput(){
		Queue<BinaryTreeNode<Integer>>  pendingNodes = new Queue<BinaryTreeNode<Integer>>(); // we can skip writing again inside <> after java version 1.7
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = s.nextInt();
			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = s.nextInt();
			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
    sum = s.nextInt();
		return root;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();

		Solution.nodesSumToS(root, sum);
	}
}
