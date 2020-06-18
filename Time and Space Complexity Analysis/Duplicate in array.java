public class DuplicateInArray{	

	public static int duplicate(int[] arr){  
        int sum = (((arr.length-2)*(arr.length-1))/2);
        int newSum = 0;
        for(int i=0;i<arr.length;i++)
        {
            newSum+=arr[i];
        }
        return newSum-sum;

	}
}

//MAIN

import java.util.Scanner;

public class Main {
	
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
		int[] arr = takeInput();
		System.out.print(DuplicateInArray.duplicate(arr));
	}
}