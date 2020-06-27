/*public class Solution {

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
	
	/*public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		// Write your code here
		if (root == null){
            return 0;
        }
        
        return maxheight(root);
        
        
	}
    
    private static boolean isBST(BinaryTreeNode<Integer> root,int min,int max){
        if (root == null){
            return true;
        }
        if (root.data < min || root.data > max){
            return false;
        }
        
        return (isBST(root.left,min,root.data-1) && isBST(root.right,root.data+1,max));
    }
    
    private static int maxheight(BinaryTreeNode<Integer> root){
        if (root == null){
            return 0;
        }
        int lHeight = 0;
        int rHeight = 0;
        if (isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE)){
            lHeight = maxheight(root.left);
            rHeight = maxheight(root.left);
        }
        return 1 + Math.max(lHeight,rHeight);
    }
}*/
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
	
    public static bstSubtreeReturn  largestBSTSubtreeHelper(BinaryTreeNode<Integer> root) 
{
   if(root == null)
   {
       bstSubtreeReturn ans = new bstSubtreeReturn();
       ans.max = Integer.MIN_VALUE;
       ans.min = Integer.MAX_VALUE;
       ans.isBST = true;
       ans.height = 0;
       return ans;
   }
    bstSubtreeReturn left = largestBSTSubtreeHelper(root.left);
    bstSubtreeReturn right = largestBSTSubtreeHelper(root.right);
    if(!(right.isBST && right.min > root.data))
    {
        right.isBST = false;
    }
    if(!(left.isBST && left.max < root.data))
    {
        left.isBST = false;
    }
    bstSubtreeReturn ans = new bstSubtreeReturn();
    if(!left.isBST || !right.isBST || root.data < left.max || root.data > right.min)
    {
        if(left.height > right.height)
        {
            left.isBST = false;
            return left;
        }
        else{
            right.isBST = false;
            return right;
        }
    }
    ans.isBST = true;
    ans.min = Math.min(left.min, Math.min(right.min, root.data));
    ans.max = Math.max(left.max, Math.max(right.max, root.data));
    ans.height = Math.max(left.height, right.height) + 1;
    return ans;
}
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		// Write your code here
		return largestBSTSubtreeHelper(root).height;
	}
}

class bstSubtreeReturn
    {
        int max;
        int min;
        int height;
        boolean isBST;
    }

//MAIN

#include <iostream>
#include <queue>

template <typename T>
class BinaryTreeNode {
    public : 
    T data;
    BinaryTreeNode<T> *left;
    BinaryTreeNode<T> *right;

    BinaryTreeNode(T data) {
        this -> data = data;
        left = NULL;
        right = NULL;
    }
    ~BinaryTreeNode() {
    	if(left) 
       		delete left;
    	if(right) 
       		delete right;
    }
};

using namespace std;
#include "solution.h"

BinaryTreeNode<int>* takeInput() {
    int rootData;
    //cout << "Enter root data : ";
    cin >> rootData;
    if(rootData == -1) {
        return NULL;
    }
    BinaryTreeNode<int> *root = new BinaryTreeNode<int>(rootData);
    queue<BinaryTreeNode<int>*> q;
    q.push(root);
    while(!q.empty()) {
        BinaryTreeNode<int> *currentNode = q.front();
	q.pop();
        int leftChild, rightChild;
        //cout << "Enter left child of " << currentNode -> data << " : ";
        cin >> leftChild;
        if(leftChild != -1) {
            BinaryTreeNode<int>* leftNode = new BinaryTreeNode<int>(leftChild);
            currentNode -> left =leftNode;
            q.push(leftNode);
        }
        //cout << "Enter right child of " << currentNode -> data << " : ";
        cin >> rightChild;
        if(rightChild != -1) {
            BinaryTreeNode<int>* rightNode = new BinaryTreeNode<int>(rightChild);
            currentNode -> right =rightNode;
            q.push(rightNode);
        }
    }
    return root;
}

int main() {
    BinaryTreeNode<int>* root = takeInput();
    cout << largestBSTSubtree(root);
    delete root;
}
