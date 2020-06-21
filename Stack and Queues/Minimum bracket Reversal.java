import java.util.Stack;

public class Solution {

	
	// Function returns -1 if brackets can't be balanced
	public static int countBracketReversals(String input){
		
		// Write your code here
        if (input.length() %2 != 0){
            return -1;
        }
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<input.length();i++){
            
            if (input.charAt(i) == '}' && stack.isEmpty()){
                stack.push(input.charAt(i));
            }
            if (input.charAt(i) == '{'){
                stack.push(input.charAt(i));
        	}
            
            if (input.charAt(i) == '}' && stack.peek() == '{'){
                stack.pop();
            }
        }
        
        int count = 0;
        while (!stack.isEmpty()){
            char c1 = stack.pop();
            char c2 = stack.pop();
            if (c1 == '{' && c2 == '}'){
                count+= 2;
            }else{
                count++;
            }
        }
        return count;
        

	}
	
	

}

//MAIN


import java.util.Scanner;



public class Main {

	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {

		String str = s.nextLine();
		System.out.println(Solution.countBracketReversals(str));

	}

}
