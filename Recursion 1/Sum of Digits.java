
public class solution {
    static int sum = 0;
	public static int sumOfDigits(int input){
		// Write your code here
        if (input/10 == 0 && input%1<10){
            return input;
        }
        
        return input%10+sumOfDigits(input/10);
        // return sum;

	}
}

//MAIN

import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(solution.sumOfDigits(n));
	}
}
