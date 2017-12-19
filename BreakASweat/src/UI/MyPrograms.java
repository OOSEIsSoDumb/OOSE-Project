package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Dimension;

import javax.swing.JScrollBar;

import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTextArea;

import logic.MainSystem;
import logic.Programs;
import Data.DatabaseManager;
import Data.TempProgramRecord;

public class MyPrograms extends JFrame implements ActionListener{

	JFrame frame;
	JList list;
	JLabel lbl_programName;
	JLabel lbl_author;
	JLabel lbl_price;
	JLabel lbl_pictures;
	JTextArea txt_description;
	JPanel content;
	JLabel lbl_guide;
	JButton btn_back;
	JButton btnJoinNow;
	JButton btnAddYourProgram;
	DatabaseManager db= new DatabaseManager();
	MainMenuForm mainmenu;
	String picture;
	ArrayList<TempProgramRecord> tempProgram = new ArrayList<TempProgramRecord>();
	MainSystem system;
	DefaultListModel itemlist;
	InsertProgram iProgram;
	/**
	 * Create the application.
	 */
	public MyPrograms(MainMenuForm main,MainSystem system) {
		this.mainmenu=main;
		this.system=system;
		frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setSize(1104, 743);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		btn_back = new JButton("Back");
		btn_back.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_back.setMargin(new Insets(2, 8, 2, 8));
		btn_back.setMaximumSize(new Dimension(70, 25));
		btn_back.setMinimumSize(new Dimension(70, 25));
		btn_back.setPreferredSize(new Dimension(59, 30));
		btn_back.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btn_back, BorderLayout.WEST);
		btn_back.addActionListener(this);
		
		JLabel program_title = new JLabel("    My Programs");
		program_title.setPreferredSize(new Dimension(55, 30));
		program_title.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		program_title.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 25));
		panel.add(program_title, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(410, 10));
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel program_sub_title = new JLabel("   Programs");
		program_sub_title.setBorder(new MatteBorder(1, 1, 1, 2, (Color) new Color(0, 0, 0)));
		program_sub_title.setPreferredSize(new Dimension(400, 30));
		program_sub_title.setMinimumSize(new Dimension(80, 16));
		program_sub_title.setMaximumSize(new Dimension(80, 16));
		program_sub_title.setFont(new Font("Trajan Pro 3", Font.BOLD, 20));
		panel_1.add(program_sub_title, BorderLayout.NORTH);
		
		itemlist= new DefaultListModel();
		tempProgram = db.getProgram();

		for(TempProgramRecord program: tempProgram){
			itemlist.addElement(program.getTitle());
			
		}
		if(db.getProgram().size()>5){
			list = new JList(iProgram.itemlist);
		}
		else{
			list = new JList(itemlist);
		}
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		MouseListener mouseListener = new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
				 if (e.getClickCount() == 2) {
					 
					 String selectedItem = (String) list.getSelectedValue();
					 //tempProgram = db.getProgram();
					 if(tempProgram.size()>5){
						 tempProgram=iProgram.tempprogram;
					 }
					 
					 for(TempProgramRecord program : tempProgram){
						 if(program.getTitle().equals(selectedItem)){
							 lbl_programName.setText("Program: "+ selectedItem);
							 lbl_price.setText("Price: "+ program.getPrice());
							 ImageIcon icon = new ImageIcon(program.getPictures());
							 lbl_pictures.setIcon(icon);
							 lbl_pictures.setAlignmentX(JLabel.CENTER_ALIGNMENT);
							 lbl_pictures.setAlignmentY(JLabel.CENTER_ALIGNMENT);
							 lbl_author.setText("Author: "+ program.getAuthors());
							 txt_description.setText(program.getDetails());
							
						 }
					 }
					 lbl_programName.setVisible(true);
					 txt_description.setVisible(true);
					 lbl_price.setVisible(true);
					 lbl_pictures.setVisible(true);
					 lbl_author.setVisible(true);
					 lbl_guide.setVisible(false);
				 }
			 }
		};
		list.addMouseListener(mouseListener);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBorder(new MatteBorder(1, 1, 1, 2, (Color) new Color(0, 0, 0)));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setPreferredSize(new Dimension(400, 2));
		scrollPane.setAutoscrolls(true);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 2, (Color) new Color(0, 0, 0)));
		panel_1.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		btnAddYourProgram = new JButton("Add Your Program");
		btnAddYourProgram.addActionListener(this);
		if(mainmenu.checkIsContributor()){
			panel_2.add(btnAddYourProgram);
		}
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel_3.setAlignmentX(Component.RIGHT_ALIGNMENT);
		frame.getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPreview = new JLabel("   Preview");
		lblPreview.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		lblPreview.setPreferredSize(new Dimension(45, 30));
		panel_3.add(lblPreview, BorderLayout.NORTH);
		lblPreview.setFont(new Font("Trajan Pro 3", Font.PLAIN, 16));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnJoinNow = new JButton("Join Now");
		panel_5.add(btnJoinNow);
		btnJoinNow.addActionListener(this);
		
		/*
		 * Preview part
		 */
		
		content = new JPanel();
		content.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panel_3.add(content, BorderLayout.CENTER);
		content.setLayout(null);
		
		lbl_programName = new JLabel("Program:");
		lbl_programName.setBounds(39, 329, 598, 16);
		content.add(lbl_programName);
		lbl_programName.setVisible(false);
		
		lbl_author = new JLabel("Author:");
		lbl_author.setBounds(39, 362, 598, 16);
		content.add(lbl_author);
		lbl_author.setVisible(false);
		
		txt_description = new JTextArea();
		txt_description.setEditable(false);
		txt_description.setLineWrap(true);
		txt_description.setBounds(39, 415, 598, 170);
		content.add(txt_description);
		txt_description.setVisible(false);
		
		lbl_price = new JLabel("Price:");
		lbl_price.setBounds(39, 386, 598, 16);
		content.add(lbl_price);
		lbl_price.setVisible(false);
		
		lbl_pictures = new JLabel();
		lbl_pictures.setBounds(227, 13, 614, 290);
		content.add(lbl_pictures);
		
		lbl_guide = new JLabel("Double Click Programs to show The Preview");
		lbl_guide.setBounds(200, 264, 598, 16);
		content.add(lbl_guide);
		lbl_guide.setVisible(true);
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if(obj == btn_back){
			mainmenu.setVisible(true);
			this.frame.setVisible(false);
		}
		if(obj == btnJoinNow ){
			 String selectedItem = (String) list.getSelectedValue();
			 if (JOptionPane.showConfirmDialog(null, "Are you sure you want to join the Program? YES(proceed to purchase program) NO(continue shopping)", "Hello There",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				 PurchaseProgram purchase= new PurchaseProgram(mainmenu,system);
				 purchase.setVisible(true);
				 this.frame.setVisible(false);
				 if(list.getSelectedIndex()==0){
					 purchase.chckbx_1.setSelected(true);
					 purchase.txt_1.setText("700");
				 }
				 if(list.getSelectedIndex()==1){
					 purchase.chckbx_2.setSelected(true);
					 purchase.txt_2.setText("900");
				 }
				 if(list.getSelectedIndex()==2){
					 purchase.chckbx_4.setSelected(true);
					 purchase.txt_3.setText("500");
				 }
				 if(list.getSelectedIndex()==3){
					 purchase.chckbx_5.setSelected(true);
					 purchase.txt_4.setText("300");
				 }
				 if(list.getSelectedIndex()==4){
					 purchase.chckbx_6.setSelected(true);
					 purchase.txt_5.setText("100");
				 }
			 } else {
				    // no option(close the dialog continue shop)
				}
			 
		}
		if(obj==btnAddYourProgram){
			InsertProgram insertProgram = new InsertProgram(this);
			insertProgram.frame.setSize(644, 654);
			insertProgram.frame.setLocationRelativeTo(null);
			insertProgram.frame.setVisible(true);
			this.frame.setVisible(false);
		}
	}
}
