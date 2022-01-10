package repository;

import java.util.ArrayList;

import model.Exercise;

public interface ExerciseRepository{
	
	Exercise getExerciseByName(String name);
	
	ArrayList<Exercise> getAllExercises();
	
	void saveExercise(Exercise exercise);
	
	void deleteExercise(Exercise exercise);
	
}
