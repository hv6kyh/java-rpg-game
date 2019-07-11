package utility;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundEngine {
	
	private static AudioInputStream ais = null;
	private static Clip bgmclip = null;
	
	public static void playBGMSound(String file) {
		// 배경음은 무한반복
		
		try {

			ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
			bgmclip = AudioSystem.getClip();
			bgmclip.open(ais);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bgmclip.start();
		System.out.println("play bgm");
		bgmclip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}
	
	public static void stopBGMSound() {
		// 배경음 종료시 clip 닫음
		bgmclip.stop();
		System.out.println("stop bgm");
		bgmclip.close();
	}
	
	public static void playEffectSound(String file) {
		
		Clip clip = null;

		try {
			clip = AudioSystem.getClip();
			ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
			clip.open(ais);
			clip.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
