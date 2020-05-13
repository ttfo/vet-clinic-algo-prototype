package vetclinicobj_staff;

import vetclinicabstract.StaffMedical;

public class StaffMedicalNurse extends StaffMedical {

	public StaffMedicalNurse() {
		role = "Vet Nurse";
		qualificationLevel = 3;	//LEVELS- Trainee Vet [1] / Receptionist [2] / Nurse [3] / IT Nerd [4] / Veterinarian [5] / Vet Surgeon [6] / Vet Locum [7]
	}

}
