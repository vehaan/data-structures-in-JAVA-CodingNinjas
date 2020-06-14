
public class solution {

	public static void towerOfHanoi(int disks , char source, char auxiliary, char destination) {
       
        if (disks==0){
            return;
        }
        if (disks == 1) {
           System.out.println(source + " " + destination);
       } else {
           towerOfHanoi(disks - 1, source, destination, auxiliary);
           System.out.println(source + " " + destination);
           towerOfHanoi(disks - 1, auxiliary, source, destination);
       }
}
}

//MAIN

import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		solution.towerOfHanoi(n, 'a', 'b', 'c');
	}
}
