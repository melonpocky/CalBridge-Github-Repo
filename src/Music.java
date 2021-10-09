//Kevin Ramirez
//5.13.2021
//this class is used by the game window to play sound files

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Music {
	void playMusic(String musicLocation) {
		try {
			File musicPath = new File(musicLocation);

			if(musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				
				int i = 0;
				while(i != 2) {
					i++;
				}
			}
			else {
				System.out.println("Can't find file");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
