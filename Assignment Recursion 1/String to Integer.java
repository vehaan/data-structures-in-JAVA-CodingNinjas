
public class solution {

	public static int convertStringToInt(String input){
		// Write your code here
        int n = (int)Math.pow(10,input.length()-1);
        if (input.length() == 0){
            return 0;
        }
        
        if (input.length() == 1){
            return input.charAt(0) - '0';
        }
        
        return (input.charAt(0)-'0')*n+convertStringToInt(input.substring(1,input.length()));
        
        

	}
}

//MAIN

import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(solution.convertStringToInt(input));
	}
}
