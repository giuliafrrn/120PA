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
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.Exercise;
import repository.ExerciseRepository;
import repository.ExerciseRepositoryImpl;

public class SelectExerciseGUI extends JFrame implements ActionListener {
	// create the buttons
	private JButton deleteButton = new JButton("Delete");
	private	JButton editButton = new JButton("Edit");
	private JButton selectButton = new JButton("Select");
	//create search label to search
	private JLabel searchLabel = new JLabel("Search:");
	// create search field
	private final JTextField searchField = new JTextField("");
	// create add button to add a exercise		
	private	JButton addButton = new JButton("Add");
	private JTextField input = new JTextField("");
	// create a list of exercises
	private JList<String> exercisesList = new JList<String>();
	private DefaultListModel<String> model = new DefaultListModel<String>();
	// create title
	private JLabel title = new JLabel("Select Exercise:");
	//create panels
	private JPanel buttonsPanel = new JPanel();
	// create panel to add all the exercise stuff, like the list and search...
	private JPanel exercisePanel = new JPanel(new BorderLayout());
	// create search panel
	private JPanel searchPanel = new JPanel(new BorderLayout());
	//create new Panel to add a new exercise
	private JPanel createExercisePanel = new JPanel(new BorderLayout());
	//create repository
	private ExerciseRepositoryImpl repository;
	
	public SelectExerciseGUI(ExerciseRepositoryImpl repository) {
		this.repository=repository;
		// create window
		this.setSize(500,400);
		this.setLayout(new BorderLayout());
		
		// define title
		title.setFont(new Font("Serif", Font.PLAIN, 24));
		this.add(title, BorderLayout.NORTH);
		
		// create panel for buttons
		buttonsPanel.setLayout(new GridLayout(0,3));
		// add the buttons to the JPanel
		buttonsPanel.add(deleteButton);
		buttonsPanel.add(editButton);
		buttonsPanel.add(selectButton);
		// add the buttons panel to the window
		this.add(buttonsPanel, BorderLayout.SOUTH);
	
		this.createDefaultListModel();
		
		// add the search button and field to the search panel
		searchPanel.add(searchLabel, BorderLayout.WEST);
		searchPanel.add(this.createSearchField(), BorderLayout.CENTER);
		// add the searchPanel to the exercise Panel
		exercisePanel.add(searchPanel, BorderLayout.NORTH);
		
	
		exercisesList.setModel(model);
		//add the list to the exercise panel
		exercisePanel.add(new JScrollPane(exercisesList), BorderLayout.CENTER);
		
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

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	private JTextField createSearchField() {
		
		searchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				this.filter();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				this.filter();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			private void filter() {
				filterModel();
			}
			
			});
		return searchField;
	}
	
	private void createDefaultListModel() {
		   for (Exercise s : repository.getAllExercises()) {
	            model.addElement(s.getName());
		   }
	}
	
	public void filterModel() {
		for (Exercise s :repository.getAllExercises()) {
			if (!s.getName().startsWith(searchField.getText())) {
				if (model.contains(s.getName())) {
					model.removeElement(s.getName());
				}
			} else {
				if (!model.contains(s.getName())) {
					model.addElement(s.getName());
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addButton) {
			model.addElement(input.getText());
			repository.saveExercise(new Exercise(input.getText()));
			input.setText("");
		}
		if(e.getSource() == deleteButton) {
			// delete exercise from repository
			repository.deleteExercise(repository.getExerciseByName(model.get(exercisesList.getSelectedIndex())));
			this.removeByIndex();
		}
		
		if (e.getSource() == editButton) {
			// remove from list
			input.setText(model.get(exercisesList.getSelectedIndex()));
			repository.deleteExercise(repository.getExerciseByName(model.get(exercisesList.getSelectedIndex())));
			this.removeByIndex();	
			
		}	
		if(e.getSource() == selectButton) {
			//TODO: select
			EnterData enterData = new EnterData(model.get(exercisesList.getSelectedIndex()), repository);
		}
		
		
	}
	
	private void removeByIndex() {
		int index = exercisesList.getSelectedIndex();
		if (index >=0) {
			model.remove(index);
		}
	}

}
