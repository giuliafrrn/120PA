package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		JButton deleteButton = new JButton("delete");
		JButton editButton = new JButton("edit");
		JButton selectButton = new JButton("select");
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
		
		//add the exercisePanel to the window
		this.add(exercisePanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
