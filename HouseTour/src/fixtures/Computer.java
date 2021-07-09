package fixtures;

public class Computer extends Fixture implements Interactable{
	public Computer(String name, String shortDesc, String longDesc) {
		super(name, shortDesc, longDesc);
	}
	public void interact(Fixture[] turnOnComp, Room room) {
		if (turnOnComp != null) {
			for (int i = 0; i<turnOnComp.length; i++) {
				if (turnOnComp[i] instanceof Computer)
					System.out.println(room.getThing(i).getName()); //Gets name and desc of item.
					System.out.println(room.getThing(i).getLongDesc()); //working idea for parsing multiple items
			}
		}else {
			System.out.println("Trying to turn on what?");
		}
	}
}
