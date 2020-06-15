
public class Solution {

	public static String replaceCharacter(String input, char c1, char c2) {
        if (input.length() == 0 ){
            return input;
        }
        
        if (input.charAt(0) == c1){
            return c2+replaceCharacter(input.substring(1,input.length()),c1,c2);
        }
        
        return input.charAt(0) + replaceCharacter(input.substring(1,input.length()),c1,c2);

	}
}

//MAIN

import java.util.Scanner;

public class Runner {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		char c1 = s.next().charAt(0);
		char c2 = s.next().charAt(0);
		System.out.println(Solution.replaceCharacter(input, c1, c2));
	}
}
