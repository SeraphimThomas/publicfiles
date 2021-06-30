package day4;

public class MethodSimulator {
	public static void main(String[] args) {
		printStuff();
		int value = combine(15,5);
		System.out.println(value);
		System.out.println(combine(20,5));
		
	}
	
	public static void printStuff() {
		System.out.println("This printed from the printStuff method");
	}
	
	public static int combine(int a, int b) {
		int sum = a+b;
		return sum;
	}
}
