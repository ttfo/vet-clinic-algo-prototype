package vetclinicabstract;

public abstract class StaffMedical extends Staff {
	
	/*
	 * NOTE TO SELF: that we don't need to declare the attributes that have already been
	 * declared in the parent class. In this case, the superclass Staff already has
	 * firstName, secondName, EmployeeId, etc. as attributes.
	 */
	
	public boolean isTrainedForExoticPets; // vet, nurse or trainee qualified to deal with exotic pets
	public boolean isSmallAnimalsOnly; // e.g. https://www.vetjobs.ie/jobs/34234736-small-animal-vet-required-in-beautiful-ennis-at-ennis-veterinary-clinic
	
	// SETTERS AND GETTERS

	public boolean isTrainedForExoticPets() {
		return isTrainedForExoticPets;
	}
	public void setTrainedForExoticPets(boolean isTrainedForExoticPets) {
		this.isTrainedForExoticPets = isTrainedForExoticPets;
	}
	public boolean isSmallAnimalsOnly() {
		return isSmallAnimalsOnly;
	}
	public void setSmallAnimalsOnly(boolean isSmallAnimalsOnly) {
		this.isSmallAnimalsOnly = isSmallAnimalsOnly;
	}
	
	// TO STRING METHOD
	@Override
	public String toString() {
		return "{\n"+
					"\t" + "Employee Id: \"" + employeeId + "\",\n" +
					"\t" + "Title: \"" + title + "\",\n" +
					"\t" + "Name: \"" + firstName + "\",\n" +
					"\t" + "Surname: \"" + secondName + "\",\n" +
					"\t" + "Job title: \"" + role + "\",\n" +
					"\t" + "Staff type (A for Admin, M for Medical): \"" + staffType + "\",\n" +
					"\t" + "Salary (EUR): \"" + salary + "\",\n" +
					"\t" + "Year joined: \"" + yearJoined + "\",\n" +
					"\t" + "Qualification level: \"" + qualificationLevel + "\",\n" +
					"\t" + "Handles small animals only: \"" + isSmallAnimalsOnly + "\",\n" +
					"\t" + "Handles exotic pets: \"" + isTrainedForExoticPets + "\"\n" +
				"}\n";
	}	

}
