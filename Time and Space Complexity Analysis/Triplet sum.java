import java.util.Arrays;

public class TripletSum {	

	public static void FindTriplet(int[] arr, int sum){

        // Arrays.sort(arr);
        
// for (int i = 0; i <= arr.length - 3; i++)
// 		{
// 			int k = sum - arr[i];
// 			int low = i + 1, high = arr.length - 1;

// 			while (low < high)
// 			{
// 				if (arr[low] + arr[high] < k) {
// 					low++;
// 				}
// 				else if (arr[low] + arr[high] > k) {
// 					high--;
// 				}
// 				else {
// 					System.out.println(arr[i] + " " + arr[low] + " " + arr[high]);
// 					low++;
// 					high--;
// 				}
// 			}
// 		}
        
        Arrays.sort(arr);
        int n = arr.length;
        
		// // first we need to sort the array
		// for(int round = 1; round < n; round++) {
		// 	for(int i = 0; i < n - 1; i++) {
		// 		if(arr[i] > arr[i+1]) {
		// 			int temp = arr[i];
		// 			arr[i] = arr[i+1];
		// 			arr[i+1] = temp;
		// 		}
		// 	}
		// }
      
      	// now we need to find and print the triplets
		for (int i = 0; i < n - 2; i++) { 
			for (int j = i + 1; j < n - 1; j++) { 
				for (int k = j + 1; k < n; k++) { 
					if (arr[i] + arr[j] + arr[k] == sum) { 
						System.out.println(arr[i] + " " + arr[j] + " " + arr[k]); 
					} 
				} 
			} 
		}
	
	}
}

//MAIN

import java.util.Scanner;

public class Main {
	
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
		int[] arr = takeInput();
		int num = s.nextInt();
		TripletSum.FindTriplet(arr, num);
	}
}