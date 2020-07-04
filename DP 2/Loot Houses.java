
public class Solution {
	public static int getMaxMoney(int arr[], int n){

		/*Your class should be named Solution.
		*Don't write main().
	 	*Don't take input, it is passed as function argument.
	 	*Don't print output.
	 	*Taking input and printing output is handled automatically.
		*/
        
        // return money(arr,n,0);
        if (n==1){
            return arr[0];
        }
        int dp[] = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for (int i=2;i<n;i++){
            dp[i] = Math.max(arr[i] + dp[i-2],dp[i-1]);
        }
        return dp[n-1];

	}
    
//     public static int money(int[] arr,int n,int i){
//         if (i >= n){
//             return 0;
//         }
//         //Choose
//         int op1 = arr[i] + money(arr,n,i+2);
//         int op2 = money(arr,n,i+1);
        
//         return Math.max(op1,op2);
//     }
}

//THE COMMENTED CODE IS RECURSIVE SOLUTION

//MAIN

import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = s.nextInt();
		}
		System.out.println(Solution.getMaxMoney(arr, n));
	}
}
