package day4labs;

public class MethodDeclaration {
	public static void main(String[] args) {
		MethodDeclaration md = new MethodDeclaration();
		
		md.talk();
		md.talk();
		md.talk();
	}
	public void talk() {
		System.out.println("Inside the talk Method");
	}
}
