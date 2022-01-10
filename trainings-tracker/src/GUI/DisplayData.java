package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Exercise;
import repository.ExerciseRepositoryImpl;

public class DisplayData extends JFrame implements ActionListener {
	// create title
	private JLabel title = new JLabel("Your Exercises:");
	// create info label
	private JLabel infoLabel = new JLabel("<html> Here you can see all of the exercises that you have completed. <br> Add another exercise or finish your workout. </html>");
		
	private JPanel contentPanel = new JPanel(new BorderLayout());
	private JPanel buttonsPanel = new JPanel(new GridLayout(1,3));
	// create buttons
	// create the buttons
	private JButton backButton = new JButton("Back");
	private JButton addButton = new JButton("Add exercise");
	private JButton finishButton = new JButton("Finish workout");
	
	private ExerciseRepositoryImpl repository = new ExerciseRepositoryImpl();
	
	private JPanel exercisesPanel = new JPanel(new GridLayout());
	
	public DisplayData() {
		// create window
		this.setSize(500,600);
		this.setLayout(new BorderLayout());
		
		// add buttons to buttons panel
		buttonsPanel.add(backButton);
		buttonsPanel.add(addButton);
		buttonsPanel.add(finishButton);
		
		this.add(buttonsPanel, BorderLayout.SOUTH);
		infoLabel.setPreferredSize(new Dimension(50,50));
		contentPanel.add(infoLabel, BorderLayout.NORTH);
		this.add(contentPanel, BorderLayout.CENTER);
	
		// define title
		title.setFont(new Font("Serif", Font.PLAIN, 24));
		this.add(title, BorderLayout.NORTH);
		
		backButton.addActionListener(this);
		addButton.addActionListener(this);
		finishButton.addActionListener(this);
		this.setVisible(true);
		
		
	}
	private void displayExercise() {
		for (Exercise exercise : repository.getAllExercises()) {
			//exercisesPanel.add(exercise.getName());
		}
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}