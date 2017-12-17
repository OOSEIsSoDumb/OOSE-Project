package logic;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Workouts {

	private String exercise;
	
	public Workouts (String exercise) {
		this.exercise = exercise;
	}
	
	public void getDetail() {
		
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
        		
                if (exercise.equals("BARBELL SQUAT - 5 sets of 5 reps")) {
                	ImageIcon icon = new ImageIcon("workouts/1.jpg");
                	JOptionPane.showMessageDialog(null,
                       "",
                       exercise, JOptionPane.INFORMATION_MESSAGE, icon);
                }
                else if (exercise.equals("BARBELL CURL - 2 sets of 8 reps")) {
                	ImageIcon icon = new ImageIcon("workouts/2.jpg");
                	JOptionPane.showMessageDialog(null,
                       "",
                       exercise, JOptionPane.INFORMATION_MESSAGE, icon);
                }
                else if (exercise.equals("PULL UPS - 2 sets of 8 reps")) {
                	ImageIcon icon = new ImageIcon("workouts/3.jpg"); 
                	JOptionPane.showMessageDialog(null,
                       "",
                       exercise, JOptionPane.INFORMATION_MESSAGE, icon);
                }
                else if (exercise.equals("SIDE LATERAL RAISE - 2 sets of 8 reps")) {
                	ImageIcon icon = new ImageIcon("workouts/4.jpg"); 
                	JOptionPane.showMessageDialog(null,
                       "",
                       exercise, JOptionPane.INFORMATION_MESSAGE, icon);
                }
                else if (exercise.equals("SIT-UP - 2 sets of 15 reps")) {
                	ImageIcon icon = new ImageIcon("workouts/5.jpg"); 
                	JOptionPane.showMessageDialog(null,
                       "",
                       exercise, JOptionPane.INFORMATION_MESSAGE, icon);
                }
                
                else if (exercise.equals("RUNNING")) {
                	ImageIcon icon = new ImageIcon("workouts/6.png");
                	JOptionPane.showMessageDialog(null,
                       "",
                       exercise, JOptionPane.INFORMATION_MESSAGE, icon);
                } 
                else if (exercise.equals("STATIONARY BIKE")) {
                	ImageIcon icon = new ImageIcon("workouts/7.png");
                	JOptionPane.showMessageDialog(null,
                       "",
                       exercise, JOptionPane.INFORMATION_MESSAGE, icon);
                }
                else if (exercise.equals("ROWING MACHINE")) {
                	ImageIcon icon = new ImageIcon("workouts/8.png");
                	JOptionPane.showMessageDialog(null,
                       "",
                       exercise, JOptionPane.INFORMATION_MESSAGE, icon);
                }
                else if (exercise.equals("STAIRS")) {
                	ImageIcon icon = new ImageIcon("workouts/9.png");
                	JOptionPane.showMessageDialog(null,
                       "",
                       exercise, JOptionPane.INFORMATION_MESSAGE, icon);
                }
                else if (exercise.equals("POWER YOGA")) {
                	ImageIcon icon = new ImageIcon("workouts/10.png");
                	JOptionPane.showMessageDialog(null,
                       "",
                       exercise, JOptionPane.INFORMATION_MESSAGE, icon);
                }

            }
        });
        
    }
	
}
