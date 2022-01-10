package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Exercise;
import model.SetRow;

public class EnterData  extends JFrame implements ActionListener{
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
	
	// create a list of exercises
	private JList<JTextField> exercisesList = new JList<JTextField>();
	private DefaultListModel<JTextField> model = new DefaultListModel<JTextField>();

	private ArrayList<SetRow> rows = new ArrayList<SetRow>();
	
	
	SetRow row1 = new SetRow(1);
	SetRow row2 = new SetRow(2);
	SetRow row3 = new SetRow(3);
	JPanel panelTest = new JPanel(new GridLayout(2,0));
	JScrollPane scrollPane = new JScrollPane();
	
	public EnterData(String exerciseName) {
			// create window
			this.setSize(500,600);
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
			
			
			
			
			panelTest.add(row1.getPanel());
			panelTest.add(row2.getPanel());
			scrollPane.setViewportView(panelTest);
			/*
			scrollPane.add(row1.getPanel());
			scrollPane.add(row2.getPanel());
			scrollPane.add(row3.getPanel());
		
			*/
			
			
			exercisePanel.add(scrollPane, BorderLayout.CENTER);
			
			this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ( e.getSource() == addSet) {
			panelTest.add(row3.getPanel());
			scrollPane.setViewportView(panelTest);
		}
			
	}
}
	