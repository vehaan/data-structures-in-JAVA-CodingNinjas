public class Solution {

	public static int power(int x, int n) {
        if (n==0){
            return 1;
        }
        int res = power(x,n-1);
        return x*res;
		
	}
}

//MAIN

import java.util.Scanner;

public class Runner {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int x = s.nextInt();
		int n = s.nextInt();
		
		System.out.println(Solution.power(x, n));
	}
}
