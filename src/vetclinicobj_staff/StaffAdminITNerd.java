package vetclinicobj_staff;

import vetclinicabstract.StaffAdmin;

public class StaffAdminITNerd extends StaffAdmin {

	public boolean isITOnCall; // IT technician who is on call for emergencies, e.g. system is down over weekends or bank holidays

	public boolean isITOnCall() {
		return isITOnCall;
	}
	public void setITOnCall(boolean isITOnCall) {
		this.isITOnCall = isITOnCall;
	}

}
