package vetclinicabstract;

import java.util.Calendar;

import vetclinicabstract.StaffInterface;

public abstract class Staff implements StaffInterface {
	
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
	
	protected String firstName;
	protected String secondName;
	protected String title;
	protected String role;	
	protected char staffType; // can be 'A' for Admin or 'M' for Medical	
	protected int salary;
	protected int yearJoined;
	// qualificationLevel => Trainee Vet [1] / Receptionist [2] / Nurse [3] / IT Nerd [4] / Veterinarian [5] / Vet Surgeon [6]  / Vet Locum [7]
	protected int qualificationLevel; 
	protected String employeeId;
	
	private int baseSalaryLevel = 49; // Base salary level for all employees
	private int baseSalary = 25000; // Base salary for all employees

	private int currentYear = Calendar.getInstance().get(Calendar.YEAR); // REF. https://stackoverflow.com/questions/136419/get-integer-value-of-the-current-year-in-java
	
	// Implementation of the StaffSalaryCalculator interface method
	public int genSalaryLevel(int yearsOfService, int qualificationLevel) { 
		// Every year in service employee gains 1 level
		// Qualification is also factored in
		int salaryLevel = baseSalaryLevel + (yearsOfService) + (qualificationLevel * qualificationLevel * 5);
		return salaryLevel;
	}

	// Implementation of the StaffSalaryCalculator interface method
	public int salaryCalculator(int salaryLevel) { 
		int salary = baseSalary + (baseSalary * salaryLevel / 100);
		return salary;
	}

	// Implementation of the StaffIdAssignment interface method
	public String genId(char staffType, int yearJoined, String secondName, int incr) { 
		
		// REF. https://stackoverflow.com/questions/8172420/how-to-convert-a-char-to-a-string
		// https://stackoverflow.com/questions/11279683/adding-zero-to-a-single-digit-number-is-it-possible
		
		String id = String.valueOf(staffType) + String.format("%03d", yearJoined) + String.valueOf(secondName.charAt(0)) + String.format("%03d", incr);
		return id;
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
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public char getStaffType() {
		return staffType;
	}
	
	public void setStaffType(char staffType) {
		this.staffType = staffType;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}	
	
	public int getSalary() {
		return salary;
	}
	
	public int getYearsOfService() {
		return currentYear - yearJoined;
	}
	
	public void setYearsOfService(int yearJoined) {
		this.yearJoined = yearJoined;
	}
	
	public int getQualificationLevel() {
		return qualificationLevel;
	}
	
	public void setQualificationLevel(int qualificationLevel) {
		this.qualificationLevel = qualificationLevel;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
					"\t" + "Qualification level: \"" + qualificationLevel + "\"\n" +
				"}\n";
	}
	
}
