package battleField;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import attribute.Stat;
import charactors.Monster;
import utility.SoundEngine;

public class AfricaDungeon1 extends Map { 		// 맵을 패널로 정의한다
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1283747220481587343L;
	private int[][] tmp = {
			
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,0,0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,0,0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,0,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,0,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
			
	};
	
//	Npc npc = new Npc("슈반", new Stat(1,1,100,1), "npc", Map.toVpz(10, 10));
	
	public AfricaDungeon1() {			// 생성자
		
		super();
		// TODO Auto-generated constructor stub
		this.setName("필드9");		
		Map.map = tmp;
		
		m = new Monster[6];

		m[0] = new Monster("고블린", new Stat(5,5,200,100), "몬스터", Map.toVpz(13, 15));
		m[1] = new Monster("고블린", new Stat(5,5,200,100), "몬스터", Map.toVpz(7, 15));
		m[2] = new Monster("고블린", new Stat(5,5,200,100), "몬스터", Map.toVpz(6, 7));
		m[3] = new Monster("고블린", new Stat(5,5,200,100), "몬스터", Map.toVpz(3, 3));
		m[4] = new Monster("고블린", new Stat(5,5,200,100), "몬스터", Map.toVpz(10, 13));
		m[5] = new Monster("고블린", new Stat(5,5,200,100), "몬스터", Map.toVpz(19, 16));
		
		for (int i = 0; i < m.length; i++) {
			new Thread(m[i]).start();
		}
		
		try {
			this.background = ImageIO.read(new File("D:/TheWorld/res/map/Afreeca D1.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.showDialog("dialog_africa_", 15, 19, this, playerCharactor, shuban, "12212");
		this.showDialog("dialog_africa_", 20, 20, this, playerCharactor);
		
		SoundEngine.playBGMSound("D:/TheWorld/res/sound/Crimsonearth.wav");
		
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
				playerCharactor.getVpz().equals(new Point(1, 6))
				|| playerCharactor.getVpz().equals(new Point(1, 7))
				|| playerCharactor.getVpz().equals(new Point(1, 8))
				|| playerCharactor.getVpz().equals(new Point(1, 9))
				
			)
		{
//			SoundEngine.stopBGMSound();
			nextPanel = new AfricaDungeon2();
			b = true;
			playerCharactor.setP(new Point(23*Map.getTileSize().width,7*Map.getTileSize().height));
		}
			
		return b;
	}

}