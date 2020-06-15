public class Solution {

	public static String removeConsecutiveDuplicates(String s) {
		// Write your code here
        if (s.length() <=1){
            return s;
        }
        
        if (s.charAt(0) == s.charAt(1)){
            return removeConsecutiveDuplicates(s.charAt(0) + removeConsecutiveDuplicates(s.substring(2,s.length())));
        }
        
        return (s.charAt(0) + removeConsecutiveDuplicates(s.substring(1,s.length())));

	}

}

/MAIN

import java.util.Scanner;

public class Main {
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
    	String input = s.next();
    	System.out.println(Solution.removeConsecutiveDuplicates(input));
    }
}