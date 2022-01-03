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
	// create the buttons
	private JButton deleteButton = new JButton("Delete");
	private	JButton editButton = new JButton("Edit");
	private JButton selectButton = new JButton("Select");
	//create search button to search
	private JButton searchButton = new JButton("Search");
	// create search field
	private JTextField searchField = new JTextField("");
	// create add button to add a exercise		
	private	JButton addButton = new JButton("Add");
	// create input field, to add new exercise
	private JTextField input = new JTextField();
	// create a list of exercises
	private JList<String> exercisesList = new JList<String>();
	private DefaultListModel<String> model = new DefaultListModel<String>();
	
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
	
		// add the search button and field to the search panel
		searchPanel.add(searchButton, BorderLayout.EAST);
		searchPanel.add(searchField, BorderLayout.CENTER);
		// add the searchPanel to the exercise Panel
		exercisePanel.add(searchPanel, BorderLayout.NORTH);
		
		
		model.addElement("Benchpress");
		model.addElement("Squats");
		model.addElement("Reverse flyes");
		exercisesList.setModel(model);
		//add the list to the exercise panel
		exercisePanel.add(exercisesList, BorderLayout.CENTER);
		
		
		//create new Panel to add a new exercise
		JPanel createExercisePanel = new JPanel(new BorderLayout());
		createExercisePanel.add(addButton, BorderLayout.EAST);
		createExercisePanel.add(input, BorderLayout.CENTER);
		
		//add the createExercisePanel to the exercisePanel
		exercisePanel.add(createExercisePanel, BorderLayout.SOUTH);
			
		//add the exercisePanel to the window
		this.add(exercisePanel, BorderLayout.CENTER);
		
		
		deleteButton.addActionListener(this);
		editButton.addActionListener(this);
		addButton.addActionListener(this);
		selectButton.addActionListener(this);
		
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addButton) {
			model.addElement(input.getText());
			input.setText("");
		}
		if(e.getSource() == deleteButton) {
			int index = exercisesList.getSelectedIndex();
			this.removeByIndex(index);
		}
		
		if (e.getSource() == editButton) {
			int index = exercisesList.getSelectedIndex();
			input.setText(model.get(index));
			this.removeByIndex(index);
		}
		if (e.getSource() == searchButton) {
			/*
			 for (String s :liste) {
		            if (!s.startsWith(searchField.getText())) {
		                if (model.contains(s)) {
		                    model.removeElement(s);
		                }
		            } else {
		                if (!model.contains(s)) {
		                    model.addElement(s);
		                }
		            }
		        }*/
		}
		
		
	}
	private void removeByIndex(int index) {
		if (index >=0) {
			model.remove(index);
		}
	}

}
