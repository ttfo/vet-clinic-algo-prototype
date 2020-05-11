package vetclinicobj_staff;

import vetclinicabstract.StaffAdmin;

public class StaffAdminITNerd extends StaffAdmin {
	
	// About missing constructor
	// I wanted to try a different approach for Staff members
	// All attributes are defined via FactoryStaff class

	public boolean isITOnCall; // IT technician who is on call for emergencies, e.g. system is down over weekends or bank holidays

	public boolean isITOnCall() {
		return isITOnCall;
	}
	public void setITOnCall(boolean isITOnCall) {
		this.isITOnCall = isITOnCall;
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
					"\t" + "Is IT person on call: \"" + isITOnCall + "\",\n" +
					"\t" + "Current task: \"" + adminTask + "\"\n" +
				"}\n";
	}		
}
