package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SelectExerciseGUI extends JFrame implements ActionListener {

	public SelectExerciseGUI() {
		// create window
		this.setSize(500,600);
		this.setLayout(new BorderLayout());
		
		// set title
		JLabel title = new JLabel("Select Exercise:");
		title.setFont(new Font("Serif", Font.PLAIN, 24));
		this.add(title, BorderLayout.NORTH);
		
		// create panel for buttons
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(0,3));
		// create the buttons
		JButton deleteButton = new JButton("Delete");
		JButton editButton = new JButton("Edit");
		JButton selectButton = new JButton("Select");
		// add the buttons to the JPanel
		buttonsPanel.add(deleteButton);
		buttonsPanel.add(editButton);
		buttonsPanel.add(selectButton);
		// add the buttons panel to the window
		this.add(buttonsPanel, BorderLayout.SOUTH);
		
		// create panel to add all the exercie stuff, like the list and search...
		JPanel exercisePanel = new JPanel(new BorderLayout());
		
		// create search panel
		JPanel searchPanel = new JPanel(new BorderLayout());
		//create search button to search
		JButton searchButton = new JButton("Search");
		// create search field
		JTextField searchField = new JTextField("");
		// add the search button and field to the search panel
		searchPanel.add(searchButton, BorderLayout.EAST);
		searchPanel.add(searchField, BorderLayout.CENTER);
		// add the searchPanel to the exercise Panel
		exercisePanel.add(searchPanel, BorderLayout.NORTH);
		
		// create a list of exercises
		JList<String> exercisesList = new JList<String>();
		DefaultListModel<String> model = new DefaultListModel<String>();
		model.addElement("Benchpress");
		model.addElement("Squats");
		model.addElement("Reverse flyes");
		exercisesList.setModel(model);
		//add the list to the exercise panel
		exercisePanel.add(exercisesList, BorderLayout.CENTER);
		
		// create add button to add a exercise		
		JButton addButton = new JButton("Add");
		// create input field, to add new exercise
		JTextField input = new JTextField();
		//create new Panel to add a new exercise
		JPanel createExercisePanel = new JPanel(new BorderLayout());
		createExercisePanel.add(addButton, BorderLayout.EAST);
		createExercisePanel.add(input, BorderLayout.CENTER);
		
		//add the createExercisePanel to the exercisePanel
		exercisePanel.add(createExercisePanel, BorderLayout.SOUTH);
			
		//add the exercisePanel to the window
		this.add(exercisePanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
