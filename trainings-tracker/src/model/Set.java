package model;

public class Set {
	private int reps;
	private int weight;
	
	public Set(int reps, int weight) {
		super();
		this.reps = reps;
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getReps() {
		return reps;
	}
	public void setReps(int reps) {
		this.reps = reps;
	}
}
