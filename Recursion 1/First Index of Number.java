
public class Solution {
    static int count = 0;
    static int finals = -2;
	public static int lastIndex(int input[], int x) {
        if (input[0]==x){
            finals = count;
        }
        if (input.length == 1){
            if(input[0] == x){
                finals =count;
            }else{
                return -1;
            }
        }
        int newInput[] = new int[input.length-1];
        for (int i=1;i<input.length;i++){
            newInput[i-1] = input[i];
        }
        count++;
        lastIndex(newInput,x);
        if (finals == -2){
            return -1;
        }else{
            return finals;
        }
	}
	
}

//MAIN

import java.util.Scanner;

public class Runner {
	
	static Scanner s = new Scanner(System.in);
	
	public static int[] takeInput(){
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++){
			input[i] = s.nextInt();
		}
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int x = s.nextInt();
		System.out.println(Solution.lastIndex(input, x));
	}
}