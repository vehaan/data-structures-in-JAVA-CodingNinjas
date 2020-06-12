/******************
 * Following is the main function we are using internally.
 * Refer this for completing the ComplexNumbers class
 * 
 
 public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int real1 = s.nextInt();
		int imaginary1 = s.nextInt();

		int real2 = s.nextInt();
		int imaginary2 = s.nextInt();

		ComplexNumbers c1 = new ComplexNumbers(real1, imaginary1);
		ComplexNumbers c2 = new ComplexNumbers(real2, imaginary2);

		int choice = s.nextInt();
		 
		if(choice == 1) {
			// Add
			c1.plus(c2);
			c1.print();
		}
		else if(choice == 2) {
			// Multiply
			c1.multiply(c2);
			c1.print();
		}
		else {
			return;
		}
	}
 ******************/

public class ComplexNumbers {
    private int real;
	private int imaginary;
    
    public ComplexNumbers(int real, int imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}
    
    public void multiply(ComplexNumbers c2) {
        int temp = this.real;
		this.real = (this.real*c2.real)-(this.imaginary*c2.imaginary);
		this.imaginary = (temp*c2.imaginary)+(this.imaginary*c2.real);
	}
    
    public void plus(ComplexNumbers c) {
		this.real = this.real+c.real;
		this.imaginary = this.imaginary+c.imaginary;
	}
    
    public void print() {
		if (imaginary<0) {
			System.out.println(real+" - i"+(-imaginary));
		}
		else {
			System.out.println(real+" + i"+imaginary);
		}
	}	
}

//MAIN

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int real1 = s.nextInt();
		int imaginary1 = s.nextInt();

		int real2 = s.nextInt();
		int imaginary2 = s.nextInt();

		ComplexNumbers c1 = new ComplexNumbers(real1, imaginary1);
		ComplexNumbers c2 = new ComplexNumbers(real2, imaginary2);

		int choice = s.nextInt();

		 
		if(choice == 1) {
			// Add
			c1.plus(c2);
			c1.print();
		}
		else if(choice == 2) {
			// Multiply
			c1.multiply(c2);
			c1.print();
		}
		else {
			return;
		}
	}
}

