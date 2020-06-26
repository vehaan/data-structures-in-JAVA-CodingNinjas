/***************
 * BinaryTreeNode class already given - 
 * 
class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
}
***************/

/**************
 * Main function that we are using internally 
 * 
public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int choice, input;
		while(true) {
			choice = s.nextInt();
			switch(choice) {
				case 1 : 
					input = s.nextInt();
					bst.insertData(input);
					break;
				case 2 : 
					input = s.nextInt();
					bst.deleteData(input);
					break;
				case 3 : 
					input = s.nextInt();
					System.out.println(bst.search(input));
					break;
				default :
					bst.printTree();
					return;
			}

		}
*******************/

public class BinarySearchTree {
	// Complete this class
	static BinaryTreeNode<Integer> root;
    
    public static BinaryTreeNode<Integer> insertData(int data){
       root = insertHelper(root,data);
        return root;
    }
    
    private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root,int data){
        if (root == null) {
    		BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(data);
    		return newNode;
    	}
    	
    	if (data < root.data) {
    		root.left = insertHelper(root.left,data);
    	}else {
    		root.right = insertHelper(root.right,data);
    	}
    	return root;
    }
    
    public static boolean search(int data){
        return searchHelper(root,data);
    }
    
    private static boolean searchHelper(BinaryTreeNode<Integer> root,int data){
        if (root == null){
            return false;
        }
        if (root.data == data){
            return true;
        }
        if (data<root.data){
            return searchHelper(root.left,data);
        }else{
            return searchHelper(root.right,data);
        }
    }
    
    public static void deleteData(int data){
        deleteHelper(root,data);
    }
    
    private static BinaryTreeNode<Integer> deleteHelper(BinaryTreeNode<Integer> root,int data){
        if (root == null){
            return null;
        }
        
        if (data < root.data){
            root.left = deleteHelper(root.left,data);
            return root;
        }else if (data > root.data){
            root.right = deleteHelper(root.right,data);
            return root;
        }else{
            
            if (root.left == null && root.right == null){
                return null;
            }
            if (root.left == null){
                return root.right;
            }
            if (root.right == null){
                //go to the min of root.right and make it's value as root's value and delete that node
                return root.left;
            }else{
                BinaryTreeNode<Integer> minNode = root.right;
        		while (minNode.left != null) {
        			minNode = minNode.left;
        		}
        		root.data = minNode.data;
        		root.right = deleteHelper(root.right,minNode.data);
        		return root;
            }
        
        }
    }
    
    public static void printTree(){
        printTreeHelper(root);
    }
    
    private static void printTreeHelper(BinaryTreeNode<Integer> root){
               if (root == null){
            return;
        }
        
        String str = root.data+":";
        if (root.left != null){
            str += "L:"+root.left.data+",";
        }
        if (root.right != null){
            str += "R:"+root.right.data;
        }
        System.out.println(str);
        printTreeHelper(root.left);
        printTreeHelper(root.right);
    }
}

//MAIN

import java.util.Scanner;


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

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		int choice, input;
		while(true) {
			choice = s.nextInt();
			switch(choice) {
				case 1 : 
					input = s.nextInt();
					bst.insertData(input);
					break;
				case 2 : 
					input = s.nextInt();
					bst.deleteData(input);
					break;
				case 3 : 
					input = s.nextInt();
					System.out.println(bst.search(input));
					break;
				default :
					bst.printTree();
					return;
			}

		}
	}
}
