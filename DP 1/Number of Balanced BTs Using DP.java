public class Solution {
    static final int MOD = 1000000007;

	public static int balancedTreesOfHeightH(int height){
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
         long[] dp = new long[height + 1]; 
          
        // base cases 
        dp[0] = 1; 
        dp[1] = 1; 
          
        for(int i = 2; i <= height; ++i)  
            dp[i] = (dp[i - 1] * ((2 * dp [i - 2])% MOD + dp[i - 1]) % MOD) % MOD; 
              
            return (int)dp[height]; 

	}
}


//MAIN

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int height = s.nextInt();
		System.out.println(Solution.balancedTreesOfHeightH(height));
	}
}