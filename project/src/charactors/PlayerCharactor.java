package charactors;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import attribute.Stat;
import battleField.Map;
import utility.SoundEngine;

public class PlayerCharactor extends Charactor {				// �÷��̾� ĳ���ʹ� ĳ������ ���� Ŭ����
	
//	0913
//	�����Ӱ� ������ ���� �ٸ� �޼ҵ�� �и� �ʿ�
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5100606715118045623L;
	
	public class AttackRange extends Arc2D.Double {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private final int radius = 100;

		public AttackRange() {
			super();
			// TODO Auto-generated constructor stub
			this.width = radius*2;
			this.height = radius*2;
			this.extent = 90;
			this.setArcType(Arc2D.PIE);
		}
		
		public void setP(Point p) {
			this.x = p.x - radius;
			this.y = p.y - radius;
		}
		
	}
	
	private BufferedImage hpbar = null;

	private AttackRange range = new AttackRange();

	// ����ī��Ʈ�� Charactor�� ����
	private int attCnt = 0;			// ���� ī��Ʈ(row ����� �ʿ�)	

	private int maxHp = this.stat.getHp();
	// �̱��� ������
	private static PlayerCharactor instance = null;
	
	public static PlayerCharactor getInstance() {
		
//		System.out.println("�÷��̾� ĳ���� �ν��Ͻ��� ȣ��� Ƚ�� : " + ++callCnt);
		
		if (instance == null) {
			
			instance = new PlayerCharactor(
					"���",
					new Stat(5,1,100,1),
					"���",
					new Dimension(32,48),
					Map.toVpz(4, 10)
					);
			
		}
		
		return instance;
		
	}

	public PlayerCharactor(String name, Stat stat, String job, Dimension charactorSize, Point p) {
		super(name, stat, job, charactorSize, p);
		// TODO Auto-generated constructor stub
		
		try {
//			this.walk_img = ImageIO.read(new File("bin/image/arsis_basic.png"));
			this.walk_img = ImageIO.read(new File("D:/TheWorld/res/player_charactor/arsis_basic.png"));
			
			this.attack_img = ImageIO.read(new File("D:/TheWorld/res/player_charactor/arsis_attack2.png"));
			this.hpbar = ImageIO.read(new File("D:/TheWorld/res/common/hpbar.png"));	

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		range = new AttackRange(p.x, p.y);
		
		this.speed = 6;
		
	}

	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
//		int width = (int)(this.charactorSize.width*this.stat.getHp()/maxHp);
		int width = (int)(40*this.stat.getHp()/maxHp);

		// ���� ĳ������ ���¿� ����
		switch (curState) {
		
		case walk :		// �ȴ� �̹����� �׸���
			g2d.drawImage(walk_img, p.x, p.y, p.x+charactorSize.width*scale, p.y+charactorSize.height*scale, (col)*charactorSize.width, (row)*charactorSize.height, (col+1)*charactorSize.width, (row+1)*charactorSize.height, this);
			g2d.drawImage(hpbar, p.x, p.y+this.charactorSize.height, width, 10, this);
			
			
			break;
			
		case attack :	// �����ϴ� �̹����� �׸���
			this.attackMotion(g);
			g2d.drawImage(hpbar, p.x, p.y+this.charactorSize.height, width, 10, this);
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
		
		g2d.draw(range);
		
	}

	public void move(KeyEvent e) {		// ĳ������ �̵�
		
		// �ȴ� ���·� �ٲ۴�
		this.setCurState(State.walk);
		
		// �̵��� ��ǥ�� �����
		Point np = new Point(this.p);

		// Į�� ����
		col = moveCnt % 4;
		
		// Ű�ڵ忡 ���� �з�
		switch (e.getKeyCode()) {
		
		case KeyEvent.VK_UP :
			moveCnt++;
			np.y -= speed;
			row = 3;
			range.start = 45;
			break;
			
		case KeyEvent.VK_DOWN :
			moveCnt++;
			np.y += speed;			
			row = 0;
			range.start = 180+45;
			break;
			
		case KeyEvent.VK_RIGHT :
			moveCnt++;
			np.x += speed;
			row = 2;
			range.start = -45;
			break;
			
		case KeyEvent.VK_LEFT :
			moveCnt++;
			np.x -= speed;
			row = 1;
			range.start = 90+45;
			break;
			
		}
		
		if (movable(np, e.getKeyCode()) == true) {
			oldMove = e.getKeyCode();
			this.p = np;
			range.setP(getCenterPosition());
		}
	
	}
	
	public void attackMotion(Graphics g) {				// �����ϴ� �̹����� �� �׸��� ���� �޼ҵ�
		
		int col = attCnt%4;
		
		g.drawImage(attack_img, p.x, p.y, p.x+charactorSize.width*scale, p.y+charactorSize.height*scale, (col)*charactorSize.width, (row)*charactorSize.height, (col+1)*charactorSize.width, (row+1)*charactorSize.height, this);

		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		attCnt++;
		
	}

	public void attack() {
		
		// �����ϴ� �̹����� �׸��� ���� ���¸� �ٲ۴�
		this.setCurState(State.attack);
		
		// �̹��� ����� ���߾� �߸��� �ʰ� �Ѵ�.
		this.setCharactorSize(new Dimension(48,50));
		
		// ���ݽ� ȿ������ ���
		SoundEngine.playEffectSound("D:/TheWorld/res/sound/Swordflesh1.wav");
		
	}
	
	public void attackStop() {
		this.setCharactorSize(new Dimension(32,48));
		attCnt = 0;
	}
	
	public void moveStop() {			// �̵� ���߸� Į�� 0�� ����

		col = 0;
		moveCnt = 0;
		
	}

	public int getOldMove() {
		return oldMove;
	}

	public void setOldMove(int oldMove) {
		this.oldMove = oldMove;
	}
	
	public void attacked(int damage) {
		
		// ü���� ���̴� �κ�
		int d = (int)(damage*(1 - this.getStat().getDef()/100));
		this.stat.setHp(this.stat.getHp() - d);
		
		System.out.println(this.getStat().getHp());
		
	}

//	public Point getCenterPosition() {
//		return new Point(p.x+charactorSize.width/2, p.y+charactorSize.height/2);
//	}

	public AttackRange getRange() {
		return range;
	}

}
