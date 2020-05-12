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
		
		// About listiterator REF. https://beginnersbook.com/2014/06/listiterator-in-java-with-examples/
		// OR https://stackoverflow.com/questions/2772836/iterator-has-next-is-there-a-way-to-get-the-previous-element-instead-of-the/2773346
		ListIterator<StaffMedical> itrMed = medicalStaff.listIterator();
		ListIterator<Animal> itrPets = animals.listIterator();
		
		while (itrPets.hasNext()) {
				
			
			//Animal nextPetInQ = itrPets.next();
			StaffMedical medAssignee;
			
			// Go through all med staff forward
			while (itrMed.hasNext()) {
				// Only execute if there are pets to be assigned
				if (itrPets.hasNext() == true) {
					medAssignee = itrMed.next();
					medAssignee.addToQ(itrPets.next());
					
					//System.out.println(nextPetInQ.toString()); //<= TEST POINT
					System.out.println("NEXT"); //<= TEST POINT
					//System.out.println(nextMedAssignee); //<= TEST POINT
				} else {
					break;
				}
			} 
			// Go through all med staff backward
			while (itrMed.hasPrevious()) {
				// Only execute if there are pets to be assigned
				if (itrPets.hasNext() == true) {
					medAssignee = itrMed.previous();
					medAssignee.addToQ(itrPets.next());
					
					System.out.println("PREVIOUS"); //<= TEST POINT
					//System.out.println(nextMedAssignee); //<= TEST POINT
				} else {
					break;
				}
			}
		}
		
	}
	
}
