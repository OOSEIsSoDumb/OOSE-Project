package UI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import logic.MainSystem;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BMICalculatorInputData extends JFrame implements ActionListener, ItemListener {

	JButton button;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private MainMenuForm prevScreen;
	private String gender = "Male";
	private JButton btnBack;
	private int random;

	public BMICalculatorInputData(MainMenuForm prevScreen , MainSystem system) {
	
		this.prevScreen = prevScreen;
		
		setTitle("BMI Calculator");
		setResizable(false);
		setSize(785, 390);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		Container pane = getContentPane();
		pane.setLayout(null);
		
		JLabel label = new JLabel("BMI CALCULATOR");
		label.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		label.setBounds(91, 39, 200, 30);
		pane.add(label);
		
		JLabel label_1 = new JLabel("Your Gender :");
		label_1.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		label_1.setBounds(30, 96, 135, 30);
		pane.add(label_1);
		
		radioButton = new JRadioButton("Male");
		radioButton.setSelected(true);
		radioButton.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		radioButton.setBounds(190, 96, 75, 30);
		pane.add(radioButton);
		
		radioButton_1 = new JRadioButton("Female");
		radioButton_1.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		radioButton_1.setBounds(267, 96, 78, 30);
		pane.add(radioButton_1);
		
		ButtonGroup grp = new ButtonGroup();
		grp.add(radioButton);
		grp.add(radioButton_1);
		
		// radio button action
		radioButton.addItemListener(this);
		radioButton_1.addItemListener(this);
		
		// age
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(190, 151, 155, 25);
		pane.add(textField);
		
		textField.addActionListener(this);
		
		// weight
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(190, 204, 155, 25);
		pane.add(textField_1);
		
		textField_1.addActionListener(this);
		
		// height
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(190, 256, 155, 25);
		pane.add(textField_2);
		
		textField_2.addActionListener(this);
		
		button = new JButton("Compute BMI");
		button.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		button.setBounds(105, 308, 170, 25);
		pane.add(button);
		
		// button action
		button.addActionListener(this);
		
		JLabel label_2 = new JLabel("Your Height (cm) :");
		label_2.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		label_2.setBounds(30, 250, 135, 30);
		pane.add(label_2);
		
		JLabel label_3 = new JLabel("Your Weight (kg) :");
		label_3.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		label_3.setBounds(30, 198, 135, 30);
		pane.add(label_3);
		
		JLabel label_4 = new JLabel("Your Age (years) :");
		label_4.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		label_4.setBounds(30, 147, 135, 30);
		pane.add(label_4);
		
		JPanel panel = new JPanel();
		panel.setBounds(390, 25, 355, 308);
		pane.add(panel);
		
		String fileName = "BMI.png";
		ImageIcon icon = new ImageIcon(fileName);
		JLabel image = new JLabel(icon);
		panel.add(image);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 89, 23);
		getContentPane().add(btnBack);
		btnBack.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object o = e.getSource();
		
		if(o == button){
			
			if(!textField.getText().isEmpty() && !textField_1.getText().isEmpty() && !textField_2.getText().isEmpty()) {
				
			random = (int)(Math.random()*5 + 1);
				
			this.setVisible(false);
			new BMICalculator(random, gender , (Integer.parseInt(textField.getText())), (Double.parseDouble(textField_1.getText())), (Double.parseDouble(textField_2.getText())),this);
			
			}
			
			else {
				JOptionPane.showMessageDialog(this, "Please key in all text fields.");
			}
			
		}
		
		if(o == btnBack) {
			this.setVisible(false);
			prevScreen.setVisible(true);
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
		if(radioButton.isSelected()){
			gender = "Male";
		}
		else if(radioButton_1.isSelected()){
			gender = "Female";
		}
		
	}
	
}
