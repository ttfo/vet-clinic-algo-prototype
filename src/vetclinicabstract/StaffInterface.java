package vetclinicabstract;

public interface StaffInterface {

	// NOTE FOR SELF-About having protected methods in interfaces: https://stackoverflow.com/questions/9046012/why-interface-cannot-have-protected-methods
	
	/**
	 * This method generates a Unique ID for each employee. 
	 * 
	 * @param staff type ('A' for Admin or 'M' for Medical), year that the employee joined the company, 
	 * employee's second name, incremental value
	 * @return a unique id for each employee
	 */	
	public abstract String genId(char staffType, int yearJoined, String secondName, int incr);
	
	
	/**
	 * This method generates a salary level. 
	 * 
	 * @param years of service in the company, level of qualification
	 * [QUALIFICATION LEVEL] within square brackets:
	 * Trainee Vet [1] / Receptionist [2] / Nurse [3] / 
	 * IT Nerd [4] / Veterinarian [5] / Vet Surgeon [6] / Vet Locum [7]
	 * 
	 * @return an integer that represents the salary level starting from a certain threshold, e.g. 50
	 * 
	 * E.g. nurse starts in the company with level 50, then for each 5 years in the company gains 1 level
	 * After 10 years the nurse will be at salary level 52
	 * 
	 */
	public abstract int genSalaryLevel(int yearsOfService, int qualificationLevel);
	
	
	/**
	 * This method calculates the salary of each employee in EUR. 
	 * 
	 * @param salaryLevel obtained via genSalaryLevel() method
	 * @return annual salary of the employee in EUR with no decimals (rounded up)
	 */	
	public abstract int salaryCalculator(int salaryLevel);	
	
}
