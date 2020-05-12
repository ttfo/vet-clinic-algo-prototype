package vetclinic;

import java.util.Iterator;
import java.util.LinkedList;

import vetclinicabstract.Animal;
import vetclinicabstract.StaffMedical;

public class QueueSystem {
	
	protected LinkedList<StaffMedical> medicalStaff;
	protected LinkedList<Animal> animals;
	
	public QueueSystem(LinkedList<StaffMedical> medicalStaff, LinkedList<Animal> animals) {
		
		Iterator<StaffMedical> itrMed = medicalStaff.iterator();
		Iterator<Animal> itrPets = animals.iterator();
		
		while (itrPets.hasNext()) {
			
			// If there is no medical staff
			if (medicalStaff.size() == 0) {
				// TODO
			} else {
				
				if (itrMed.hasNext()) {
				StaffMedical nextMedStaff = itrMed.next();
				Animal nextPetInQ = itrPets.next();
				
				nextMedStaff.addToQ(nextPetInQ); //<= TEST POINT
				
				System.out.println(nextPetInQ.toString()); //<= TEST POINT
				System.out.println(nextMedStaff); //<= TEST POINT
				}
				System.out.println("Reset Iterator"); // <= TEST POINT
				itrPets = animals.iterator();
			}
		}
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
