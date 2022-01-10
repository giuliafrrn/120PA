package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Exercise;

public class EnterData  extends JFrame implements ActionListener{
	// create title
	private JLabel title = new JLabel("Enter Data:");
	// create exercise label, which shows which exercise was chosen
	private JLabel exerciseLabel = new JLabel();
	//create exercise 
	private Exercise exercise = new Exercise();
	
	public EnterData(String exerciseName) {
			// create window
			this.setSize(500,600);
			this.setLayout(new BorderLayout());
			
			// define title
			title.setFont(new Font("Serif", Font.PLAIN, 24));
			this.add(title, BorderLayout.NORTH);
			
			// set text from exercise label
			exerciseLabel.setText(exerciseName);
			// set name on exercise name
			exercise.setName(exerciseName);
			
			this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
