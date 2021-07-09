package game;

import fixtures.Computer;
import fixtures.Room;
import fixtures.Scarlet;
import fixtures.Toilet;

public class RoomManager {
	private Room startingRoom;
	private Room[] rooms;
	public RoomManager(int numberRooms) {
		super();
		rooms = new Room[numberRooms];
	}
	public void init() {
		Room entrance = new Room(
				"Entrance",
				"The main entrance",
				"The short foyer is the main entrance to the house." +
			 	"The exit is to the south, with the living room opening to the east.\nThat's blocked by several moving boxes, however." +
				"  North of you is the entrance to the den.");
		this.rooms[0] = entrance;
		startingRoom = entrance;
	Room den = new Room(
			"Den",
			"The big room",
			"The main den is quite large.  There's a couch and two chairs in front of you.  It connects " + "\n"+
			"to the kitchen to the east.  A rather lazy dachshund is sleeping on the couch, quite content under " + "\n" +
			"mass of blankets she has, with at least 2 stick chews treats on the floor.\n"+
			"The TV between the furniture is off and dones't seem to work.  There's also a door to the west leading " +"\n" +
			"to a hallway further into the house.");
		this.rooms[1] = den;
	Room kitchen = new Room("Kitchen", 
			"The kitchen and dining area", 
			"The kitchen is directly connected with the den, to the west.\n"+
			"There's a table at one side, with chairs on one side and some bench seats under the window on the other side.\n"+
			"The kitchen is quite nice, with black granite counter tops, an electric stove top, and a large silver fridge.\n"+
			"The sliding door to your east leads to the small laundry room, while the other door to your south leads to the living room, but it's blocked.");
		this.rooms[2] = kitchen;
		Room mainHall = new Room("Main Hall", 
			"The main hall of the house", "The main hall is brightly lit, with white walls"+
			" and several pictures along the walls.\nIt turns at 90 degrees to the right, leading to the master bedroom to the north.\n" +
			" There is a guest room to the south, and the den is back to the east.  There is also a bathroom to the west.");
		this.rooms[3] = mainHall;
		Room masterBed = new Room("Master Bedroom", 
			"The main bedroom of the house", "The master bedroom has a large king bed on one wall.  There's a " +
			"window seat on the opposite side, along with a TV on a dresser.  The master bathroom is ahead, but it's blocked by several\n" +
			"boxes, packed with stuff.  The main hall is to your south.");
		this.rooms[4] = masterBed;
		Room hallBath = new Room("Hall Bathroom", 
			"The hall bathroom", 
			"The hall bathroom is a short hall-like room leading to the west.\n" +
			" There's a sink on a nice counter top, and a good sized bath and a toilet.  The main hall opens to the east.");
		this.rooms[5] = hallBath;
		Room laundry = new Room("Laundry Room", "The laundry room", "The laundry room is a closed little area with one door leading"+
			" outside and the washing and drying machines before you.\nThere's a small closet opposite them, with linens and dog treats."
			+ "  You distinctly hear the jingle of the dog's collar from the den as you enter.\nIt's probably better to not give her any" +
			" treats.  She had a little pile of them near her.  The kitchen entrance is to the west.");
		this.rooms[6] = laundry;
		Room guestRoom = new Room("The Guest Bedroom", 
			"The guest bedroom", "The guest bedroom has a single double bed, steel gray walls\n" +
			" and a small desk with a laptop next to the window.  Clothes and books are scattered around, leaving much to be desired about\n" +
			" the cleanliness person currently living in this room.  The main hall opens up behind you to the north.");
		Room masterBath = new Room("The Master Bathroom",
			"The master bathroom", "The master bathroom has a long hall that connects to the room with the toilet and shower in the north.\n"+
			"One long counter has 2 sinks opposite that door, with two smaller counters on each small wing.\n"
			+"A handmade towel rack, almost resembling a ladder, rests next to the door.  The master bedroom is to the south.");
		this.rooms[7] = masterBath;
		Room masterBathToilet = new Room("The Toilet Closet of the Master Bathroom", "The Master Toilet",
				"This is just the room for the toilet and the shower.  The shower has been redone recently, having a nice stone surface.\n"+
				"There is even a little seat in the corner.  The first part of the masterbath is to the south.");
		this.rooms[8] = masterBathToilet;
	// Order of exits is North, South, East, West
	Room[] entranceExits = {den, null, null, null,entrance}; //Last one is reference to same room to remedy null retrun error
		entrance.setExits(entranceExits);
	Room[] denExits = {null, entrance, kitchen, mainHall,den};
		den.setExits(denExits);
	Room[] kitchenExits = {null, null,laundry, den, kitchen};
		kitchen.setExits(kitchenExits);
	Room[] mainHallExits = {masterBed, guestRoom, den, hallBath, mainHall};
		mainHall.setExits(mainHallExits);
	Room[] masterBedExits = {masterBath, mainHall, null, null, masterBed};
		masterBed.setExits(masterBedExits);
	Room[] hallBathExits = {null, null, mainHall, null, hallBath};
		hallBath.setExits(hallBathExits);
	Room[] laundryExits = {null, null, null, kitchen, laundry};
		laundry.setExits(laundryExits);
	Room[] guestRoomExits = {mainHall, null, null, null, guestRoom};
		guestRoom.setExits(guestRoomExits);
	Room[] masterBathExits = {masterBathToilet, masterBed, null, null, masterBath};
		masterBath.setExits(masterBathExits);
	Room[] masterBathToiletExits = {null, masterBath, null, null, masterBathToilet};
		masterBathToilet.setExits(masterBathToiletExits);
	//Create objects
	Scarlet pupper = new Scarlet("Lazy Dachshund", "An old, but sweet dachshund", "You gently pet the dachshund in the blankets.  She groans"+
	" rolling onto her side a bit to let your rub her belly as well.  Her tail thumps in \nappreciation.  As you pull your hand back, she truns to"+
	" re-adjust herself in her blanket pile.");
	Computer laptop = new Computer("A nice laptop", "A relatively nice gaming laptop", "You open up the laptop and it powers on.  It definetly seems"+
	" like the person who uses this likes their classic video games.  You take the moment\nto close it again before you move back.");
	Toilet toilet = new Toilet("Really?","You're really doing this?", "You flush the toilet.  Okay....I guess every game needs working toilets.");
	//set objects to specific rooms
	den.setThings(pupper);
	guestRoom.setThings(laptop);
	masterBathToilet.setThings(toilet);
	hallBath.setThings(toilet);
	}
	public Room getStartingRoom() {
		return startingRoom;
	}
	public Room[] getRooms() {
		return this.rooms;
	}
	public void setRooms(Room[] rooms) {
		this.rooms=rooms;
	}
	public void printRoom(Player player) {
		System.out.println("CURRENT ROOM");
		System.out.println(player.getCurrentRoom().getName());
		System.out.println(player.getCurrentRoom().getShortDesc());
		System.out.println(player.getCurrentRoom().getLongDesc());
	}
	public void printShort(Player player) {
		System.out.println("CURRENT ROOM");
		System.out.println(player.getCurrentRoom().getName());
		System.out.println(player.getCurrentRoom().getShortDesc());
	}
	public void printLong(Player player) {
		System.out.println("CURRENT ROOM");
		System.out.println(player.getCurrentRoom().getName());
		System.out.println(player.getCurrentRoom().getLongDesc());
	}
}
