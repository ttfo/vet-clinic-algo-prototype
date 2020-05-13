package vetclinicobj_staff;

import vetclinicabstract.StaffMedical;

public class StaffMedicalVet extends StaffMedical {
	
	public StaffMedicalVet() {
		title = "Dr."; // REF https://www.thejournal.ie/ireland-doctors-vets-new-animals-2696672-Apr2016/
		role = "Vet Physician"; // Default role, is overridden in FactoryStaff for specialized jobs
		//LEVELS- Trainee Vet [1] / Receptionist [2] / Nurse [3] / IT Nerd [4] / Veterinarian [5] / Vet Surgeon [6] / Vet Locum [7]
		qualificationLevel = 5; // Default qualification level, is overridden in FactoryStaff for specialized jobs
	}
	
	public boolean isVetOnCall; // vet who is on call for emergencies, e.g. over weekends or bank holidays		
	public boolean isSurgeon; // vet qualified to perform surgery
	public boolean isLocum; // locum vet- https://thevetservice.com/what-is-locuming/

	// SETTERS AND GETTERS
	
	public boolean isSurgeon() {
		return isSurgeon;
	}
	public void setSurgeon(boolean isSurgeon) {
		this.isSurgeon = isSurgeon;
	}
	public boolean isLocum() {
		return isLocum;
	}
	public void setLocum(boolean isLocum) {
		this.isLocum = isLocum;
	}	
	public boolean isVetOnCall() {
		return isVetOnCall;
	}
	public void setVetOnCall(boolean isVetOnCall) {
		this.isVetOnCall = isVetOnCall;
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
					"\t" + "Handles exotic pets: \"" + isTrainedForExoticPets + "\",\n" +					
					"\t" + "Is Surgeon Vet: \"" + isSurgeon + "\",\n" +
					"\t" + "Is Locum Vet: \"" + isLocum + "\",\n" +
					"\t" + "Is Vet on call: \"" + isVetOnCall + "\",\n" +
					"\t" + "Queue: \"" + animalQ.toString() + "\"\n" +
				"}\n";
	}
	
	
}
