package fixtures;

public class Toilet extends Fixture implements Interactable{
	public Toilet(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);
	}
	public void interact(Fixture[] toilet, Room room) {
		if (toilet != null) {
			for (int i = 0; i<toilet.length; i++) {
				if (toilet[i] instanceof Toilet)
					System.out.println(room.getThing(i).getName()); //Gets name and desc of item.
					System.out.println(room.getThing(i).getShortDesc());
					System.out.println(room.getThing(i).getLongDesc()); //working idea for parsing multiple items
			}
		}else {
			System.out.println("You're not in a bathroom, ya know.");
		}
	}
}