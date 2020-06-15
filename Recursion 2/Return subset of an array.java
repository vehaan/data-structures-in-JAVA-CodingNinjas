public class solution {

	// Return a 2D array that contains all the subsets
	public static int[][] subsets(int input[]) {
    return subsets(input,0);
   }
   public static int[][] subsets(int input[], int StartIndex) {

    if(StartIndex==input.length)
    {
    return new int[1][0];
    }

    int SmallAns1[][]=subsets(input,StartIndex+1);
    int SmallAns2[][]=subsets(input,StartIndex+1);

    int ans[][]=new int[SmallAns1.length*2][];
    int l=0;
    for(int i=0;i<SmallAns1.length;i++)
    {
        ans[l]=new int[SmallAns1[i].length + 1];
        ans[l][0] = input[StartIndex];
        for(int j=1;j<=SmallAns1[i].length;j++)
        {
            ans[l][j]=SmallAns1[i][j - 1];
        }
        l++;
    }

    for(int i=0;i<SmallAns2.length;i++)
    {
        ans[l]=new int[SmallAns2[i].length];
        for(int j=0;j<SmallAns2[i].length;j++)
        {
            ans[l][j]=SmallAns2[i][j];
        }
        l++;
    }        

    return ans;
    }
}

//MAIN

import java.util.Scanner;

public class runner {
	
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
		int[] input = takeInput();
		int output[][] = solution.subsets(input);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}
}
