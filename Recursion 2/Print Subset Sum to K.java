import java.util.*; 

public class solution {
	public static void printSubsetsSumTok(int input[], int k) {
		// Write your code here
        Vector<Integer> v= new Vector<Integer>();  
    printAllSubsetsRec(input, input.length, v, k);  
		// printAllSubsetsRec(input,)
	}
    
     // The vector v stores current subset.  
static void printAllSubsetsRec(int arr[], int n, Vector<Integer> v,  
                        int sum)  
{  
    // If remaining sum is 0, then print all  
    // elements of current subset.  
    if (sum == 0) {  
        for (int i=v.size()-1;i>=0;i--)  
            System.out.print( v.get(i) + " ");  
        System.out.println(); 
        return;  
    }  
  
    // If no remaining elements,  
    if (n == 0)  
        return;  
    
    printAllSubsetsRec(arr, n - 1, v, sum);  
    Vector<Integer> v1=new Vector<Integer>(v); 
    v1.add(arr[n - 1]);  
    printAllSubsetsRec(arr, n - 1, v1, sum - arr[n - 1]);  
    }  
}

//MAIN

import java.util.Scanner;

public class runner {
	static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int k = s.nextInt();
		solution.printSubsetsSumTok(input, k);
	}
}
