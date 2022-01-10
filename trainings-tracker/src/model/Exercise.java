package model;

import java.util.ArrayList;

public class Exercise {
	private String name;
	private ArrayList<Set> sets;
	
	public Exercise() {
		
	}

	public Exercise(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Set> getSets() {
		return sets;
	}
	public void setSets(ArrayList<Set> sets) {
		this.sets = sets;
	}
	
	public void addSet(Set newSet) {
		this.sets.add(newSet);
	}
	
	public void removeSet(Set oldSet) {
		this.sets.remove(oldSet);
	}
	
	
	
}
