package vetclinicobj_animals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import vetclinicabstract.Animal;

public class FactoryAnimal {

	/*
	 * --SPECS FROM CA DESCRIPTOR--
	 * 
	 * At least 1000 animals. There must be at least 3 different types of Animal.
	 * However, you can include additional Animal types for extra marks
	 */
	
	ArrayList<Animal> animals = new ArrayList<Animal>();
	
	// Need to get subclasses of Animal and its count
	
	// EASY WAY
	// String[] animalTypes = new String[] { "cat","dog","horse","python" }; // animal types
	// int animalTypesCount = animalTypes.length; // How many types of animal we have available?
	
	// MORE REFINED WAY
	// Create a list of possible subclasses of Animal
	// REF. https://stackoverflow.com/questions/6665165/random-selection-from-a-heap-of-classes-in-java
	List<Class<? extends Animal>> subclassesOfAnimal = Arrays.asList(AnimalCat.class, AnimalDog.class, AnimalHorse.class, AnimalPython.class);
	int animalTypesCount = subclassesOfAnimal.size(); 
	
	public FactoryAnimal(int animalCount) throws IOException, InstantiationException, IllegalAccessException {	
		
		// Reading files with random pet names
		String petNameFile = "src/PetNameRandom.txt";
		BufferedReader inPetName = new BufferedReader(new FileReader(petNameFile));
		
		ArrayList<String> petNames = new ArrayList<String>();		
		String linePetNames = inPetName.readLine();
		
		while (linePetNames != null) {	
			petNames.add(linePetNames); // populating array list of first names from file
			linePetNames = inPetName.readLine();
		}
		
		inPetName.close(); // REF. https://stackoverflow.com/questions/12519335/resource-leak-in-is-never-closed

		// Reading files with random medical conditions
		String medConditionFile = "src/MedConditionRandom.txt";
		BufferedReader inMedConditions = new BufferedReader(new FileReader(medConditionFile));
		
		ArrayList<String> medConditions = new ArrayList<String>();		
		String lineMedConditions = inMedConditions.readLine();
		
		while (lineMedConditions != null) {	
			medConditions.add(lineMedConditions); // populating array list of first names from file
			lineMedConditions = inMedConditions.readLine();
		}
		
		inMedConditions.close(); // REF. https://stackoverflow.com/questions/12519335/resource-leak-in-is-never-closed
			
		// TODO ensure that we have at least 1 animal for each type
		for (int i = 0; i < animalCount; i++) {
			
			Random r = new Random();
			int tossCoin = r.nextInt(animalTypesCount);
			int rndNameIndex = r.nextInt(petNames.size());
			int rndConditionIndex = r.nextInt(medConditions.size());
			
			Animal animal = (Animal)subclassesOfAnimal.get(tossCoin).newInstance();
			animal.setAge(r.nextInt(animal.getMaxAge())+1);
			animal.setPetName(petNames.get(rndNameIndex));
			animal.setMedicalCondition(medConditions.get(rndConditionIndex));
			
			animals.add(animal);
			
			// To show full output in console in Eclipse
			// Under Window > Preferences, go to the Run/Debug > Console section, 
			// un-check option "Limit console output.
			// REF.: https://stackoverflow.com/questions/2828255/how-do-i-increase-the-capacity-of-the-eclipse-output-console
			System.out.println(i + "=> ( tossCoin: " +tossCoin+ " ): " + animal.toString()); //<= TEST POINT

		}
		
	}
	
}
