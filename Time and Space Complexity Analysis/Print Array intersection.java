public class Intersection{
	
	public static void intersection(int[] arr1, int[] arr2){
        mergeSort(arr1);
        mergeSort(arr2);
        int i=0;
        int j=0;
        
        while (i<arr1.length && j<arr2.length){
            if (arr1[i] == arr2[j]){
                System.out.println(arr1[i]);
                i++;
                j++;
            }
            else if(arr1[i]<arr2[j]){
                i++;
            }
            else if(arr1[i]>arr2[j]){
                j++;
            }
        }
    }
    
    	public static void mergeSort(int[] input){
        
        if (input.length < 2) {
        return;
    }
    int mid = input.length / 2;
    int[] l = new int[mid];
    int[] r = new int[input.length - mid];
 
    for (int i = 0; i < mid; i++) {
        l[i] = input[i];
    }
    for (int i = mid; i < input.length; i++) {
        r[i - mid] = input[i];
    }
    mergeSort(l);
    mergeSort(r);
 
    merge(input, l, r, mid, input.length - mid);
        
		
	}
    
    public static void merge(
  int[] input, int[] l, int[] r, int left, int right) {
  
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
        if (l[i] <= r[j]) {
            input[k++] = l[i++];
        }
        else {
            input[k++] = r[j++];
        }
    }
    while (i < left) {
        input[k++] = l[i++];
    }
    while (j < right) {
        input[k++] = r[j++];
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