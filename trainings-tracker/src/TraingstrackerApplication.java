import GUI.SelectExercise;
import repository.ExerciseRepositoryImpl;

public class TraingstrackerApplication {
	//create repository
	private static ExerciseRepositoryImpl repository = new ExerciseRepositoryImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectExercise selectExercise = new SelectExercise(repository);
	}

}
