package repository;

import java.util.ArrayList;

import model.Exercise;

public class ExerciseRepositoryImpl implements ExerciseRepository{

	ArrayList<Exercise> exercises = new ArrayList<Exercise>();
    
	public ExerciseRepositoryImpl(){
		exercises.add(new Exercise("Bench press"));
		exercises.add(new Exercise("Reverse flyes"));
		exercises.add(new Exercise("Squats"));
	}
	
	@Override
	public Exercise getExerciseByName(String name) {
	    for (Exercise exercise : exercises) {
	        if (exercise.getName().equals(name)) {
	            return exercise;
	        }
	    }
		return null;
	}

	@Override
	public ArrayList<Exercise> getAllExercises() {
		// TODO Auto-generated method stub
		return exercises;
	}

	@Override
	public void saveExercise(Exercise exercise) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteExercise(Exercise exercise) {
		int indexlist = exercises.indexOf(exercise);
		exercises.remove(indexlist);
		
	}
	
	
	

}
