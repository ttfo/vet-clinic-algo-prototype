package vetclinic;

import java.io.IOException;
import java.util.ArrayList;

import vetclinicabstract.Animal;
import vetclinicabstract.Staff;
import vetclinicobj_animals.FactoryAnimal;
import vetclinicobj_staff.FactoryStaff;

public class Main {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
		
		/*
		 * Creates array list of 'staff' objects with variable numbers of admin/ medical and vet staff members
		 * Values passed as params represent the min requirement as for the specs in CA
		 * However bigger values are also supported, e.g. (40, 60, 10)
		 */		
		FactoryStaff factoryStaff = new FactoryStaff(10, 30, 5);
		// Returning array list with staff members
		ArrayList<Staff> staff = factoryStaff.getStaff();
		System.out.println(factoryStaff.toString()); //<= TEST POINT
		
		
		/*
		 * Creates 'animal' objects with a param that allows to determine overall number of animals
		 * 1000 animals is the min requirement as per CA specs
		 */		
		FactoryAnimal factoryAnimal = new FactoryAnimal(1000);
		ArrayList<Animal> animal = factoryAnimal.getAnimals();
		System.out.println(factoryAnimal.toString()); //<= TEST POINT
		
		/*
		 * CA SPECS - Once all the entities have been created, the system should assign EACH animal
		 * to a member of medical staff (for treatment). This means you need some way of
		 * knowing which Medical Staff member is assigned to which animal.
		 */
		
	}

}
