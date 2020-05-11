package vetclinicobj_animals;

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
	
	public FactoryAnimal(int animalCount) throws IOException {	
		
		System.out.println(animalTypesCount); //<= TEST POINT 
		
		for (int i = 0; i < animalCount; i++) {
			
			Random r = new Random();
			int tossCoin = r.nextInt(animalTypesCount);
			
			switch(tossCoin) {
			case 0:
				// code block
				break;
			case 1:
				// code block
				break;
			case 2:
				// code block
				break;
			case 3:
				// code block
				break;
			default:
				// code block
			}
			
		}
		
	}
	
}
