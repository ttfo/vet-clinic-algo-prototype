/**
 * This interface is for unique id assignment to staff
 */
package vetclinicabstract;

/**
 * @author matbe
 *
 */

public interface StaffIdAssignment {

	/**
	 * This method generates a Unique ID for each employee. 
	 * 
	 * @param staff type ('A' for Admin or 'M' for Medical), year that the employee joined the company, employee's second name
	 * @return a unique id for each employee
	 */	
	public abstract String genId(char staffType, int yearJoined, String secondName);
	
}
