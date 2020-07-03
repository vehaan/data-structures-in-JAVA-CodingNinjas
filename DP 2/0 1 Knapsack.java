public class Solution {
	
	public static int knapsack(int[] weight,int value[],int maxWeight, int n){
		/* Your class should be named Solution.
		* Don't write main() function.
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/	
        return knapSack(weight,value,maxWeight,0);
	}
    
    private static int knapSack(int[] weights, int[] values, int maxWeight, int i) {
		if (i == weights.length || maxWeight == 0) {
			return 0;
		}
		
		if (weights[i] > maxWeight) {
			return knapSack(weights,values,maxWeight,i+1);
		}else {
			//include this ith item
			int op1 = values[i]  + knapSack(weights, values, maxWeight - weights[i], i+1);
			//not include
			int op2 = knapSack(weights, values, maxWeight,i+1);
			return Math.max(op1, op2);
		}
		
	}
}

//MAIN

import java.util.Scanner;
public class runner {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int weight[] = new int[n];
		for(int i = 0 ; i < n; i++){
			weight[i] = s.nextInt();
		}
		int value[] = new int[n];
		for(int i = 0 ; i < n; i++){
			value[i] = s.nextInt();
		}
		int maxWeight = s.nextInt();
		System.out.println(Solution.knapsack(weight, value, maxWeight, n));		
	}
}