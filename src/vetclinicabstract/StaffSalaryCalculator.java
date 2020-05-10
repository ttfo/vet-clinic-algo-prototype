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
	 * a a a
	 */
	public abstract String genSalaryLevel();
	public abstract int salaryCalculator();
	
}
