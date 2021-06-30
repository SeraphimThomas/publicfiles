package day4;

public class DogSimulator {
	public static void main(String[] args) {
		/* new objects need to have class then name
		 * and then have it equal the new Object (with params)
		 */
		Dog fido = new Dog();
		fido.name = "Fido";
		fido.age = 3;
		fido.bark();
		
		Dog scooby = new Dog();
		scooby.name= "Scooby Doo";
		scooby.age= 7;
		
		System.out.println(fido.name);
		System.out.println(scooby.name);
	}
}
