package day5labs;

public class Constructors {
	
	public Constructors() {
		System.out.println("Default constructor ran.");
	}
	
	public Constructors(int value) {
		System.out.println(value);
	}
	public static void main(String[] args) {
		//create instance here
		Constructors c = new Constructors(5839);
		
		//use no-arg construct
		Constructors cNoArg = new Constructors();
		
	}
}
