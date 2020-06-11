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
