import java.util.*;

/*
	- You are given an integer array containing positive and negative numbers.
	- Your task is to find out the length of the longest continuous subset of this array whose elements add upto zero.

*/

public class solution 
{
    public static int lengthOfLongestSubsetWithZeroSum(ArrayList<Integer> arr) 
   	{
		//	write your code here.
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;
        int maxLen = 0;
        
        if (arr.get(0) == 0){
            return 1;
        }
        for (int i=0;i<arr.size();i++){
            sum += arr.get(i);
            if (map.containsKey(sum)){
                len = i - map.get(sum);
                continue;
            }
            map.put(sum,i);
            if (len > maxLen){
                maxLen = len;
            }
        }

		return maxLen;
	}
}

//MAIN

import java.util.*;

public class runner 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();

		int size = scan.nextInt();
		for(int i = 0; i < size; i++)
			arr.add(scan.nextInt());

		System.out.println(solution.lengthOfLongestSubsetWithZeroSum(arr));
		scan.close();
	}
}

//5 1 2 -2 4 -4