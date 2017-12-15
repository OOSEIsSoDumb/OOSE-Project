package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class Register {

	JFrame frame;
	private JTextField txt_username;
	private JPasswordField pf_loginpassword;
	private JPasswordField pf_cloginpassword;
	private JTextField txt_email;
	private JTextField txt_profession;
	private JTextField txt_contactNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_title = new JLabel("Register Account");
		lbl_title.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbl_title.setBounds(140, 11, 126, 19);
		frame.getContentPane().add(lbl_title);
		
		JLabel lbl_username = new JLabel("Username");
		lbl_username.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbl_username.setBounds(36, 53, 77, 14);
		frame.getContentPane().add(lbl_username);
		
		JLabel lbl_password = new JLabel("Password");
		lbl_password.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbl_password.setBounds(36, 91, 64, 14);
		frame.getContentPane().add(lbl_password);
		
		JLabel lbl_cpassword = new JLabel("Confirm Password");
		lbl_cpassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbl_cpassword.setBounds(36, 130, 119, 14);
		frame.getContentPane().add(lbl_cpassword);
		
		txt_username = new JTextField();
		txt_username.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txt_username.setBounds(180, 51, 126, 20);
		frame.getContentPane().add(txt_username);
		txt_username.setColumns(10);
		
		pf_loginpassword = new JPasswordField();
		pf_loginpassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pf_loginpassword.setBounds(180, 89, 126, 20);
		frame.getContentPane().add(pf_loginpassword);
		
		pf_cloginpassword = new JPasswordField();
		pf_cloginpassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pf_cloginpassword.setText("");
		pf_cloginpassword.setBounds(180, 128, 126, 20);
		frame.getContentPane().add(pf_cloginpassword);
		
		JLabel lbl_email = new JLabel("E-mail Address");
		lbl_email.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbl_email.setBounds(36, 168, 98, 14);
		frame.getContentPane().add(lbl_email);
		
		txt_email = new JTextField();
		txt_email.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txt_email.setBounds(180, 166, 126, 20);
		frame.getContentPane().add(txt_email);
		txt_email.setColumns(10);
		
		final JLabel lbl_gender = new JLabel("Gender");
		lbl_gender.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbl_gender.setBounds(36, 257, 119, 16);
		lbl_gender.setVisible(false);
		frame.getContentPane().add(lbl_gender);
		
		final JLabel lbl_profession = new JLabel("Profession");
		lbl_profession.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbl_profession.setBounds(36, 300, 119, 16);
		lbl_profession.setVisible(false);
		frame.getContentPane().add(lbl_profession);
		
		final JLabel lbl_contactNo = new JLabel("Contact No.");
		lbl_contactNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbl_contactNo.setBounds(36, 346, 119, 16);
		lbl_contactNo.setVisible(false);
		frame.getContentPane().add(lbl_contactNo);
		
		final JComboBox cb_gender = new JComboBox();
		cb_gender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		cb_gender.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cb_gender.setBounds(222, 256, 64, 20);
		cb_gender.setVisible(false);
		frame.getContentPane().add(cb_gender);
		
		txt_profession = new JTextField();
		txt_profession.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txt_profession.setColumns(10);
		txt_profession.setBounds(222, 299, 116, 20);
		txt_profession.setVisible(false);
		frame.getContentPane().add(txt_profession);
		
		txt_contactNo = new JTextField();
		txt_contactNo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		txt_contactNo.setColumns(10);
		txt_contactNo.setBounds(222, 342, 116, 20);
		txt_contactNo.setVisible(false);
		frame.getContentPane().add(txt_contactNo);

		final JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Your account has been registered.");
				frame.dispose();
			}
		});

		btnRegister.setFont(new Font("Felix Titling", Font.PLAIN, 11));
		btnRegister.setBounds(217, 203, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		final JCheckBox cb_contributor = new JCheckBox("Register as Contributor");
		cb_contributor.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		cb_contributor.setBounds(36, 202, 176, 23);
		frame.getContentPane().add(cb_contributor);
		cb_contributor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cb_contributor.isSelected()){
					
					try {
						lbl_gender.setVisible(true);
						lbl_profession.setVisible(true);
						lbl_contactNo.setVisible(true);
						cb_gender.setVisible(true);
						txt_profession.setVisible(true);
						txt_contactNo.setVisible(true);
						btnRegister.setBounds(217, 370, 89, 23);
						frame.setBounds(100, 100, 450, 474);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else{
					lbl_gender.setVisible(false);
					lbl_profession.setVisible(false);
					lbl_contactNo.setVisible(false);
					cb_gender.setVisible(false);
					txt_profession.setVisible(false);
					txt_contactNo.setVisible(false);
					btnRegister.setBounds(217, 203, 89, 23);
					frame.setBounds(100, 100, 450, 300);
				}
			}
		});
	
		
		
	}
}
