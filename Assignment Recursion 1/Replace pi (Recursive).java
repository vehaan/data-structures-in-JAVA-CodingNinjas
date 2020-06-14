public class solution {

	// Return the changed string
	public static String replace(String input){
		// Write your code here
        if (input.length() <= 1){
            return input;
        }
        
        if (input.charAt(0) == 'p' && input.length()>=2 && input.charAt(1) == 'i'){
            return "3.14"+replace(input.substring(2,input.length()));
        }
        
        return input.charAt(0)+replace(input.substring(1,input.length()));

	}
}

//MAIN

import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(solution.replace(input));
	}
}
