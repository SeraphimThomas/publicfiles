package day4;

public class WhileLoops {
	public static void main(String[] args) {
		System.out.println("Start of Application");
		int x =0;
		while (x<10) {
			System.out.println(x);
			x++;
		}
		System.out.println("Outside of While Loop: " + x);
		
		x=0;
		
		do {
			System.out.println(x);
			x++;
		} while (x<10);
		
		// do while will execute at least once and then repeat if true
	}
}
