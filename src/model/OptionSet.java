/*
Nicholas Carrig	
CIS D035B
Assignment 3 
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class OptionSet implements Serializable{
	private String opsetName;
	private ArrayList<Option> options;
	
	//constructor
	public OptionSet(String name, ArrayList<String> opList) {
		options = new ArrayList<Option>();
		this.opsetName = name;
//		System.out.println(opsetName);
		
		Iterator<String> iterator = null;
		iterator = opList.iterator();
		while(iterator.hasNext()) {
			String opt = iterator.next();
			//need to parse price value out of the string
			String[] result = opt.split("\\s");
			double price = Double.parseDouble(result[result.length-1]);
			//remake option name after splitting the price out
			String optName = "";
			for(int i = 0; i < result.length-1; i++) {
				optName += result[i];
				if(i != result.length - 2) {
					optName += " ";
				}
			}
			Option newOpt = new Option(optName, price);
			options.add(newOpt);
		}
	}
	
	//getter/setters
	protected String getOpsetName() {
		return opsetName;
	}
	protected void setOpsetName(String opsetName) {
		this.opsetName = opsetName;
	}
	protected ArrayList<Option> getOptions() {
		return options;
	}
	protected void setOptions(ArrayList<Option> options) {
		this.options = options;
	}
	protected int getOptionSize() {
		return options.size();
	}
	protected Option getSingleOption(int i) {
		return options.get(i);
	}
	protected void printOptionSetInfo() {
		System.out.println(opsetName + ":");
		Iterator<Option> iterator = null;
		
		iterator = options.iterator();
		while(iterator.hasNext()) {
			Option option = iterator.next();
			option.printOptionInfo();
			System.out.println();
		}
	}


	//INNER CLASS
	public class Option implements Serializable{
		private String name;
		private double price;
		
		//Constructor
		public Option(String name, double price) {
			this.name = name;
			this.price = price;
			
//			System.out.println(name + " " + price);
		}
		
		//getter/setters
		protected String getName() {
			return name;
		}
		protected void setName(String name) {
			this.name = name;
		}
		protected double getPrice() {
			return price;
		}
		protected void setPrice(double price) {
			this.price = price;
		}
		protected void printOptionInfo() {
			System.out.printf("%s - $%.2f", name, price);
		}
		
	}

}
