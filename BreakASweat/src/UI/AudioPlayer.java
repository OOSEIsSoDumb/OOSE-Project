package UI;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import logic.MainSystem;

public class AudioPlayer extends JFrame implements ActionListener , ListSelectionListener , LineListener {
	
	private JList list = new JList();
	private JTextArea txtrPleaseSelectA = new JTextArea();
	JButton btnPlay = null;
	JButton btnStop = null ;
	JButton btnPause = null;
	JButton btnRepeat = null;
	JButton btnBack;
	
	File soundFile;
	JDialog playingDialog;
	Clip clip;
	private JLabel lblNewLabel = new JLabel("Repeat Off");
	long clipTime = 0;

	boolean check = false;
	boolean check2 = false;
	boolean playing = false;
	private final JButton btnSelect = new JButton("Select Song From File");
	private MainMenuForm prevScreen2;

	public AudioPlayer(MainMenuForm prevScreen2, MainSystem system) {
		this.prevScreen2 = prevScreen2;
		setTitle("Audio Player");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 736, 458);
		Container pane = getContentPane();
		pane.setLayout(null);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		list.setBounds(24, 71, 267, 249);
		list.setSelectedIndices(new int[] {0});
		
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Beautiful Now - AKON", "Dangerously - Charlie Puth"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		pane.add(list);
		list.addListSelectionListener(this);
		
		JLabel lblSongList = new JLabel("SONG LIST");
		lblSongList.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		lblSongList.setBounds(91, 41, 138, 31);
		pane.add(lblSongList);
		txtrPleaseSelectA.setText("Please Select A Music From the List");
		
		txtrPleaseSelectA.setFont(new Font("Comic Sans MS", Font.PLAIN, 19));
		txtrPleaseSelectA.setBounds(366, 67, 328, 196);
		txtrPleaseSelectA.setEditable(false);
		txtrPleaseSelectA.setLineWrap(true);
		txtrPleaseSelectA.setWrapStyleWord(true);
		pane.add(txtrPleaseSelectA);
		
		JLabel lblSongDetails = new JLabel("SONG DETAILS :");
		lblSongDetails.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		lblSongDetails.setBounds(365, 29, 242, 31);
		pane.add(lblSongDetails);
		
		String fileName = "button/play.png" ;
		ImageIcon icon = new ImageIcon(fileName);
	    btnPlay = new JButton(icon);
		btnPlay.setBorderPainted(false);
	    btnPlay.setFocusPainted(false);
	    btnPlay.setContentAreaFilled(false);
		btnPlay.setBounds(24, 360, 101, 70);
		pane.add(btnPlay);
		
		btnPlay.addActionListener(this);
		
		String fileName1 = "button/stop.png" ;
		ImageIcon icon1 = new ImageIcon(fileName1);
	    btnStop = new JButton(icon1);
	    btnStop.setBounds(325, 360, 89, 70);
	    btnStop.setBorderPainted(false);
	    btnStop.setFocusPainted(false);
	    btnStop.setContentAreaFilled(false);
		pane.add(btnStop);
		
		btnStop.addActionListener(this);
		
		String fileName4 = "button/shuffle.png" ;
		ImageIcon icon4 = new ImageIcon(fileName4);
		
		String fileName5 = "button/repeat.png" ;
		ImageIcon icon5 = new ImageIcon(fileName5);
	    btnRepeat = new JButton(icon5);
		btnRepeat.setBorderPainted(false);
	    btnRepeat.setFocusPainted(false);
	    btnRepeat.setContentAreaFilled(false);
		btnRepeat.setBounds(475, 362, 89, 70);
		pane.add(btnRepeat);
		
		btnRepeat.addActionListener(this);
		
		String fileName3 = "button/pause.png" ;
		ImageIcon icon3 = new ImageIcon(fileName3);
	    btnPause = new JButton(icon3);
		btnPause.setBorderPainted(false);
	    btnPause.setFocusPainted(false);
	    btnPause.setContentAreaFilled(false);
		btnPause.setBounds(175, 360, 101, 70);
		getContentPane().add(btnPause);
		lblNewLabel.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblNewLabel.setBounds(475, 333, 89, 25);
		
		btnPause.addActionListener(this);
		
		pane.add(lblNewLabel);
		
		btnSelect.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		btnSelect.setBounds(366, 289, 328, 31);
		
		pane.add(btnSelect);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 89, 31);
		btnBack.addActionListener(this);
		getContentPane().add(btnBack);
		
		btnSelect.addActionListener(this);
		
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		String song = (String)list.getSelectedValue();
		
		if (song.equals("Beautiful Now - AKON")){
			txtrPleaseSelectA.setText("");
			txtrPleaseSelectA.append("Song Name : Beautiful Now" + "\n\n");
			txtrPleaseSelectA.append("Singer : Akon" + "\n\n");
			txtrPleaseSelectA.append("Genre : Western" + "\n\n");
			    
		    soundFile = new File("song/Beautiful_Now.wav");
			    
			System.out.println("Playing " + soundFile.getName());
			
		}
		
		else if (song.equals("Dangerously - Charlie Puth")){
			txtrPleaseSelectA.setText("");
			txtrPleaseSelectA.append("Song Name : Dangerously" + "\n\n");
			txtrPleaseSelectA.append("Singer : Charlie Puth" + "\n\n");
			txtrPleaseSelectA.append("Genre : Western" + "\n\n");
			
			soundFile = new File("song/Dangerously.wav");
		    
		    System.out.println("Playing " + soundFile.getName());
		    
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object obj = e.getSource();
		
		if(obj == btnPlay){
			Line.Info linfo = new Line.Info(Clip.class);
		    Line line = null;
				try {
					line = AudioSystem.getLine(linfo);
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    clip = (Clip) line;
		    clip.addLineListener(this);
		    AudioInputStream ais = null;

				try {
					ais = AudioSystem.getAudioInputStream(soundFile);
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					clip.open(ais);
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block 
					e1.printStackTrace();
				}
			
			clip.setMicrosecondPosition(clipTime);
			clip.start();
			
			list.enable(false);			
			
		}
		else if (obj == btnStop){
			clip.stop();
			clipTime = 0;
			list.enable(true);
		}
		else if (obj == btnPause){
			clipTime = clip.getMicrosecondPosition();
			clip.stop();
		}
		else if (obj == btnRepeat){
			if (check == false){
				check = true;
				lblNewLabel.setText("Repeat On");
				clip.loop(clip.LOOP_CONTINUOUSLY);
			}
			else {
				check = false;
				lblNewLabel.setText("Repeat Off");
				clip.loop(0);
			}	
		}
		else if (obj == btnSelect){
			
			if(playing == true){
				clip.stop();
			}
			list.enable(false);
			
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				soundFile = chooser.getSelectedFile();
					
		    txtrPleaseSelectA.setText("");
		    txtrPleaseSelectA.append("Song Name : " + soundFile.getName() + "\n\n");
			txtrPleaseSelectA.append("Singer : Unknown" + "\n\n");
			txtrPleaseSelectA.append("Genre : Unknown" + "\n\n");
		    }
		
		else if(obj == btnBack) {
			this.setVisible(false);
			prevScreen2.music=this;
			prevScreen2.setVisible(true);
		}
		
	}
	
	public void update(LineEvent le) {
	    LineEvent.Type type = le.getType();
	    if (type == LineEvent.Type.OPEN) {
	      System.out.println("OPEN");
	    } else if (type == LineEvent.Type.CLOSE) {
	      System.out.println("CLOSE");
	      System.exit(0);
	    } else if (type == LineEvent.Type.START) {
	      System.out.println("START");
	      playing = true;
	      playingDialog.setVisible(true);
	    } else if (type == LineEvent.Type.STOP) {
	      System.out.println("STOP");
	      list.enable(true);
	      playing = false;
	      playingDialog.setVisible(false);
	      clip.close();
	    }
	  }
}
