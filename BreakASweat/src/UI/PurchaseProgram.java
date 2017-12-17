package UI;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.TextArea;
import java.util.ArrayList;

import logic.MainSystem;
import logic.Programs;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PurchaseProgram extends JFrame implements ActionListener {

	private JTextField txt_name;
	private JTextField txt_address;
	private JTextField txt_postcode;
	private JTextField txt_tel;
	private JTextField txt_email;
	private JTextField txt_membership;
	private JTextField txt_promo;
	private JTextField txt_discounts;
	private JTextField txt_subtotal;
	private JTextField txt_grandtotal;
	private ArrayList<Programs> programsList;
	JButton[] btnMoreDetails;
	private MainMenuForm prevScreen;
	
	public PurchaseProgram(MainMenuForm prevScreen , MainSystem system) {
		
		this.prevScreen = prevScreen;
		Container pane = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("View All Member Screen");
		setSize(1366, 768);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBounds(10, 11, 454, 238);
		pane.add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(10, 27, 130, 28);
		panel.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddress.setBounds(10, 66, 130, 28);
		panel.add(lblAddress);
		
		JLabel lblPostcode = new JLabel("Postcode");
		lblPostcode.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPostcode.setBounds(10, 105, 128, 28);
		panel.add(lblPostcode);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTelephone.setBounds(10, 144, 130, 28);
		panel.add(lblTelephone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmail.setBounds(10, 183, 130, 28);
		panel.add(lblEmail);
		
		txt_name = new JTextField();
		txt_name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_name.setBounds(190, 28, 223, 28);
		panel.add(txt_name);
		txt_name.setColumns(10);
		
		txt_address = new JTextField();
		txt_address.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_address.setColumns(10);
		txt_address.setBounds(190, 66, 223, 28);
		panel.add(txt_address);
		
		txt_postcode = new JTextField();
		txt_postcode.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_postcode.setColumns(10);
		txt_postcode.setBounds(190, 105, 223, 28);
		panel.add(txt_postcode);
		
		txt_tel = new JTextField();
		txt_tel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_tel.setColumns(10);
		txt_tel.setBounds(190, 144, 223, 27);
		panel.add(txt_tel);
		
		txt_email = new JTextField();
		txt_email.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txt_email.setColumns(10);
		txt_email.setBounds(190, 183, 223, 27);
		panel.add(txt_email);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_1.setBounds(10, 260, 524, 309);
		pane.add(panel_1);
		panel_1.setLayout(null);
		
		JCheckBox chckbx_1 = new JCheckBox("Program 1");
		chckbx_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		chckbx_1.setBounds(6, 17, 321, 36);
		panel_1.add(chckbx_1);
		
		
		
		programsList = system.getAllProgram();
		btnMoreDetails = new JButton[programsList.size()];
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(new GridLayout(programsList.size(), 1));
		panel_1.add(panel_9);
		
		System.out.println(programsList.size());
		
		for(int i=0; i<programsList.size(); i++) {
			Programs program = programsList.get(i);
			String label = program.getTitle() + "( "+ program.getPrice() + " )";
			
			JButton btnView = new JButton(label);
			btnView.addActionListener(this);
			btnMoreDetails[i] = btnView;
			
			JPanel p = new JPanel();
			p.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			p.add(new JLabel((i+1)+"."));
			p.add(btnView);
			panel_9.add(p);
		}
		
		JCheckBox chckbx_2 = new JCheckBox("Program 2");
		chckbx_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		chckbx_2.setBounds(6, 56, 321, 36);
		panel_1.add(chckbx_2);
		
		JCheckBox chckbx_3 = new JCheckBox("Program 3");
		chckbx_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		chckbx_3.setBounds(6, 95, 321, 36);
		panel_1.add(chckbx_3);
		
		JCheckBox chckbx_4 = new JCheckBox("Program 4");
		chckbx_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		chckbx_4.setBounds(6, 134, 321, 36);
		panel_1.add(chckbx_4);
		
		JCheckBox chckbx_5 = new JCheckBox("Program 5");
		chckbx_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		chckbx_5.setBounds(6, 173, 321, 36);
		panel_1.add(chckbx_5);
		
		JCheckBox chckbx_6 = new JCheckBox("Program 6");
		chckbx_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		chckbx_6.setBounds(6, 212, 321, 36);
		panel_1.add(chckbx_6);
		
		JCheckBox chckbx_7 = new JCheckBox("Program 7");
		chckbx_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		chckbx_7.setBounds(6, 251, 321, 36);
		panel_1.add(chckbx_7);

		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_2.setBounds(474, 11, 454, 238);
		pane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSelectYourMembership = new JLabel("Select Your Membership");
		lblSelectYourMembership.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSelectYourMembership.setBounds(20, 22, 243, 33);
		panel_2.add(lblSelectYourMembership);
		
		JComboBox comboBox_membership = new JComboBox();
		comboBox_membership.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_membership.setModel(new DefaultComboBoxModel(new String[] {"Select", "Non-Member", "VIP Member"}));
		comboBox_membership.setBounds(20, 66, 142, 20);
		panel_2.add(comboBox_membership);
		
		txt_membership = new JTextField();
		txt_membership.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_membership.setBounds(20, 112, 161, 33);
		panel_2.add(txt_membership);
		txt_membership.setColumns(10);
		
		JLabel lblPromoCode = new JLabel("Promo Code");
		lblPromoCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblPromoCode.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPromoCode.setBounds(211, 22, 243, 33);
		panel_2.add(lblPromoCode);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(251, 0, 1, 237);
		panel_2.add(panel_3);
		
		txt_promo = new JTextField();
		txt_promo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_promo.setBounds(270, 61, 155, 33);
		panel_2.add(txt_promo);
		txt_promo.setColumns(10);
		
		JLabel lbl_membership = new JLabel("* Select your membership");
		lbl_membership.setBounds(20, 200, 180, 14);
		panel_2.add(lbl_membership);
		
		JLabel lbl_promo = new JLabel("* Enter promo code");
		lbl_promo.setBounds(264, 200, 180, 14);
		panel_2.add(lbl_promo);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_4.setBounds(544, 260, 385, 309);
		pane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblDiscounts = new JLabel("Discounts");
		lblDiscounts.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDiscounts.setBounds(10, 25, 173, 33);
		panel_4.add(lblDiscounts);
		
		txt_discounts = new JTextField();
		txt_discounts.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_discounts.setColumns(10);
		txt_discounts.setBounds(158, 26, 199, 33);
		panel_4.add(txt_discounts);
		
		JLabel lblSubtotal = new JLabel("Sub-Total");
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSubtotal.setBounds(10, 111, 173, 33);
		panel_4.add(lblSubtotal);
		
		txt_subtotal = new JTextField();
		txt_subtotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_subtotal.setColumns(10);
		txt_subtotal.setBounds(158, 111, 199, 33);
		panel_4.add(txt_subtotal);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(0, 169, 385, 1);
		panel_4.add(panel_5);
		
		JLabel lblGrandTotal = new JLabel("Grand Total");
		lblGrandTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGrandTotal.setBounds(10, 214, 173, 33);
		panel_4.add(lblGrandTotal);
		
		txt_grandtotal = new JTextField();
		txt_grandtotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_grandtotal.setColumns(10);
		txt_grandtotal.setBounds(158, 214, 199, 33);
		panel_4.add(txt_grandtotal);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_7.setBounds(10, 580, 918, 98);
		pane.add(panel_7);
		panel_7.setLayout(null);
		
		JButton button_6 = new JButton("");
		button_6.setBounds(554, 11, 167, 64);
		panel_7.add(button_6);
		
		JButton btn_Exit = new JButton("Exit");
		btn_Exit.setBounds(731, 11, 167, 64);
		panel_7.add(btn_Exit);
		
		JButton btn_reset = new JButton("Reset");
		btn_reset.setBounds(375, 11, 167, 64);
		panel_7.add(btn_reset);
		
		JButton btn_Receipt = new JButton("Receipt");
		btn_Receipt.setBounds(198, 11, 167, 64);
		panel_7.add(btn_Receipt);
		
		JButton btn_Total = new JButton("Total");
		btn_Total.setBounds(21, 11, 167, 64);
		panel_7.add(btn_Total);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_8.setBounds(938, 11, 414, 667);
		pane.add(panel_8);
		panel_8.setLayout(null);
		
		TextArea textArea_receipt = new TextArea();
		textArea_receipt.setBounds(10, 21, 394, 571);
		panel_8.add(textArea_receipt);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
