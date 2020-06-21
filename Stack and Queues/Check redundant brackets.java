import java.util.Stack;

public class solution {
	
	public static boolean checkRedundantBrackets(String input) {
		// Write your code here
        for (int i=0;i<input.length()-1;i++){
            if ((input.charAt(i) == '('  && input.charAt(i) == input.charAt(i+1)) || input.charAt(i) == '('  && input.charAt(i+1) == ')'){
                return true;
                // break;
            }
        }
        return false;

	}
}

//MAIN

import java.util.Scanner;

public class Main {
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		String input = s.nextLine();
		System.out.println(solution.checkRedundantBrackets(input));
	}
}