package UI;

import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

public class PlayMusic extends Object implements LineListener {
  File soundFile;

  JDialog playingDialog;

  Clip clip;

  public static void main(String[] args) throws Exception {
    PlayMusic s = new PlayMusic();
  }

  public PlayMusic() throws Exception {
    //JFileChooser chooser = new JFileChooser();
    //chooser.showOpenDialog(null);
    //soundFile = chooser.getSelectedFile();

    soundFile = new File("song/Beautiful_Now.wav");
    
    System.out.println("Playing " + soundFile.getName());

    Line.Info linfo = new Line.Info(Clip.class);
    Line line = AudioSystem.getLine(linfo);
    clip = (Clip) line;
    clip.addLineListener(this);
    AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
    clip.open(ais);
    
    clip.start();
    
    Scanner sc = new Scanner(System.in);
    int n = 0;
    
    long clipTime = 0;
    while (n != 3){
    	
    	if (n==4){

    		System.out.println("" + clip.getMicrosecondPosition());
    	}
    	
    	if (n==5){
    		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
    		AudioFormat format = audioInputStream.getFormat();
    		long frames = audioInputStream.getFrameLength();
    		double durationInSeconds = (frames+0.0) / format.getFrameRate(); 
    		long second = (long)(durationInSeconds * 1000000);
    		System.out.println(second);
    		System.out.println(clip.getMicrosecondLength());
    	}
    	
    	//clip.loop(clip.LOOP_CONTINUOUSLY);
    	
    	//pause
    	if (n == 1){
    	
    	clipTime= clip.getMicrosecondPosition();

    	clip.stop();
    	}
    	
    	// replay
    	if(n==2){
    		clip.setMicrosecondPosition(clipTime);;
    		clip.start();
    	}
    	
    	n = sc.nextInt();
    }
    clip.stop();
    
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
      playingDialog.setVisible(true);
    } else if (type == LineEvent.Type.STOP) {
      System.out.println("STOP");
      playingDialog.setVisible(false);
      clip.close();
    }
  }
}