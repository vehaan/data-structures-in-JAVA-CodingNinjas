
public class solution {

	// Return the changed string
	public static String removeX(String input){
		// Write your code here
        if (input.length() == 0){
            return input;
        }
        
        if (input.length()>=1  && input.charAt(0) == 'x'){
            return removeX(input.substring(1,input.length()));
        }
        
        return input.charAt(0)+removeX(input.substring(1,input.length()));

	}
}

//MAIN

import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(solution.removeX(input));
	}
}
