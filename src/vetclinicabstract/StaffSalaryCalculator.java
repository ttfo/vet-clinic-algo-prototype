/**
 * This interface is for yearly salary assignment to staff
 */
package vetclinicabstract;

/**
 * @author matbe
 *
 */
public interface StaffSalaryCalculator {
	
	// About having protected methods in interfaces: https://stackoverflow.com/questions/9046012/why-interface-cannot-have-protected-methods
	
	/**
	 * This method generates a salary level. 
	 * 
	 * @param years of service in the company, level of qualification
	 * [QUALIFICATION LEVEL] within square brackets:
	 * Trainee Vet [A]=> Receptionist [B] => Nurse [C] => IT Nerd [D] => Veterinarian [E]
	 * 
	 * @return an integer that represents the salary level starting from a certain threshold, e.g. 50
	 * 
	 * E.g. nurse starts in the company with level 50, then for each 5 years in the company gains 1 level
	 * After 10 years the nurse will be at salary level 52
	 * 
	 */
	public int genSalaryLevel(int yearsOfService, char qualificationLevel);
	
	
	/**
	 * This method calculates the salary of each employee in EUR. 
	 * 
	 * @param salaryLevel obtained via genSalaryLevel() method
	 * @return annual salary of the employee in EUR with no decimals (rounded up)
	 */	
	public int salaryCalculator(int salaryLevel);
	
}
