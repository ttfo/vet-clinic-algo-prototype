package vetclinicabstract;

public abstract class Animal {
	
	/*
	 * -- SPECS FROM CA DESCRIPTOR --
	 * Each animal must be given (a) a name, (b) an age (realistic age!) and (c) a
	 * medical condition. The medical condition does not need to be realistic for
	 * the animal in question, but should look like an illness (see example below).
	 * Animal names must be generated randomly in some manner (but must be text and
	 * should look like a name)
	 * 
	 * --EXAMPLE--
	 * Type of Animal: Rabbit
	 * Name of Animal: Fluffy
	 * Age: 5
	 * Medical Condition: Carrot Allergy 
	 */
	
	protected String animalSize; // can be small or big
	protected String animalOrigin; // can be native or exotic
	protected String animalType; // e.g. cat, dog, horse, python 
	protected String petName;
	protected int age;
	protected int maxAge; // maximum possible age for that animal
	protected String medicalCondition;
	
	// SETTERS AND GETTERS
	
	public String getAnimalType() {
		return animalType;
	}
	public String getAnimalSize() {
		return animalSize;
	}
	public String getAnimalOrigin() {
		return animalOrigin;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMaxAge() {
		return maxAge;
	}	
	public String getMedicalCondition() {
		return medicalCondition;
	}
	public void setMedicalCondition(String medicalCondition) {
		this.medicalCondition = medicalCondition;
	}
	
	// TO STRING METHOD
	@Override
	public String toString() {
		return "{\n"+
					"\t" + "animalSize: \"" + animalSize + "\",\n" +
					"\t" + "animalOrigin: \"" + animalOrigin + "\",\n" +
					"\t" + "animalType: \"" + animalType + "\",\n" +
					"\t" + "petName: \"" + petName + "\",\n" +
					"\t" + "age: \"" + age + "\",\n" +
					"\t" + "medicalCondition: \"" + medicalCondition + "\"\n" +
				"}\n";
	}	

}
