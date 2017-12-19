package UI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import Data.TempProgramRecord;

public class InsertProgram extends JFrame implements ActionListener{

	JFrame frame;
	private JTextField txt_price;
	private JTextField txt_author;
	private JTextField txt_title;
	private JLabel lbl_picture;
	private JButton btn_addProgram;
	private JButton btn_selectPicture;
	private JButton btn_back;
	private JTextField txt_imagePath;
	private JTextArea txt_description;
	private String filename;
	private MyPrograms myProgram;
	private File f;
	DefaultListModel itemlist;
	BufferedImage image;
	ArrayList<TempProgramRecord> tempprogram;
	

	/**
	 * Create the application.
	 */
	public InsertProgram(MyPrograms myprog) {
		this.myProgram=myprog;
		
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(65, 220, 56, 16);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(65, 267, 56, 16);
		frame.getContentPane().add(lblAuthor);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(65, 308, 56, 16);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(65, 349, 176, 16);
		frame.getContentPane().add(lblDescription);
		
		txt_price = new JTextField();
		txt_price.setBounds(116, 305, 458, 22);
		frame.getContentPane().add(txt_price);
		txt_price.setColumns(10);
		
		txt_author = new JTextField();
		txt_author.setColumns(10);
		txt_author.setBounds(116, 264, 458, 22);
		frame.getContentPane().add(txt_author);
		
		txt_title = new JTextField();
		txt_title.setColumns(10);
		txt_title.setBounds(116, 217, 458, 22);
		frame.getContentPane().add(txt_title);
		
		lbl_picture = new JLabel("");
		lbl_picture.setBounds(64, 11, 230, 196);
		frame.getContentPane().add(lbl_picture);
		lbl_picture.setVisible(false);
		
		btn_addProgram = new JButton("Add Program");
		btn_addProgram.setBounds(227, 550, 136, 25);
		frame.getContentPane().add(btn_addProgram);
		btn_addProgram.addActionListener(this);
		
		btn_selectPicture = new JButton("Attach Image");
		btn_selectPicture.setBounds(322, 97, 168, 25);
		frame.getContentPane().add(btn_selectPicture);
		btn_selectPicture.addActionListener(this);
		
		btn_back = new JButton("Back");
		btn_back.setBounds(450,30, 100, 25);
		frame.getContentPane().add(btn_back);
		btn_back.addActionListener(this);
		
		txt_imagePath = new JTextField();
		txt_imagePath.setColumns(10);
		txt_imagePath.setBounds(322, 129, 252, 22);
		frame.getContentPane().add(txt_imagePath);
		
		txt_description = new JTextArea();
		txt_description.setLineWrap(true);
		txt_description.setBounds(65, 378, 509, 148);
		frame.getContentPane().add(txt_description);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj= e.getSource();
		if(obj==btn_selectPicture){
			JFileChooser filechooser = new JFileChooser();
			int result = filechooser.showSaveDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				f = filechooser.getSelectedFile();
			} else if (result == JFileChooser.CANCEL_OPTION) {
			    System.out.println("Cancel was selected");
			}
			
			filename = f.getName();
			txt_imagePath.setText(f.getAbsolutePath());
			ImageIcon icon=new ImageIcon(txt_imagePath.getText());
			lbl_picture.setIcon(icon);
			lbl_picture.setVisible(true);
			
		}
		if(obj==btn_addProgram && lbl_picture.isVisible()){
			String title = txt_title.getText();
			String author = txt_author.getText();
			String price = txt_price.getText();
			String description = txt_description.getText();
			myProgram.db.insertProgram(title, "img/"+filename, author, description, price);
			
			JOptionPane.showMessageDialog(this, "Your Program Has Been Added");
			myProgram.tempProgram = myProgram.db.getProgram();
			myProgram.itemlist.clear();
			
			for(TempProgramRecord program: myProgram.tempProgram){
				myProgram.itemlist.addElement(program.getTitle());
			}
			tempprogram=myProgram.tempProgram;
			itemlist=myProgram.itemlist;
			try {
				image = ImageIO.read(f);
				ImageIO.write(image, "jpg", new File("img/"+filename));
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			myProgram.frame.setVisible(true);
			this.frame.setVisible(false);
			myProgram.iProgram=this;
		}
		else if(obj==btn_addProgram && lbl_picture.isVisible()==false){
			JOptionPane.showMessageDialog(this, "Opps, where is you picture?");

		}
		if(obj==btn_back){
			myProgram.frame.setVisible(true);
			this.frame.setVisible(false);
		}
	}
}
