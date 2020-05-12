package vetclinic;

import java.util.LinkedList;
import java.util.ListIterator;

import vetclinicabstract.Animal;
import vetclinicabstract.StaffMedical;

public class QueueSystemTest {
	
	protected LinkedList<StaffMedical> medicalStaff;
	protected LinkedList<Animal> animals;
	
	public QueueSystemTest(LinkedList<StaffMedical> medicalStaff, LinkedList<Animal> animals) {
		
		// System.out.println(animals.toString()); //<= TEST POINT
		
		// About listiterator REF. https://beginnersbook.com/2014/06/listiterator-in-java-with-examples/
		// OR https://stackoverflow.com/questions/2772836/iterator-has-next-is-there-a-way-to-get-the-previous-element-instead-of-the/2773346
		ListIterator<StaffMedical> itrMed = medicalStaff.listIterator();
		ListIterator<Animal> itrPets = animals.listIterator();
		
		while (itrPets.hasNext()) {
				
			
			//Animal nextPetInQ = itrPets.next();
			StaffMedical medAssignee;
			
			Animal petInQ = itrPets.next();			
			
			// Go through all med staff forward
			while (itrMed.hasNext()) {

				
				// Only execute if there are pets to be assigned
				if (itrPets.hasNext() == true) {
					
					
					medAssignee = itrMed.next();
									
					//System.out.println(nextPetInQ.toString()); //<= TEST POINT
					//System.out.println("NEXT"); //<= TEST POINT
					//System.out.println(nextMedAssignee); //<= TEST POINT
						
					//If non-exotic animal assign to any staff
					if (petInQ.getAnimalOrigin() != "exotic") {			
						// If big animal assign to staff who is not limited to small animals
						if (petInQ.getAnimalSize() == "big") {
							// TODO
							
							medAssignee.addToQ(itrPets.next());	
							petInQ = itrPets.next();
						}
						
						// TODO Assign to any staff
					
					// If exotic animal assign to staff who deals with exotic animals
					} else if (petInQ.getAnimalOrigin() == "exotic") {
						
						// If big animal assign to staff who deals with exotic animals and is not limited to small animals
						if (petInQ.getAnimalSize() == "big") {
							// TODO
						}
						
						// TODO Assign to any staff who deals with exotic animals
						
					}					
					
				}
			} 
			// Go through all med staff backward
			while (itrMed.hasPrevious()) {
				// Only execute if there are pets to be assigned
				if (itrPets.hasNext() == true) {
					medAssignee = itrMed.previous();
					medAssignee.addToQ(itrPets.next());
					
					//System.out.println("PREVIOUS"); //<= TEST POINT
					//System.out.println(nextMedAssignee); //<= TEST POINT
				}
			}
		}
		
		System.out.println(medicalStaff.toString()); //<= TEST POINT
	}
	
	
//	public QueueSystem(LinkedList<StaffMedical> medicalStaff, LinkedList<Animal> animals) {
//		
//		Iterator<StaffMedical> itrMed = medicalStaff.iterator();
//		Iterator<Animal> itrPets = animals.iterator();
//		
//		while (itrPets.hasNext()) {
//			
//			// If there is no medical staff
//			if (medicalStaff.size() == 0) {
//				// TODO
//			} else {
//				
//				if (itrMed.hasNext()) {
//				StaffMedical nextMedStaff = itrMed.next();
//				Animal nextPetInQ = itrPets.next();
//				
//				nextMedStaff.addToQ(nextPetInQ); //<= TEST POINT
//				
//				System.out.println(nextPetInQ.toString()); //<= TEST POINT
//				System.out.println(nextMedStaff); //<= TEST POINT
//				}
//				System.out.println("Reset Iterator"); // <= TEST POINT
//				itrPets = animals.iterator();
//			}
//		}
//	}	
	
	
//	Iterator<StaffMedical> itrMed = medicalStaff.iterator();
//	Iterator<Animal> itrPets = animals.iterator();
//	
//	while (itrMed.hasNext()) {
//		
//		// If there are no animals
//		if (animals.size() == 0) {
//			// TODO
//		} else {
//			
//			StaffMedical nextMedStaff = itrMed.next();
//			Animal nextPetInQ = itrPets.next();
//			
//			nextMedStaff.addToQ(nextPetInQ); //<= TEST POINT
//			System.out.println(nextPetInQ.toString()); //<= TEST POINT
//			System.out.println(nextMedStaff); //<= TEST POINT
//		
//		}
//	}
	
	
//	for (int i=0; i < animal.size(); i++) {
//		Animal animalInQueue = animal.get(i);
//		
//		for (int j=0; j < medicalStaff.size(); j++) {
//			StaffMedical medicalStaffAvailable = medicalStaff.get(j);
//			medicalStaffAvailable.addToQ(animalInQueue);
//		}

//	for (int j=0; j < medicalStaff.size(); j++) {
//		Animal animalInQueue = null;
//		StaffMedical medicalStaffAvailable = medicalStaff.get(j);
//		
//		for (int i=0; i < animal.size(); i++) {
//			animalInQueue = animal.get(i);
//		}
//		medicalStaffAvailable.addToQ(animalInQueue);
//		
//		// https://www.tutorialspoint.com/iterate-through-arraylist-in-java
//		// https://stackoverflow.com/questions/5849154/can-we-write-our-own-iterator-in-java
//		Iterator<StaffMedical> itr = medicalStaffAvailable.iterator();
//		
//		// TODO change arraylists for linkedlists so I can use iterator??
//		// https://www.javatpoint.com/difference-between-arraylist-and-linkedlist
//		
//		// If non-exotic animal assign to any staff
////		if (animalInQueue.getAnimalOrigin() != "exotic") {
////	
////			// If big animal assign to staff who is not limited to small animals
////			if (animalInQueue.getAnimalSize() == "big") {
////				// TODO
////			}
////			
////			// TODO Assign to any staff
////		
////		// If exotic animal assign to staff who deals with exotic animals
////		} else if (animalInQueue.getAnimalOrigin() == "exotic") {
////			
////			// If big animal assign to staff who deals with exotic animals and is not limited to small animals
////			if (animalInQueue.getAnimalSize() == "big") {
////				// TODO
////			}
////			
////			// TODO Assign to any staff who deals with exotic animals
////			
////		}
//		
//	}
//	System.out.println(medicalStaff.toString()); //<= TEST POINT

}
