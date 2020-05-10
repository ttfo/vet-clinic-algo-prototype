package vetclinicabstract;

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

public abstract class Staff {
	
	protected String firstName;
	protected String secondName;
	protected String title;
	protected char staffType; // can be 'A' for Admin or 'M' for Medical	
	protected int salary;
	protected int yearsOfService;
	protected char qualificationLevel;
	
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
		return yearsOfService;
	}
	
	public void setYearsOfService(int yearsOfService) {
		this.yearsOfService = yearsOfService;
	}
	
	public char getQualificationLevel() {
		return qualificationLevel;
	}
	
	public void setQualificationLevel(char qualificationLevel) {
		this.qualificationLevel = qualificationLevel;
	}
	
	
	// TO STRING METHOD
	// @TODO
	

}
