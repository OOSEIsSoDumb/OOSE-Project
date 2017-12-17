package UI;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

	JFrame frame;
	private JTextField txt_name;
	private JTextField txt_address;
	private JTextField txt_postcode;
	private JTextField txt_tel;
	private JTextField txt_email;
	private JTextField txt_promo;
	private JTextField txt_discounts;
	private JTextField txt_subtotal;
	private JTextField txt_grandtotal;
	private JComboBox comboBox_membership;
	private JTextArea textArea_receipt;
	private ArrayList<Programs> programsList;
	private JLabel lbl_membership, lbl_promo;
	JButton[] btnMoreDetails;
	private MainMenuForm prevScreen;
	private JCheckBox chckbx_1, chckbx_2, chckbx_4, chckbx_5, chckbx_6;
	private JButton btn_Exit, btn_reset, btn_Receipt, btn_Total, button_6;
	private JButton btn_apply;
	private JTextField txt_1;
	private JTextField txt_2;
	private JTextField txt_3;
	private JTextField txt_4;
	private JTextField txt_5;
	private JTextField txt_RM5;
	private JTextField txt_RM20;
	private JLabel lblOff;
	private JLabel lblRm;
	private JLabel label_1;
	private JLabel label_2;

	public PurchaseProgram(MainMenuForm prevScreen, MainSystem system) {

		this.prevScreen = prevScreen;
		Container pane = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Purchase Program");
		setSize(1366, 725);
		setLocationRelativeTo(null);
		setVisible(true);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_1.setBounds(10, 260, 524, 309);
		pane.add(panel_1);
		panel_1.setLayout(null);

		chckbx_1 = new JCheckBox("");
		chckbx_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		chckbx_1.setBounds(6, 17, 21, 36);
		chckbx_1.addActionListener(this);
		panel_1.add(chckbx_1);

		programsList = system.getAllProgram();
		btnMoreDetails = new JButton[programsList.size()];

		System.out.println(programsList.size());

		JPanel btn_programs = new JPanel();
		btn_programs.setBounds(37, 17, 351, 270);
		panel_1.add(btn_programs);
		btn_programs.setLayout(new GridLayout(programsList.size(), 1));

		for (int i = 0; i < programsList.size(); i++) {
			Programs program = programsList.get(i);
			String label = program.getDetails() + "( " + program.getAuthors() + " )";

			JButton btnView = new JButton(label);
			btnView.addActionListener(this);
			btnMoreDetails[i] = btnView;

			JPanel p = new JPanel();
			p.setLayout(new FlowLayout(FlowLayout.LEFT));

			p.add(btnView);
			btn_programs.add(p);
		}

		chckbx_2 = new JCheckBox("");
		chckbx_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		chckbx_2.setBounds(6, 68, 21, 36);
		chckbx_2.addActionListener(this);
		panel_1.add(chckbx_2);

		chckbx_4 = new JCheckBox("");
		chckbx_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		chckbx_4.setBounds(6, 124, 21, 36);
		chckbx_4.addActionListener(this);
		panel_1.add(chckbx_4);

		chckbx_5 = new JCheckBox("");
		chckbx_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		chckbx_5.setBounds(6, 186, 21, 36);
		chckbx_5.addActionListener(this);
		panel_1.add(chckbx_5);

		chckbx_6 = new JCheckBox("");
		chckbx_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		chckbx_6.setBounds(6, 239, 21, 36);
		chckbx_6.addActionListener(this);
		panel_1.add(chckbx_6);

		txt_1 = new JTextField();
		txt_1.setEditable(false);
		txt_1.setFont(new Font("Dialog", Font.BOLD, 14));
		txt_1.setHorizontalAlignment(SwingConstants.CENTER);
		txt_1.setText("0");
		txt_1.setBounds(398, 27, 93, 26);
		panel_1.add(txt_1);
		txt_1.setColumns(10);

		txt_2 = new JTextField();
		txt_2.setEditable(false);
		txt_2.setFont(new Font("Dialog", Font.BOLD, 14));
		txt_2.setHorizontalAlignment(SwingConstants.CENTER);
		txt_2.setText("0");
		txt_2.setColumns(10);
		txt_2.setBounds(398, 78, 93, 26);
		panel_1.add(txt_2);

		txt_3 = new JTextField();
		txt_3.setEditable(false);
		txt_3.setFont(new Font("Dialog", Font.BOLD, 14));
		txt_3.setHorizontalAlignment(SwingConstants.CENTER);
		txt_3.setText("0");
		txt_3.setColumns(10);
		txt_3.setBounds(398, 134, 93, 26);
		panel_1.add(txt_3);

		txt_4 = new JTextField();
		txt_4.setEditable(false);
		txt_4.setFont(new Font("Dialog", Font.BOLD, 14));
		txt_4.setHorizontalAlignment(SwingConstants.CENTER);
		txt_4.setText("0");
		txt_4.setColumns(10);
		txt_4.setBounds(398, 196, 93, 26);
		panel_1.add(txt_4);

		txt_5 = new JTextField();
		txt_5.setEditable(false);
		txt_5.setFont(new Font("Dialog", Font.BOLD, 14));
		txt_5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_5.setText("0");
		txt_5.setColumns(10);
		txt_5.setBounds(398, 249, 93, 26);
		panel_1.add(txt_5);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_2.setBounds(474, 11, 454, 238);
		pane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblSelectYourMembership = new JLabel("Select Your Membership");
		lblSelectYourMembership.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectYourMembership.setBounds(20, 22, 197, 33);
		panel_2.add(lblSelectYourMembership);

		comboBox_membership = new JComboBox();
		comboBox_membership.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_membership.setModel(new DefaultComboBoxModel(new String[] { "Select", "Non-Member", "VIP Member" }));
		comboBox_membership.setBounds(20, 66, 142, 20);
		comboBox_membership.addActionListener(this);
		panel_2.add(comboBox_membership);

		JLabel lblPromoCode = new JLabel("Promo Code");
		lblPromoCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblPromoCode.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPromoCode.setBounds(233, 22, 221, 33);
		panel_2.add(lblPromoCode);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(227, 0, 1, 248);
		panel_2.add(panel_3);

		txt_promo = new JTextField();
		txt_promo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_promo.setBounds(270, 61, 155, 33);
		panel_2.add(txt_promo);
		txt_promo.setColumns(10);

		lbl_membership = new JLabel("* Select your membership");
		lbl_membership.setBounds(20, 200, 221, 14);
		panel_2.add(lbl_membership);

		lbl_promo = new JLabel("* Enter promo code");
		lbl_promo.setBounds(237, 200, 207, 14);
		panel_2.add(lbl_promo);

		btn_apply = new JButton("Apply");
		btn_apply.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_apply.setBounds(288, 161, 107, 28);
		btn_apply.addActionListener(this);
		panel_2.add(btn_apply);

		txt_RM5 = new JTextField();
		txt_RM5.setEditable(false);
		txt_RM5.setText("0");
		txt_RM5.setHorizontalAlignment(SwingConstants.CENTER);
		txt_RM5.setFont(new Font("Dialog", Font.BOLD, 14));
		txt_RM5.setColumns(10);
		txt_RM5.setBounds(297, 105, 62, 33);
		panel_2.add(txt_RM5);

		txt_RM20 = new JTextField();
		txt_RM20.setEditable(false);
		txt_RM20.setText("0");
		txt_RM20.setHorizontalAlignment(SwingConstants.CENTER);
		txt_RM20.setFont(new Font("Dialog", Font.BOLD, 14));
		txt_RM20.setColumns(10);
		txt_RM20.setBounds(49, 112, 62, 33);
		panel_2.add(txt_RM20);

		lblOff = new JLabel("OFF");
		lblOff.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOff.setBounds(121, 112, 38, 33);
		panel_2.add(lblOff);

		lblRm = new JLabel("RM");
		lblRm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRm.setBounds(20, 112, 30, 33);
		panel_2.add(lblRm);

		label_1 = new JLabel("RM");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(263, 105, 30, 33);
		panel_2.add(label_1);

		label_2 = new JLabel("OFF");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(368, 105, 38, 33);
		panel_2.add(label_2);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_4.setBounds(544, 260, 385, 309);
		pane.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblDiscounts = new JLabel("Discounts");
		lblDiscounts.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDiscounts.setBounds(10, 25, 128, 33);
		panel_4.add(lblDiscounts);

		txt_discounts = new JTextField();
		txt_discounts.setEditable(false);
		txt_discounts.setFont(new Font("Dialog", Font.BOLD, 14));
		txt_discounts.setColumns(10);
		txt_discounts.setBounds(158, 26, 199, 33);
		panel_4.add(txt_discounts);

		JLabel lblSubtotal = new JLabel("Sub-Total");
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSubtotal.setBounds(10, 111, 128, 33);
		panel_4.add(lblSubtotal);

		txt_subtotal = new JTextField();
		txt_subtotal.setEditable(false);
		txt_subtotal.setFont(new Font("Dialog", Font.BOLD, 14));
		txt_subtotal.setColumns(10);
		txt_subtotal.setBounds(158, 111, 199, 33);
		panel_4.add(txt_subtotal);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(0, 169, 385, 1);
		panel_4.add(panel_5);

		JLabel lblGrandTotal = new JLabel("Grand Total");
		lblGrandTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGrandTotal.setBounds(10, 214, 128, 33);
		panel_4.add(lblGrandTotal);

		txt_grandtotal = new JTextField();
		txt_grandtotal.setEditable(false);
		txt_grandtotal.setFont(new Font("Dialog", Font.BOLD, 14));
		txt_grandtotal.setColumns(10);
		txt_grandtotal.setBounds(158, 214, 199, 33);
		panel_4.add(txt_grandtotal);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_7.setBounds(10, 580, 918, 98);
		pane.add(panel_7);
		panel_7.setLayout(null);

		button_6 = new JButton("");
		button_6.setBounds(554, 11, 167, 64);
		panel_7.add(button_6);
		button_6.addActionListener(this);

		btn_Exit = new JButton("Exit");
		btn_Exit.setBounds(731, 11, 167, 64);
		panel_7.add(btn_Exit);
		btn_Exit.addActionListener(this);

		btn_reset = new JButton("Reset");
		btn_reset.setBounds(375, 11, 167, 64);
		panel_7.add(btn_reset);
		btn_reset.addActionListener(this);

		btn_Receipt = new JButton("Receipt");
		btn_Receipt.setBounds(198, 11, 167, 64);
		panel_7.add(btn_Receipt);
		btn_Receipt.addActionListener(this);

		btn_Total = new JButton("Total");
		btn_Total.setBounds(21, 11, 167, 64);
		panel_7.add(btn_Total);
		btn_Total.addActionListener(this);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(938, 11, 414, 667);
		pane.add(panel_8);
		panel_8.setLayout(null);

		JPanel panel = new JPanel();
		panel_8.add(panel);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBounds(10, 11, 454, 238);
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

		textArea_receipt = new JTextArea();
		textArea_receipt.setEditable(false);
		textArea_receipt.setFont(new Font("Dialog", Font.BOLD, 14));
		textArea_receipt.setBounds(946, 11, 394, 664);
		panel_8.add(textArea_receipt);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == btn_Exit) {
			frame = new JFrame("Exit");
			if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to Exit?", "Purchase Page",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				this.setVisible(false);
				MainMenuForm menu = new MainMenuForm();
				menu.setVisible(true);
			}
		}

		if (obj == btn_reset) {
			txt_name.setText(null);
			txt_address.setText(null);
			txt_postcode.setText(null);
			txt_email.setText(null);
			txt_tel.setText(null);
			comboBox_membership.setSelectedItem("Select");
			chckbx_1.setSelected(false);
			chckbx_2.setSelected(false);
			chckbx_4.setSelected(false);
			chckbx_5.setSelected(false);
			chckbx_6.setSelected(false);
			txt_1.setText(null);
			txt_2.setText(null);
			txt_3.setText(null);
			txt_4.setText(null);
			txt_5.setText(null);
			txt_RM20.setText("0");
			txt_RM5.setText("0");
			txt_promo.setText(null);
			txt_subtotal.setText(null);
			txt_discounts.setText(null);
			txt_grandtotal.setText(null);
			textArea_receipt.setText(null);
		}

		else if (obj == comboBox_membership) {
			if (comboBox_membership.getSelectedItem().equals("Non-Member")) {
				lbl_membership.setText("Register Member to get Discounts");
				txt_RM20.setText("0");

			} else if (comboBox_membership.getSelectedItem().equals("VIP Member")) {
				lbl_membership.setText("You will get RM20 Off your Purchase");
				txt_RM20.setText("20");
			} else if (comboBox_membership.getSelectedItem().equals("Select")) {
				lbl_membership.setText("* Select your membership");
			}
		}

		if (obj == btn_apply) {
			if (txt_promo.getText().equals("BREAK")) {
				lbl_promo.setText("Congrats! RM5 Off your Purchase");
				txt_RM5.setText("5");
			} else {
				txt_RM5.setText("0");
			}
		}

		if (chckbx_1.isSelected() == true) {
			txt_1.setText("700");
		} else if (chckbx_1.isSelected() == false) {
			txt_1.setText("0");
		}

		if (chckbx_2.isSelected() == true) {
			txt_2.setText("900");
		} else if (chckbx_2.isSelected() == false) {
			txt_2.setText("0");
		}

		if (chckbx_4.isSelected() == true) {
			txt_3.setText("500");
		} else if (chckbx_4.isSelected() == false) {
			txt_3.setText("0");
		}

		if (chckbx_5.isSelected() == true) {
			txt_4.setText("300");
		} else if (chckbx_5.isSelected() == false) {
			txt_4.setText("0");
		}

		if (chckbx_6.isSelected() == true) {
			txt_5.setText("100");
		} else if (chckbx_6.isSelected() == false) {
			txt_5.setText("0");
		}

		if (obj == btn_Total) {
			if (chckbx_1.isSelected() == false && chckbx_2.isSelected() == false && chckbx_6.isSelected() == false
					&& chckbx_4.isSelected() == false && chckbx_5.isSelected() == false) {
				JOptionPane.showMessageDialog(this, "Please Select a Program to Purchase", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			if (comboBox_membership.getSelectedItem().equals("Select") || txt_name.equals(null)
					|| txt_address.equals(null) || txt_email.equals(null) || txt_tel.equals(null)
					|| txt_postcode.equals(null)) {

				JOptionPane.showMessageDialog(this, "Please Select or Enter Required Fields", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				double[] TotalCost = new double[20];

				TotalCost[0] = 0;
				TotalCost[1] = Double.parseDouble(txt_1.getText());
				TotalCost[2] = Double.parseDouble(txt_2.getText());
				TotalCost[3] = Double.parseDouble(txt_3.getText());
				TotalCost[4] = Double.parseDouble(txt_4.getText());
				TotalCost[5] = Double.parseDouble(txt_5.getText());
				TotalCost[6] = Double.parseDouble(txt_RM20.getText());
				TotalCost[7] = Double.parseDouble(txt_RM5.getText());

				// Total Cost
				TotalCost[8] = TotalCost[1] + TotalCost[2] + TotalCost[3] + TotalCost[4] + TotalCost[5];
				// Total Discounts
				TotalCost[9] = TotalCost[6] + TotalCost[7];
				// Total Cost After Discount
				TotalCost[10] = TotalCost[8] - TotalCost[9];

				String subTotal = String.format("RM%.2f ", TotalCost[8]);
				String discounts = String.format("RM%.2f ", TotalCost[9]);
				String GrandTotal = String.format("RM%.2f ", TotalCost[10]);
				txt_subtotal.setText(subTotal);
				txt_discounts.setText(discounts);
				txt_grandtotal.setText(GrandTotal);
			}
		}

		if (obj == btn_Receipt) {
			if (chckbx_1.isSelected() == false && chckbx_2.isSelected() == false && chckbx_6.isSelected() == false
					&& chckbx_4.isSelected() == false && chckbx_5.isSelected() == false) {
				JOptionPane.showMessageDialog(this, "Please Select a Program to Purchase", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			if (comboBox_membership.getSelectedItem().equals("Select") || txt_name.equals(null)
					|| txt_address.equals(null) || txt_email.equals(null) || txt_tel.equals(null)
					|| txt_postcode.equals(null)) {

				JOptionPane.showMessageDialog(this, "Please Select or Enter Required Fields", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				String name = txt_name.getText();
				String address = txt_address.getText();
				String postcode = txt_postcode.getText();
				String tel = txt_tel.getText();
				String email = txt_email.getText();

				String subTotal = txt_subtotal.getText();
				String discounts = txt_discounts.getText();
				String grand = txt_grandtotal.getText();
				String memberdiscount = txt_RM20.getText();
				String promodiscount = txt_RM5.getText();

				textArea_receipt.append("\n" + "\n" + "\n" + "\tBreak A Sweat SDN BHD \n"
						+ "\n==============================================" + "\nName\t\t" + name + "\nAddress\t\t"
						+ address + "\nPost Code\t\t" + postcode + "\nTelephone Num\t" + tel + "\nEmail\t\t" + email
						+ "\n" + "\n==============================================" + "\nMember Discount\tRM"
						+ memberdiscount + "\nPromo Discount\tRM" + promodiscount + "\n"
						+ "\n==============================================" + "\nSub-Total\t\t" + subTotal
						+ "\nTotal Discounts\t" + discounts + "\nGrand Total\t\t" + grand + "\n"
						+ "\n=============================================="
						+ "\n\n\tThanks For Shopping With Us \n\t               Break A Sweat");

			}
		}
	}

}
