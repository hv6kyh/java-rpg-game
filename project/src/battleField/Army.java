package battleField;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import frame.MainFrame;

// 1018 중복되는 메소드들을 상위 클래스로 통합
public class Army extends Map { 		// 맵을 패널로 정의한다
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1283747220481587343L;
	private int[][] tmp = {
			{1,1,1,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
			{1,1,1,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1},
			{1,1,1,1,1,0,1,1,1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
			{1,1,1,1,1,0,1,1,1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
			{1,0,1,1,1,1,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
			{1,0,0,1,1,1,0,0,0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
			{0,0,0,0,0,0,0,0,0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0,0,0,0,1,0,0,0,0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0,0,0,1,1,1,0,0,0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0,0,0,0,0,0,0,0,0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0,1,1,1,1,1,1,0,0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0,1,1,1,1,1,1,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0,1,1,1,1,1,1,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{0,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{1,1,1,1,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
			{1,1,1,1,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,1,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,1,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
	};

//	Npc npc1 = new Npc("사령관", new Stat(1,1,100,1), "npc", Map.toVpz(10, 11));
//	Npc npc2 = new Npc("카일", new Stat(1,1,100,1), "npc", Map.toVpz(18, 11));
	
	private static boolean asia = false;
	private static boolean north1 = false;
	private static boolean north2 = false;
	
	public Army() {			// 생성자
		
		super();
		// TODO Auto-generated constructor stub
		Map.map = tmp;
		
		try {
			this.background = ImageIO.read(new File("D:/TheWorld/res/map/army.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(asia);
		System.out.println(north1);
		System.out.println(north2);

		if (asia == false) {
			this.showDialog("dialog_asia_", 9, 12, this, commander, kyle, "1221");
			asia = true;
		}
		else if (north1 == false) {
			this.showDialog("dialog_southamerica_", 1, 5, this, kyle, commander, "12121");
			north1 = true;
		}
		else if (north2 == false) {
			this.showDialog("dialog_southamerica_", 24, 28, this, playerCharactor, commander, "12212");
			north2 = true;
		}
		this.repaintThread.start();

	} 

//	@Override
//	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paint(g);
//		npc1.draw(g);
//		npc2.draw(g);
//		
//	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

				MainFrame.setCurrentPanel(new AsiaVillageEnter());
			
		}
			
	}

}