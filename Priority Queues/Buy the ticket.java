import java.util.*;
public class Solution {
	
	public static int buyTicket(int input[], int k) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
        int timer = 0;
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0;i<input.length;i++){
            queue.add(i);
            pq.add(input[i]);
        }
        int i=0;
        while (!queue.isEmpty()){
            if (input[queue.peek()] < pq.peek()){
                queue.add(queue.poll());
            }else{
                int temp = queue.poll();
                pq.remove();
                timer++;
                if (temp == k){
                    return timer;
                }
            }
        }
        return timer;

	}
}

//MAIN

import java.util.Scanner;

public class Runner {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		int k = s.nextInt();
		System.out.println(Solution.buyTicket(input, k));
	}

}