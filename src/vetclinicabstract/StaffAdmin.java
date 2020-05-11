package vetclinicabstract;

public abstract class StaffAdmin extends Staff {
	
	/*
	 * NOTE TO SELF: that we don't need to declare the attributes that have already been
	 * declared in the parent class. In this case, the superclass Staff already has
	 * firstName, secondName, EmployeeId, etc. as attributes.
	 * 
	 * FROM CA DESCRIPTOR:
	 * The system must also assign a task to each member of the Admin staff. These tasks can be invented
	 * by you, but there should be several different tasks – e.g. Filing, Making Phone Calls, On Holidays, etc. 
	 */	
	
	// About having or not having default constructor - https://stackoverflow.com/questions/4488716/java-default-constructor
	
	public String adminTask;
	
	// SETTERS AND GETTERS

	public String getAdminTask() {
		return adminTask;
	}
	public void setAdminTask(String adminTask) {
		this.adminTask = adminTask;
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
					"\t" + "Current task: \"" + adminTask + "\"\n" +
				"}\n";
	}	
	
}
