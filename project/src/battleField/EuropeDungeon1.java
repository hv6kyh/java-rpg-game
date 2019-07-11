package battleField;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import attribute.Stat;
import charactors.Monster;
import utility.SoundEngine;

public class EuropeDungeon1 extends Map { 		// ¸ÊÀ» ÆÐ³Î·Î Á¤ÀÇÇÑ´Ù
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1283747220481587343L;
	private int[][] tmp = {
			
			{0,0,0,0,0,0,1,1,1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0,0,0,0,0,0,1,1,1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0,0,0,0,0,0,1,1,1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{0,0,0,0,0,0,1,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
			{0,0,0,0,0,0,1,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
			{0,0,0,0,0,0,1,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
			{0,0,0,0,0,0,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1},
			{0,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1},
			{0,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1},
			{1,1,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1},
			{1,1,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1},
			{1,1,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1},
			{1,1,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
			{1,1,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
			{1,1,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{0,0,0,0,0,0,0,1,1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{0,0,0,0,0,0,0,1,1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}

			
	};
	
//	private Monster[] m = new Monster[6];
	
	public EuropeDungeon1() {			// »ý¼ºÀÚ
		
		super();
		// TODO Auto-generated constructor stub
//		this.setName("ÇÊµå6");		
		Map.map = tmp;
		
		m = new Monster[6];
		
		m[0] = new Monster("µ¿±¼¹ÚÁã", new Stat(1,1,50,1), "¸ó½ºÅÍ", Map.toVpz(5, 12));
		m[1] = new Monster("µ¿±¼¹ÚÁã", new Stat(1,1,50,1), "¸ó½ºÅÍ", Map.toVpz(8, 13));
		m[2] = new Monster("µ¿±¼¹ÚÁã", new Stat(1,1,50,1), "¸ó½ºÅÍ", Map.toVpz(19, 13));
		m[3] = new Monster("µ¿±¼¹ÚÁã", new Stat(1,1,50,1), "¸ó½ºÅÍ", Map.toVpz(17, 9));
		m[4] = new Monster("µ¿±¼¹ÚÁã", new Stat(1,1,50,1), "¸ó½ºÅÍ", Map.toVpz(20, 4));
		m[5] = new Monster("µ¿±¼¹ÚÁã", new Stat(1,1,50,1), "¸ó½ºÅÍ", Map.toVpz(9, 4));
		
		for (int i = 0; i < m.length; i++) {
			new Thread(m[i]).start();
		}
		
		try {
			this.background = ImageIO.read(new File("D:/TheWorld/res/map/Europe Dungeon1.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.showDialog("dialog_europe_", 4, 6, this, playerCharactor);
		
		SoundEngine.playBGMSound("D:/TheWorld/res/sound/Battle1.wav");
		
		this.repaintThread.start();

	} 

//	@Override
//	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paint(g);
//		playerCharactor.draw(g);
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
				playerCharactor.getVpz().equals(new Point(9, 1))
				|| playerCharactor.getVpz().equals(new Point(10, 1))
				|| playerCharactor.getVpz().equals(new Point(11, 1))
				|| playerCharactor.getVpz().equals(new Point(12, 1))
				
			)
		{
			SoundEngine.stopBGMSound();
			nextPanel = new EuropeDungeon2();
			b = true;
			playerCharactor.setP(new Point(12*Map.getTileSize().width,16*Map.getTileSize().height));
		}
			
		return b;
	}
	
//	public void attack() {
//		
//		for (int i = 0; i < m.length; i++) {
//			
//			if (ActionEngine.isInsideRange(m[i], playerCharactor)) {
//				m[i].attacked(playerCharactor.getStat().getAtk(), playerCharactor.getOldMove());
//			}
//			
//		}
//		
//	}
//	
//	public void attacked() {
//
//		for (int i = 0; i < m.length; i++) {
//			
//			if (ActionEngine.isInsideRange(playerCharactor, m[i])) {
//				playerCharactor.attacked(m[i].getStat().getAtk());
//			}
//			
//		}
//		
//	}

}