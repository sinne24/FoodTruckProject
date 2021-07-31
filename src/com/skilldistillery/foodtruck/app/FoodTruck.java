package com.skilldistillery.foodtruck.app;

public class FoodTruck {
	private static int uniqueID = 1112;
	private String truckName;
	private String foodType;
	private int starRating; //0 - 5 stars
	private int truckID;
	
	public FoodTruck(String truckName, String foodType, int starRating) {
		super();
		FoodTruck.uniqueID++;
		this.truckID = uniqueID;
		this.truckName = truckName;
		this.foodType = foodType;
		this.starRating = starRating;	
		
	}

	public String displayTruck() {
		return  truckName + " (truck ID number " + truckID + "):\n\t This truck sells " + foodType + " food , and is rated at " + starRating
				+ " stars!";
	}

	public static int getUniqueID() {
		return uniqueID;
	}

	public static void setUniqueID(int uniqueID) {
		FoodTruck.uniqueID = uniqueID;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getStarRating() {
		return starRating;
	}

	public void setStarRating(int starRating) {
		this.starRating = starRating;
	}
	
	
	
	

}
