package vetclinic;

import java.io.IOException;

import vetclinicobj_staff.FactoryStaff;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FactoryStaff factoryNames = new FactoryStaff(10, 30, 5);
		factoryNames.staffFullNamesRndGen();
		
	}

}
