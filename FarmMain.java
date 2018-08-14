package farm.main;

import java.util.ArrayList;
import java.util.Scanner;

import farm.people.Family;
import farm.people.Person;
import farm.property.Crop;
import farm.property.Land;

public class FarmMain {	
	public static Family fam1 = new Family();
	public static Crop wheat = new Crop("wheat");
	public static Crop barley = new Crop("barley");
	public static Crop oats = new Crop("oats");
	public static Crop lentils = new Crop("lentils");
	public static Scanner keyboard = new Scanner(System.in);
		
	public static void main(String[] args) {
		int year = 1100;
		int season = 1;
		
		initFamily();		
		System.out.println("Welcome to the Medieval Farming Life!");				
		executeTurn(season, year);		
	}
	
	
	private static void initFamily() {		
		Person father = new Person();		// Create a father and mother
		Person mother = new Person();

		Land field1 = new Land();		// Create 3 fields (10 acres each)
		Land field2 = new Land();
		Land field3 = new Land();
		
		father.setGender("male");			// Set properties
		father.setFirstName("John");
		father.setLastName("Snow");
		father.setAge(30);
		father.setGeneration(0);
		
		mother.setGender("female");
		mother.setFirstName("Ygrit");
		mother.setLastName("Snow");
		mother.setAge(30);
		mother.setGeneration(0);
		
		fam1.setHusband(father);
		fam1.setWife(mother);
		
		field1.setAcres(10);
		field2.setAcres(10);
		field3.setAcres(10);
											
		ArrayList<Land> fields = new ArrayList<Land>(); 
		fields.add(field1);
		fields.add(field2);					// Create an array for the fields
		fields.add(field3);
		
		fam1.setFamilyLand(fields);			//  to fam1.FamilyLand
	}
	
	private static void executeTurn(int season, int year) {		
		if(season == 1) {
			System.out.println("The Year is AD " + year);
			System.out.println("It is the spring season, "
					+ "the following tasks are available.");
			System.out.println("1. Prepare fields for planting");
			System.out.println("2. Plant fields");
			System.out.println("3. Clear new land");
			System.out.println("You have " + fam1.count() + " workers available"
					+ " and " + fam1.countFields() + " fields.");
			System.out.println("  Wheat Stores: " + fam1.getWheat() + " Bushels");
			System.out.println(" Barley Stores: " + fam1.getBarley() + " Bushels");
			System.out.println("   Oats Stores: " + fam1.getOats() + " Bushels");
			System.out.println("Lentils Stores: " + fam1.getLentils() + " Bushels");
			
			String task = getUserInput(keyboard.nextLine());
			
			if(task.equalsIgnoreCase("1")) {
				
				System.out.println("You have " + fam1.countFields() + " fields. Each field"
						+ " will require one worker to prepare.\n How many fields would you"
						+ " like to prepare?");				
				int numOfFields = getUserInput(keyboard.nextLine(), fam1.countFields(), fam1.count());				
				int ctr = 0;
				while(ctr < numOfFields) {					
					ArrayList<Land> fields = fam1.getFamilyLand();
					
					if(!fields.get(ctr).isPlanted() && fam1.getFertilizer() >= 10) {
						fields.get(ctr).prepForPlanting();
						fam1.setFertilizer(fam1.getFertilizer() - 10);
						ctr++;
						System.out.println("A field was prepared!");
					} else if(fam1.getFertilizer() < 10){
						System.out.println("Could not prepare field, not enough fertilizer");
						ctr++;
					}				
				}				
			} else if(task.equalsIgnoreCase("2")) {				
				int fieldsPossible = 0;
				if(fam1.count() < fam1.countFields()) {
					fieldsPossible = fam1.count();
				} else {
					fieldsPossible = fam1.countFields();
				}				
				System.out.println("You may plant up to " + fieldsPossible + " fields.\n"
						+ "How many would you like to plant?");				
				int numFields = getUserInput(keyboard.nextLine(), fam1.countFields(), fam1.count());				
				int ctr = 0;
				while(ctr < numFields) {
					ArrayList<Land> fields = fam1.getFamilyLand();					
					if(!fields.get(ctr).isPlanted()) {
						System.out.println("Field " + (ctr + 1) + ": What crop would you like to plant"
								+ " in this field?");					
						String input = keyboard.nextLine();
						boolean success = false;						
						if(input.equalsIgnoreCase("wheat")) {							
							success = fields.get(ctr).plant(wheat, fam1);
							ctr++;							
						} else if(input.equalsIgnoreCase("barley")) {							
							success = fields.get(ctr).plant(barley, fam1);
							ctr++;							
						} else if(input.equalsIgnoreCase("oats")) {							
							success = fields.get(ctr).plant(oats, fam1);
							ctr++;							
						} else if(input.equalsIgnoreCase("lentils")) {							
							success = fields.get(ctr).plant(lentils, fam1);
							ctr++;							
						} else {
							System.out.println("Your input didn't compute, please try again.");
						}						
						if(!success) {
							System.out.println("A field could not be planted due to insufficient"
									+ " resources.");							
						}						
					} 	
				}				
			}			
		} else if (season == 2) {	//TODO Summer tasks and events			
		} else if (season == 3) {	//TODO Autumn tasks and events			
		} else {					//TODO Winter tasks and events			
		}		
		if(season < 4) {
			season++;
		} else {
			season = 1;
			year++;
		}
	}
			
	
	///////////// STRING INPUT VALIDATION  /////////////////
	private static String getUserInput(String firstUserInput) {		
		while(!firstUserInput.equalsIgnoreCase("1") && !firstUserInput.equalsIgnoreCase("2")
				&& !firstUserInput.equalsIgnoreCase("3")) {
			System.out.println("Please enter 1, 2, or 3 for the appropriate task.");
			firstUserInput = keyboard.nextLine();
		}		
		return firstUserInput;
	}
			
	
	//////////////  INT INPUT VALIDATION   ///////////////////
	private static int getUserInput(String userInput, int numOfFields, int numOfWorkers) {
		int numericInput = -1;		
		try {
			numericInput = Integer.parseInt(userInput);
		} catch (NumberFormatException ex) {
			System.out.println("Why you no enter number?");
		}			
		while(numericInput < 0 || numericInput > numOfFields || numericInput > numOfWorkers) {
			System.out.println("Your entry was invalid, please try again.");			
			try {
				numericInput = Integer.parseInt(keyboard.nextLine());
			} catch (NumberFormatException ex) {
				System.out.println("Why you no enter number?");
			}			
		}		
		return numericInput;
	}
}




