package vetclinicabstract;

public abstract class Staff {
	
	/*
	 * SPECS FROM CA DESCRIPTOR
	 * Each staff member must be given (a) a name, (b) a UNIQUE staff number and (c) a salary level
	 * The Staff name must be randomly generated in some manner
	 * (but must be text and should look like a name!) 
	 * 
	 * NOTE: staff can be Admin Staff or Medical Staff, they all have name, id and salary
	 * 
	 * MY OWN SALARY PROGRESSION SCHEMA (lower to higher salary [QUALIFICATION LEVEL] within square brackets):
	 * Trainee Vet [A]=> Receptionist [B] => Nurse [C] => IT Nerd [D] => Veterinarian [E]
	 */

	// About abstract class implementing interfaces, REF.:
	// https://stackoverflow.com/questions/197893/why-an-abstract-class-implementing-an-interface-can-miss-the-declaration-impleme
	// https://stackoverflow.com/questions/21263607/can-a-normal-class-implement-multiple-interfaces	
	
	// TODO move StaffIdAssignment implementation to FactoryStaff
	
	protected String firstName;
	protected String secondName;
	protected String title;
	protected char staffType; // can be 'A' for Admin or 'M' for Medical	
	protected int salary;
	protected int yearJoined;
	protected char qualificationLevel; // Trainee Vet [A] / Receptionist [B] / Nurse [C] / IT Nerd [D] / Veterinarian [E]
	protected String employeeId;
	
	// protected abstract int yearsOfService(int yearJoined);
	
	public int yearsOfService(int yearJoined) {
		// TODO 
		return 0;
	}
	
	// Implementation of the StaffSalaryCalculator interface method
	public int genSalaryLevel(int yearsOfService, char qualificationLevel) { 
		// TODO 
		return 0;
	}

	// Implementation of the StaffSalaryCalculator interface method
	public int salaryCalculator(int salaryLevel) { 
		// TODO 
		return 0;
	}

	// Implementation of the StaffIdAssignment interface method
	public String genId(char staffType, int yearJoined, String secondName) { 
		// TODO 
		return null;
	}	
	
	// SETTERS AND GETTERS
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSecondName() {
		return secondName;
	}
	
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public char getStaffType() {
		return staffType;
	}
	
	public void setStaffType(char staffType) {
		this.staffType = staffType;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public int getYearsOfService() {
		return yearJoined;
	}
	
	public void setYearsOfService(int yearJoined) {
		this.yearJoined = yearJoined;
	}
	
	public char getQualificationLevel() {
		return qualificationLevel;
	}
	
	public void setQualificationLevel(char qualificationLevel) {
		this.qualificationLevel = qualificationLevel;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	// TO STRING METHOD
	// TODO
	

}
