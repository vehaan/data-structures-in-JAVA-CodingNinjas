public class solution {

	public static void mergeSort(int[] input){
		// Write your code here
        
        if (input.length < 2) {
        return;
    }
    int mid = input.length / 2;
    int[] l = new int[mid];
    int[] r = new int[input.length - mid];
 
    for (int i = 0; i < mid; i++) {
        l[i] = input[i];
    }
    for (int i = mid; i < input.length; i++) {
        r[i - mid] = input[i];
    }
    mergeSort(l);
    mergeSort(r);
 
    merge(input, l, r, mid, input.length - mid);
        
		
	}
    
    public static void merge(
  int[] input, int[] l, int[] r, int left, int right) {
  
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
        if (l[i] <= r[j]) {
            input[k++] = l[i++];
        }
        else {
            input[k++] = r[j++];
        }
    }
    while (i < left) {
        input[k++] = l[i++];
    }
    while (j < right) {
        input[k++] = r[j++];
    }
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
	
	public static void printArray(int input[]) {
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		solution.mergeSort(input);
		printArray(input);
	}
}
