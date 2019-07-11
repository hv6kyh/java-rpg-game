package charactors;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import attribute.Stat;
import battleField.Map;

// 1019 ����Ʈ static����
public class Charactor extends JComponent implements Movable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4074453721854222777L;
	
	protected String name = null;					// ĳ���� �̸�
	protected String imgName = null;				// �̹��� �̸�
	protected String attImgName = null;				// ���� �̹��� �̸�
	protected String job = null;					// ����
		
	protected Stat stat = null;						// ĳ���� ����
	
	protected BufferedImage walk_img = null;		// �ȴ� ��� �̹���
	protected BufferedImage attack_img = null;		// ���� �̹���
	protected BufferedImage attacked_img = null;	// ���ݴ��ϴ� �̹���
	protected BufferedImage dead_img = null;	
	protected BufferedImage dialogIcon = null;

	protected Dimension charactorSize = null;		// ĳ���� ������
	
	protected Point p = null;						// ĳ���� ��ǥ
	
	protected int row = 0, col = 0;					// ��� ��(�̹��� ��ο�� �ʿ�)
	protected int oldMove = KeyEvent.VK_DOWN;
	protected int speed = 4;						// �̵� �ӵ�
	protected int scale = 1;						// ĳ���� ũ�� ����

	protected int moveCnt = 0;						// �̵� ī��Ʈ(�̹��� ��ο�� �ʿ�)
	
	protected State curState = State.walk;
	
	protected boolean isSpeaking = false;
	protected boolean visible = false;	
	
	public Charactor(String name, Stat stat, String job, Dimension charactorSize, Point p) {
		super();
		this.name = name;
		this.stat = stat;
		this.job = job;
		this.charactorSize = charactorSize;
		this.p = p;
		
		try {
			this.dialogIcon = ImageIO.read(new File("D:/TheWorld/res/common/dialog.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Charactor(String name, Stat stat, String job, Point p) {
		super();
		this.name = name;
		this.stat = stat;
		this.job = job;
		this.p = p;
		
		try {
			this.dialogIcon = ImageIO.read(new File("D:/TheWorld/res/common/dialog.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
	// �̵��������� �Ǻ��ϴ� �޼ҵ�
	public boolean movable(Point newPoint, int code) {
		// �̵��Ǵ� ������ȭ ��ǥ, ����(Ű �ڵ�)

		boolean b = true;
		
		// �̵��� ����ȭ ��ǥ�� ����
		Point newVpz = this.getVpz(newPoint);

		// ���� ����ȭ ��ǥ�� �̵������� �Ű������� �Ѱ��ش�
		LinkedList<Rectangle> list = Map.getRect(this.getVpz(), code);
		
		// ĳ������ ����ȭ ���� ����
		Rectangle rt = new Rectangle(
//				newPoint.x+this.charactorSize.width/2-Map.getTileSize().width/2,
//				newPoint.y+this.charactorSize.height-Map.getTileSize().height,
				newVpz.x*Map.getTileSize().width,
				newVpz.y*Map.getTileSize().height,
				Map.getTileSize().width,
				Map.getTileSize().height
				
				);
				
		for (Rectangle r : list) {
			if (r.intersects(rt)) {
				b = false;
			}

		}	
		
		return b;
		
	}

	public int getMoney() {
		return this.stat.getMoney();
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public State getCurState() {
		return curState;
	}

	public void setCurState(State curState) {
		this.curState = curState;
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Dimension getCharactorSize() {
		return charactorSize;
	}

	public void setCharactorSize(Dimension charactorSize) {
		this.charactorSize = charactorSize;
	}
	
	public Point getVpz() {
		// ĳ������ ������ �������� ����
		return new Point((this.p.x+charactorSize.width/2)/Map.getTileSize().width, (this.p.y+charactorSize.height-10)/Map.getTileSize().height);
		
	}
	
	public Point getVpz(Point np) {
		// ĳ������ ������ �������� ����
		return new Point((np.x+charactorSize.width/2)/Map.getTileSize().width, (np.y+charactorSize.height-10)/Map.getTileSize().height);
		
	}

	public Stat getStat() {
		return stat;
	}

	public void setStat(Stat stat) {
		this.stat = stat;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setWalk_img(String imgName) {
		try {
			this.walk_img = ImageIO.read(new File(imgName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.charactorSize.width = this.walk_img.getWidth()/4;
		this.charactorSize.height = this.walk_img.getHeight()/4;
		
	}

	public void setAttack_img(String imgName) {
		try {
			this.attack_img = ImageIO.read(new File(imgName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.charactorSize.width = this.attack_img.getWidth()/4;
		this.charactorSize.height = this.attack_img.getHeight()/4;
	}
	
public Point[] getFrontPoint() {
		
		Point[] p = new Point[4];
		
		switch (oldMove) {
		
		case KeyEvent.VK_UP:
			p[0] = new Point(this.getVpz().x-1, this.getVpz().y-1);
			p[1] = new Point(this.getVpz().x, this.getVpz().y-1);
			p[2] = new Point(this.getVpz().x+1, this.getVpz().y-1);
			break;
			
		case KeyEvent.VK_LEFT:
			p[0] = new Point(this.getVpz().x-1, this.getVpz().y-1);
			p[1] = new Point(this.getVpz().x-1, this.getVpz().y);
			p[2] = new Point(this.getVpz().x-1, this.getVpz().y+1);
			break;
			
		case KeyEvent.VK_RIGHT:
			p[0] = new Point(this.getVpz().x+1, this.getVpz().y-1);
			p[1] = new Point(this.getVpz().x+1, this.getVpz().y);
			p[2] = new Point(this.getVpz().x+1, this.getVpz().y+1);
			break;
			
		case KeyEvent.VK_DOWN:
			p[0] = new Point(this.getVpz().x-1, this.getVpz().y+1);
			p[1] = new Point(this.getVpz().x, this.getVpz().y+1);
			p[2] = new Point(this.getVpz().x+1, this.getVpz().y+1);			
			break;
			
		}
		
		p[3] = getVpz();
		
		return p;
		
	}

	public void setSpeaking(boolean isSpeaking) {
		this.isSpeaking = isSpeaking;
	}
	
	public Point getCenterPosition() {
		return new Point(p.x+charactorSize.width/2, p.y+charactorSize.height/2);
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
}
