public class solution {
    static String[] allLetters = new String[] {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };


	public static void printKeypad(int input){
		// Write your code here
        String inp = Integer.toString(input);
        convertSubstring(inp,"");
		
	}
    public static void convertSubstring(String phoneNumber, String convertedLetters)
{                   
  int digit = Integer.parseInt(phoneNumber.substring(0, 1));
  String letters=allLetters[digit];
  String remainingString=phoneNumber.substring(1);

  for (int i = 0; i < letters.length(); ++i) 
  {
     char letter = letters.charAt(i);
     String result=convertedLetters+letter;
     if (remainingString.length()==0)
        System.out.println(result);
     else
        convertSubstring(remainingString, result);
  }
}
}

//MAIN

import java.util.Scanner;

public class runner {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		solution.printKeypad(input);
	}
}
