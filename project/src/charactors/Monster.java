//**********************************************

package charactors;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import attribute.Stat;

public class Monster extends Charactor implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4183416593294887240L;
	
	private BufferedImage hpbar = null;
	
	private static int numberOfMonsters = 0;

	private int number;	
	private int maxHp;
	private int kind;
	
//	private Rectangle range = null;
	
//	private final int playerWidth = 100;
//	private final int playerHeight = 100;

	private boolean isAlive = true;

	public Monster(String name, Stat stat, String job, Point p) {
		super(name, stat, job, p);
		// TODO Auto-generated constructor stub
		
		this.number = ++ numberOfMonsters;

		maxHp = this.stat.getHp();
		
		try {
			
			switch(name) {
			
			case "��������" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/monster/Monster.png"));
				this.dead_img = ImageIO.read(new File("D:/TheWorld/res/monster/Damage3.png"));
				this.charactorSize = new Dimension(48,48);
				break;
				
			case "�͵�����" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/monster/091-Monster05.png"));
				this.charactorSize = new Dimension(64,64);
				break;
				
			case "�� �޸� �����Ǹ�" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/monster/Monster.png"));
				this.charactorSize = new Dimension(48,48);
				this.kind = 9;				
				break;
				
			case "�Ǹ�" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/monster/077-Devil03.png"));
				this.charactorSize = new Dimension(80,80);
				break;
				
			case "������ ��" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/monster/099-Monster13.png"));
				this.charactorSize = new Dimension(96,96);
				break;
				
			case "���" :
				this.walk_img = ImageIO.read(new File("D:/TheWorld/res/monster/Monster.png"));
				this.charactorSize = new Dimension(48,48);
				this.kind = 6;
				break;
				
			}
			
			this.hpbar = ImageIO.read(new File("D:/TheWorld/res/common/hpbar.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void draw(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		int width = (int)(this.charactorSize.width*this.stat.getHp()/maxHp);

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		
		switch (curState) {
		
		case walk :
			
			g2d.drawImage(walk_img, p.x, p.y, p.x+charactorSize.width*scale, p.y+charactorSize.height*scale, (col)*charactorSize.width, (row)*charactorSize.height, (col+1)*charactorSize.width, (row+1)*charactorSize.height, this);
			
			g2d.setColor(Color.BLACK);		
			g2d.setFont(new Font("����", Font.PLAIN, 13));		// ��Ʈ ����
			g2d.drawString(name+number, p.x, p.y);			// ĳ������ �̸� ǥ��
	
			g2d.drawImage(hpbar, p.x, p.y+this.charactorSize.height, width, 10, this);

			break;
		
			
		case attacked :
			
			g2d.drawImage(walk_img, p.x, p.y, p.x+charactorSize.width*scale, p.y+charactorSize.height*scale, (col)*charactorSize.width, (row)*charactorSize.height, (col+1)*charactorSize.width, (row+1)*charactorSize.height, this);
			
			g2d.setColor(Color.BLACK);		
			g2d.setFont(new Font("����", Font.PLAIN, 13));		// ��Ʈ ����
			g2d.drawString(name+number, p.x, p.y);			// ĳ������ �̸� ǥ��
		
			g2d.drawImage(hpbar, p.x, p.y+this.charactorSize.height, width, 10, this);
			
			break;
			
		case died :
			break;
			
		default:
			break;
			
		}
		
//		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
//		g2d.fillRect(this.range.x, this.range.y, this.range.width, this.range.height);
	
	}
	
	public void move(int code) {
		
		Point np = new Point(this.p);
		
		switch (code) {
		
		case KeyEvent.VK_DOWN :		// ������ �̵�
			np.y += speed;
			oldMove = KeyEvent.VK_DOWN;
			row = 0;
			break;
			
		case KeyEvent.VK_LEFT :		// �������� �̵�
			np.x -= speed;
			oldMove = KeyEvent.VK_LEFT;
			row = 1;
			break;
			
		case KeyEvent.VK_RIGHT :		// ���������� �̵�
			np.x += speed;
			oldMove = KeyEvent.VK_RIGHT;
			row = 2;
			break;
			
		case KeyEvent.VK_UP :		// �������� �̵�
			np.y -= speed;
			oldMove = KeyEvent.VK_UP;
			row = 3;
			break;			
			
		}

		if (movable(np, oldMove) == true && this.curState == State.walk) {		
			this.p = np;
			
//			range = new Rectangle(p.x-playerWidth, p.y-playerHeight, this.getCharactorSize().width+playerWidth*2, this.getCharactorSize().height+playerHeight*2);
	
		}
		
	}
	
	// ĳ������ ���ݷ°� ĳ������ ������ �޾ƿ´�
	// ���ݷ¸�ŭ ü���� ���̰� ĳ���͸� ���� ���� �������� �����Ѵ�
	public void attacked(int damage, int direction) {

		this.setCurState(State.attacked);
		
		// ü���� ���̴� �κ�
		int d = (int)(damage*(1 - this.getStat().getDef()/100));
		this.stat.setHp(this.stat.getHp() - d);
		
		// ü���� 0�̸� ����
		if (this.stat.getHp() <= 0) {
			this.die();
		}
		
		switch (direction) {
		
		case KeyEvent.VK_UP :
			this.setRow(0);
			break;
		case KeyEvent.VK_DOWN :
			this.setRow(3);
			break;
		case KeyEvent.VK_LEFT :
			this.setRow(2);
			break;
		case KeyEvent.VK_RIGHT :
			this.setRow(1);
			break;
			
		}
		
	}
	
	public void die() {
		
		isAlive = false;
		this.setCurState(State.died);
		System.out.println(this.name + " ����");
		
	}

	@Override
	public String toString() {
		return String.format("���� ��ȣ : %d, ���� �̸� : %s", this.number, this.name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (isAlive) {

			col = moveCnt % 3 + kind;				// Į�� ����
			
			moveCnt++;
			
			// �̵��ϱ�
			if (this.getCurState() == State.walk) {
			
				switch ((int)(Math.random()*30)) {
				// 0~29
				
				case 0 :
					move(KeyEvent.VK_DOWN);
					break;
					
				case 1 :
					move(KeyEvent.VK_LEFT);
					break;
					
				case 2 :
					move(KeyEvent.VK_RIGHT);
					break;
						
				case 3 :
					move(KeyEvent.VK_UP);
					break;
					
				default :
					move(oldMove);
	
				}
			
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

//			System.out.println(PhysicsEngine.hit(this));

		}
		
	}

	public int getNumber() {
		return number;
	}

}

