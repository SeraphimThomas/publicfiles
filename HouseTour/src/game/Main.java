package game;

import java.util.Scanner;
import fixtures.*;

public class Main{
	private static RoomManager createRooms = new RoomManager(9); //initialize creation of rooms
	static Scanner scan = new Scanner(System.in); //make scanner
	static Room currentRoom;
	static Room backUpRoom; // Backup room object in case of error with move.  Has backup of last room visited
	static boolean gameOn = true;
	static String[] input = {"", ""};
	public static void main(String[] args) {
		Player player = new Player();
		createRooms.init(); //create the rooms first
		printInstructions();
		player.setCurrentRoom(createRooms.getStartingRoom());
		currentRoom = createRooms.getStartingRoom();
		backUpRoom = currentRoom;
		createRooms.printRoom(player);
		do {
			parse(collectInput(), player);
		} while (gameOn); //as long as the user doesn't enter 'Quit Game' it will continue
		
		
	}
	public static String[] collectInput() {
		String command = scan.nextLine();
		String[] input = command.split(" ", 2);
		return input;
	}
	public static void parse(String[] input, Player player) {
		String command[] = new String[2];
		command = input;
		command[0] = command[0].toUpperCase().intern();
		command[1] = command[1].toUpperCase().intern();
		if (command.length>1) {
			command[1] = command[1].toUpperCase().intern();
		}
		if (command[0] == "GO" | command[0] == "MOVE") {
			player.setCurrentRoom(currentRoom.getExits(command[1]));
			if (player.getCurrentRoom() == null) {
				System.out.println("You can't go that way.\n");
				System.out.println("\n");
				player.setCurrentRoom(currentRoom);
				createRooms.printShort(player);
			}else{
			currentRoom=player.getCurrentRoom();
			createRooms.printLong(player);
			backUpRoom=currentRoom;
			}
		} else if (command[0] == "PET") {
				if (command[1] == "DOG" | command[1] == "PUP" | command[1] == "PUPPER") {
					Scarlet pup = new Scarlet("this","should","work!");//default object to call the class
					pup.interact(currentRoom.getThings(), currentRoom);
			}
		}else if (command[0] == "OPEN") {
				if (command[1] == "LAPTOP") {
					Computer comp = new Computer("this","should","ALSO WORK!");//default object to call the class
					comp.interact(currentRoom.getThings(), currentRoom);
				}
		} else if (command[0] == "FLUSH") {
				if (command[1] == "TOILET") {
					Toilet swirls = new Toilet("and", "we", "swirl!"); //default object to call the class
					swirls.interact(currentRoom.getThings(), currentRoom);
				}
		}else if (command[0] == "LOOK" && command[1] == "ROOM") {
			createRooms.printLong(player);
		} else if (command[0] == "QUIT") {
				endGame();
			}else {
				System.out.println("Say that again?");
			}
		}
	public static void endGame() {
		System.out.println("Thank you for playing!");
		gameOn=false;
		scan.close();
	}
	public static void printInstructions() {
		System.out.println("This is a simple exploration of my house.  Please keep these in mind:");
		System.out.println("1. All commands are 2 word prompts.");
		System.out.println("2. Move is done with 'move' or 'go' (without the quotes.");
		System.out.println("3. Direction are 4 cardinal directions (north, south, east, west)");
		System.out.println("4. To exit, enter 'quit game' (without the quotes)");
		System.out.println("5. Interactions include 'open', 'pet', and 'flush'");
		System.out.println("6. You can enter 'look room' to get the full room description again.");
	}

}
