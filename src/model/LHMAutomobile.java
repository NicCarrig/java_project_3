/*
Nicholas Carrig	
CIS D035B
Assignment 3 
 */
package model;

import java.util.LinkedHashMap;
import java.util.Set;

//Create a LHM template class in model package to be used for instantiating Automobile as a LHM

//key should be car's make and model (and possibly year)
//value will be the LHMAutomobile object
public class LHMAutomobile<T extends Automobile> {
	//Should define CRUD operations for LHM using the LinkedHashMap API
	//instantiate the LHM object in the ProxyAuto class
	private LinkedHashMap<String, T> a1;
	
	//constructor
	public LHMAutomobile(){
		a1 = new LinkedHashMap<String, T>();
	}
	
	//CRUD
	public void create(T car) {
		String key = car.generateKey();
		a1.put(key, car);
	}
	public T read(String key) {
		return a1.get(key);
	}
	public void updateOptionSetName(String key, String oldName, String newName) {
		a1.get(key).updateOptionSetName(oldName, newName);		
	}
	public void updateOptionPrice(String key, String optionSetName, String optionName, double newPrice) {
		a1.get(key).updateOptionPrice(optionSetName, optionName, newPrice);
	}
	public void delete(String key) {
		a1.remove(key);
	}
	
	
	//helpers
	public Set<String> setKeys() {
		Set<String> keys = a1.keySet();
		return keys;
	}
	
}
