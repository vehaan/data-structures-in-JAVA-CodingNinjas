public class ArrayRotate {	

	public static void rotate(int[] arr, int d) {
	
         d = d%arr.length;
            
        
        int temp[] = new int[d];
        for (int i=0;i<d;i++){
            
            temp[i] = arr[i];
        }
        for (int i=d;i<arr.length;i++){
            arr[i-d] = arr[i];
        }
        for (int i=arr.length-d;i<arr.length;i++){
            arr[i] = temp[i-(arr.length-d)];
        }
        

	}
}

//MAIN

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }
        
        String[] strNums; 
        strNums = br.readLine().split("\\s");
        

        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {

            int[] input = takeInput();
            int d = Integer.parseInt(br.readLine().trim());
            Solution.rotate(input, d);
            printArray(input);

            t -= 1;
        }
    }
}