
class Node<T> {
	T data;
	Node<T> next;

	public Node(T data) {
		this.data = data;
	}
}

class Stack<T> {
    
    private Node<T> head;
    private int size;
	
	public Stack() {
        head = null;
        size = 0;

	}
	
	public int size() {
        return size;

	}
	
	public void push(T data) {
        Node<T> temp = new Node<>(data);
        temp.next = head;
        head = temp;
        size++;

	}
	
	public boolean isEmpty() {
        return size == 0 ? true:false;

	}
	
	public T pop() throws StackEmptyException {
        if (size == 0){
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        Node<T> temp = head;
        head = head.next;
        size--;
        return temp.data;
        

	}
	
	public T peek() throws StackEmptyException {
        if (size == 0){
            StackEmptyException e = new StackEmptyException();
            throw e;
        }
        return head.data;

	}
}

class StackEmptyException extends Exception{
    
}

public class Solution {

	public static boolean checkBalanced(String exp) {
		// Write your code here
        Stack<Character> stack = new Stack<>();
        try{
        for (int i=0;i<exp.length();i++){
            if (exp.charAt(i) == '[' || exp.charAt(i) == '{' || exp.charAt(i) == '('){
                stack.push(exp.charAt(i));
            }
            
            if ((exp.charAt(i) == ']' && stack.peek() == '[') || (exp.charAt(i) == '}' && stack.peek() == '{') || (exp.charAt(i) == ')' && stack.peek() == '(')){
                stack.pop();
            }
        
        }
        }catch(StackEmptyException e){
            return false;
        }
        return stack.isEmpty();
	}
}

//MAIN

import java.util.Scanner;

public class Main {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		String input = s.nextLine();
		System.out.println(Solution.checkBalanced(input));
	}
}