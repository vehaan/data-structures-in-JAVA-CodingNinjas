
public class Solution {

	public static int lis(int arr[]) {
		
		/*Your class should be named Solution. 
		*Don't write main().
	 	*Don't take input, it is passed as function argument.
	 	*Don't print output.
	 	*Taking input and printing output is handled automatically.
		*/
        int n = arr.length;
         int lis[] = new int[n]; 
          int i,j,max = 0; 
  
          /* Initialize LIS values for all indexes */
           for ( i = 0; i < n; i++ ) 
              lis[i] = 1; 
  
           /* Compute optimized LIS values in  
              bottom up manner */
           for ( i = 1; i < n; i++ ) 
              for ( j = 0; j < i; j++ )  
                         if ( arr[i] > arr[j] &&  
                                  lis[i] < lis[j] + 1) 
                    lis[i] = lis[j] + 1; 
  
           /* Pick maximum of all LIS values */
           for ( i = 0; i < n; i++ ) 
              if ( max < lis[i] ) 
                 max = lis[i]; 
  
            return max; 
        
	}	
}

//MAIN

import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = s.nextInt();
		}
		System.out.println(Solution.lis(arr));

	}
}
