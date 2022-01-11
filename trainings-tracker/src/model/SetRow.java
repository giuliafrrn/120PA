package model;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SetRow {
	
	private int id;
	private JLabel repsLabel = new JLabel();
	private JLabel weightLabel = new JLabel();
	private JTextField repsTextField = new JTextField("");
	private JTextField weightTextField = new JTextField("");
	private JButton cancelButton = new JButton("X");	
	private JPanel panel = new JPanel(new GridLayout(1,4,10,10));
	
	public SetRow(int counter) {
		this.id = counter;
		this.repsLabel.setText(counter + ". set: reps:");
		this.weightLabel.setText("weight:");
	
	}
	public JPanel getPanel() {
		panel.add(repsLabel);
		panel.add(repsTextField);
		panel.add(weightLabel);
		panel.add(weightTextField);
		panel.add(cancelButton);
		return panel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public JButton getCancelButton() {
		return cancelButton;
	}
	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}
	public JLabel getRepsLabel() {
		return repsLabel;
	}

	public void setRepsLabel(JLabel repsLabel) {
		this.repsLabel = repsLabel;
	}

	public JLabel getWeightLabel() {
		return weightLabel;
	}

	public void setWeightLabel(JLabel weightLabel) {
		this.weightLabel = weightLabel;
	}

	public JTextField getRepsTextField() {
		return repsTextField;
	}

	public void setRepsTextField(JTextField repsTextField) {
		this.repsTextField = repsTextField;
	}

	public JTextField getWeightTextField() {
		return weightTextField;
	}

	public void setWeightTextField(JTextField weightTextField) {
		this.weightTextField = weightTextField;
	}
	
	
}
