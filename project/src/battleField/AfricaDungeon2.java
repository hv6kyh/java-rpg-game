package battleField;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import attribute.Stat;
import charactors.Monster;
import frame.WorldMap;

public class AfricaDungeon2 extends Map { 		// 맵을 패널로 정의한다
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1283747220481587343L;
	private int[][] tmp = {
			
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,0,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,0,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,0,0,0,0,1,0,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
			{1,1,0,0,0,0,1,0,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
			{1,1,0,0,0,0,1,0,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
			{1,1,0,0,0,0,1,0,1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,1,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{1,0,1,1,1,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{1,0,1,1,1,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{1,0,1,1,1,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
			
	};
	
//	Npc npc1 = new Npc("슈반", new Stat(1,1,100,1), "npc", Map.toVpz(10, 10));
//	Npc npc2 = new Npc("카일", new Stat(1,1,100,1), "npc", Map.toVpz(11, 10));
//	Npc npc3 = new Npc("병사", new Stat(1,1,100,1), "npc", Map.toVpz(12, 10));
	
	private static boolean afterFight = false;
	
	
	public AfricaDungeon2() {			// 생성자
		
		super();
		// TODO Auto-generated constructor stub
		this.setName("필드10");		
		Map.map = tmp;
		
		m = new Monster[6];
		
		m[0] = new Monster("맹독전갈", new Stat(5,5,200,100), "몬스터", Map.toVpz(20, 10));
		m[1] = new Monster("맹독전갈", new Stat(5,5,200,100), "몬스터", Map.toVpz(21, 13));
		m[2] = new Monster("맹독전갈", new Stat(5,5,200,100), "몬스터", Map.toVpz(14, 12));
		m[3] = new Monster("맹독전갈", new Stat(5,5,200,100), "몬스터", Map.toVpz(9, 15));
		m[4] = new Monster("맹독전갈", new Stat(5,5,200,100), "몬스터", Map.toVpz(3, 9));
		m[5] = new Monster("대지의 용", new Stat(5,5,200,100), "몬스터", Map.toVpz(3, 4));
		
		for (int i = 0; i < m.length; i++) {
			new Thread(m[i]).start();
		}
		
		try {
			this.background = ImageIO.read(new File("D:/TheWorld/res/map/Afreeca D2.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (afterFight == false) {
			this.showDialog("dialog_africa_", 21, 22, this, playerCharactor, shuban, "12");
			this.showDialog("dialog_africa_", 23, 24, this, kyle, soldier, "12");
			this.showDialog("dialog_africa_", 25, 26, this, playerCharactor, shuban, "12");
			afterFight = true;
		}
		else {
//			this.showDialog("dialog_africa_", 27, this, playerCharactor, shuban, "12");
			this.showDialog("dialog_africa_", 27, 27, this, playerCharactor);
		}
		
//		SoundEngine.playBGMSound("D:/TheWorld/res/sound/진홍의대지.wav");
		
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
				playerCharactor.getVpz().equals(new Point(1, 1))
				|| playerCharactor.getVpz().equals(new Point(2, 1))
				|| playerCharactor.getVpz().equals(new Point(3, 1))
				|| playerCharactor.getVpz().equals(new Point(4, 1))
				|| playerCharactor.getVpz().equals(new Point(5, 1))
				|| playerCharactor.getVpz().equals(new Point(6, 1))
				
				
			)
		{
//			SoundEngine.stopBGMSound();
			nextPanel = new WorldMap();
			b = true;
			playerCharactor.setP(new Point(23*Map.getTileSize().width,7*Map.getTileSize().height));
		}
			
		return b;
	}

}