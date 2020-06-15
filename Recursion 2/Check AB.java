public class Solution {

	public static boolean checkAB(String input) {
		// Write your code here
        if (input.length() == 0){
            return true;
        }
        if (input.charAt(0) == 'a'){
            if (input.substring(1).length() > 1 && input.charAt(1) == 'b' && input.charAt(2) == 'b'){
                return checkAB(input.substring(3));
            }
            else{
             return checkAB(input.substring(1));   
            }
            
        }
        return false;

	}
}

//MAIN

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		System.out.println(Solution.checkAB(input));
	}

}