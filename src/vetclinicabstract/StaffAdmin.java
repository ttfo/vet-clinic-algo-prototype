package vetclinicabstract;

public abstract class StaffAdmin extends Staff {
	
	/*
	 * NOTE TO SELF: that we don't need to declare the attributes that have already been
	 * declared in the parent class. In this case, the superclass Staff already has
	 * firstName, secondName, EmployeeId, etc. as attributes.
	 */	
	
	// About having or not having default constructor - https://stackoverflow.com/questions/4488716/java-default-constructor
	
	public int adminCategory; // medical category- can be IT technician (it), receptionist (r)
	
	// SETTERS AND GETTERS
	
	public int getAdminCategory() {
		return adminCategory;
	}
	public void setAdminCategory(int adminCategory) {
		this.adminCategory = adminCategory;
	}
	
}
