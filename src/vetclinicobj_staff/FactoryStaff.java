package vetclinicobj_staff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import vetclinicabstract.Staff;
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
	public int adminStaffCount; // = 10; // min requirement from CA specs
	public int medicalStaffCount; // = 30; // min requirement from CA specs
	public int vetStaffCount; // = 5; // min requirement from CA specs, sub-group of 'medicalStaff'
	public int staffCount; // = adminStaffCount + medicalStaffCount;
	public int yearClinicFoundation = 2000;
	public int currentYear = Calendar.getInstance().get(Calendar.YEAR); // REF. https://stackoverflow.com/questions/136419/get-integer-value-of-the-current-year-in-java
	public int maxYearsAsTraineeOrLocum = 2;	
	
	ArrayList<Staff> staff = new ArrayList<Staff>();
	
	public FactoryStaff(int adminStaffCount, int medicalStaffCount, int vetStaffCount) throws IOException {
		
		if (vetStaffCount > medicalStaffCount) {
			// TODO throw an exception; vet is a sub-group of medical staff and we cannot have more vets than medical staff
			return;
		} else if (vetStaffCount < 5) { 
			// TODO throw an exception; clinic MUST have at least 5 vets
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
				vet.setStaffType('M');
				vet.setTitle("Dr."); // REF https://www.thejournal.ie/ireland-doctors-vets-new-animals-2696672-Apr2016/
				
				if (!isNotSurgeon) {
					vet.isSurgeon = true;					
					if (!isLocum) {		
						vet.isSurgeon = true; // We need at least 1 FTE surgeon on call in the clinic
						vet.setQualificationLevel(6);
						vet.setRole("Vet Surgeon");
						vet.isLocum = false;
						if (!isNotVetOnCall) {
							vet.isVetOnCall = true;
						} else {
							isNotVetOnCall = true; // we only need 1 vet to be 'on call'
							vet.isVetOnCall = false;
						}
					} else {
						vet.setQualificationLevel(7);
						vet.setRole("Vet Locum");
						vet.isLocum = true;
					}
					
				} else {
					vet.isSurgeon = false;
					vet.setQualificationLevel(5);
					vet.setRole("Vet Physician");					
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
					nurse.setStaffType('M');
					nurse.setQualificationLevel(3);
					nurse.setRole("Vet Nurse");
					staff.add(nurse);			
					
				} else {
					StaffMedicalVetTrainee vetTrainee = new StaffMedicalVetTrainee();
					vetTrainee.setStaffType('M');
					vetTrainee.setQualificationLevel(1);
					vetTrainee.setRole("Vet Trainee");
					staff.add(vetTrainee);
				}	
				isTrainee = r.nextBoolean(); // REF. https://stackoverflow.com/questions/8878015/return-true-or-false-randomly
			}
	
			// generating admin staff (it nerds or receptionists)
			boolean isReceptionist = false;
			for (int i = 0; i < adminStaffCount; i++) {
				
				if (!isReceptionist) {
					StaffAdminITNerd itNerd = new StaffAdminITNerd();
					itNerd.setStaffType('A');
					itNerd.setQualificationLevel(4);
					itNerd.setRole("IT Technician");
					itNerd.setTitle("Eng.");
					staff.add(itNerd);			
					
				} else {
					StaffAdminReceptionist receptionist = new StaffAdminReceptionist();
					receptionist.setStaffType('A');
					receptionist.setQualificationLevel(2);
					receptionist.setRole("Receptionist");
					staff.add(receptionist);
				}	
				isReceptionist = r.nextBoolean(); // REF. https://stackoverflow.com/questions/8878015/return-true-or-false-randomly
			}
		}
		
		// Assigns staff members with random names
		staffFullNamesRndGen();
		
		// Generate all other staff details for each staff member
		genericStaffDetailsGen();
		
	}
	

	// NOTE: SET text encoding in Eclipse to UTF-8 for the proper experience
	// REF. https://stackoverflow.com/questions/33991916/eclipe-handling-accents-in-java-file
	public void staffFullNamesRndGen() throws IOException {
		
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
	public void genericStaffDetailsGen() {
		
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
				((StaffMedical) staffMember).isSmallAnimalsOnly = handlesSmallAnimalsOnly;
				((StaffMedical) staffMember).isTrainedForExoticPets = !handlesNotExoticPetsOnly;				
				handlesSmallAnimalsOnly = r.nextBoolean();
				handlesNotExoticPetsOnly = r.nextBoolean();
			}
			
			System.out.println((i+1) + ")\n" + staffMember.toString()); //<= TEST POINT
			
		}
		
	}

	
}
