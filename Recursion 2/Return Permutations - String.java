public class solution {
    public static String[] permutationOfString(String input){
        if(input.length() == 0){
            String output[] = {""}; 
            return output; 
        } 
        String[] smallerOutput = permutationOfString(input.substring(1)); 
        String output[] = new String[input.length()*smallerOutput.length];
        int k =0;
        for(int i = 0; i < smallerOutput.length; i++){
            String currentString = smallerOutput[i];
            for(int j = 0; j <= currentString.length(); j++){
                output[k] = currentString.substring(0, j) + input.charAt(0) + currentString.substring(j);
                k++; 
            } 
        } 
        return output; 
    }
}

//MAIN

import java.util.Scanner;

public class runner {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		String output[] = solution.permutationOfString(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}
}
