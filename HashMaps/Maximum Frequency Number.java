import java.util.*;
import java.util.Map.Entry;
public class Solution {

	public static int maxFrequencyNumber(int[] arr){
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            if (map.containsKey(arr[i])){
                int freq = map.get(arr[i]);
                freq++;
                map.put(arr[i],freq);
                continue;
            }
            map.put(arr[i],1);
        }
        
        int val = -1;
        int max = 0;
        for(int i = 0; i < arr.length ; i++)
        {
            if(map.get(arr[i]) > max)
               {
                   max = map.get(arr[i]) ;
                   val = arr[i] ;
               }
            
        }
               
               return val;
	}
}

//MAIN

import java.util.Scanner;

public class Runner {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int sze = s.nextInt();
		int[] arr = new int[sze];
		for(int index = 0;index<sze;index++){
			arr[index]=s.nextInt();
		}
		System.out.println(Solution.maxFrequencyNumber(arr));
	}
}