package battleField;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import frame.MainFrame;
import frame.WorldMap;
import utility.SoundEngine;

public class SouthAmericaDungeon2 extends Map { 		// 맵을 패널로 정의한다
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1283747220481587343L;
	private int[][] tmp = {
			
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,0,0,0,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,0,0,0,0,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,0,0,0,0,0,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,0,0,0,0,0,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,0,0,0,0,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,0,0,0,0,0,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,0,0,0,0,0,0,0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,0,0,0,0,0,0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,0,0,0,0,0,0,0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,0,0,0,0,0,0,0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,0,0,0,0,1,0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,0,0,0,0,0,0,0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,0,0,0,0,0,0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
			{1,1,1,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,1,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
			
	};
	
	public SouthAmericaDungeon2() {			// 생성자
		
		super();
		// TODO Auto-generated constructor stub		
		Map.map = tmp;
		
		try {
			this.background = ImageIO.read(new File("D:/TheWorld/res/map/South America Dungeon2.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		this.showDialog("dialog_europe_", 1, 3, this, playerCharactor);
		
		SoundEngine.playBGMSound("D:/TheWorld/res/sound/Town1.wav");
		
		this.repaintThread.start();

	} 

//	@Override
//	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paint(g);
//		playerCharactor.draw(g);
//		
//	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			MainFrame.setCurrentPanel(new WorldMap());

		}

	}

}