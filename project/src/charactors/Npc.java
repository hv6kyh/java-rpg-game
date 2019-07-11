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
					"ī��",
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
					"����",
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
					"���̵�",
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
					"��������",
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
					"����",
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
					"��ɰ�",
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
					"�����ֹ�",
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
			
			case "ī��" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/npc/Evil.png"));
				this.charactorSize = new Dimension(32, 32);
				this.col = 1;
				this.row = 5;
				break;
				
			case "����" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/npc/People2.png"));
				this.charactorSize = new Dimension(32, 32);
				this.col = 1;
				this.row = 2;
				break;
				
			case "��ɰ�" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/npc/People3.png"));
				this.charactorSize = new Dimension(48, 48);
				this.col = 6;
				this.row = 4;
				break;
				
			case "����" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/npc/People3.png"));
				this.charactorSize = new Dimension(48, 48);
				this.col = 9;
				this.row = 4;
				break;
				
			case "��������" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/npc/People1.png"));
				this.charactorSize = new Dimension(32, 32);
				this.col = 3;
				this.row = 4;
				break;
				
			case "���̵�" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/npc/People1.png"));
				this.charactorSize = new Dimension(32, 32);
				this.col = 6;
				this.row = 4;
				break;
				
			case "�����ֹ�" :
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
		
		// ���� ĳ������ ���¿� ����
		switch (curState) {
		
		case walk :		// �ȴ� �̹����� �׸���
			g2d.drawImage(walk_img, p.x, p.y, p.x+charactorSize.width*scale, p.y+charactorSize.height*scale, (col)*charactorSize.width, (row)*charactorSize.height, (col+1)*charactorSize.width, (row+1)*charactorSize.height, this);
			break;

		default:
			break;
			
		}			
		
		// ĳ���� �̸� ���
		g2d.setFont(new Font("����", Font.PLAIN, 13));		// ��Ʈ ����
		g2d.drawString(name, p.x, p.y);						// ĳ������ �̸� ǥ��
		
		if (this.isSpeaking == true) {
			g2d.drawImage(dialogIcon, p.x, p.y-this.charactorSize.height, this);
		}
		
	}

}
