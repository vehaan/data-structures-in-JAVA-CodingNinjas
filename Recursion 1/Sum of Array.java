public class Solution {
	
	public static boolean checkNumber(int input[], int x) {
        boolean res;
		int smallerInput[] = new int[input.length-1];
        for(int i=1;i<input.length;i++){
            smallerInput[i-1] = input[i];
        }
        if (input[0] == x){
            return true;
        }else if(input.length == 1){
            return false;
        }
        else{
             res = checkNumber(smallerInput,x);
        }
        return res;
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
		int x = s.nextInt();
		System.out.println(Solution.checkNumber(input, x));
	}
}
