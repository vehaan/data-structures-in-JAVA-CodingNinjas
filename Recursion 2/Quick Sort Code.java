
public class Solution {
	public static int count = 0;
	public static void quickSort(int[] array) {
	
         recursiveQuickSort(array, 0, array.length - 1);

	}
    
    public static void recursiveQuickSort(int[] array, int startIdx, int endIdx) { 
        int idx = partition(array, startIdx, endIdx); // Recursively call quicksort with left part of the partitioned array 
        if (startIdx < idx - 1) { 
            recursiveQuickSort(array, startIdx, idx - 1); 
        } // Recursively call quick sort with right part of the partitioned array
        
        if (endIdx > idx) {
            recursiveQuickSort(array, idx, endIdx); 
        }
    }
    
    public static int partition(int[] array, int left, int right) { 
        int pivot = array[left]; // taking first element as pivot 
        while (left <= right) { //searching number which is greater than pivot, bottom up 
            while (array[left] < pivot) {
                left++; 
            } //searching number which is less than pivot, top down 
            while (array[right] > pivot) { 
                right--; 
            } // swap the values 
            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp; //increment left index and decrement right index 
                left++; 
                right--; 
            } 
        } 
        return left;
    }
}

//MAIN

import java.util.Scanner;

public class Runner {
	
	static Scanner s = new Scanner(System.in);
	
	public static int[] takeInput(){
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++){
			input[i] = s.nextInt();
		}
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		Solution.quickSort(input);
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
}