package vetclinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

import vetclinicabstract.Animal;
import vetclinicabstract.Staff;
import vetclinicabstract.StaffMedical;
import vetclinicobj_animals.FactoryAnimal;
import vetclinicobj_staff.FactoryStaff;

public class Menu {

	/*
	 * CA SPECS-
	 * The user should be able to: 
	 * 		1) [STAFF] List all staff 
	 * 		2) [STAFF] List staff by categories (e.g. list all Nurses)
	 * 		3) [STAFF] List all Admin staff performing a certain task
	 * 		4) [STAFF] Search for a specific member of staff by name 
	 * 		5) [PETS] List all animals
	 * 		6) [PETS] List animals by various types (e.g. list all dogs) 
	 * 		7) [PETS] Search for a specific animal by name
	 * 		8) [PETS] List all the animals assigned to a member of medical staff 
	 * 		9) [QUEUE MANAGEMENT] List the order in which pets will be looked after by a member of the medical staff
	 * `	10) [QUEUE MANAGEMENT] For a given member of the medical staff, pass to the next pet.
	 * 		11) [BONUS - QUEUE MANAGEMENT] Show count of pets in queue for each medical staff
	 */
	
	// Structure *borrowed* from 'Pizza' example done in Algo class (May 2020)
	public Menu() throws IOException, InstantiationException, IllegalAccessException {
		
		/*
		 * Creates array list of 'staff' objects with variable numbers of admin/ medical and vet staff members.
		 * Values passed as params (10, 30, 5) represent the min requirement as for the specs in CA,
		 * however bigger values are also supported, e.g. (40, 60, 10)
		 */
		FactoryStaff factoryStaff = new FactoryStaff(10, 30, 5);
		// Returning array list with staff members
		ArrayList<Staff> staff = factoryStaff.getStaff();
		LinkedList<StaffMedical> medicalStaff = factoryStaff.getMedicalStaff();
		// System.out.println(staff.toString()); //<= TEST POINT
		// System.out.println(medicalStaff.toString()); //<= TEST POINT
		
		
		/*
		 * Creates 'animal' objects with a param that allows to determine overall number of animals
		 * 1000 animals is the min requirement as per CA specs
		 */		
		FactoryAnimal factoryAnimal = new FactoryAnimal(90);
		LinkedList<Animal> animals = factoryAnimal.getAnimals();
		//System.out.println(factoryAnimal.toString()); //<= TEST POINT
		
		
		/*
		 * CA SPECS - Once all the entities have been created, the system should assign EACH animal
		 * to a member of medical staff (for treatment). This means you need some way of
		 * knowing which Medical Staff member is assigned to which animal.
		 */
		QueueSystem qs= new QueueSystem(medicalStaff,animals);
		// medicalStaff's queues are now populated with animals
		// System.out.println(medicalStaff.toString()); //<= TEST POINT	
		System.out.println(staff.toString()); //<= TEST POINT
		
		
//		int option = -1;
//		
//		do {
//			do {
//				mainMenuOptions();
//				option = readingUser();
//				
//			} while (!validOption(option));
//			
//			if(option != 0) {
//				addIngredient(option);
//			}	
//		} while (option != 0);
//
//		System.out.println("test");
//		
//	}
//	
//	public void mainMenuOptions() {
//		System.out.println("Select your ingredients");
//		for(int i = 0; i < ingredients.length; i++) {
//			System.out.println("Press " + (i+1) + " for " + ingredients[i]);
//		}
//		System.out.println("Press 0 to ORDER YOUR PIZZA");
//	}	
	
//	public void mainMenuOptions() {
//		System.out.println("Select your ingredients");
//		for(int i = 0; i < ingredients.length; i++) {
//			System.out.println("Press " + (i+1) + " for " + ingredients[i]);
//		}
//		System.out.println("Press 0 to ORDER YOUR PIZZA");
//	}
//	
//	public int readingUser() {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String optionString = null;
//		int option = -1; 
//		
//		try {
//			optionString = br.readLine();
//			option = Integer.parseInt(optionString); 
//			 
//		} catch (IOException | NumberFormatException e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//			System.out.println("That's not a valid option, please type 0-9");
//		}
//		
//		return option;
//	}
//	
//	public boolean validOption(int option) {
//		return option >= 0 && option <= 9;
//	}
//	
//	public void addIngredient(int option) {
//		selectedIngredients.add(ingredients[option - 1]);
//	}	

	}
}
