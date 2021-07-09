package fixtures;

public class Room extends Fixture{
	private Room[] exit = new Room[5];

	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
	}
	
	private Fixture[] things;
	
	public Room getExits(String direction) {
		int i = 0;
		switch (direction) {
		case "NORTH":
			i=0;
			break;
		case "SOUTH":
			i=1;
			break;
		case "EAST":
			i=2;
			break;
		case "WEST":
			i=3;
			break;
		default:
			System.out.println("Not a valid direction");
			i=4;
		}
		return exit[i];
	}
	public void setExits(Room[] exit) {
		this.exit = exit;
	}
	public void setExits(Room exit, int index) {
		this.exit[index]=exit;
	}
	public void setThings(Fixture... things) {
		this.things=things;
	}
	public Fixture[] getThings() {
		return things;
	}
	public Fixture getThing(int i) {
		return things[i];
	}
}
