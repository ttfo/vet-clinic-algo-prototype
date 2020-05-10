package vetclinic;

import java.io.IOException;

import vetclinicobj_staff.FactoryStaff;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Creates array list of 'staff' objects with variable numbers of admin/ medical and vet staff members
		FactoryStaff factoryStaff = new FactoryStaff(10, 30, 5); 
		
		// Assigns staff members with random names
		factoryStaff.staffFullNamesRndGen();
		factoryStaff.genericStaffDetailsGen();
		
	}

}
