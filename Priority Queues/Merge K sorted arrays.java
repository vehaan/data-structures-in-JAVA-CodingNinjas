import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0;i<input.size();i++){
            for (int j=0;j<input.get(i).size();j++){
                pq.add(input.get(i).get(j));
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        while(!pq.isEmpty()){
            output.add(pq.remove());
        }
        return output;
	}

}

//MAIN

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		while(k > 0) {
			int n = s.nextInt();
			ArrayList<Integer> current = new ArrayList<Integer>();
			for(int i = 0; i < n; i++) {
				current.add(s.nextInt());
			}
			input.add(current);
			k--;
		}
		ArrayList<Integer> output = Solution.mergeKSortedArrays(input);
		for(int i : output) {
			System.out.print(i + " ");
		}
	}
}