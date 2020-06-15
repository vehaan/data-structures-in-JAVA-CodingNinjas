public class solution {

	// element - number to be searched
	public static int binarySearch(int input[], int element) {
		// Write your code here
        return binarysearch(input,0,input.length-1,element);
    }
     public static int binarysearch(int arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            // If the element is present at the middle itself 
            if (arr[mid] == x) 
                return mid; 
  
            // If element is smaller than mid, then it can only 
            // be present in left subarray 
            if (arr[mid] > x) 
                return binarysearch(arr, l, mid - 1, x); 
  
            // Else the element can only be present in right 
            // subarray 
            return binarysearch(arr, mid + 1, r, x); 
        } 
  
        // We reach here when element is not present in array 
        return -1; 
    } 
  
}

//MAIN

import java.util.Scanner;

public class runner {
	static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int element = s.nextInt();
		System.out.println(solution.binarySearch(input, element));
	}
}
