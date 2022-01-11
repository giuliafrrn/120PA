package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Exercise;
import model.Set;
import model.SetRow;
import repository.ExerciseRepositoryImpl;

public class EnterData extends JFrame implements ActionListener{
	// create title
	private JLabel title = new JLabel("Enter Data:");
	// create exercise label, which shows which exercise was chosen
	private JLabel exerciseLabel = new JLabel();
	//create exercise 
	private Exercise exercise = new Exercise();
	// exercise panel
	private JPanel exercisePanel = new JPanel(new BorderLayout());
	// create button panel
	private JPanel buttonsPanel = new JPanel(new GridLayout(0,3));
	// create the buttons
	private JButton backButton = new JButton("Back");
	private JButton addSet = new JButton("Add set");
	private JButton continueButton = new JButton("Continue");
	
	//create panel for the sets
	private JPanel setsPanel = new JPanel(new GridLayout(0,1,10,10));
	
	private ArrayList<SetRow> rows = new ArrayList<SetRow>();
	private int counter = 1;
	private ExerciseRepositoryImpl repository;
	
	public EnterData(String exerciseName, ExerciseRepositoryImpl repository) {
			this.repository=repository;
			// create window
			this.setSize(500,300);
			this.setLayout(new BorderLayout());
			
			// define title
			title.setFont(new Font("Serif", Font.PLAIN, 24));
			this.add(title, BorderLayout.NORTH);
			
			// add the buttons to the buttons panel
			buttonsPanel.add(backButton);
			buttonsPanel.add(addSet);
			buttonsPanel.add(continueButton);
			// add the buttons to the window
			this.add(buttonsPanel, BorderLayout.SOUTH);
			// set text from exercise label
			exerciseLabel.setText(exerciseName);
			// set name on exercise name
			exercise.setName(exerciseName);
			// add exercise name to exercise panel
			exercisePanel.add(exerciseLabel, BorderLayout.NORTH);
			// add exercisePanel to the window
			this.add(exercisePanel, BorderLayout.CENTER);
			
			
			this.addRows();
			exercisePanel.add(new JScrollPane(setsPanel), BorderLayout.CENTER);
			
			
			// add buttons to actions listener
			backButton.addActionListener(this);
			addSet.addActionListener(this);
			continueButton.addActionListener(this);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
	}

	private void addRows() {
		while (counter < 4) {
			SetRow row = new SetRow(counter);
			setsPanel.add(row.getPanel());
			row.getCancelButton().addActionListener(this);
			rows.add(row);
			counter+=1;
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ( e.getSource() == addSet) {
			SetRow row = new SetRow(counter);
			setsPanel.add(row.getPanel());
			rows.add(row);
			row.getCancelButton().addActionListener(this);
			setsPanel.revalidate();
			validate();
			counter+=1;
		}
			
		if (e.getSource() == backButton) {
			SelectExerciseGUI selectExercise = new SelectExerciseGUI(repository);
		}
		
		for (SetRow row : rows) {
			if (e.getSource() == row.getCancelButton()) {
				int index = rows.indexOf(row);
				rows.remove(index);
				setsPanel.remove(row.getPanel());
				setsPanel.revalidate();
				validate();
				break;
			}
		}
		
		if (e.getSource() == continueButton) {
			for (SetRow row : rows) {
				int reps = Integer.parseInt(row.getRepsTextField().getText());
				int weight = Integer.parseInt(row.getWeightTextField().getText());
				Set set = new Set(reps, weight);
				exercise.addSet(set);
			}
			repository.saveTrainingExercise(exercise);
			DisplayData displayData = new DisplayData(exercise, repository);
		}
	}
}
	