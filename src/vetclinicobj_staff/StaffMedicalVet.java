package vetclinicobj_staff;

import vetclinicabstract.StaffMedical;

public class StaffMedicalVet extends StaffMedical {
	
	public boolean isVetOnCall; // vet who is on call for emergencies, e.g. over weekends or bank holidays		
	public boolean isSurgeon; // vet qualified to perform surgery

	// SETTERS AND GETTERS
	
	public boolean isSurgeon() {
		return isSurgeon;
	}
	public void setSurgeon(boolean isSurgeon) {
		this.isSurgeon = isSurgeon;
	}
	public boolean isVetOnCall() {
		return isVetOnCall;
	}
	public void setVetOnCall(boolean isVetOnCall) {
		this.isVetOnCall = isVetOnCall;
	}	
	
}
