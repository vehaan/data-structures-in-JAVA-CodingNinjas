
public class solution {
    static int count = 0;
	public static int countZerosRec(int input){
		// Write your code here
        if(input%10 == 0){
            count++;
        }
        if (input/10 == 0){
            return 0;
        }
            countZerosRec(input/10);
        
        return count;
	}
}

//MAIN

import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(solution.countZerosRec(n));
	}
}
