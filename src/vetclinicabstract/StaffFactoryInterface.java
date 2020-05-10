package vetclinicabstract;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public interface StaffFactoryInterface {

	// NOTE FOR SELF-About having protected methods in interfaces: https://stackoverflow.com/questions/9046012/why-interface-cannot-have-protected-methods

	/**
	 * This method must use a buffered reader passed in
	 * to generate random names for all employees of the clinic
	 * 
	 * @param in of the type bufferedReader
	 * @return an array list of staff members' names
	 * @throws IOException
	 */	
	//public ArrayList<String> namesReader(BufferedReader in) throws IOException;

	/**
	 * This method generates a Unique ID for each employee. 
	 * 
	 * @param staff type ('A' for Admin or 'M' for Medical), year that the employee joined the company, employee's second name
	 * @return a unique id for each employee
	 */	
	public abstract String genId(char staffType, int yearJoined, String secondName);
	
	
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
