package battleField;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import utility.SoundEngine;

public class AfricaVillage extends Map { 		// 맵을 패널로 정의한다
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1283747220481587343L;
	private int[][] tmp = {
			
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,1,1,0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,1,1,0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{1,0,0,0,0,0,0,0,0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{1,0,0,0,0,0,0,0,0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{1,0,0,0,0,0,0,0,0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1},
			{1,0,0,0,1,1,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,1,1,1,1,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1},
			{1,1,1,1,1,1,1,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1},
			{1,1,1,1,1,1,1,0,0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1},
			{1,0,0,0,1,1,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
			{1,1,1,1,1,1,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
			{1,1,1,1,1,1,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
			
	};
	
	private static boolean clear = false;
	
	public AfricaVillage() {			// 생성자
		
		super();
		// TODO Auto-generated constructor stub
		this.setName("필드7");		
		Map.map = tmp;
		
		try {
			this.background = ImageIO.read(new File("D:/TheWorld/res/map/Afreeca.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (clear == false) {
			this.showDialog("dialog_africa_", 6, 6, this, playerCharactor);
			clear = true;
		}
		
		SoundEngine.playBGMSound("D:/TheWorld/res/sound/Dungeon2.wav");
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
	public boolean reachPortal() {
		// TODO Auto-generated method stub
		boolean b = false;
		
		if (
				playerCharactor.getVpz().equals(new Point(1, 1))
				|| playerCharactor.getVpz().equals(new Point(2, 1))
				|| playerCharactor.getVpz().equals(new Point(3, 1))
				|| playerCharactor.getVpz().equals(new Point(4, 1))
				|| playerCharactor.getVpz().equals(new Point(5, 1))
				|| playerCharactor.getVpz().equals(new Point(6, 1))
			)
		{
			SoundEngine.stopBGMSound();
			nextPanel = new AfricaDungeon1();
			b = true;
			playerCharactor.setP(new Point(23*Map.getTileSize().width,16*Map.getTileSize().height));
		}
		else if (
				playerCharactor.getVpz().equals(new Point(12, 5))
				)
		{
			SoundEngine.stopBGMSound();
			nextPanel = new AfricaHotel();
			b = true;
			playerCharactor.setP(new Point(12*Map.getTileSize().width,15*Map.getTileSize().height));
		}
			
		return b;
	}

}