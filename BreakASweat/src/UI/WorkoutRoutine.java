package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Data.DatabaseManager;
import Data.TempProgramRecord;
import Data.TempWorkoutRecord;
import logic.MainSystem;
import logic.Workouts;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class WorkoutRoutine extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txt_name;
	private DefaultListModel<String> listModelHidden = new DefaultListModel<>();
	private DefaultListModel<String> listModelVisible = new DefaultListModel<>();
	private DefaultListModel<String> listModelr1 = new DefaultListModel<>();
	private DefaultListModel<String> listModelr2 = new DefaultListModel<>();
	private DefaultListModel<String> listModelr3 = new DefaultListModel<>();
	private DefaultListModel<String> listModelr4 = new DefaultListModel<>();
	private MainMenuForm prevScreen;
	Workouts workout;
	JList listVisible, list_r1, list_r2, list_r3, list_r4, listHidden;
	JButton btnAddAll, btn_remove, btn_removeAll, btnAdd, btn_Add1, btn_Add2, btn_Add3, btn_Add4, btnRemove_routine;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_5;
	JLabel lbl_pic;
	private JLabel lblFavourites;
	private JButton btnBack;
	ArrayList<TempWorkoutRecord> tempWorkout = new ArrayList<TempWorkoutRecord>();
	DatabaseManager db = new DatabaseManager();

	public WorkoutRoutine(MainMenuForm prevScreen2, MainSystem system) {

		this.prevScreen = prevScreen2;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366, 751);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JList list = new JList();
		list.setBounds(143, 123, -60, 43);
		contentPane.add(list);

		JLabel lblWorkoutRoutine = new JLabel("Types Of Workouts");
		lblWorkoutRoutine.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblWorkoutRoutine.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkoutRoutine.setBounds(20, 45, 299, 37);
		contentPane.add(lblWorkoutRoutine);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBounds(10, 79, 762, 345);
		contentPane.add(panel);
		panel.setLayout(null);

		listHidden = new JList<>(listModelHidden);
		listHidden.setBorder(new LineBorder(new Color(0, 0, 0)));
		listHidden.setBounds(473, 35, 263, 289);
		listHidden.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//listHidden.addListSelectionListener(this);
		// panel.add(listHidden);

		btnAdd = new JButton("ADD >");
		btnAdd.setBounds(307, 56, 140, 39);
		btnAdd.addActionListener(this);
		panel.add(btnAdd);

		btn_remove = new JButton("< REMOVE");
		btn_remove.setBounds(308, 204, 140, 39);
		btn_remove.addActionListener(this);

		btnAddAll = new JButton("ADD ALL >");
		btnAddAll.setBounds(308, 112, 140, 39);
		btnAddAll.addActionListener(this);
		panel.add(btnAddAll);
		panel.add(btn_remove);

		btn_removeAll = new JButton("< REMOVE ALL");
		btn_removeAll.setBounds(308, 255, 140, 39);
		btn_removeAll.addActionListener(this);
		panel.add(btn_removeAll);

		tempWorkout = db.getWorkoutRegister();
		listVisible = new JList<>(listModelVisible);
		listVisible.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				 String selectedItem = (String) listVisible.getSelectedValue();
				 
				 for(TempWorkoutRecord workout : tempWorkout){
					 if(workout.getName().equals(selectedItem)){
						 txt_name.setText(workout.getName());
						 ImageIcon icon = new ImageIcon(workout.getPh());
						 lbl_pic.setIcon(icon);
					 }
				 }
			}
		});
		listVisible.setFont(new Font("Tahoma", Font.PLAIN, 18));
		//listVisible.addListSelectionListener(this);
		listVisible.setModel(new AbstractListModel() {
			String[] values = new String[] { "PUSH UPS", "BACK PRESS", "PULL UPS", "BENCHED PRESS", "CABLE FLY",
					"DEAD LIFT", "DUMBBELL FLYS", "PARALLEL BAR DIPS", "BARBELL CURLS", "HAMMER CURLS", "CARDIO",
					"UPRIGHT ROWS" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listVisible.setBounds(21, 35, 263, 289);
		// panel.add(listVisible);
		listVisible.setBorder(new LineBorder(new Color(0, 0, 0)));

		scrollPane = new JScrollPane(listVisible);
		scrollPane.setBounds(10, 26, 287, 308);
		panel.add(scrollPane);

		scrollPane_1 = new JScrollPane(listHidden);
		scrollPane_1.setBounds(457, 23, 295, 311);
		panel.add(scrollPane_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_1.setBounds(782, 79, 558, 621);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		list_r1 = new JList(listModelr1);
		list_r1.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_r1.setBounds(41, 50, 220, 155);
		//list_r1.addListSelectionListener(this);
		// panel_1.add(list_r1);

		list_r2 = new JList(listModelr2);
		list_r2.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_r2.setBounds(315, 50, 220, 155);
		//list_r2.addListSelectionListener(this);
		// panel_1.add(list_r2);

		list_r3 = new JList(listModelr3);
		list_r3.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_r3.setBounds(41, 298, 220, 155);
		//list_r3.addListSelectionListener(this);
		// panel_1.add(list_r3);

		list_r4 = new JList(listModelr4);
		list_r4.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_r4.setBounds(315, 298, 220, 155);
		//list_r4.addListSelectionListener(this);
		// panel_1.add(list_r4);

		JLabel lblRoutine = new JLabel("Easy");
		lblRoutine.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoutine.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoutine.setBounds(89, 25, 103, 19);
		panel_1.add(lblRoutine);

		JLabel lblRoutine_1 = new JLabel("Moderate");
		lblRoutine_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoutine_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoutine_1.setBounds(371, 26, 103, 19);
		panel_1.add(lblRoutine_1);

		JLabel lblRoutine_2 = new JLabel("Intense");
		lblRoutine_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoutine_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoutine_2.setBounds(96, 273, 103, 19);
		panel_1.add(lblRoutine_2);

		JLabel lblRoutine_3 = new JLabel("High Intensity");
		lblRoutine_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoutine_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoutine_3.setBounds(371, 273, 103, 19);
		panel_1.add(lblRoutine_3);

		btn_Add1 = new JButton("Add To Routine 1");
		btn_Add1.setBounds(79, 216, 140, 39);
		btn_Add1.addActionListener(this);
		panel_1.add(btn_Add1);

		btn_Add2 = new JButton("Add To Routine 2");
		btn_Add2.setBounds(371, 216, 140, 39);
		btn_Add2.addActionListener(this);
		panel_1.add(btn_Add2);

		btn_Add3 = new JButton("Add To Routine 3");
		btn_Add3.setBounds(89, 464, 140, 39);
		btn_Add3.addActionListener(this);
		panel_1.add(btn_Add3);

		btn_Add4 = new JButton("Add To Routine 4");
		btn_Add4.setBounds(371, 464, 140, 39);
		btn_Add4.addActionListener(this);
		panel_1.add(btn_Add4);

		btnRemove_routine = new JButton("Remove");
		btnRemove_routine.setBounds(408, 571, 140, 39);
		btnRemove_routine.addActionListener(this);
		panel_1.add(btnRemove_routine);

		scrollPane_2 = new JScrollPane(list_r1);
		scrollPane_2.setBounds(29, 43, 242, 169);
		panel_1.add(scrollPane_2);

		scrollPane_3 = new JScrollPane(list_r2);
		scrollPane_3.setBounds(306, 43, 242, 169);
		panel_1.add(scrollPane_3);

		scrollPane_4 = new JScrollPane(list_r3);
		scrollPane_4.setBounds(29, 294, 242, 163);
		panel_1.add(scrollPane_4);

		scrollPane_5 = new JScrollPane(list_r4);
		scrollPane_5.setBounds(306, 294, 242, 163);
		panel_1.add(scrollPane_5);

		JLabel lblRoutines = new JLabel("Routines");
		lblRoutines.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoutines.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblRoutines.setBounds(918, 33, 299, 37);
		contentPane.add(lblRoutines);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel_2.setBounds(15, 439, 756, 261);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		// ImageIcon icon = new ImageIcon(workout.getPh());
		lbl_pic = new JLabel();
		lbl_pic.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_pic.setBounds(296, 22, 421, 215);
		panel_2.add(lbl_pic);

		JLabel lblExample = new JLabel("Example >>");
		lblExample.setHorizontalAlignment(SwingConstants.CENTER);
		lblExample.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblExample.setBounds(10, 132, 245, 37);
		panel_2.add(lblExample);

		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblName.setBounds(10, 26, 245, 37);
		panel_2.add(lblName);

		txt_name = new JTextField();
		txt_name.setEditable(false);
		txt_name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_name.setHorizontalAlignment(SwingConstants.CENTER);
		txt_name.setBounds(33, 74, 222, 38);
		panel_2.add(txt_name);
		txt_name.setColumns(10);
		
		lblFavourites = new JLabel("Favourites");
		lblFavourites.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavourites.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblFavourites.setBounds(473, 45, 299, 37);
		contentPane.add(lblFavourites);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 89, 37);
		btnBack.addActionListener(this);
		contentPane.add(btnBack);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == btnAdd) {
			for (Object selectedValue : listVisible.getSelectedValuesList()) {
				listModelHidden.addElement((String) selectedValue);
				int iSelected = listVisible.getSelectedIndex();
				if (iSelected == -1)
					return;

			}
		}

		if (obj == btnAddAll) {
			for (int i = 0; i < listVisible.getModel().getSize(); i++) {
				String get = (String) listVisible.getModel().getElementAt(i);
				listModelHidden.addElement(get);
			}
		}

		if (obj == btn_Add1) {
			for (Object selectedValue : listVisible.getSelectedValuesList()) {
				listModelr1.addElement((String) selectedValue);
				int iSelected = listVisible.getSelectedIndex();
				if (iSelected == -1)
					return;

			}
		}
		if (obj == btn_Add2) {
			for (Object selectedValue : listVisible.getSelectedValuesList()) {
				listModelr2.addElement((String) selectedValue);
				int iSelected = listVisible.getSelectedIndex();
				if (iSelected == -1)
					return;

			}
		}
		if (obj == btn_Add3) {
			for (Object selectedValue : listVisible.getSelectedValuesList()) {
				listModelr3.addElement((String) selectedValue);
				int iSelected = listVisible.getSelectedIndex();
				if (iSelected == -1)
					return;

			}
		}
		if (obj == btn_Add4) {
			for (Object selectedValue : listVisible.getSelectedValuesList()) {
				listModelr4.addElement((String) selectedValue);
				int iSelected = listVisible.getSelectedIndex();
				if (iSelected == -1)
					return;

			}
		}

		if (obj == btn_remove) {
			for (Object selectedValue : listHidden.getSelectedValuesList()) {
				listModelHidden.removeElement(selectedValue);
				int iSelected = listVisible.getSelectedIndex();
				if (iSelected == -1)
					return;
			}
		}
		if (obj == btnRemove_routine) {
			for (Object selectedValue : list_r1.getSelectedValuesList()) {
				listModelr1.removeElement(selectedValue);
				int iSelected = list_r1.getSelectedIndex();
				if (iSelected == -1)
					return;
			}
			for (Object selectedValue : list_r2.getSelectedValuesList()) {
				listModelr2.removeElement(selectedValue);
				int iSelected = list_r2.getSelectedIndex();
				if (iSelected == -1)
					return;
			}
			for (Object selectedValue : list_r3.getSelectedValuesList()) {
				listModelr3.removeElement(selectedValue);
				int iSelected = list_r3.getSelectedIndex();
				if (iSelected == -1)
					return;
			}
			for (Object selectedValue : list_r4.getSelectedValuesList()) {
				listModelr4.removeElement(selectedValue);
				int iSelected = list_r4.getSelectedIndex();
				if (iSelected == -1)
					return;
			}

		}

		if (obj == btn_removeAll) {
			listModelHidden.clear();
		}
		
		if(obj == btnBack) {
			this.setVisible(false);
			prevScreen.wk=this;
			prevScreen.setVisible(true);
		}

	}



}