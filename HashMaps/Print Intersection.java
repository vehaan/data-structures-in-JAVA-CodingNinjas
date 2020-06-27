import java.util.*;
public class Intersection{
	
	public static void intersection(int[] arr1, int[] arr2){
		/* Your class should be named Intersection
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Print output and don't return it.
	 	 * Taking input is handled automatically.
  		 */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<arr1.length;i++){
            if (map.containsKey(arr1[i])){
                int temp = map.get(arr1[i]);
                temp++;
                map.put(arr1[i],temp);
                continue;
            }
            map.put(arr1[i],1);
        }
        for (int i=0;i<arr2.length;i++){
            if (map.containsKey(arr2[i])){
                System.out.println(arr2[i]);
                if (map.get(arr2[i]) == 1){
                    map.remove(arr2[i]);
                }else{
                    int temp = map.get(arr2[i]);
                    temp--;
                    map.put(arr2[i],temp);
                }
            }
        }

	}
}

//MAIN

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static void print(ArrayList<Integer> list) {
		for (int i : list) {
			System.out.print(i+" ");
		}
	}
	
	public static void main(String[] args) {
		int[] arr1 = takeInput();
		int[] arr2 = takeInput();
		Intersection.intersection(arr1, arr2);
	}
}