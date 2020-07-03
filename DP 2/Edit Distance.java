
public class Solution {
	public static int editDistance(String s, String t){		
		//Your class should be named Solution
		//* Don't write main().
		//* Don't read input, it is passed as function argument.
		//* Return output and don't print it.
		

		//write your code here
        
        if (s.length()==0) {
			return t.length();
		}
		if (t.length()==0) {
			return s.length();
		}
		if (s.charAt(0) == t.charAt(0)) {
			return editDistance(s.substring(1),t.substring(1));
		}else {
			//insert
			int op1 = editDistance(s,t.substring(1));
			//delete
			int op2 = editDistance(s.substring(1),t);
			//substitute
			int op3 = editDistance(s.substring(1),t.substring(1));
			return 1 + Math.min(op1, Math.min(op2, op3));
        }
	}
}

//MAIN

import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
	
		String str1 = s.next();
		String str2 = s.next();
		System.out.println(Solution.editDistance(str1, str2));
	}
}