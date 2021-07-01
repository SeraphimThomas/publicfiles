package day5labs;

public class Test {
	
	public static void main(String[] args) {
		A.staticCount=2494;
		System.out.println("Class A staticCount: " + A.staticCount);
		
		A a =new A();
	
		System.out.println(a.instanceCount);
		System.out.println(A.staticCount);
	
		A a2 =new A();
	
		System.out.println(a2.instanceCount);
		System.out.println(A.staticCount);
	
		a.instanceCount = 15;
	
		System.out.println("Object a instatnceCount: " + a.instanceCount);
		System.out.println("Object a2 instatnceCount: " + a2.instanceCount);
		System.out.println("Class A StaticCount: " + A.staticCount);
	
	}
}
