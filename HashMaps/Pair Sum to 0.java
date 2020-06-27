import java.util.*;

public class Solution {
	public static void PairSum(int[] input, int size) {
		
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Print the desired output and don't return anything.
	 	 * Taking input is handled automatically.
		 */
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<input.length;i++){
            
            	if (map.containsKey(-input[i])){
                for (int j=0;j<map.get(-input[i]);j++){
                    System.out.println((input[i] < 0 ? input[i] : -input[i]) + " " + (input[i] > 0 ? input[i] : -input[i]));
                }
            }
            
            if (map.containsKey(input[i])){
                int temp = map.get(input[i]);
                temp++;
                map.put(input[i],temp);
                continue;
            }
            
else{
                map.put(input[i],1);
            }
            
            
        }
	}
}

//MAIN

import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n = s.nextInt();
		int arr[]=new int[n];
		for(int i=0; i<n; i++)
		{
			arr[i]=s.nextInt();
		}		
		Solution.PairSum(arr, n);
	}
}