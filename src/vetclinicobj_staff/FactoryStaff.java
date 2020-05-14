package vetclinicobj_staff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Random;

import vetclinic.Throwable;
import vetclinicabstract.Staff;
import vetclinicabstract.StaffAdmin;
import vetclinicabstract.StaffMedical;

public class FactoryStaff {

	/*
	 * --SPECS FROM CA DESCRIPTOR--
	 * 
	 * - At least 10 Admin staff or various types (they cannot all be the same
	 * type). There must be at least 2 different types of Admin staff. 
	 * 
	 * - At least 30 Medical staff of various types (there must be 5 Vets, and as above, the 30
	 * cannot all be the same type). There must be at least 3 different types of
	 * Medical staff.
	 */
	
	// DEFAULT MIN VALUES AS PER ASSIGNMENT
	//	public int adminStaffCount; // = 10; // min requirement from CA specs
	//	public int medicalStaffCount; // = 30; // min requirement from CA specs
	//	public int vetStaffCount; // = 5; // min requirement from CA specs, sub-group of 'medicalStaff'
	
	private int yearClinicFoundation = 2000;
	private int currentYear = Calendar.getInstance().get(Calendar.YEAR); // REF. https://stackoverflow.com/questions/136419/get-integer-value-of-the-current-year-in-java
	private int maxYearsAsTraineeOrLocum = 2;	

	public int staffCount; // = adminStaffCount + medicalStaffCount;
	
	public ArrayList<Staff> staff = new ArrayList<Staff>();
	public LinkedList<StaffMedical> medicalStaff = new LinkedList<StaffMedical>();

	public ArrayList<Staff> getStaff() {
		return staff;
	}	
	public int getstaffCount() {
		return staffCount;
	}
	public LinkedList<StaffMedical> getMedicalStaff() {
		for (Staff st : staff) {
			if (st instanceof StaffMedical) {
				medicalStaff.add((StaffMedical) st);
			}
		}
		return medicalStaff;
	}
	
	public FactoryStaff(int adminStaffCount, int medicalStaffCount, int vetStaffCount) throws IOException {
		Throwable throwable = new Throwable();
		throwable.checkEligibilty(medicalStaffCount, vetStaffCount);
		
		if (vetStaffCount > medicalStaffCount) {
			//vet is a sub-group of medical staff and we cannot have more vets than medical staff
			System.out.println("[INTERNAL WARNING] vetStaffCount is a sub-group of medicalStaffCount. vetStaffCount cannot be bigger than medicalStaffCount.");
			return;
		} else if (vetStaffCount < 5) { 
			System.out.println("[INTERNAL WARNING] We need at least 5 Vets.");
			throwable.checkMinVet(vetStaffCount);
			return;		
		} else {
			
			staffCount = adminStaffCount + medicalStaffCount;
			// System.out.println("total employees: " + staffCount); //<= TEST POINT: total number of employees
			
			Random r = new Random();
			
			// generating vets
			boolean isNotSurgeon = false;
			boolean isLocum = false;
			boolean isNotVetOnCall = false;
			
			for (int i = 0; i < vetStaffCount; i++) {
				StaffMedicalVet vet = new StaffMedicalVet();
			
				if (!isNotSurgeon) {
					vet.isSurgeon = true;					
					if (!isLocum) {		
						vet.isSurgeon = true; // We need at least 1 FTE surgeon on call in the clinic
						vet.setQualificationLevel(6);
						vet.setRole("Vet Surgeon");
						vet.isLocum = false;
						if (!isNotVetOnCall) {
							vet.isVetOnCall = true;
							isNotVetOnCall = true; // we only need 1 vet to be 'on call'
						} else {
							vet.isVetOnCall = false;
						}
					} else {
						vet.setQualificationLevel(7);
						vet.setRole("Vet Locum");
						vet.isLocum = true;
					}
					
				} else {
					vet.isSurgeon = false;				
				}
				
				staff.add(vet);
				
				isNotSurgeon = r.nextBoolean(); // REF. https://stackoverflow.com/questions/8878015/return-true-or-false-randomly
				isLocum = r.nextBoolean();				
				//System.out.println(vet.toString()); //<= TEST POINT
			}
			
			// generating trainees and nurses
			boolean isTrainee = false;
			for (int i = 0; i < (medicalStaffCount - vetStaffCount); i++) {
				
				if (!isTrainee) {
					StaffMedicalNurse nurse = new StaffMedicalNurse();
					staff.add(nurse);			
					
				} else {
					StaffMedicalVetTrainee vetTrainee = new StaffMedicalVetTrainee();
					staff.add(vetTrainee);
				}	
				isTrainee = r.nextBoolean(); // REF. https://stackoverflow.com/questions/8878015/return-true-or-false-randomly
			}
	
			// generating admin staff (it nerds or receptionists)
			boolean isReceptionist = false;
			for (int i = 0; i < adminStaffCount; i++) {
				
				if (!isReceptionist) {
					StaffAdminITNerd itNerd = new StaffAdminITNerd();
					staff.add(itNerd);			
					
				} else {
					StaffAdminReceptionist receptionist = new StaffAdminReceptionist();
					staff.add(receptionist);
				}	
				isReceptionist = r.nextBoolean(); // REF. https://stackoverflow.com/questions/8878015/return-true-or-false-randomly
			}
		}
		
		// Assigns staff members with random names
		staffFullNamesRndGen();
		
		// Generates all other generic staff details for each staff member
		genericStaffDetailsGen();
		
		// Generates remaining attributes for admin staff
		adminStaffRndGen();
		
	}
	

	// NOTE: SET text encoding in Eclipse to UTF-8 for the proper experience
	// REF. https://stackoverflow.com/questions/33991916/eclipe-handling-accents-in-java-file
	private void staffFullNamesRndGen() throws IOException {
		
		// System.out.println(staffCount); //<= TEST POINT
		// String[] staffFullNames = new String[staffCount];

		// Reading files with random names and surnames
		String fileName = "src/NameRandom.txt";
		String fileSurname = "src/SurnameRandom.txt";
		BufferedReader inName = new BufferedReader(new FileReader(fileName));
		BufferedReader inSurname = new BufferedReader(new FileReader(fileSurname));
		
		ArrayList<String> firstNames = new ArrayList<String>();
		ArrayList<String> secondNames = new ArrayList<String>();
		
		String lineName = inName.readLine();
		String lineSurname = inSurname.readLine();
		
		while (lineName != null) {	
			firstNames.add(lineName); // populating array list of first names from file
			lineName = inName.readLine();
		}
		
		inName.close(); // REF. https://stackoverflow.com/questions/12519335/resource-leak-in-is-never-closed

		while (lineSurname != null) {	
			secondNames.add(lineSurname); // populating array list of second names from file
			lineSurname = inSurname.readLine();
		}
		
		inSurname.close(); // REF. https://stackoverflow.com/questions/12519335/resource-leak-in-is-never-closed
		
		// REF. https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values
		Random r = new Random();
		
		for (int i = 0; i < staff.size(); i++) {
			int rndIndex1 = r.nextInt(firstNames.size());
			int rndIndex2 = r.nextInt(secondNames.size());
			Staff staffMember = staff.get(i);
			staffMember.setFirstName(firstNames.get(rndIndex1));
			staffMember.setSecondName(secondNames.get(rndIndex2));
			// System.out.println(i + ") " + staffFullName); //<= TEST POINT
			// System.out.println((i+1) + ")\n" + staffMember.toString()); //<= TEST POINT
		}
		
		// System.out.println(staffFullNames); //<= TEST POINT
		// return staffFullNames;
		
	}
	
	// This methods sets all the generic attributes that apply to all employees
	private void genericStaffDetailsGen() {
		
		Random r = new Random();
		
		boolean handlesSmallAnimalsOnly = false;	
		boolean handlesNotExoticPetsOnly = false;			
		
		for (int i = 0; i < staff.size(); i++) {
			
			Staff staffMember = staff.get(i);
			int yearJoinedRdm = 0;
			
			// setYearsOfService
			
			if (staffMember instanceof StaffMedicalVetTrainee || staffMember.getRole() == "Vet Locum") {
				// condition can also be written as
				// if (staffMember.getQualificationLevel() == 1 || staffMember.getQualificationLevel() == 7)
				// trainees and locum vets can't be in their position for more than a certain amount of years
				// about 'instanceof' REF.: https://www.javatpoint.com/downcasting-with-instanceof-operator
				yearJoinedRdm = currentYear - r.nextInt(maxYearsAsTraineeOrLocum);			
			} else {
				yearJoinedRdm = yearClinicFoundation + r.nextInt(currentYear - yearClinicFoundation);
			}
			
			staffMember.setYearsOfService(yearJoinedRdm);
			
			// setEmployeeId
			staffMember.setEmployeeId(staffMember.genId(staffMember.getStaffType(), (yearJoinedRdm - 2000), staffMember.getSecondName(), (i+1)));

			// setSalary
			staffMember.setSalary(staffMember.salaryCalculator(staffMember.genSalaryLevel(staffMember.getYearsOfService(), staffMember.getQualificationLevel())));

			// set Medical Staff attributes		
			
			if (staffMember instanceof StaffMedical) { 
			// condition can also be written as	
			// if (staffMember.getStaffType() == 'M')
				
				// first assignment
				// we need to make sure that we have at least a vet able to take care of all animals
				((StaffMedical) staffMember).isSmallAnimalsOnly = handlesSmallAnimalsOnly;
				((StaffMedical) staffMember).isTrainedForExoticPets = !handlesNotExoticPetsOnly;	
				
				handlesSmallAnimalsOnly = r.nextBoolean();
				handlesNotExoticPetsOnly = r.nextBoolean();
				
				// who handles exotic pets should also handle big animals
				// (most exotic animals would be of large size)
				if (((StaffMedical) staffMember).isTrainedForExoticPets) {
					((StaffMedical) staffMember).isSmallAnimalsOnly = false; 
				}
			}
			
			// System.out.println((i+1) + ")\n" + staffMember.toString()); //<= TEST POINT
			
		}
		
	}
	
	
	private void adminStaffRndGen() throws IOException {

		// Reading files with random names and surnames
		String adminTasksFile = "src/AdminTaskRandom.txt";
		String itTasksFile = "src/ITTaskRandom.txt";
		BufferedReader inAdminTasks = new BufferedReader(new FileReader(adminTasksFile));
		BufferedReader inITTasks = new BufferedReader(new FileReader(itTasksFile));
		
		ArrayList<String> adminTasks = new ArrayList<String>();
		ArrayList<String> itTasks = new ArrayList<String>();
		
		String lineAdminTasks = inAdminTasks.readLine();
		String lineITTasks = inITTasks.readLine();
		
		while (lineAdminTasks != null) {	
			adminTasks.add(lineAdminTasks); // populating array list of first names from file
			lineAdminTasks = inAdminTasks.readLine();
		}
		
		inAdminTasks.close(); // REF. https://stackoverflow.com/questions/12519335/resource-leak-in-is-never-closed

		while (lineITTasks != null) {	
			itTasks.add(lineITTasks); // populating array list of second names from file
			lineITTasks = inITTasks.readLine();
		}
		
		inITTasks.close(); // REF. https://stackoverflow.com/questions/12519335/resource-leak-in-is-never-closed
		
		// REF. https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values
		Random r = new Random();
		boolean itNotOnCall = false;
		
		for (int i = 0; i < staff.size(); i++) {
			
			Staff staffMember = staff.get(i);
			if (staffMember instanceof StaffAdminReceptionist) { 
				
				int rndIndex = r.nextInt(adminTasks.size());		
				((StaffAdmin) staffMember).setAdminTask(adminTasks.get(rndIndex));

			} else if (staffMember instanceof StaffAdminITNerd) {
				
				int rndIndex = r.nextInt(itTasks.size());
				((StaffAdmin) staffMember).setAdminTask(itTasks.get(rndIndex));	
				
				if (!itNotOnCall) {
					((StaffAdminITNerd) staffMember).setITOnCall(true);
					itNotOnCall = true; // we only need 1 IT person to be 'on call'
				} else {
					((StaffAdminITNerd) staffMember).setITOnCall(false);
				}
				
			}
			
			//System.out.println((i+1) + ")\n" + staffMember.toString()); //<= TEST POINT
		}
		
	}
	
	@Override
	public String toString() {
		
		// REF. https://stackoverflow.com/questions/40961590/how-to-use-a-loop-in-a-tostring
		StringBuilder result = new StringBuilder();
		
		result.append("[Total staff: " + staffCount + " employees\n");
		
		for (Staff st : staff) {
			result.append(st.toString() + "\n");
		}
			
		result.append("]\n");
		
		return result.toString();
	}

	
}
