package vetclinicabstract;

public abstract class StaffMedical extends Staff {
	
	/*
	 * NOTE TO SELF: that we don't need to declare the attributes that have already been
	 * declared in the parent class. In this case, the superclass Staff already has
	 * firstName, secondName, EmployeeId, etc. as attributes.
	 */
	
	public boolean isTrainedForExoticPets; // vet, nurse or trainee qualified to deal with exotic pets
	public int medicalCategory; // medical category- can be vet (v), nurse (n) or trainee vet (tv)
	
	// SETTERS AND GETTERS

	public boolean isTrainedForExoticPets() {
		return isTrainedForExoticPets;
	}
	public void setTrainedForExoticPets(boolean isTrainedForExoticPets) {
		this.isTrainedForExoticPets = isTrainedForExoticPets;
	}
	public int getMedicalCategory() {
		return medicalCategory;
	}
	public void setMedicalCategory(int medicalCategory) {
		this.medicalCategory = medicalCategory;
	}

}
