package battleField;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import frame.MainFrame;

// 1018 중복되는 메소드들을 상위 클래스로 통합
public class AfricaLab extends Map { 		// 맵을 패널로 정의한다
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1283747220481587343L;
	private int[][] tmp = {
			{1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,   1,  1,   1,   1,   1,   1,   1,    1,   1,  1},
			{1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,   1,  1,   1,   1,   1,   1,   1,    1,   1,  1},
			{1,   1,   1,   1,   1,   1,   1,   1,   1,   0,   1,   1,   0,   1,    1,   1,  1,   1,   1,   0,   0,   1,    1,   1,  1},
			{1,   1,   1,   1,   1,   1,   0,   0,   0,   0,   1,   1,   1,   1,   1,   1,   1,   1,   1,   0,   0,   1,    1,   1,  1},
			{1,   1,   0,   0,   0,   0,   0,   0,   0,   0,   1,   1,   1,   1,   1,   1,   1,   1,   1,   0,   0,   0,    1,   1,  1},
			{1,   1,   0,   0,   0,   0,   0,   0,   0,   0,   1,   1,   1,   1,   1,   1,   1,   1,   1,   0,   0,   0,    1,   1,  1},
			{1,   1,   0,   0,   0,   0,   0,   0,   0,   0,   1,   1,   1,   1,   1,   1,   1,   1,   1,   0,   0,   1,    1,   1,  1},
			{1,   1,   1,   1,   0,   0,   1,   1,   0,   0,   0,   0,   0,   1,   1,   0,   1,   1,   0,   0,   0,   0,    1,   1,  1},
			{1,   1,   1,   1,   1,   1,   1,   1,   0,   0,   0,   0,   0,   1,   1,   0,   1,   1,   0,   0,   0,   0,    0,   0,  0},
			{1,   1,   1,   1,   1,   1,   1,   1,   0,   0,   0,   0,   0,   1,   1,   0,   1,   1,   0,   0,   0,   0,    0,   0,  0},
			{1,   1,   1,   1,   1,   1,   1,   1,   0,   0,   0,   0,   0,   1,   1,   0,   1,   1,   0,   0,   0,   0,    0,   0,  0},
			{1,   1,   1,   1,   1,   1,   1,   1,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,    1,   1,  1},
			{1,   1,   1,   1,   1,   1,   1,   1,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   1,    1,   1,  1},
			{1,   1,   1,   1,   1,   1,   1,   1,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,   0,    1,   1,  1},
			{1,   1,   0,   1,   0,   0,   1,   0,   0,   1,   0,   0,   0,   1,   1,   0,   0,   0,   0,   0,   0,   0,    1,   1,  1},
			{1,   1,   0,   0,   0,   0,   0,   0,   0,   1,   0,   0,   0,   1,   1,   0,   0,   0,   0,   0,   0,   1,    1,   1,  1},
			{1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   0,   0,   0,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,   1,  1},
			{1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   0,   0,   0,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,   1,  1},
			{1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   0,   0,   0,   1,   1,   1,   1,   1,   1,   1,   1,   1,    1,   1,  1}
	};

//	Npc npc1 = new Npc("슈반", new Stat(1,1,100,1), "npc", Map.toVpz(10, 11));
//	Npc npc2 = new Npc("카일", new Stat(1,1,100,1), "npc", Map.toVpz(18, 11));

	public AfricaLab() {			// 생성자
		
		super();
		// TODO Auto-generated constructor stub
		Map.map = tmp;
		
		try {
			this.background = ImageIO.read(new File("D:/TheWorld/res/map/lab.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.showDialog("dialog_africa_", 1, 5, this, kyle, shuban, "21221");
		
		this.repaintThread.start();

	} 

//	@Override
//	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paint(g);
////		playerCharactor.draw(g);
//		npc1.draw(g);
//		npc2.draw(g);
//		
//	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

				MainFrame.setCurrentPanel(new AfricaVillage());
			
		}
			
	}

}