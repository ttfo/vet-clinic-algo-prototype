package vetclinic;

import java.util.LinkedList;
import java.util.ListIterator;

import vetclinicabstract.Animal;
import vetclinicabstract.StaffMedical;

public class QueueSystem {
	
//	protected LinkedList<StaffMedical> medicalStaffWithQ;
//	protected LinkedList<Animal> animals;


	public QueueSystem(LinkedList<StaffMedical> medicalStaff, LinkedList<Animal> animals) {
		
		// System.out.println(animals.toString()); //<= TEST POINT
		
		// Lists of medical members by specialty
		LinkedList<StaffMedical> medicalStaffExotic = new LinkedList<StaffMedical>();
		LinkedList<StaffMedical> medicalStaffNonExotic = new LinkedList<StaffMedical>();
		LinkedList<StaffMedical> medicalStaffBigAnimals = new LinkedList<StaffMedical>();
		LinkedList<StaffMedical> medicalStaffNonBigAnimals = new LinkedList<StaffMedical>();
		
		// Populating lists
		for (StaffMedical st : medicalStaff) {
			if (st.isTrainedForExoticPets) {
				medicalStaffExotic.add(st);
			}
			if (!st.isTrainedForExoticPets) {
				medicalStaffNonExotic.add(st);
			}
			if (!st.isSmallAnimalsOnly) {
				medicalStaffBigAnimals.add(st);
			}
			if (st.isSmallAnimalsOnly) {
				medicalStaffNonBigAnimals.add(st);
			}			
		}
		
		// Lists of animals by size and origin
		LinkedList<Animal> animalExotic = new LinkedList<Animal>();
		LinkedList<Animal> animalBig = new LinkedList<Animal>();
		LinkedList<Animal> animalNotBigNotExotic = new LinkedList<Animal>();
		
		// Populating lists
		for (Animal an : animals) {
			// If exotic animal, needs to go into 'exotic' list for assignment
			if (an.getAnimalOrigin() == "exotic") {
				animalExotic.add(an);
			}
			// If non-exotic animal, check size
			if ((an.getAnimalOrigin() != "exotic")&&(an.getAnimalSize() == "big")) {
				animalBig.add(an);
			}
			if ((an.getAnimalOrigin() != "exotic")&&(an.getAnimalSize() != "big")) {
				animalNotBigNotExotic.add(an);
			}
		}
		
		/*
		 * Assignment of all animals to medical staff, based on animal origin and size.
		 * This should give a more realistic representation of a vet clinic, where certain
		 * staff members would be qualified to deal with certain types of animals only
		 * and not all staff members have an equal amount of animals in queue.
		 */
		
		// Assign exotic animals (e.g. pythons) to staff who is qualified to deal with them
		coreQFunctionality(animalExotic,medicalStaffExotic);
		// Assign big animals (e.g. horses) to staff who is qualified to deal with them
		coreQFunctionality(animalBig,medicalStaffBigAnimals);
		// Assign all other animals (e.g. dogs or cats) to staff in full rotation
		coreQFunctionality(animalNotBigNotExotic,medicalStaff);
		
	}
	
	
	private void coreQFunctionality(LinkedList<Animal> llAn, LinkedList<StaffMedical> llSMed) {
		
		// About listiterator REF. https://beginnersbook.com/2014/06/listiterator-in-java-with-examples/
		// OR https://stackoverflow.com/questions/2772836/iterator-has-next-is-there-a-way-to-get-the-previous-element-instead-of-the/2773346
		
		ListIterator<Animal> itrPets = llAn.listIterator();
		ListIterator<StaffMedical> itrMed = llSMed.listIterator();
		
		// Core functionality
		while (itrPets.hasNext()) {
				
			
			//Animal nextPetInQ = itrPets.next();
			StaffMedical medAssignee;
			
			// Scans all med staff forward
			while (itrMed.hasNext()) {
				// Only execute if there are pets to be assigned
				if (itrPets.hasNext() == true) {
					
					medAssignee = itrMed.next();
					medAssignee.addToQ(itrPets.next());
					
					//System.out.println(nextPetInQ.toString()); //<= TEST POINT
					//System.out.println("NEXT"); //<= TEST POINT
					//System.out.println(nextMedAssignee); //<= TEST POINT
				} else {
					break;
				}
			} 
			// Scans all all med staff backward
			while (itrMed.hasPrevious()) {
				// Only execute if there are pets to be assigned
				if (itrPets.hasNext() == true) {
					medAssignee = itrMed.previous();
					medAssignee.addToQ(itrPets.next());
					
					//System.out.println("PREVIOUS"); //<= TEST POINT
					//System.out.println(nextMedAssignee); //<= TEST POINT
				} else {
					break;
				}
			}
		}		
	}
	
	
}
