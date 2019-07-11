package battleField;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import attribute.Stat;
import charactors.Npc;
import frame.MainFrame;

public class AsiaVillageEnter extends Map { 		// 맵을 패널로 정의한다

	/**
	 * 
	 */
	private static final long serialVersionUID = 8777107590063355188L;
	private int[][] tmp = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,1,1,0,0,1,1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,1,1,1,0,0,0,1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,1,1,1,0,0,0,1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,1,0,0,0,0,1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,1,1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,1,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,1,1,1,1,0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,1,1,1,1,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1},
			{1,0,0,0,1,1,1,1,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	};

//	Npc npc = new Npc("군사", new Stat(1,1,100,1), "npc", Map.toVpz(10, 11));
	Npc[] other = new Npc[4];

	public AsiaVillageEnter() {			// 생성자

		super();
		// TODO Auto-generated constructor stub

		Map.map = tmp;

		for (int i = 0; i < other.length; i++) {
			int tmp = 11 + i;
			other[i] = new Npc("군사", new Stat(1,1,100,1), "npc", Map.toVpz(tmp, 11));
		}

		try {
			this.background = ImageIO.read(new File("D:/TheWorld/res/map/entrance.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.showDialog("dialog_asia_", 13, 16, this, playerCharactor, soldier, "1212");
		//		SoundEngine.playBGMSound("D:/TheWorld/res/sound/Battle2.wav");
		this.repaintThread.start();

	} 

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);

		for (int i = 0; i < other.length; i++) {
			other[i].draw(g);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			MainFrame.setCurrentPanel(new GrandfatherRoom());

		}

	}

}