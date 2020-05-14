package vetclinic;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
		
		new Menu();
		/*
		 * Below parameters can be defined in Menu.java lines 63-66:
		 * 
		 * adminStaffCount => total number of admin staff members that need to be auto-generated
		 * medicalStaffCount => total number of medical staff members that need to be auto-generated
		 * vetStaffCount => total number of vet doctors that need to be auto-generated (sub-group of medicalStaffCount)
		 * animalTotalCount => total number of animals that need to be auto-generated
		 * 
		 * NOTE! User will not be able to manipulate the above values via CLI, but
		 * custom exception is thrown if an invalid param value is provided in code, e.g.:
		 * - if vetStaffCount<5 (min requirement as per specs)
		 * - if vetStaffCount > (medicalStaffCount - numberOfAvailableMedicalCategories)
		 */	
		
	}	

}
