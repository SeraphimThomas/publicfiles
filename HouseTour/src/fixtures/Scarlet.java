package fixtures;

public class Scarlet extends Fixture implements Interactable{
	// Allow petting of the pup
	public Scarlet(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);
	}
	public void interact(Fixture[] canIPetThePup, Room room) {
				if ( canIPetThePup != null) {
					for (int i = 0; i<canIPetThePup.length; i++) {
						if (canIPetThePup[i] instanceof Scarlet)
							System.out.println(room.getThing(i).getName()); //Gets name and desc of item.
							System.out.println(room.getThing(i).getLongDesc());
					}
				} else {
					System.out.println("The pupper aint here and she doesn't want to leave her blankets.");
		}
	}
}
