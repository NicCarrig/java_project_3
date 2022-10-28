/*
Nicholas Carrig	
CIS D035B
Assignment 3 
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import model.OptionSet.Option;

public class Automobile implements Serializable{
	private String make;
	private String model;
	private double basePrice;
	private ArrayList<OptionSet> opset;
	private ArrayList<Option> choice;
	
	//Constructor
	public Automobile(String make, String model, double basePrice, ArrayList<OptionSet> optionSets) {
		opset = new ArrayList<OptionSet>();
		choice = new ArrayList<Option>();
		this.make = make;
		this.model = model;
		this.basePrice = basePrice;
		
		setOpset(optionSets);	
	}

	//Getter/Setters
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMakeAndModel() {
		return make + " " + model;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public ArrayList<OptionSet> getOpset() {
		return opset;
	}
	public void setOpset(ArrayList<OptionSet> optionSets) {
		Iterator<OptionSet> iterator = null;
		iterator = optionSets.iterator();
		while(iterator.hasNext()) {
			OptionSet optionSetEl = iterator.next();
			opset.add(optionSetEl);
		}
	}
	public OptionSet getSingleOpset(int x) {
		return opset.get(x);
	}
	public String getOpsetName(int x) {
		return opset.get(x).getOpsetName();
	}
	
	
	//print methods
	public void printMake() {
		System.out.println("Make: " + make);
	}
	public void printModel() {
		System.out.println("Model: " + model);
	}
	public void printMakeAndModel() {
		System.out.println(make + " " + model);
	}
	public void printBasePrice() {
		System.out.printf("Base Price: $%.2f", basePrice);
		System.out.println();
	}
	public void printAllOptionSets() {
		Iterator<OptionSet> iterator = null;
		iterator = opset.iterator();
		while(iterator.hasNext()) {
			OptionSet opSetEl = iterator.next();
			opSetEl.printOptionSetInfo();
		}
	}
	public void printOneOptionSet(int x) {
		opset.get(x).printOptionSetInfo();
	}
	public void printCarInfo() {
		printMakeAndModel();
		printBasePrice();
		printAllOptionSets();
	}

	
	//helpers for LHM
	public String generateKey() {
		return make + " " + model;
	}

	public void updateOptionSetName(String oldName, String newName) {

		for(int i = 0; i < opset.size(); i++) {
			if(oldName.equals( opset.get(i).getOpsetName() )) {
				opset.get(i).setOpsetName(newName);
				return;
			}
		}
		//returns once the name get updated, otherwise will hit the "not found" message 
		System.out.println("No option set with name " + oldName + " found.");
	}
	public void updateOptionPrice(String optionSetName, String optionName, double newPrice) {
		for(int i = 0; i < opset.size(); i++) {
			//find matching option set name
			if(optionSetName.equals( opset.get(i).getOpsetName() )) {
				for(int j = 0; j< opset.get(i).getOptionSize(); j++) {
					//find matching option name
					if(optionName.equals( opset.get(i).getSingleOption(j).getName() )) {
						opset.get(i).getSingleOption(j).setPrice(newPrice);
						return;
					}
				}
			}
		}
		System.out.println("Unable to update price. Please verify that the option set name and option name are correct.");
	}

	
}
