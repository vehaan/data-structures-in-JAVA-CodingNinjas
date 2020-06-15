public class solution {

	// Return a string array that contains all the possible strings
	public static String[] keypad(int n){
		// Write your code here
        // if (n==0){
        //     String a[] = {""};
        //     return 
        // }
        if (n/10==0){
            String ans[] = helper(n);
            return ans;
        }
        String smallAns[] = keypad(n/10); 
        String help[] = helper(n%10);
        String ans[] = new String[smallAns.length*help.length];
        int k=0;
        for (int i=0;i<help.length;i++){
            for (int j =0;j<smallAns.length;j++){
                ans[k] = smallAns[j]+help[i];
                k++;
            }
        }
        return ans;
	}
    
    public static String[] helper(int n){
        if (n==2){
            String a[] =  {"a","b","c"};
            return a;
        }
        if (n==3){
            String a[] = {"d","e","f"};
            return a;
        }
        if (n==4){
            String a[] = {"g","h","i"};
            return a;
        }
        if (n==5){
            String a[] = {"j","k","l"};
            return a;
        }
        if (n==6){
            String a[] = {"m","n","o"};
            return a;
        }
        if (n==7){
            String a[] = {"p","q","r","s"};
            return a;
        }
        if (n==8){
            String a[] = {"t","u","v"};
            return a;
        }
        if (n==9){
            String a[] = {"w","x","y","z"};
            return a;
        }
        String a[] = {""};
        return a;
       
    }
	
}

//MAIN

import java.util.Scanner;

public class runner {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		String output[] = solution.keypad(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}
}
