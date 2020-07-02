


public class Solution {
	
	public static int countStepsTo1(int n){
		
	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
	 * Taking input and printing output is handled automatically.
	 */
        int storage [] = new int [n + 1]; 
		storage [1] = 0; 
		for (int i = 2; i <= n; i ++) { 
			int min = storage [i - 1]; 
			if (i% 3 == 0) { 
				if (min> storage [i / 3]) { 
					min = storage [i / 3]; 
				} 
			} 
			if (i% 2 == 0) { 
				if (min> storage [i / 2]) { 
					min = storage [i / 2]; 
				} 
			} 
			storage [i] = 1 + min; 
		} 
		return storage [n]; 
	
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
