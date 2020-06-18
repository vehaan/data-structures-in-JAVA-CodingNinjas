public class FindUnique{	

	public static int findUnique(int[] arr){
		/* Your class should be named FindUnique
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		 */
        int count = 0;
        return unique(arr,0,count);

	}
    
    public static int unique(int[] arr,int si, int count){
        for (int i = 0;i<arr.length;i++){
            if (arr[si] == arr[i]){
                count++;
            }
        }
        
        if (count == 1){
            return arr[si];
        }

        return unique(arr,si+1,0);
    }
}

//MAIN

import java.util.Scanner;

public class Main {
	
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = takeInput();
		System.out.print(FindUnique.findUnique(arr));
	}
}