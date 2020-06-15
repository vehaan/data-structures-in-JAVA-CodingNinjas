public class solution {
	public static void printSubsets(int input[]) {
		// Write your code here
        // int[] temp = new int[input.length];
        printSubsequences(input,0,"");

	}
    
    static void printSubsequences(int arr[], int index, String str) {
        if (index >= arr.length) {
            System.out.println(str);
            return;
        }
        printSubsequences(arr, index + 1, str + arr[index]+" ");
        printSubsequences(arr, index + 1, str);
    }

}

//MAIN

import java.util.Scanner;

public class runner {
	
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		solution.printSubsets(input);
	}
}
