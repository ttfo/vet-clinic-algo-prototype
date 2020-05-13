package vetclinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import vetclinicabstract.Animal;
import vetclinicabstract.Staff;
import vetclinicabstract.StaffAdmin;
import vetclinicabstract.StaffMedical;
import vetclinicobj_animals.AnimalCat;
import vetclinicobj_animals.AnimalDog;
import vetclinicobj_animals.AnimalHorse;
import vetclinicobj_animals.AnimalPython;
import vetclinicobj_animals.FactoryAnimal;
import vetclinicobj_staff.FactoryStaff;
import vetclinicobj_staff.StaffAdminITNerd;
import vetclinicobj_staff.StaffAdminReceptionist;
import vetclinicobj_staff.StaffMedicalNurse;
import vetclinicobj_staff.StaffMedicalVet;
import vetclinicobj_staff.StaffMedicalVetTrainee;

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
	 * 		8) [QUEUE MANAGEMENT] List all the animals assigned to a member of medical staff 
	 * 		9) [QUEUE MANAGEMENT] List the order in which pets will be looked after by a member of the medical staff
	 * `	10) [QUEUE MANAGEMENT] For a given member of the medical staff, pass to the next pet.
	 * 		11) [BONUS - QUEUE MANAGEMENT] Show count of pets in queue for each medical staff
	 */
	
	String[] menuMainOptions = {"STAFF Queries", "PETS Queries", "QUEUE MANAGEMENT Queries"};
	String[] menuSecondaryOptionsStaff = {"List all staff", "List staff by categories", "List Admin staff by task", "Search member of staff by name"};
	String[] menuSecondaryOptionsPets = {"List all animals", "List animals by type", "Search for pet by name"};
	String[] menuSecondaryOptionsQ = {"List all the animals assigned to individual medical staff member", "List queue order by individual medical staff member", 
			"Move to next pet in queue for individual medical staff member", "Show count of pets in queue for all medical staff"};
	
	// ASCII art from https://www.asciiart.eu/animals/dogs
	private String ASCIIArt = ("\r\n\r\n"+
			"	        |\\_/|        D\\___/\\\r\n" + 
			"	        (0_0)         (0_o)\r\n" + 
			"	       ==(Y)==         (V)\r\n" + 
			"	    --(u)---(u)----oOo--U--oOo---\r\n" + 
			"	  |       |       |       |       |   \r\n"+
			"\r\n"+
			"	  *   WELCOME TO THE VET CLINIC   *   \r\n"+
			"	  ***    Management Console     ***   \r\n\r\n");
	
	
	
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
	// System.out.println(staff.toString()); //<= TEST POINT
	
	
	public Menu() throws IOException, InstantiationException, IllegalAccessException {
		
		// Following structure *borrowed* from 'Pizza' example done in Algo class (May 2020)
		
		int option = -1;
		int secondaryOption = -1;
		
		System.out.println(ASCIIArt);
		do {
			do {
				// Show main options and read user input
				mainMenuOptions();
				option = readingUser();
				
			} while (!validOptionMain(option)); // Validate the input is int between 0 and 9
			
			// If option is not 0 go to sub-menu
			if(option != 0) {
				//System.out.println(option+" selected ..."); //<= TEST POINT
				do {
					secondaryMenuOptions(option);
					secondaryOption = readingUser();
				} while (!validOptionMain(option)); // TODO Validation for secondary entries
				
				// If option is valid run selected query
				queryBuilder(option, secondaryOption);
			}	
		} while (option != 0);
		
		// If option is 0 exit
		System.out.println("... Closing application ...");
		return;
		
	}
	
	public void mainMenuOptions() {
		System.out.println("Choose from one of these options:\r\n");
		for(int i = 0; i < menuMainOptions.length; i++) {
			System.out.println("Press " + (i+1) + " for " + menuMainOptions[i]);
		}
		System.out.println("Press 0 to EXIT");
	}
	
	public void secondaryMenuOptions(int menuBranch) {
		//System.out.println("Sub-menu =>"+menuBranch); //<= TEST POINT
        switch (menuBranch) {
	        case 1:  //menuBranch = 1; // STAFF Queries
						System.out.println("Pick your query:\r\n");
						for(int i = 0; i < menuSecondaryOptionsStaff.length; i++) {
							System.out.println("Press " + (i+1) + " for " + menuSecondaryOptionsStaff[i]);
						}
						System.out.println("Press 0 for MAIN MENU");
	                 break;
	        case 2:  //menuBranch = 2; // PETS Queries
						System.out.println("Pick your query:\r\n");
						for(int i = 0; i < menuSecondaryOptionsPets.length; i++) {
							System.out.println("Press " + (i+1) + " for " + menuSecondaryOptionsPets[i]);
						}
						System.out.println("Press 0 for MAIN MENU");	        
	                 break;
	        case 3:  //menuBranch = 3; // QUEUE MANAGEMENT Queries
						System.out.println("Pick your query:\r\n");
						for(int i = 0; i < menuSecondaryOptionsQ.length; i++) {
							System.out.println("Press " + (i+1) + " for " + menuSecondaryOptionsQ[i]);
						}
						System.out.println("Press 0 for MAIN MENU");	        
	                 break;
	        default: break;
        }		
	}	
	
	public void queryBuilder(int option, int secondaryOption) {
		
		if(secondaryOption != 0) { // TODO Refine this condition
			
			// STAFF Queries
			if(option == 1) { 
				switch (secondaryOption) {
				
					case 1: // List all staff
						for(Staff st: staff){
							System.out.println("Staff ID "+ st.getEmployeeId() + ": " +
									((st.getTitle() != null) ? st.getTitle() : "") +
									st.getFirstName() + " " + st.getSecondName());
						}
						System.out.println("\r\nTotal staff: "+staff.size()+" employees\r\n");
						System.out.println("\r\n*DONE!*\r\n");
						break;
						
					case 2: // List staff by categories
						ArrayList<String> adminITNerdList = new ArrayList<String>();
						ArrayList<String> adminReceptionistList = new ArrayList<String>();
						ArrayList<String> medicalNurseList = new ArrayList<String>();
						ArrayList<String> medicalVetList = new ArrayList<String>();
						ArrayList<String> medicalVetTraineeList = new ArrayList<String>();
						
						for(Staff st: staff){
							
							// About StringBuilder REF. https://www.javatpoint.com/StringBuilder-class
							StringBuilder stDetails = new StringBuilder();
							stDetails.append("Staff ID " + st.getEmployeeId() + ": "
									+ ((st.getTitle() != null) ? st.getTitle() : "") + st.getFirstName() + " "
									+ st.getSecondName());
							
							if (st instanceof StaffAdminITNerd) {
								// show 'ON CALL' is the staff member is 'on call' person for emergencies
								// 'on call' only applies to 1 IT person and 1 Vet
								if (((StaffAdminITNerd) st).isITOnCall() == true) {
									stDetails.append(" (ON CALL)");
								}
								adminITNerdList.add(stDetails.toString());
							} else if (st instanceof StaffAdminReceptionist) {
								adminReceptionistList.add(stDetails.toString());
							} else if (st instanceof StaffMedicalNurse) {
								medicalNurseList.add(stDetails.toString());
							} else if (st instanceof StaffMedicalVet) {
								// show 'ON CALL' is the staff member is 'on call' person for emergencies
								// 'on call' only applies to 1 IT person and 1 Vet								
								if (((StaffMedicalVet) st).isVetOnCall == true) {
									stDetails.append(" (ON CALL)");
								}								
								medicalVetList.add(stDetails.toString());
							} else if (st instanceof StaffMedicalVetTrainee) {
								medicalVetTraineeList.add(stDetails.toString());
							}
						}
						
						System.out.println("\r\n*** MEDICAL STAFF ***\r\n");
						
						System.out.println("\r\n*** List of Vets ***\r\n");
						for (String str : medicalVetList) {
							System.out.println(str);
						}						
						System.out.println("\r\n*** List of Nurses ***\r\n");
						for (String str : medicalNurseList) {
							System.out.println(str);
						}						
						System.out.println("\r\n*** List of Vet Trainees ***\r\n");
						for (String str : medicalVetTraineeList) {
							System.out.println(str);
						}	
						System.out.println("\r\n------\r\n");
						
						System.out.println("\r\n*** ADMIN STAFF ***\r\n");	
						
						System.out.println("\r\n*** List of IT Technicians ***\r\n");
						for (String str : adminITNerdList) {
							System.out.println(str);
						}
						System.out.println("\r\n*** List of Receptionist ***\r\n");
						for (String str : adminReceptionistList) {
							System.out.println(str);
						}
						System.out.println("\r\n*DONE!*\r\n");
						break;
						
					case 3: // List Admin staff by task
						
						ArrayList<StaffAdmin> adminStaff = new ArrayList<StaffAdmin>();
						Map<String, String> adminTasks = new HashMap<String, String>();
						
						// Scanning queue to retrieve existing admin tasks as key values of Maps
						// Tasks are auto-generated, so we do not know in advance which tasks are available
						for(Staff st: staff){
							if(st instanceof StaffAdmin) {
								adminStaff.add((StaffAdmin) st);
								String currentTask = ((StaffAdmin) st).getAdminTask();
								adminTasks.put(currentTask, null);
							}
						}
						// REF. https://stackoverflow.com/questions/10462819/get-keys-from-hashmap-in-java
						for ( String keyTask : adminTasks.keySet() ) {
						    System.out.println( "Currently working on: " + keyTask + "\r\n");
						    for(StaffAdmin stAdm: adminStaff){
						    	if (stAdm.getAdminTask() == keyTask) {
						    		System.out.println("Staff ID " + stAdm.getEmployeeId() + ": "
									+ ((stAdm.getTitle() != null) ? stAdm.getTitle() : "") + stAdm.getFirstName() + " "
									+ stAdm.getSecondName());
						    	}
						    }
						    System.out.println("------");
						}
						System.out.println("\r\n*DONE!*\r\n");
						//System.out.println(adminTasks.toString());
						break;	
					case 4: // Search member of staff by name
						break;								
					default: break;
				}
			}
			
			// PETS Queries
			if(option == 2) { 
				switch (secondaryOption) {
					case 1: // List all animals
						for(Animal anm: animals){
							System.out.println("Pet name: "+ anm.getPetName() + " (" +
									anm.getAnimalType() + "), " + anm.getAge() + " years old");
						}
						System.out.println("\r\nCount of animals: "+animals.size()+" animals\r\n");
						System.out.println("\r\n*DONE!*\r\n");
						break;
						
					case 2: // List animals by type
						ArrayList<String> cats = new ArrayList<String>();
						ArrayList<String> dogs = new ArrayList<String>();
						ArrayList<String> horses = new ArrayList<String>();
						ArrayList<String> pythons = new ArrayList<String>();
						
						for(Animal anm: animals){
							
							String anmDetails = ("Pet name: "+ anm.getPetName() + " (" +
									anm.getAnimalType() + "), " + anm.getAge() + " years old");
							
							if (anm instanceof AnimalCat) {
								cats.add(anmDetails);
							} else if (anm instanceof AnimalDog) {
								dogs.add(anmDetails);
							} else if (anm instanceof AnimalHorse) {
								horses.add(anmDetails);
							} else if (anm instanceof AnimalPython) {							
								pythons.add(anmDetails);
							}
						}
						
						System.out.println("\r\n*** List of Cats ***\r\n");
						for (String str : cats) {
							System.out.println(str);
						}						
						System.out.println("\r\n*** List of Dogs ***\r\n");
						for (String str : dogs) {
							System.out.println(str);
						}						
						System.out.println("\r\n*** List of Horses ***\r\n");
						for (String str : horses) {
							System.out.println(str);
						}	
						System.out.println("\r\n*** List of Pythons ***\r\n");
						for (String str : pythons) {
							System.out.println(str);
						}	
						System.out.println("\r\n*DONE!*\r\n");
						break;						
						
					case 3: // Search for pet by name
						break;								
					default: break;
				}
			}
			
			// QUEUE MANAGEMENT Queries
			if(option == 3) { 
				switch (secondaryOption) {
					case 1: // List all the animals assigned to individual medical staff member
						for(StaffMedical stMed: medicalStaff){
							
							Deque<Animal> animalQ = stMed.getAnimalQ();
							
							String staffDetails = ("Staff ID " + stMed.getEmployeeId() + ": "
									+ ((stMed.getTitle() != null) ? stMed.getTitle() : "") + stMed.getFirstName() + " "
									+ stMed.getSecondName() + "\r\n");
							String staffSpecialty = (stMed.getRole() + " specialized in: " + (stMed.isSmallAnimalsOnly() ? "small only" : "small or big")
									+ " and " + (stMed.isTrainedForExoticPets() ? "exotic or native" : "native only")
									+ " animals\r\n");							
							System.out.println(staffDetails + staffSpecialty + "\r\n" + stMed.getFirstName() +
									"'s QUEUE:\r\n");
							for(Animal anm: animalQ) {
								System.out.println("Pet name: "+ anm.getPetName() + " (" +
										anm.getAnimalType() + "), " + anm.getAge() + " y.o. Condition: " + anm.getMedicalCondition());								
							}							
							System.out.println("\r\n------\r\n");
						}
						System.out.println("\r\n*DONE!*\r\n");
						break;
					case 2: // List queue order by individual medical staff member
						break;
					case 3: // Move to next pet in queue for individual medical staff member
						break;	
					case 4: // BONUS! Show count of pets in queue for all medical staff
						for(StaffMedical stMed: medicalStaff){
							
							Deque<Animal> animalQ = stMed.getAnimalQ();
							int animalCountInQ = 0;
							for(Animal anm: animalQ) {
								animalCountInQ += 1;								
							}
							
							String staffDetails = ("Staff ID " + stMed.getEmployeeId() + ": "
									+ ((stMed.getTitle() != null) ? stMed.getTitle() : "") + stMed.getFirstName() + " "
									+ stMed.getSecondName() + "\r\n");
							String staffSpecialty = (stMed.getRole() + " specialized in: " + (stMed.isSmallAnimalsOnly() ? "small only" : "small or big")
									+ " and " + (stMed.isTrainedForExoticPets() ? "exotic or native" : "native only")
									+ " animals\r\n");							
							System.out.println(staffDetails + staffSpecialty + "\r\n" + stMed.getFirstName() +
									"'s QUEUE: " + animalCountInQ + " animals");							
							System.out.println("\r\n------\r\n");
						}
						System.out.println("\r\n*DONE!*\r\n");						
						break;								
					default: break;
				}
			}					
		}
		
	}
	
	public int readingUser() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String optionString = null;
		int option = -1; 
		
		try {
			optionString = br.readLine();
			option = Integer.parseInt(optionString); 
			 
		} catch (IOException | NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("That's not a valid option, please type 0-9");
		}
		
		return option;
	}
	
	public boolean validOptionMain(int option) {
		return option >= 0 && option <= menuMainOptions.length;
	}

}
