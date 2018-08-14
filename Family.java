package farm.people;

import java.util.ArrayList;
import farm.property.Land;

public class Family {
	private Person husband;
	private Person wife;
	private ArrayList<Person> children = new ArrayList<Person>();
	private ArrayList<Person> ancestors = new ArrayList<Person>();
	private ArrayList<Land> familyLand = new ArrayList<Land>();
	
	private int wheat = 20;
	private int barley = 40;
	private int oats = 40;
	private int lentils = 30;
	
	private int fertilizer = 10;
	private int money = 0;
		
	public int count() {
		int counter = 0;		
		if(this.husband.isAlive() && !this.husband.isBusy()) {			counter++;
		}		
		if(this.wife.isAlive() && !this.wife.isBusy()) {
			counter++;
		}		
		for(Person child : children) {
			if(child.getAge() > 7 && child.isAlive() && !child.isBusy()){
				counter++;
			}
		}		
		return counter;
	}	
	public int countFields() {
		return familyLand.size();
	}	
	public Person getHusband() {
		return husband;
	}
	public void setHusband(Person husband) {
		this.husband = husband;
	}
	public Person getWife() {
		return wife;
	}
	public void setWife(Person wife) {
		this.wife = wife;
	}
	public ArrayList<Person> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<Person> children) {
		this.children = children;
	}
	public ArrayList<Person> getAncestors() {
		return ancestors;
	}
	public void setAncestors(ArrayList<Person> ancestors) {
		this.ancestors = ancestors;
	}	
	public ArrayList<Land> getFamilyLand() {
		ArrayList<Land> tempList = new ArrayList<Land>();		
		for(Land field: familyLand) {
			tempList.add(field.copy());
		}		
		return tempList;
	}	
	public void setFamilyLand(ArrayList<Land> familyLand) {
		this.familyLand = familyLand;
	}
	public int getWheat() {
		return wheat;
	}
	public void setWheat(int wheat) {
		this.wheat = wheat;
	}
	public int getBarley() {
		return barley;
	}
	public void setBarley(int barley) {
		this.barley = barley;
	}
	public int getOats() {
		return oats;
	}
	public void setOats(int oats) {
		this.oats = oats;
	}
	public int getLentils() {
		return lentils;
	}
	public void setLentils(int lentils) {
		this.lentils = lentils;
	}
	public int getFertilizer() {
		return fertilizer;
	}
	public void setFertilizer(int fertilizer) {
		this.fertilizer = fertilizer;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}		
}