public class Solution {

	
	public static int countWaysToMakeChange(int denominations[], int value){

		
int n = denominations.length;
        int way[][] = new int [n][value+1];
        for(int i = 0; i<n ; i++){
            way[i][0]=1;
        }
        for(int i = n-1;i>=0;i--){
            for(int j = 1 ;j<=value;j++){
                int count1 = 0;
                if(i+1 <= n-1){
                    count1 = way[i+1][j];
                }
                int count2 = 0;
                if(j-denominations[i]>=0){
                    count2 = way[i][j-denominations[i]];
                }
                way[i][j] = count1+count2;
            }
        }
	return way[0][value];
        }
	
}

//MAIN

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int numDenominations = s.nextInt();
		int denominations[] = new int[numDenominations];
		for(int i = 0; i < numDenominations; i++){
			denominations[i] = s.nextInt();
		}
		
		int value = s.nextInt();
		
		System.out.println(Solution.countWaysToMakeChange(denominations, value));
		
	}

}
