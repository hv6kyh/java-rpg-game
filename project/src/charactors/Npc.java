package charactors;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import attribute.Stat;

public class Npc extends Charactor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -64970641557589687L;
	
	private static Npc kyle = null;
	private static Npc shuban = null;
	private static Npc hyde = null;
	private static Npc madame = null;
	private static Npc soldier = null;
	private static Npc commander = null;
	private static Npc villager = null;
	
	public static Npc getKyle() {

		if (kyle == null) {
			
			kyle = new Npc(
					"카일",
					new Stat(1,1,100,1),
					"npc",
					new Point(0,0)
					);
			
		}
		
		return kyle;
		
	}
	
	public static Npc getShuban() {

		if (shuban == null) {
			
			shuban = new Npc(
					"슈반",
					new Stat(1,1,100,1),
					"npc",
					new Point(0,0)
					);
			
		}
		
		return shuban;
		
	}

	public static Npc getHyde() {

		if (hyde == null) {
			
			hyde = new Npc(
					"하이드",
					new Stat(1,1,100,1),
					"npc",
					new Point(0,0)
					);
			
		}
		
		return hyde;
		
	}
	
	public static Npc getMadame() {

		if (madame == null) {
			
			madame = new Npc(
					"여관주인",
					new Stat(1,1,100,1),
					"npc",
					new Point(0,0)
					);
			
		}
		
		return madame;
		
	}
	
	public static Npc getSoldier() {

		if (soldier == null) {
			
			soldier = new Npc(
					"군사",
					new Stat(1,1,100,1),
					"npc",
					new Point(0,0)
					);
			
		}
		
		return soldier;
		
	}
	
	public static Npc getCommander() {

		if (commander == null) {
			
			commander = new Npc(
					"사령관",
					new Stat(1,1,100,1),
					"npc",
					new Point(0,0)
					);
			
		}
		
		return commander;
		
	}
	
	public static Npc getVillager() {

		if (villager == null) {
			
			villager = new Npc(
					"마을주민",
					new Stat(1,1,100,1),
					"npc",
					new Point(0,0)
					);
			
		}
		
		return villager;
		
	}
	
	public Npc(String name, Stat stat, String job, Point p) {
		super(name, stat, job, p);
		// TODO Auto-generated constructor stub
		
		try {
			
			switch (name) {
			
			case "카일" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/npc/Evil.png"));
				this.charactorSize = new Dimension(32, 32);
				this.col = 1;
				this.row = 5;
				break;
				
			case "슈반" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/npc/People2.png"));
				this.charactorSize = new Dimension(32, 32);
				this.col = 1;
				this.row = 2;
				break;
				
			case "사령관" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/npc/People3.png"));
				this.charactorSize = new Dimension(48, 48);
				this.col = 6;
				this.row = 4;
				break;
				
			case "군사" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/npc/People3.png"));
				this.charactorSize = new Dimension(48, 48);
				this.col = 9;
				this.row = 4;
				break;
				
			case "여관주인" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/npc/People1.png"));
				this.charactorSize = new Dimension(32, 32);
				this.col = 3;
				this.row = 4;
				break;
				
			case "하이드" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/npc/People1.png"));
				this.charactorSize = new Dimension(32, 32);
				this.col = 6;
				this.row = 4;
				break;
				
			case "마을주민" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/npc/People1.png"));
				this.charactorSize = new Dimension(32, 32);
				this.col = 0;
				this.row = 4;
				
			}
			
//			this.dialogIcon = ImageIO.read(new File("D:/TheWorld/res/npc/dialog.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		
		// 현재 캐릭터의 상태에 따라
		switch (curState) {
		
		case walk :		// 걷는 이미지를 그린다
			g2d.drawImage(walk_img, p.x, p.y, p.x+charactorSize.width*scale, p.y+charactorSize.height*scale, (col)*charactorSize.width, (row)*charactorSize.height, (col+1)*charactorSize.width, (row+1)*charactorSize.height, this);
			break;

		default:
			break;
			
		}			
		
		// 캐릭터 이름 출력
		g2d.setFont(new Font("돋움", Font.PLAIN, 13));		// 폰트 설정
		g2d.drawString(name, p.x, p.y);						// 캐릭터의 이름 표시
		
		if (this.isSpeaking == true) {
			g2d.drawImage(dialogIcon, p.x, p.y-this.charactorSize.height, this);
		}
		
	}

}
