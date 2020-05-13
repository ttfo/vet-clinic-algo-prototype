package vetclinicobj_staff;

import vetclinicabstract.StaffAdmin;

public class StaffAdminReceptionist extends StaffAdmin {
	
	public StaffAdminReceptionist() {
		role = "Receptionist";
		qualificationLevel = 2;	//LEVELS- Trainee Vet [1] / Receptionist [2] / Nurse [3] / IT Nerd [4] / Veterinarian [5] / Vet Surgeon [6] / Vet Locum [7]
	}

}
