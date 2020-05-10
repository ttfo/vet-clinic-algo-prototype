package vetclinic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import vetclinicabstract.StaffFactoryInterface;
import vetclinicobj_staff.FactoryStaff;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FactoryStaff factoryNames = new FactoryStaff();
		factoryNames.staffFullNamesRndGen();
		
	}

}
