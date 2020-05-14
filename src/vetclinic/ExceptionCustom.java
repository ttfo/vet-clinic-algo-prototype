package vetclinic;

public class ExceptionCustom extends Exception {

	/**
	 * REF. https://beginnersbook.com/2013/04/throw-in-java/ We want to throw an
	 * internal error if an incorrect value is provided for FactoryStaff()
	 * parameters in Menu.java (currently at line 73, as of 14/05/2020)
	 */
	private static final long serialVersionUID = 1L; // Suggested by Eclipse

	public void checkEligibilty(int medCount, int vetCount) {
		medCount = medCount - 3; // accounting for all medical 'categories' to be created as well
		if (vetCount > medCount) {
			throw new ArithmeticException(
					"Number of Vet. Doctors cannot be bigger than number of memebers of Medical Staff."
							+ " As we should have at least a member for each medical category, number of Vet. Doctors must be smaller than number of memebers of Medical Staff.");
		}
	}
	
	public void checkMinVet(int vetCount) {
		if (vetCount < 5) {
			throw new ArithmeticException(
					"The minimum requirement of Vet. Doctors is 5.");
		}
	}	

}
