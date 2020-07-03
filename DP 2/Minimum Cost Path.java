public class Solution {
    
	public static int minCostPath(int input[][]) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/

        return minCost(input,0,0);
	}
    
    public static int minCost(int input[][], int i, int j){
        int m = input.length;
        int n = input[0].length;
        if (i==m-1 && j==n-1){
            return input[i][j];
        }
        
        if (i>= m || j>=n){
            return Integer.MAX_VALUE;
        }
        int op1 = minCost(input,i+1,j);
        int op2 = minCost(input,i,j+1);
        int op3 = minCost(input,i+1,j+1);
        
        return input[i][j] +  Math.min(op1,Math.min(op2,op3));
    }
}

//MAIN

import java.util.Scanner;
public class Runner {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int m = s.nextInt();
		int n = s.nextInt();
		int input[][] = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				input[i][j] = s.nextInt();
			}
		}
		System.out.println(Solution.minCostPath(input));
	}
}