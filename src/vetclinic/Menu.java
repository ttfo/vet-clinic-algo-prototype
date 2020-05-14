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
	
	int adminStaffCount = 10; // 10 is the min requirement as per CA specs
	int medicalStaffCount = 30; // 30 is the min requirement as per CA specs
	int vetStaffCount = 5; // 5 is min requirement as per CA specs
	int animalTotalCount = 1000; // 1000 is min requirement as per CA specs
	
	/*
	 * Creates array list of 'staff' objects with variable numbers of admin/ medical and vet staff members.
	 * Values passed as params (10, 30, 5) represent the min requirement as for the specs in CA,
	 * however bigger values are also supported, e.g. (40, 60, 10)
	 */
	FactoryStaff factoryStaff = new FactoryStaff(adminStaffCount, medicalStaffCount, vetStaffCount);
	
	// Returning array list with staff members
	ArrayList<Staff> staff = factoryStaff.getStaff();
	LinkedList<StaffMedical> medicalStaff = factoryStaff.getMedicalStaff();
	// System.out.println(staff.toString()); //<= TEST POINT
	// System.out.println(medicalStaff.toString()); //<= TEST POINT
	
	
	/*
	 * Creates 'animal' objects with a param that allows to determine overall number of animals
	 * 1000 animals is the min requirement as per CA specs
	 */		
	FactoryAnimal factoryAnimal = new FactoryAnimal(animalTotalCount);
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
		
		// Following structure is derived from 'Pizza' example done in Algo class (May 2020)
		
		Integer option = null;
		Integer secondaryOption;
		String searchBox;
		
		System.out.println(ASCIIArt);
		do {
			do {
				option = null; // resetting user input
				secondaryOption = null; // resetting user input
				searchBox = null; // resetting user input
				
				// Show main options and read user input
				mainMenuOptions();
				option = readingUser();
				
				if (validOption(option, secondaryOption) && option != 0) {
					
					secondaryMenuOptions(option);
					secondaryOption = readingUser();
					
					// If option is valid run selected query
					if (validOption(option, secondaryOption) && secondaryOption != 0) {
						
						//System.out.println("Selection #1 - " + option); //<=TEST POINT
						//System.out.println("Selection #2 - " + secondaryOption); //<=TEST POINT

						if ((option == 1 && secondaryOption == 4) || // Search member of staff by name
								(option == 2 && secondaryOption == 3) || // Search for pet by name
								(option == 3) && (secondaryOption == 2 || secondaryOption == 3)) {
							// OPTIONS: List queue order by individual medical staff member
							// & Move to next pet in queue for individual medical staff member
							
							if (option == 1 && secondaryOption == 4) {
								System.out.println("[ENTER STAFF MEMBER'S FIRST NAME BELOW]");
							}
							
							if (option == 2 && secondaryOption == 3) {
								System.out.println("[ENTER PET NAME BELOW]");
							}
							
							if (option == 3 && secondaryOption == 2) {
								System.out.println("[ENTER MEDICAL STAFF MEMBER NAME BELOW]");
								System.out.println("Note: we'll look up  for a match with either name or surname");
							}
							
							if (option == 3 && secondaryOption == 3) {
								System.out.println("[ENTER UNIQUE EMPLOYEE ID]");
								System.out.println("Note: this query only checks for exact matches");
							}							
							
							System.out.println("☟--Search Box--☟");
							searchBox = readingUser2();
							
							//System.out.println(searchBox); //<=TEST POINT
						}
						
						queryBuilder(option, secondaryOption, searchBox);
												

					} else {
						System.out.println("[WARNING] The option that you have selected does not exist.");
					}					
				}
				if (option > menuMainOptions.length) {
					System.out.println("[WARNING] The option that you have selected does not exist. Try again.");
				}
				
			} while (!validOption(option, secondaryOption) && option != 0);

		} while (option != 0); // EXIT app when input is 0
		
		// If option is 0 exit
		System.out.println("... Closing application ...");
		return;
		
	}
	
	
	public int readingUser() {
		// REF. https://stackoverflow.com/questions/5287538/how-to-get-the-user-input-in-java
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String optionString = null;
		int option = -1; 
		
		try {
			optionString = br.readLine();
			option = Integer.parseInt(optionString); 
			 
		} catch (IOException | NumberFormatException e) {
			System.out.println("[WARNING] Not a numeric value.");
		}
		
		return option;
	}
	

	public String readingUser2() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String optionString = null;
		
		try {
			optionString = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return optionString;
	}	
	
	
	public boolean validOption(Integer option, Integer secondaryOption) {
		
		// Need to use 'Integer' instead of 'int' to check if null
		// REF. https://stackoverflow.com/questions/13747859/how-to-check-if-an-int-is-a-null
		if (secondaryOption != null) {
			
			if (option == 1) { // STAFF Queries
				return secondaryOption >= 0 && secondaryOption <= menuSecondaryOptionsStaff.length;
			} 
			if (option == 2) { // PETS Queries
				return secondaryOption >= 0 && secondaryOption <= menuSecondaryOptionsPets.length;
			} 
			if (option == 3) { // QUEUE MANAGEMENT Queries
				return secondaryOption >= 0 && secondaryOption <= menuSecondaryOptionsQ.length;
			} 	
			
		} else {
			return option >= 0 && option <= menuMainOptions.length;
		}
		return false;
	}	

	
	public void mainMenuOptions() {
		System.out.println("\r\n***MAIN MENU***\r\n");
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
	        default: System.out.println("[WARNING] No such options. Please try again.\r\n"); 
	        		 break;
        }		
	}	
	
	
	public void queryBuilder(Integer option, Integer secondaryOption, String searchBox) {
		
		if(validOption(option, secondaryOption) && option != 0 && secondaryOption != 0) { // TODO Refine this condition
			
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
						
						int adminITNerdTOTPay = 0;
						int adminReceptionistTOTPay = 0;
						int medicalNurseTOTPay = 0;
						int medicalVetTOTPay = 0;
						int medicalVetTraineeTOTPay = 0;
						
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
								adminITNerdTOTPay += st.getSalary();
								
							} else if (st instanceof StaffAdminReceptionist) {
								adminReceptionistList.add(stDetails.toString());
								adminReceptionistTOTPay += st.getSalary();
								
							} else if (st instanceof StaffMedicalNurse) {
								medicalNurseList.add(stDetails.toString());
								medicalNurseTOTPay += st.getSalary();
								
							} else if (st instanceof StaffMedicalVet) {
								// show 'ON CALL' is the staff member is 'on call' person for emergencies
								// 'on call' only applies to 1 IT person and 1 Vet								
								if (((StaffMedicalVet) st).isVetOnCall == true) {
									stDetails.append(" (ON CALL)");
								}								
								medicalVetList.add(stDetails.toString());
								medicalVetTOTPay += st.getSalary();
								
							} else if (st instanceof StaffMedicalVetTrainee) {
								medicalVetTraineeList.add(stDetails.toString());
								medicalVetTraineeTOTPay += st.getSalary();
							}
							
						}
						
						int medicalTOTPay = medicalNurseTOTPay + medicalVetTOTPay + medicalVetTraineeTOTPay;
						int adminTOTPay = adminITNerdTOTPay + adminReceptionistTOTPay; 
						
						System.out.println("\r\n*** MEDICAL STAFF ***\r\n");
						System.out.println("Total number of Medical Staff: " + (medicalNurseList.size()+medicalVetList.size()+medicalVetTraineeList.size()) + ".");							
						System.out.println("AVG salary: " + (medicalTOTPay/(medicalNurseList.size()+medicalVetList.size()+medicalVetTraineeList.size())) + " EUR.\r\n");
						
						System.out.println("\r\n*** List of Vets ***\r\n");
						System.out.println("Total number of Vet Doctors: " + medicalVetList.size() + ".");						
						System.out.println("AVG salary: " + (medicalVetTOTPay/medicalVetList.size()) + " EUR.\r\n");
						
						for (String str : medicalVetList) {
							System.out.println(str);
						}	
						
						System.out.println("\r\n*** List of Nurses ***\r\n");
						System.out.println("Total number of Nurses: " + medicalNurseList.size() + ".");						
						System.out.println("AVG salary: " + (medicalNurseTOTPay/medicalNurseList.size()) + " EUR.\r\n");						
						
						for (String str : medicalNurseList) {
							System.out.println(str);
						}
						
						System.out.println("\r\n*** List of Vet Trainees ***\r\n");
						System.out.println("Total number of Vet Trainees: " + medicalVetTraineeList.size() + ".");						
						System.out.println("AVG salary: " + (medicalVetTraineeTOTPay/medicalVetTraineeList.size()) + " EUR.\r\n");						
						
						for (String str : medicalVetTraineeList) {
							System.out.println(str);
						}	
						System.out.println("\r\n------\r\n");
						
						System.out.println("\r\n*** ADMIN STAFF ***\r\n");	
						System.out.println("Total number of Admin Staff: " + (adminITNerdList.size()+adminReceptionistList.size()) + ".");							
						System.out.println("AVG salary: " + (adminTOTPay/(adminITNerdList.size()+adminReceptionistList.size())) + " EUR.\r\n");	
						
						System.out.println("\r\n*** List of IT Technicians ***\r\n");
						System.out.println("Total number of IT Technicians: " + (adminITNerdList.size()) + ".");							
						System.out.println("AVG salary: " + (adminITNerdTOTPay/adminITNerdList.size()) + " EUR.\r\n");	
						
						for (String str : adminITNerdList) {
							System.out.println(str);
						}
						
						System.out.println("\r\n*** List of Receptionist ***\r\n");
						System.out.println("Total number of Receptionists: " + (adminReceptionistList.size()) + ".");							
						System.out.println("AVG salary: " + (adminReceptionistTOTPay/adminReceptionistList.size()) + " EUR.\r\n");	
						
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
						ArrayList<String> nameMatch = new ArrayList<String>();
						for (Staff st : staff) {
							if (st.getFirstName().contains(searchBox)) {
								nameMatch.add("Staff ID: " + st.getEmployeeId() + ": " + st.getFirstName() + " " + st.getSecondName());
							}
						}
						if (nameMatch.size() == 0) {
							System.out.println("No employee of the clinic is called: "+searchBox+"!");
						} else {
							System.out.println(nameMatch.size()+" result"+((nameMatch.size() == 1) ? "": "s")+"!");
							System.out.println(nameMatch.toString());
						}
						System.out.println("\r\n*DONE!*\r\n");
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
						ArrayList<String> nameMatch = new ArrayList<String>();
						for (Animal anm : animals) {
							if (anm.getPetName().contains(searchBox)) {
								nameMatch.add(anm.getPetName() + " (" + anm.getAnimalType() + ", " + anm.getAge() + " y/o.)");
							}
						}
						if (nameMatch.size() == 0) {
							System.out.println("No registered pet called: "+searchBox+"!");
						} else {
							System.out.println(nameMatch.size()+" result"+((nameMatch.size() == 1) ? "": "s")+"!");
							System.out.println(nameMatch.toString());
						}
						System.out.println("\r\n*DONE!*\r\n");						
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
						ArrayList<StaffMedical> nameMatchMed = new ArrayList<StaffMedical>();
						for (StaffMedical medSt : medicalStaff) {
							if (medSt.getFirstName().contains(searchBox) || medSt.getSecondName().contains(searchBox)) {
								nameMatchMed.add(medSt);
							}
						}
						if (nameMatchMed.size() == 0) {
							System.out.println("No employee of the clinic is called: "+searchBox+"!");
						} else {
							for (StaffMedical stMed : nameMatchMed) {
								Deque<Animal> animalQ = stMed.getAnimalQ();
								
								String staffDetails = ("Staff ID " + stMed.getEmployeeId() + ": "
										+ ((stMed.getTitle() != null) ? stMed.getTitle() : "") + stMed.getFirstName() + " "
										+ stMed.getSecondName() + "\r\n");
								String staffSpecialty = (stMed.getRole() + " specialized in: " + (stMed.isSmallAnimalsOnly() ? "small only" : "small or big")
										+ " and " + (stMed.isTrainedForExoticPets() ? "exotic or native" : "native only")
										+ " animals\r\n");							
								System.out.println(staffDetails + staffSpecialty + "\r\n" + stMed.getFirstName() +
										"'s QUEUE:\r\n");
								int iQ = 1;
								for(Animal anm: animalQ) {
									System.out.println("QUEUE POSITION # " + iQ + " =>");
									System.out.println("Pet name: "+ anm.getPetName() + " (" +
											anm.getAnimalType() + "), " + anm.getAge() + " y.o. Condition: " + anm.getMedicalCondition());
									iQ++;
								}							
								System.out.println("\r\n------\r\n");
							}
						}
						System.out.println("\r\n*DONE!*\r\n");						
						break;
						
					case 3: // Move to next pet in queue for individual medical staff member
						ArrayList<StaffMedical> nameMatchMed2 = new ArrayList<StaffMedical>();
						for (StaffMedical medSt : medicalStaff) {
							if (medSt.getEmployeeId().contentEquals(searchBox)) {
								nameMatchMed2.add(medSt);
							}
						}
						if (nameMatchMed2.size() == 0) {
							System.out.println("We have no medical staff with Staff ID: "+searchBox+"!");
						} else {
							for (StaffMedical stMed : nameMatchMed2) {
								Deque<Animal> animalQ = stMed.getAnimalQ();
								
								// CURRENT QUEUE
								String staffDetails = ("Staff ID " + stMed.getEmployeeId() + ": "
										+ ((stMed.getTitle() != null) ? stMed.getTitle() : "") + stMed.getFirstName() + " "
										+ stMed.getSecondName() + "\r\n");								
								System.out.println(staffDetails + "\r\n" + stMed.getFirstName() +
										"'s OLD QUEUE:\r\n");	
								int iQ = 1;
								for(Animal anm: animalQ) {
									System.out.println("QUEUE POSITION # " + iQ + " =>");
									System.out.println("Pet name: "+ anm.getPetName() + " (" +
											anm.getAnimalType() + "), " + anm.getAge() + " y.o. Condition: " + anm.getMedicalCondition());
									iQ++;
								}		
								System.out.println("\r\n------\r\n");
								
								// UPDATED QUEUE
								
								animalQ.removeFirst();
								
								System.out.println(stMed.getFirstName() +
										"'s UPDATED QUEUE:\r\n");	
								int iQ2 = 1;
								for(Animal anm: animalQ) {
									System.out.println("QUEUE POSITION # " + iQ2 + " =>");
									System.out.println("Pet name: "+ anm.getPetName() + " (" +
											anm.getAnimalType() + "), " + anm.getAge() + " y.o. Condition: " + anm.getMedicalCondition());
									iQ2++;
								}	
							}
							System.out.println("\r\n------\r\n");
						}
						System.out.println("\r\n*DONE!*\r\n");							
						break;	
						
					case 4: // BONUS! Show count of pets in queue for all medical staff
						for(StaffMedical stMed: medicalStaff){
							
							Deque<Animal> animalQ = stMed.getAnimalQ();
							int animalCountInQ = animalQ.size();
							
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

}
