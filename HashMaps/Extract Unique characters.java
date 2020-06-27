import java.util.HashMap;
public class solution {

	public static String uniqueChar(String str){
		// Write your code here
        String result = "";
        HashMap<Character,Boolean> map = new HashMap<>();
        for (int i=0;i<str.length();i++){
            if (map.containsKey(str.charAt(i))){
                continue;
            }
            map.put(str.charAt(i),true);
        }
        for (int i=0;i<str.length();i++){
            if (map.containsKey(str.charAt(i))){
                result += str.charAt(i);
                map.remove(str.charAt(i));
            }
        }
        return result;
	}
}

//MAIN

import java.util.Scanner;

public class runner {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String uniChars = solution.uniqueChar(s.next());
		System.out.println(uniChars);
	}
}
