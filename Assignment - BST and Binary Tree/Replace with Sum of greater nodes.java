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
	
	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		// Write your code here
                Sum S = new Sum(); 
        modifyBSTUtil(root, S); 
		
	}
    
       // Recursive function to add all greater values in 
    // every node 
   static void modifyBSTUtil(BinaryTreeNode<Integer> node, Sum S) 
    { 
        // Base Case 
        if (node == null) 
            return; 
              
        // Recur for right subtree     
        modifyBSTUtil(node.right, S);  
          
        // Now *sum has sum of nodes in right subtree, add 
        // root->data to sum and update root->data 
        S.sum = S.sum + node.data; 
        node.data = S.sum; 
          
        // Recur for left subtree 
        modifyBSTUtil(node.left, S);  
    } 
  
    // A wrapper over modifyBSTUtil() 
    // void modifyBST(Node node) 
    // { 
    //     Sum S = new Sum(); 
    //     this.modifyBSTUtil(node, S); 
    // } 
}

  class Sum { 
        int sum = 0; 
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

public class Main {
	static Scanner s = new Scanner(System.in);

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
		return root;
	}
	
	public static void printLevelWiseAtDiffLevel(BinaryTreeNode<Integer> root){
		Queue<BinaryTreeNode<Integer>> primary = new Queue<BinaryTreeNode<Integer>>();
		Queue<BinaryTreeNode<Integer>> secondary = new Queue<BinaryTreeNode<Integer>>();

		primary.enqueue(root);

		while(!primary.isEmpty()){
			BinaryTreeNode<Integer> current=null;
			try {
				current = primary.dequeue();
			} catch (QueueEmptyException e) {
				System.out.println("Not possible");
			}
			System.out.print(current.data + " ");
			if(current.left != null){
				secondary.enqueue(current.left);
			}
			if(current.right != null){
				secondary.enqueue(current.right);
			}
			if(primary.isEmpty()){
				Queue<BinaryTreeNode<Integer>>  temp = secondary;
				secondary = primary;
				primary = temp;
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		Solution.replaceWithLargerNodesSum(root);
		printLevelWiseAtDiffLevel(root);
	}
}
