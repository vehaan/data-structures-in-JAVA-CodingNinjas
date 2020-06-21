public class Solution {

	public static int[] stockSpan(int[] price) {
		// Write your code here
        int n = price.length;
        int result[] = new int[n];
        for (int i= n-1;i>=0;i--){
            int count = 1;
            for (int j = i-1;j>=0;j--){
                if (price[j] < price[i]){
                    count++;
                }else{
                    break;
                }
            }
            result [i] = count;
        }
		return result;
	}
}

//MAIN

import java.util.Scanner;

public class Main {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++) {
			input[i] = s.nextInt();
		}
		int output[] = Solution.stockSpan(input);
		for(int i = 0; i < size; i++) {
			System.out.print(output[i] + " ");
		}
	}
}