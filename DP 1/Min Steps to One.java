


public class Solution {
	
	public static int countStepsTo1(int n){
		
	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
	 * Taking input and printing output is handled automatically.
	 */
        if (n == 1) { 
			return 0; 
		} 
		int op1 = countStepsTo1 (n - 1); 
		int minSteps = op1; 
		if (n% 3 == 0) { 
			int op2 = countStepsTo1 (n / 3); 
			if (op2 <minSteps) { 
				minSteps = op2; 
			} 
		} 
		if (n% 2 == 0) { 
			int op3 = countStepsTo1 (n / 2); 
			if (op3 <minSteps) { 
				minSteps = op3; 
			} 
		} 
		return 1 + minSteps; 
	
	}
	
}

//MAIN

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(Solution.countStepsTo1(n));
	}

}
