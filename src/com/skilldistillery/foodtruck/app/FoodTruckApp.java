package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		boolean quit = false;
		int selection;
		Scanner kb = new Scanner(System.in);

		FoodTruckApp truckApp = new FoodTruckApp();

		System.out.println(
				"Enter the food truck line up! Prompts will appear asking " 
						+ "for specific information on each truck");
		FoodTruck[] lineUp = truckApp.populateTrucks(kb);

		while (!quit) {
			truckApp.printMenu();
			selection = kb.nextInt();
			truckApp.userSelection(selection, lineUp);
			if (selection == 4) {
				quit = true;
			}

		}

	}

	private void userSelection(int selection, FoodTruck[] lineUp) {
		if (selection == 1) {
			System.out.println("Listing all existing food trucks: ");
			listTrucks(lineUp);
			System.out.println("");
		} else if (selection == 2) {
			double average = calculateAvgRating(lineUp);
			System.out.println("The average rating of these food trucks is " + average);
			System.out.println("");

		} else if (selection == 3) {
			FoodTruck highestRatedTruck = determineHighestRatedTruck(lineUp);
			System.out.println("The highest-rated food truck is " + highestRatedTruck.displayTruck());
			System.out.println("");
		} else {
			System.out.println("Quitting. Thanks for stopping by!");
		}

	}

	private void listTrucks(FoodTruck[] lineUp) {
		int index = 1;
		for (int i = 0; i < lineUp.length; i++) {
			if (lineUp[i] != null) {
			System.out.print(index + ".) ");
			System.out.println(lineUp[i].getTruckName());
			index++;
			}
		}
	}

	private FoodTruck determineHighestRatedTruck(FoodTruck[] lineUp) {
		int highestRating = 0;
		FoodTruck highestRated = null;
		for (int i = 0; i < lineUp.length; i++) {
			if (lineUp[i] != null) {
				if (lineUp[i].getStarRating() > highestRating) {
					highestRating = lineUp[i].getStarRating();
					highestRated = lineUp[i];
					}
			}
		}
		return highestRated;
		
	}

	private double calculateAvgRating(FoodTruck[] lineUp) {
		int numTrucks = 1;
		int ratings = 0;
		for (int i = 0; i < lineUp.length; i++) {
			if (lineUp[i] != null) {
			ratings += lineUp[i].getStarRating();
			numTrucks++;
			}
		}
		double average = (double)(ratings/numTrucks);
		return average;

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
			} else {
				System.out.println("Please enter the type of food " + foodTruckName + " served: ");
				foodType = kb.nextLine();
				System.out.println("Please enter how many stars you rate " + foodTruckName + " at (0-5): ");
				starRating = kb.nextInt();
				
				kb.nextLine();

				newTruck = new FoodTruck(foodTruckName, foodType, starRating);
				lineUp[i] = newTruck;
			}
			
		}
		return lineUp;
	}

}
