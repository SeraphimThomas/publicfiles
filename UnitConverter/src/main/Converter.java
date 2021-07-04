package main;

import java.util.*;

public class Converter {
	static Scanner sc = new Scanner(System.in);
	static int subMenu = 0;
	static double value;
	static String continStr = "Yes";
	public static void main(String[] args) {
		int menuSelection = 0;
		while (menuSelection != 4) {
			continStr = "Yes";
			System.out.println("Please Select an option:");
			System.out.println("1. Distance Conversion");
			System.out.println("2. Fluid Conversion");
			System.out.println("3. Harry Potter Coin Conversion");
			System.out.println("4. Quit");
			menuSelection = sc.nextInt();
			switch (menuSelection) {
			case 1:
				distanceConversion();
				break;
			case 2:
				fluidConversion();
				System.out.println("\n");
				break;
			case 3:
				magicConversion();
				System.out.println("\n");
				break;
			case 4:
				System.out.println("Thank you for using the converter!");
				sc.close();
				break;
			default:
				System.out.println("Invalid option.");
			}
		}
	}
	public static double yardsToMeters(double qty) {
		double result = qty*0.9144;
		return result;
	}
	public static double inchesToCentimeters(double qty) {
		double result = qty*2.54;
		return result;
	}
	public static double milesToKilometers(double qty) {
		double result = qty*1.609344;
		return result;
	}
	public static double gallonsToLiters(double qty) {
		double result = qty*3.785412;
		return result;
	}
	public static double cupsToCentiliters(double qty) {
		double result = qty*23.6588;
		return result;
	}
	public static double cupsToMililiters(double qty) {
		double result = 236.588;
		return result;
	}
	public static double sicklesToGalleon(double qty) {
		double result = qty/17;
		return result;
	}
	public static double knutsToSickles(double qty) {
		double result=qty/29;
		return result;
	}
	public static double knutsToGalleon(double qty) {
		double result=qty/493;
		return result;
	}
	public static void distanceConversion() {
	while (continStr.equalsIgnoreCase("Y") || continStr.equalsIgnoreCase("Yes")) {
		System.out.println("Please select an suboption:");
		System.out.println("1. Yards to Meters");
		System.out.println("2. Inches to Centimeters");
		System.out.println("3. Miles to Kilometers");
		subMenu = sc.nextInt();
			switch (subMenu) {
			case 1:
				System.out.println("Please enter yards:");
				value = sc.nextDouble();
				System.out.println(value + " yards is equal to " + yardsToMeters(value) + " meters");
				System.out.println("\n");
				System.out.println("Would you like to try another distance conversion?");
				System.out.println("Y/N");
				continStr = sc.next();
				break;
			case 2:
				System.out.println("Please enter inches:");
				value = sc.nextDouble();
				System.out.println(value + " inches is equal to " + inchesToCentimeters(value) + " centimeters");
				System.out.println("\n");
				System.out.println("Would you like to try another distance conversion?");
				System.out.println("Y/N");
				continStr = sc.next();
				break;
			case 3: 
				System.out.println("Please enter miles:");
				value = sc.nextDouble();
				System.out.println(value + " miles is equal to " + milesToKilometers(value) + " kilometers.");
				System.out.println("\n");
				System.out.println("Would you like to try another distance conversion?");
				System.out.println("Y/N");
				continStr = sc.next();
				break;
			default:
				System.out.println("Invalid option");
				System.out.println("Would you like to try another distance conversion?");
				System.out.println("Y/N");
				continStr = sc.next();
					}
			if (continStr.equalsIgnoreCase("Y") || continStr.equalsIgnoreCase("Yes")) {
				continue;
			}else if (continStr.equalsIgnoreCase("N") || continStr.equalsIgnoreCase("No")) {
				continue;
			}else {
				System.out.println("Invalid entry.  Returning to main menu by default.");
				continStr = "N";
				}
		}
	}
	public static void fluidConversion() {
		while (continStr.equalsIgnoreCase("Y") || continStr.equalsIgnoreCase("Yes")) {
		System.out.println("Please select an suboption:");
		System.out.println("1. Gallons to Liters");
		System.out.println("2. Cups to Centiliters");
		System.out.println("3. Cups to Mililiters");
		subMenu = sc.nextInt();
		switch (subMenu) {
		case 1:
			System.out.println("Please enter gallons: ");
			value = sc.nextDouble();
			System.out.println(value + " gallons is equal to " + gallonsToLiters(value) + " liters");
			System.out.println("\n");
			System.out.print("Would you like to try another fluid conversion?");
			System.out.println("Y/N");
			continStr = sc.next();
			break;
		case 2:
			System.out.println("Please enter cups to convert to centiliters: ");
			value = sc.nextDouble();
			System.out.println(value + " cups is equal to " + cupsToCentiliters(value) + " centiliters");
			System.out.println("\n");
			System.out.print("Would you like to try another fluid conversion?");
			System.out.println("Y/N");
			continStr = sc.next();
			break;
		case 3:
			System.out.println("Please enter cups to conver to mililiters: ");
			value = sc.nextDouble();
			System.out.println(value + " cups is equal " + cupsToMililiters(value) + " mililiters");
			System.out.println("\n");
			System.out.print("Would you like to try another fluid conversion?");
			System.out.println("Y/N");
			continStr = sc.next();
			break;
		default:
			System.out.println("Invalid Option");
			System.out.print("Would you like to try another fluid conversion?");
			System.out.println("Y/N");
			continStr = sc.next();
			}
		if (continStr.equalsIgnoreCase("Y") || continStr.equalsIgnoreCase("Yes")) {
			continue;
		}else if (continStr.equalsIgnoreCase("N") || continStr.equalsIgnoreCase("No")) {
			continue;
		}else {
			System.out.println("Invalid entry.  Returning to main menu by default.");
			continStr = "N";
			}
		}
	}
	public static void magicConversion() {
		while (continStr.equalsIgnoreCase("Y") || continStr.equalsIgnoreCase("Yes")) {
		System.out.println("Welcome to Gringots.  What you looking to exchange?:");
		System.out.println("1. Sickles to Galleons");
		System.out.println("2. Knuts to Scickles");
		System.out.println("3. Knuts to Galleons");
		subMenu = sc.nextInt();
		switch (subMenu) {
		case 1:
			System.out.println("How many sickles you exchaning to galleons?");
			value = sc.nextDouble();
			System.out.println("Current exhange would mean " + (int)value + " sickles is equal to " + sicklesToGalleon(value) + 
					" galleons.");
			System.out.println("\n");
			System.out.println("There any other exchange you need to do?");
			System.out.println("Y/N");
			continStr = sc.next();
			break;
		case 2:
			System.out.println("How many knuts you exchanging to sickles?:");
			value = sc.nextDouble();
			System.out.println("Current exchange would mean " + (int)value + " knuts is equal to " + knutsToSickles(value) +
					" sickles.");
			System.out.println("\n");
			System.out.println("There any other exchange you need to do?");
			System.out.println("Y/N");
			continStr = sc.next();
			break;
		case 3:
			System.out.println("How many knuts you exchanging to galleons?:");
			value = sc.nextDouble();
			System.out.println("Current exhange would mean " +value+ " knuts is eqaul to " +knutsToGalleon(value) +
					" galleons");
			System.out.println("\n");
			System.out.println("There any other exchange you need to do?");
			System.out.println("Y/N");
			continStr = sc.next();
			break;
		default:
			System.out.println("You get hit with a Stupefy spell?  That ain't an option.");
			System.out.println("There any other exchange you need to do?");
			System.out.println("Y/N");
			continStr = sc.next();
			}
		if (continStr.equalsIgnoreCase("Y") || continStr.equalsIgnoreCase("Yes")) {
			continue;
		}else if (continStr.equalsIgnoreCase("N") || continStr.equalsIgnoreCase("No")) {
			continue;
		}else {
			System.out.println("Invalid entry.  Returning to main menu by default.");
			continStr = "N";
			}
		}
	}
}
