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


	public static void printNodesSumToS(BinaryTreeNode<Integer> node, int tar) {
		// Write your code here
                // LeftList which stores the left side values 
        ArrayList<BinaryTreeNode<Integer>> LeftList = new ArrayList<>(); 
  
        // RightList which stores the right side values 
        ArrayList<BinaryTreeNode<Integer>> RightList = new ArrayList<>(); 
  
        // curr_left pointer is used for left side execution and 
        // curr_right pointer is used for right side execution 
        BinaryTreeNode<Integer> curr_left = node; 
        BinaryTreeNode<Integer> curr_right = node; 
  
        while (curr_left != null || curr_right != null
               || LeftList.size() > 0 && RightList.size() > 0) { 
  
            // Storing the left side values into LeftList 
            // till leaf node not found 
            while (curr_left != null) { 
                LeftList.add(curr_left); 
                curr_left = curr_left.left; 
            } 
  
            // Storing the right side values into RightList 
            // till leaf node not found 
            while (curr_right != null) { 
                RightList.add(curr_right); 
                curr_right = curr_right.right; 
            } 
  
            // Last node of LeftList 
            BinaryTreeNode<Integer> LeftNode = LeftList.get(LeftList.size() - 1); 
  
            // Last node of RightList 
            BinaryTreeNode<Integer> RightNode = RightList.get(RightList.size() - 1); 
  
            int leftVal = LeftNode.data; 
            int rightVal = RightNode.data; 
  
            // To prevent repetition like 2, 6 and 6, 2 
            if (leftVal >= rightVal) 
                break; 
  
            // Delete the last value of LeftList and make 
            // the execution to the right side 
            if (leftVal + rightVal < tar) { 
                LeftList.remove(LeftList.size() - 1); 
                curr_left = LeftNode.right; 
            } 
  
            // Delete the last value of RightList and make 
            // the execution to the left side 
            else if (leftVal + rightVal > tar) { 
                RightList.remove(RightList.size() - 1); 
                curr_right = RightNode.left; 
            } 
  
            // (left value + right value) = target 
            // then print the left value and right value 
            // Delete the last value of left and right list 
            // and make the left execution to right side 
            // and right side execution to left side 
            else { 
                System.out.println(LeftNode.data + " " + RightNode.data); 
  
                RightList.remove(RightList.size() - 1); 
                LeftList.remove(LeftList.size() - 1); 
                curr_left = LeftNode.right; 
                curr_right = RightNode.left; 
            } 
        } 

	}
}

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

		Solution.printNodesSumToS(root, sum);
	}
}
