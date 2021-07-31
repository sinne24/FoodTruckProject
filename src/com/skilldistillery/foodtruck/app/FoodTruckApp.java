package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		boolean quit = false;
		int selection;
		Scanner kb = new Scanner(System.in);

		FoodTruck[] lineUp = new FoodTruck[5];
		FoodTruckApp truckApp = new FoodTruckApp();

		System.out.println(
				"Enter the food truck line up! Prompts will appear asking " 
		+ "for specific information on each truck");
		lineUp = truckApp.populateTrucks(kb);

		while (!quit) {
			truckApp.printMenu();
			selection = kb.hashCode();
			truckApp.userSelection(selection);
			if (selection == 4) {
				quit = true;
			}

		}

	}

	private void userSelection(int selection) {
		if (selection == 1) {
			System.out.println("Listing all existing food trucks: ");
		} else if (selection == 2) {
			int average = calculateAvgRating();
			System.out.println("The average rating of these food trucks is " + average);

		} else if (selection == 3) {
			String highestRatedTruck = determineHighestRatedTruck();
			System.out.println("The highest-rated food truck is" + highestRatedTruck);
		} else {
			System.out.println("Quitting. Thanks for stopping by!");
		}

	}

	private String determineHighestRatedTruck() {
		// TODO Auto-generated method stub
		return null;
	}

	private int calculateAvgRating() {
		// TODO Auto-generated method stub

	}

	private void printMenu() {
		System.out.println("1.)List all existing food trucks.\n"
						 + "2.)See the average rating of food trucks.\n"
						 + "3.)Display the highest-rated food truck.\n"
						 + "4.)Quit the program.");

	}

	private FoodTruck[] populateTrucks(Scanner kb) {
		String foodTruckName;
		int starRating;
		String foodType;
		FoodTruck newTruck;
		FoodTruck[] lineUp = new FoodTruck[5];

		for (int i = 0; i < 5; i++) {
			System.out.println("Please enter the food truck's name or quit to stop: ");
			foodTruckName = kb.nextLine();
			if (foodTruckName.equalsIgnoreCase("quit")) {
				break;
			}
			System.out.println("Please enter the type of food " + foodTruckName + " serves: ");
			foodType = kb.nextLine();
			System.out.println("Please enter how many stars you rate " + foodTruckName + " at (0-5): ");
			starRating = kb.nextInt();

			newTruck = new FoodTruck(foodTruckName, foodType, starRating);
			lineUp[i] = newTruck;
		}
		return lineUp;
	}

}
