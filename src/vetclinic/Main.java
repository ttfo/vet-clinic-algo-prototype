package vetclinic;

import java.io.IOException;

import vetclinicobj_animals.FactoryAnimal;
import vetclinicobj_staff.FactoryStaff;

public class Main {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
		
		// Creates array list of 'staff' objects with variable numbers of admin/ medical and vet staff members
		// Values passed as params represent the min requirement as for the specs in CA
		// However bigger values are also supported, e.g. (40, 60, 10)
		FactoryStaff factoryStaff = new FactoryStaff(10, 30, 5); 
		
		// Creates 'animal' objects
		FactoryAnimal factoryAnimal = new FactoryAnimal(1000); 
		
	}

}
