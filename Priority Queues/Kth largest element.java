import java.util.*;
public class Solution {

	public static int kthLargest(int arr[], int k) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		 */
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        for (int i=0;i<k-1;i++){
            pq.remove();
        }
        return pq.remove();
	}
}

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
		int k = s.nextInt();
		System.out.println(Solution.kthLargest(arr, k));
	}

}
