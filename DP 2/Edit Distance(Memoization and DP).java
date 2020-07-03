
public class Solution {

	
	public static int editDistance(String s, String t){
		
	/* Your class should be named Solution
	 * Don't write main().
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
	*/
		// int m = s.length();
		// int n = t.length();
		// int storage[][] = new int[m+1][n+1];
		// for (int i=0;i<=m;i++) {
		// 	for (int j=0;j<=n;j++) {
		// 		storage[i][j] = -1;
		// 	}
		// }
		// return editDistanceM(s,t,storage);
        
        int m = s.length();
		int n = t.length();
		int storage[][] = new int[m+1][n+1];
		
		for (int j=0;j<=n;j++) {
			storage[0][j] = j;
		}
		
		for (int i=0;i<=m;i++) {
			storage[i][0] = i;
		}
		for (int i=1;i<=m;i++) {
			for (int j=1;j<=n;j++) {
				if (s.charAt(m-i) == t.charAt(n-j)) {
					storage[i][j] = storage[i-1][j-1];
				}else {
					storage[i][j] = 1 + Math.min(storage[i][j-1],Math.min(storage[i-1][j], storage[i-1][j-1]));
				}
				
			}
		}
		return storage[m][n];

	}
    
//     	private static int editDistanceM(String s,String t,int[][] storage) {
// 		int m = s.length();
// 		int n = t.length();
// 		if (storage[m][n] != -1) {
// 			return storage[m][n];
// 		}
// 		if (m == 0) {
// 			storage[m][n] = n;
// 			return storage[m][n];
// 		}
// 		if (n == 0) {
// 			storage[m][n] = m;
// 			return storage[m][n];
// 		}
		
// 		if (s.charAt(0) == t.charAt(0)) {
// 			storage[m][n] = editDistanceM(s.substring(1),t.substring(1),storage);
// 		}else {
// 			//insert
// 			int op1 = editDistanceM(s,t.substring(1),storage);
// 			//delete
// 			int op2 = editDistanceM(s.substring(1),t,storage);
// 			//substitute
// 			int op3 = editDistanceM(s.substring(1),t.substring(1),storage);
// 			storage[m][n] = 1 + Math.min(op1, Math.min(op2, op3));
// 		}
// 		return storage[m][n];
// 	}

	
}

//THE REMAINING COMMENTED CODE IS MEMOIZATION

//MAIN

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
	
		String str1 = s.nextLine();
		String str2 = s.nextLine();
		System.out.println(Solution.editDistance(str1, str2));
		
	}

}
