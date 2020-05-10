package vetclinicobj_staff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import vetclinicabstract.Staff;
import vetclinicabstract.StaffFactoryInterface;

public class FactoryStaff implements StaffFactoryInterface {

	/*
	 * --SPECS FROM CA DESCRIPTOR--
	 * 
	 * - At least 10 Admin staff or various types (they cannot all be the same
	 * type). There must be at least 2 different types of Admin staff. 
	 * 
	 * - At least 30 Medical staff of various types (there must be 5 Vets, and as above, the 30
	 * cannot all be the same type). There must be at least 3 different types of
	 * Medical staff.
	 */
	
	public int adminStaffCount = 10; // min requirement from CA specs
	public int medicalStaffCount = 30; // min requirement from CA specs
	public int vetStaffCount = 5; // min requirement from CA specs, sub-group of 'medicalStaff'
	public int staffCount = adminStaffCount + medicalStaffCount;
	
	String[] staffFullNames = new String[staffCount];
	ArrayList<Staff> staff = new ArrayList<Staff>();

	// NOTE: SET text encoding in Eclipse to UTF-8 for the proper experience
	// REF. https://stackoverflow.com/questions/33991916/eclipe-handling-accents-in-java-file
	public String[] staffFullNamesRndGen() throws IOException {		

		// Reading files with random names and surnames
		String fileName = "src/NameRandom.txt";
		String fileSurname = "src/SurnameRandom.txt";
		BufferedReader inName = new BufferedReader(new FileReader(fileName));
		BufferedReader inSurname = new BufferedReader(new FileReader(fileSurname));
		
		ArrayList<String> firstNames = new ArrayList<String>();
		ArrayList<String> secondNames = new ArrayList<String>();
		
		String lineName = inName.readLine();
		String lineSurname = inSurname.readLine();
		
		while (lineName != null) {	
			firstNames.add(lineName); // populating array list of first names from file
			lineName = inName.readLine();
		}
		
		inName.close(); // REF. https://stackoverflow.com/questions/12519335/resource-leak-in-is-never-closed

		while (lineSurname != null) {	
			secondNames.add(lineSurname); // populating array list of second names from file
			lineSurname = inSurname.readLine();
		}
		
		inSurname.close(); // REF. https://stackoverflow.com/questions/12519335/resource-leak-in-is-never-closed
		
		// REF. https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values
		Random r = new Random();
		
		for (int i = 0; i < staffCount; i++) {
			int rndIndex1 = r.nextInt(staffCount);
			int rndIndex2 = r.nextInt(staffCount);
			String staffFullName = firstNames.get(rndIndex1) + " " + secondNames.get(rndIndex2);
			staffFullNames[i] = staffFullName;
			// System.out.println(i + ") " + staffFullName); //<= TEST POINT
		}
		
		// System.out.println(staffFullNames); //<= TEST POINT
		return staffFullNames;
		
	}
	
	@Override
	public String genId(char staffType, int yearJoined, String secondName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int genSalaryLevel(int yearsOfService, char qualificationLevel) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int salaryCalculator(int salaryLevel) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
