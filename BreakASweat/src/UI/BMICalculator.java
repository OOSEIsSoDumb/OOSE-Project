package UI;



import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logic.Workouts;

import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class BMICalculator extends JFrame implements ActionListener , ListSelectionListener {

	private JTextField textField; // age
	private JTextField textField_1; // weight
	private JTextField textField_2; // height
	private JTextField textField_3; // bmi
	private JTextArea textArea; // comment
	private JTextField textField_5; // gender
	private JButton btnBack;
	private JList list;
	private BMICalculatorInputData prevScreen;

	private String gender;
	private int age;
	private double weight;
	private double height;
	private double BMI;
	private int random;
	
	public BMICalculator(int random, String gender, int age, double weight, double height, BMICalculatorInputData p){
		this.random = random;
		this.gender = gender;
		this.age = age;
		this.weight = weight;
		this.height = height;
		
		prevScreen = p;
		
		setBackground(new Color(240, 240, 240));
		setTitle("BMI Calculator ( Result )");
		setResizable(false);
		setBounds(100, 100, 843, 680);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		initialize();
	}
	public String getGender(){
		return gender;
	}
	public int getAge(){
		return age;
	}
	public double getWeight(){
		return weight;
	}
	public double getheight(){
		return height;
	}
	public double getBMI() {
		BMI = weight/((height/100)*(height/100));
		return BMI;
	}
	public double getRandom(){
		return random;
	}
	
	public String getPic() {
		if (getRandom() == 1) {
			return "tips/1.png";
		}
		else if (getRandom() == 2) {
			return "tips/2.png";
		}
		else if (getRandom() == 3) {
			return "tips/3.png";
		}
		else if (getRandom() == 4) {
			return "tips/4.png";
		}
		else {
			return "tips/5.png";
		}
	}

	private void initialize() {
		
		Container pane = getContentPane();
		pane.setLayout(null);
		
		JLabel lblBmiCalculator = new JLabel("THE RESULT :");
		lblBmiCalculator.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		lblBmiCalculator.setBounds(120, 21, 125, 30);
		pane.add(lblBmiCalculator);
		
		JLabel lblYourWeightkg = new JLabel("Your Weight (kg) :");
		lblYourWeightkg.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblYourWeightkg.setBounds(25, 178, 135, 30);
		pane.add(lblYourWeightkg);
		
		JLabel lblYourHeightcm = new JLabel("Your Height (cm) :");
		lblYourHeightcm.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblYourHeightcm.setBounds(25, 233, 135, 30);
		pane.add(lblYourHeightcm);
		
		JLabel lblYourAgeyears = new JLabel("Your Age (years) :");
		lblYourAgeyears.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblYourAgeyears.setBounds(25, 126, 135, 30);
		pane.add(lblYourAgeyears);
		
		JLabel lblYourGender = new JLabel("Your Gender :");
		lblYourGender.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblYourGender.setBounds(25, 70, 135, 30);
		pane.add(lblYourGender);
		
		textField = new JTextField();
		textField.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		textField.setEditable(false);
		textField.setBounds(185, 130, 155, 25);
		pane.add(textField);
		textField.setColumns(10);

		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(185, 184, 155, 25);
		pane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(185, 239, 155, 25);
		pane.add(textField_2);
		
		JSlider slider = new JSlider();
		slider.setMinorTickSpacing(1);
		slider.setToolTipText("");
		slider.setMajorTickSpacing(5);
		slider.setMaximum(30);
		
		if(getBMI() <= 0) {
			slider.setValue(0);
		}
		else if(getBMI() >= 30) {
			slider.setValue(30);
		}
		else {
			slider.setValue((int)getBMI());
		}
		
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setBounds(25, 360, 315, 38);
		slider.setEnabled(false);
		pane.add(slider);
		
		JLabel lblResult = new JLabel("Your BMI / BMI  for Age :");
		lblResult.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblResult.setBounds(25, 293, 195, 25);
		pane.add(lblResult);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tekton Pro", Font.BOLD, 16));
		textField_3.setEditable(true);
		textField_3.setColumns(10);
		textField_3.setBounds(215, 294, 125, 25);
		textField_3.setEditable(false);
		pane.add(textField_3);
		
		JLabel lblComments = new JLabel("Comments :");
		lblComments.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblComments.setBounds(25, 443, 88, 30);
		pane.add(lblComments);
		
		Panel panel = new Panel();
		panel.setBounds(390, 57, 422, 329);
		pane.add(panel);
		
		String fileName = getPic();
		ImageIcon icon = new ImageIcon(fileName);
		JLabel image = new JLabel(icon);
		panel.add(image);
		
		JLabel lblHealthyTips = new JLabel("HEALTHY TIPS :");
		lblHealthyTips.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		lblHealthyTips.setBounds(528, 21, 146, 30);
		pane.add(lblHealthyTips);
		
		JLabel lblSuggestedWorkouts = new JLabel("SUGGESTED WORKOUTS :");
		lblSuggestedWorkouts.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		lblSuggestedWorkouts.setBounds(471, 402, 260, 30);
		pane.add(lblSuggestedWorkouts);
		
		list = new JList();
		list.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		list.setSelectedIndices(new int[] {0});
		
		if (getBMI() < 25) {
			list.setModel(new AbstractListModel() {
				String[] values = new String[] {"BARBELL SQUAT - 5 sets of 5 reps", "BARBELL CURL - 2 sets of 8 reps", "PULL UPS - 2 sets of 8 reps", "SIDE LATERAL RAISE - 2 sets of 8 reps", "SIT-UP - 2 sets of 15 reps"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
		}
		else {
			list.setModel(new AbstractListModel() {
				String[] values = new String[] {"RUNNING", "STATIONARY BIKE", "ROWING MACHINE", "STAIRS", "POWER YOGA"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
		}
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
		
		list.setBounds(390, 443, 422, 147);
		pane.add(list);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(185, 76, 155, 25);
		pane.add(textField_5);
		
		textField.setText("" + getAge());
		textField_1.setText("" + getWeight());
		textField_2.setText("" + getheight());
		DecimalFormat df = new DecimalFormat("0.00");
		double BMIvalue = getBMI();
		textField_3.setText("" + df.format(BMIvalue));

	    textArea = new JTextArea();
	    textArea.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		textArea.setBounds(136, 443, 204, 147);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		pane.add(textArea);
		
		if( BMIvalue < 18.5) {
			textArea.append("You are UNDERWEIGHT. Your body weight is too low. Consult a nutritionist to put on more weight.");
		}
		else if( BMIvalue >= 18.5 && getBMI() < 25) {
			textArea.setText("Congratulations ! Your body weight is in the desirable range. ");
		}
		else if( BMIvalue >= 25 && getBMI() < 30) {
			textArea.setText("You are OVERWEIGHT ! Your body weight is too high ! Consult a nutritionist !");
		}
		else {
			textArea.setText("You are OBESE ! Your body weight is too excessive ! Consult a nutritionist !");
		}
		
		textField_5.setText("" + getGender());
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		btnBack.setBounds(374, 618, 89, 23);
		pane.add(btnBack);
		
		btnBack.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == btnBack) {
			this.setVisible(false);
			prevScreen.setVisible(true);
		}
		
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		String exercise = (String)list.getSelectedValue();
		new Workouts(exercise).getDetail();
	}
}
