/*
Nicholas Carrig	
CIS D035B
Assignment 3 
 */
package driver;

import adapter.BuildAuto;
import adapter.CreateAuto;
import model.Automobile;
import util.FileIO;

public class Driver {
	public static void main(String [] args) {
		
		String fileName = "test-car-3.txt";
		FileIO newCar = new FileIO(fileName);
		
		Automobile car1 = newCar.readFile();
//		car1.printCarInfo();
		
		newCar.serializeVehicle(car1);
		Automobile car2 = newCar.deserializeVehicle("Ford Focus Wagon");
		System.out.println("Deserialized File:");
		car2.printCarInfo();
		
		System.out.println("Build Auto Testing:");
//		String key = "Ford Focus Wagon";
		String key = "Focus Wagon";
		BuildAuto a1 = new BuildAuto();
		a1.buildAuto(fileName);
		a1.printAuto(key);
		a1.updateOptionSetName(key, "Power Moonroof", "Updated Power Moonroof");
		a1.printAuto(key);
		a1.updateOptionPrice(key, "Updated Power Moonroof", "not present", 0.99);
		a1.printAuto(key);

//		AutoException err1 = new AutoException(101);
//		System.out.println(err1.getErrMsg());
//		AutoException err2 = new AutoException(101, "test message");
//		System.out.println(err2.getErrMsg());
//		AutoException err3 = new AutoException();
	}
}
