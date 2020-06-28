// import java.util.ArrayList;
import java.util.*;

public class Solution {

	public static ArrayList<Integer> kLargest(int input[], int k) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
        ArrayList<Integer> output = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<input.length;i++){
            pq.add(input[i]);
        }
        for (int i=0;i<k;i++){
            output.add(pq.remove());
        }
        
		return output;
	}
}

//MAIN

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int j = 0; j < n; j++) {
			input[j] = s.nextInt();
		}
		int k = s.nextInt();
		ArrayList<Integer> output = Solution.kLargest(input, k);
		for(int i : output) {
			System.out.println(i);
		}
		
	}
}