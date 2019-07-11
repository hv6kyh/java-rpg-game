package battleField;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import frame.MainFrame;
import frame.WorldMap;
import utility.SoundEngine;

public class OceaniaVillage extends Map { 		// ���� �гη� �����Ѵ�
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1283747220481587343L;
	private int[][] tmp = {
			
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,1,1,0,1,1,1,0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{1,0,1,1,0,1,1,1,0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,0,0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,1,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,1,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,1,1,1,1,1,1,1,1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
			
	};
	
	public OceaniaVillage() {			// ������
		
		super();
		// TODO Auto-generated constructor stub		
		Map.map = tmp;
		
		try {
			this.background = ImageIO.read(new File("D:/TheWorld/res/map/Oceania Entrance.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.showDialog("dialog_europe_", 5, 10, this, playerCharactor, shuban, "121221");
		this.showDialog("dialog_europe_", 11, 12, this, villager, shuban, "12");
		this.showDialog("dialog_europe_", 13, 14, this, playerCharactor, shuban, "12");
		
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