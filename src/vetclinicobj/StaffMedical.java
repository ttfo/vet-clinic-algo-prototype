package vetclinicobj;

import vetclinicabstract.Staff;

public class StaffMedical extends Staff {
	
	/*
	 * NOTE TO SELF: that we don't need to declare the attributes that have already been
	 * declared in the parent class. In this case, the superclass Staff already has
	 * firstName, secondName, EmployeeId, etc. as attributes.
	 */
	
	@Override
	protected int yearsOfService(int yearJoined) {
		// TODO Auto-generated method stub
		return 0;
	}

}
