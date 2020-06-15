
public class Solution {
	
	 // public static int count = 0;
    public static int a,b,c = 0;
     public static int staircase(int n){

         if (n == 0 || n==1){
             return 1;
         }
         if (n==2){
             return 2;
         }
         if (n==3){
             return 4;
         }
        return staircase(n-1)+staircase(n-2)+staircase(n-3);

	}
	
}

//MAIN

import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(Solution.staircase(n));
	}
}
