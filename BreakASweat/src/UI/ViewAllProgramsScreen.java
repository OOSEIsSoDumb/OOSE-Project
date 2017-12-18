package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.MainSystem;
import logic.Programs;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ViewAllProgramsScreen extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txt_price;
	private JTextField txt_author;
	private JTextField txt_title;
	private JButton btnBack; 
	private PurchaseProgram prevScreen;
	
	public ViewAllProgramsScreen(PurchaseProgram prevScreen, Programs program ) {
		
		this.prevScreen = prevScreen;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("View All Programs");
		setSize(1014, 713);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		ImageIcon icon = new ImageIcon(program.getPrice());
				
		JLabel label = new JLabel(icon);
		label.setBounds(190, 24, 614, 290);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBounds(187, 326, 621, 312);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Program Name");
		lblTitle.setBounds(19, 26, 222, 26);
		panel.add(lblTitle);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(19, 80, 154, 32);
		panel.add(lblAuthor);
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(20, 133, 65, 32);
		panel.add(lblPrice);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setBounds(20, 189, 74, 32);
		panel.add(lblDetails);
		lblDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JTextArea txt_area = new JTextArea();
		txt_area.setEditable(false);
		txt_area.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_area.setLineWrap(true);
		txt_area.setRows(2);
		txt_area.setBounds(257, 188, 308, 98);
		txt_area.append(program.getPictures());
		panel.add(txt_area);
		
		txt_price = new JTextField(program.getAuthors(), JLabel.CENTER);
		txt_price.setEditable(false);
		txt_price.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_price.setBounds(255, 134, 306, 29);
		panel.add(txt_price);
		txt_price.setColumns(10);
		
		txt_author = new JTextField(program.getTitle(), JLabel.CENTER);
		txt_author.setEditable(false);
		txt_author.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_author.setColumns(10);
		txt_author.setBounds(255, 79, 306, 29);
		panel.add(txt_author);
		
		txt_title = new JTextField(program.getDetails(), JLabel.CENTER);
		txt_title.setEditable(false);
		txt_title.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_title.setColumns(10);
		txt_title.setBounds(255, 21, 306, 29);
		panel.add(txt_title);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(9, 17, 91, 32);
		btnBack.addActionListener(this);
		contentPane.add(btnBack);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
		prevScreen.setVisible(true);
		
	}
}
