package battleField;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import attribute.Stat;
import charactors.Monster;
import utility.SoundEngine;

public class EuropeDungeon2 extends Map { 		// ¸ÊÀ» ÆÐ³Î·Î Á¤ÀÇÇÑ´Ù
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1283747220481587343L;
	private int[][] tmp = {
			
			{1,1,1,1,1,1,1,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1,0,0,0,0,0,1,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{1,0,0,0,0,0,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1},
			{0,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1},
			{1,0,1,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,1,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,1,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{1,1,1,1,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}

			
	};
	
	private boolean afterFight = false;
	
	public EuropeDungeon2() {			// »ý¼ºÀÚ
		
		super();
		// TODO Auto-generated constructor stub
//		this.setName("ÇÊµå6");		
		Map.map = tmp;
		
		m = new Monster[7];
		
		m[0] = new Monster("»Ô ´Þ¸° ²¿¸¶¾Ç¸¶", new Stat(1,1,100,1), "¸ó½ºÅÍ", Map.toVpz(5, 12));
		m[1] = new Monster("»Ô ´Þ¸° ²¿¸¶¾Ç¸¶", new Stat(1,1,100,1), "¸ó½ºÅÍ", Map.toVpz(8, 13));
		m[2] = new Monster("»Ô ´Þ¸° ²¿¸¶¾Ç¸¶", new Stat(1,1,100,1), "¸ó½ºÅÍ", Map.toVpz(19, 13));
		m[3] = new Monster("»Ô ´Þ¸° ²¿¸¶¾Ç¸¶", new Stat(1,1,100,1), "¸ó½ºÅÍ", Map.toVpz(17, 9));
		m[4] = new Monster("»Ô ´Þ¸° ²¿¸¶¾Ç¸¶", new Stat(1,1,100,1), "¸ó½ºÅÍ", Map.toVpz(20, 4));
		m[5] = new Monster("»Ô ´Þ¸° ²¿¸¶¾Ç¸¶", new Stat(1,1,100,1), "¸ó½ºÅÍ", Map.toVpz(9, 4));
		m[6] = new Monster("¾Ç¸¶", new Stat(10,10,1000,1), "¸ó½ºÅÍ", Map.toVpz(3, 3));
		
		
		for (int i = 0; i < m.length; i++) {
			new Thread(m[i]).start();
		}
		
		try {
			this.background = ImageIO.read(new File("D:/TheWorld/res/map/Europe Dungeon2.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (afterFight == false) {
			this.showDialog("dialog_europe_", 7, 8, this, playerCharactor);
			afterFight = true;
		}
		else {
			this.showDialog("dialog_europe_", 9, 10, this, playerCharactor);
		}
		
		SoundEngine.playBGMSound("D:/TheWorld/res/sound/Bango.wav");
		this.repaintThread.start();

	} 

//	@Override
//	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paint(g);
//		playerCharactor.draw(g);
//
//
//		for (int i = 0; i < m.length; i++) {
//			m[i].draw(g);
//		}
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
				
			)
		{
			SoundEngine.stopBGMSound();
			nextPanel = new EuropeVillage();
			b = true;
			playerCharactor.setP(new Point(4*Map.getTileSize().width,11*Map.getTileSize().height));
		}
			
		return b;
	}
}