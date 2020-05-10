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
	protected int salary;
	protected int yearsOfService;
	protected String qualificationLevel;
	
	protected abstract String genId();
	protected abstract String genSalaryLevel();
	protected abstract int salaryCalculator();
	
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
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getYearsOfService() {
		return yearsOfService;
	}
	
	public void setYearsOfService(int yearsOfService) {
		this.yearsOfService = yearsOfService;
	}
	
	public String getQualificationLevel() {
		return qualificationLevel;
	}
	
	public void setQualificationLevel(String qualificationLevel) {
		this.qualificationLevel = qualificationLevel;
	}
	
	
	// TO STRING METHOD
	

}
