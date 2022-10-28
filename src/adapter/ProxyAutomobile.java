package adapter;

import java.util.Set;

import model.Automobile;
import model.LHMAutomobile;
import util.FileIO;

public abstract class ProxyAutomobile {
	private static LHMAutomobile a1;
	
	public ProxyAutomobile() {
		a1 = new LHMAutomobile();
	}
	
	//CreateAuto Interface methods
	public void buildAuto(String fileName) {
		FileIO carFile = new FileIO(fileName);
		Automobile car = carFile.readFile();
		a1.create(car);
	}
	public void printAuto(String modelName) {
		String key = findKeyFromModelName(modelName);
		Automobile car = a1.read(key);
		car.printCarInfo();
	}
	
	//UpdateAuto Interface methods
	public void updateOptionSetName(String modelName, String optionSetName, String newName) {
		String key = findKeyFromModelName(modelName);
		a1.updateOptionSetName(key, optionSetName, newName);
	}
	public void updateOptionPrice(String modelName, String optionSetName, String optionName, double newPrice) {
		String key = findKeyFromModelName(modelName);
		a1.updateOptionPrice(key, optionSetName, optionName, newPrice);
	}
	
	//FixAuto Interface methods
	public void fixErr(int errNo) {
		
	}
	
	//LMH search and helper methods
	public String findKeyFromModelName(String modelName) {
		//used to find the hash map key from either just a model name or  make and model names
		//ex: should be able to get the key for either "Ford Focus Wagon" or "Focus Wagon"
		Set<String> keys = a1.setKeys();
		for(String key : keys) {
			if( modelName.equals(a1.read(key).getModel()) || modelName.equals(a1.read(key).getMakeAndModel()) ) {
				return a1.read(key).generateKey();
			}
		}
		
		return "";
	}
}
