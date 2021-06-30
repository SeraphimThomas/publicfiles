package day4labs;

public class OverloadMethods {
	public static void main(String[] args) {
		OverloadMethods om = new OverloadMethods();
		om.print();
		
		om.print("second print method");
		om.print("second", "third");
	}
	
	public void print() {
		System.out.println("original print method");
	}
	
	public void print (String str) {
		System.out.println(str);
	}
	
	public void print(String str, String str2) {
		System.out.println(str + " " + str2);
	}
	
}
