package clientapp;



import java.util.Scanner;
import org.apache.logging.log4j.*;
import bank.AccountManager;



public class Main {
	static AccountManager accMan = new AccountManager();
	static Scanner sc = new Scanner(System.in);
	static String choice = "";
	static boolean quit = false;
	private static final Logger logger = LogManager.getLogger(Main.class.getName());
	public static void main(String[] args) {
		
		while(quit == false){
			logger.info("Program starting...");
			runProg(); //program will keep running till the quit Boolean is made true
		}
		
	}
	public static void runProg() {
		menuOptions(); //show the starting options
		choice = sc.next(); //set the choice
		choice = choice.toLowerCase();
		switch (choice) {
		case "login":
			logger.info("Starting login.");
			loginMenu();
			break;
		case "register":
			accCreate();
			break;
		case "quit":
			exitProg();
			break;
		default:
			logger.error("Invalid input");
			System.out.println("Invalid option");
		}
	}
	
	public static String loginMenu() { //Menu for logging in
		System.out.println("Please enter Username: ");
		String user = sc.next();
		System.out.println("Please enter Password: ");
		String pass = sc.next();
		System.out.println("Please enter ID: ");
		int id = sc.nextInt();
		logger.info("Login with " + user + " " + pass + " " +id);
		accMan.getAccount(user, pass, id);
		
		return null;
	}
	public static void menuOptions() { //main options for the app
		System.out.println("Please select an option: ");
		System.out.println("'Login' to login to account");
		System.out.println("'Register' to register an account");
		System.out.println("Type Quit to exit");
	}
	
	public static void accOptions() { //options to deposit, withdraw, and check account
		accountOptions();
		choice = sc.next().toLowerCase();
		switch (choice) {
		case "deposit":
			accountDepo();
			accOptions();
			break;
		case "withdraw":
			accountWithdraw();
			accOptions();
			break;
		case "delete":
			deletion();
			runProg();
			break;
		case "balance":
			System.out.println("======================");
			accMan.printBalance();
		case "return":
			System.out.println("======================");
			break;
		case "quit":
			System.out.println("======================");
			exitProg();
			System.out.println("======================");
			break;
		default:
			System.out.println("======================");
			System.out.println("Invalid entry");
			System.out.println("======================");
			logger.warn("Invalid entry on Account Options: " + choice);
			accOptions();
		}
	}
	public static void accCreate() { //prompts to making a new account
		System.out.println("Please enter desired username: ");
		String user = sc.next();
		System.out.println("Please enter desired password: ");
		String pass = sc.next();
		System.out.println("Please enter ID number: ");
		int id = sc.nextInt();
		System.out.println("Please enter starting balance: ");
		double balance = sc.nextDouble();
		if (balance<0.0) {
			System.out.println("Invalid starting balance.  Returning to main menu.");
			runProg();
		}else {
		accMan.setAccount(id, user, pass, balance);
		}
	}
	
	public static void accountOptions() { //account option menu
		System.out.println("Please select an option for this account:");
		System.out.println("'Deposit' to add funds");
		System.out.println("'Withdraw' to remove funds");
		System.out.println("'Balance' to check current balance");
		System.out.println("'Delete' to delete this account");
		System.out.println("'Return' to retrurn to main menu");
		System.out.println("'Quit' to exit the program");
	}
	public static void accountWithdraw() { //method to verify amount is positive and send it off to withdraw
		System.out.println("======================");
		System.out.println("Enter withdraw amount: ");
		double withd = sc.nextDouble();
		if (withd < 0.0) {
			System.out.println("Please enter a positive number");
			System.out.println("======================");
		}else {
		logger.info("Withdrawing from account");
		accMan.alterAccount(withd, true);
		accMan.printBalance();
		System.out.println("======================");
		}
	}
	public static void accountDepo() { //method to verify amount is positive and send it off to deposit
		System.out.println("======================");
		System.out.println("Enter deposit amount: ");
		double depo = sc.nextDouble();
		if (depo < 0.0) {
			System.out.println("Please enter a positive number");
			System.out.println("======================");
		}else {
		logger.info("Depositing into acocunt");
		accMan.alterAccount(depo, false);
		accMan.printBalance();
		System.out.println("======================");
		}
	}
	public static void deletion() { //method to send off account deletion
		System.out.println("Please re-enter account password for verification: ");
		System.out.println("======================");
		logger.info("Deletion of account");
		String pass = sc.next();
		System.out.println("Deleting....");
		accMan.removeAcc(pass);
	}
	

	public static void exitProg() {
		quit = true;
		System.out.println("==============================");
		System.out.println("Thank you and have a nice day!");
		logger.info("Program exited");
		sc.close();
		LogManager.shutdown();
		//cloeses the scanner, logger and make quit true to end loop
	}
}
