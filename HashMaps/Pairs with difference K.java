import java.util.HashMap;
public class Solution {

    public static void findPairsDifferenceK(int[] input, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<input.length;i++){
            if(map.containsKey(input[i])){
                int temp = map.get(input[i]);
                temp++;
                map.put(input[i],temp);
                continue;
            }
            map.put(input[i],1);
        }
        if(k==0)
        {
            for(int i:map.keySet())
            {
                int n=map.get(i);
                int p=(n*(n-1))/2;
                for(int j=0;j<p;j++)
                {
                    System.out.println(i+" "+i);
                }
            }
        }
        else
            for (int i : map.keySet()){
                if(map.containsKey(i-k) && map.get(i-k)>0)
                {
                    for(int j=0;j<map.get(i-k)*map.get(i);j++)
                    {
                        System.out.println(Math.min(i-k,i)+" "+Math.max(i-k,i));
                    }
                    map.put(i-k,0);
                }
            }
    }
}

//MAIN

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		int k = s.nextInt();
		Solution.findPairsDifferenceK(input, k);
	}
}
