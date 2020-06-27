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
	
	public static void nodesAtDistanceKDown(BinaryTreeNode<Integer> root, int k) {
        if(root == null) {
            return; 
        } 
        if(k == 0) {
            System.out.println(root.data);
            return; 
        } 
        nodesAtDistanceKDown(root.left, k - 1);
        nodesAtDistanceKDown(root.right, k - 1); 
    } 
    
    public static int nodesAtDistanceKHelper(BinaryTreeNode<Integer> node, int target, int k) { 
        if (node == null) return -1;
        if (node.data == target) {
            nodesAtDistanceKDown(node, k);
            return 0; 
        } 
        int leftD = nodesAtDistanceKHelper(node.left, target, k);
        if (leftD != -1) {
            if (leftD + 1 == k) {
                System.out.println(node.data); 
            } else nodesAtDistanceKDown(node.right, k - leftD - 2);
            return 1 + leftD; 
        } 
        int rightD = nodesAtDistanceKHelper(node.right, target, k); 
        if (rightD != -1) {
            if (rightD + 1 == k) { 
                System.out.println(node.data); 
            } else nodesAtDistanceKDown(node.left, k - rightD - 2); 
            return 1 + rightD; 
        } return -1; 
    } 
    
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        nodesAtDistanceKHelper(root, node, k); 
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
	static int target;
	static int k;
	public static BinaryTreeNode<Integer> takeInput(){
		Queue<BinaryTreeNode<Integer>>  pendingNodes = new Queue<BinaryTreeNode<Integer>>(); // we can skip writing again inside <> after java version 1.7
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
		target = s.nextInt();
		k = s.nextInt();
		return root;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();

		Solution.nodesAtDistanceK(root, target, k);
	}
}