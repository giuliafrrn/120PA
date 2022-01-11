package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Exercise;
import repository.ExerciseRepositoryImpl;

public class ConfirmFinish extends JFrame implements ActionListener {
	private ExerciseRepositoryImpl repository;
	private JButton yesButton = new JButton("Yes");
	private JButton noButton = new JButton("No");
	private JLabel textLabel = new JLabel("Are you sure you want to quit your training?");
	private JPanel buttonsPanel = new JPanel(new GridLayout(1,2));
	private Exercise lastExercise;
	
	public ConfirmFinish(Exercise lastExercise,ExerciseRepositoryImpl repository){
		this.repository=repository;
		this.lastExercise = lastExercise;
		// create window
		this.setSize(500,200);
		this.setLayout(new BorderLayout());
		
		buttonsPanel.add(yesButton);
		buttonsPanel.add(noButton);
		this.add(buttonsPanel, BorderLayout.SOUTH);
		this.add(textLabel, BorderLayout.CENTER);
		yesButton.addActionListener(this);
		noButton.addActionListener(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == yesButton ) {
			 System.exit(0);
		}
		
		if (e.getSource() == noButton) {
			DisplayData displayData = new DisplayData(lastExercise, repository);
		}	
	}

}
