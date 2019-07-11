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

// 1019 포인트 static으로
public class Charactor extends JComponent implements Movable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4074453721854222777L;
	
	protected String name = null;					// 캐릭터 이름
	protected String imgName = null;				// 이미지 이름
	protected String attImgName = null;				// 공격 이미지 이름
	protected String job = null;					// 직업
		
	protected Stat stat = null;						// 캐릭터 스탯
	
	protected BufferedImage walk_img = null;		// 걷는 모션 이미지
	protected BufferedImage attack_img = null;		// 공격 이미지
	protected BufferedImage attacked_img = null;	// 공격당하는 이미지
	protected BufferedImage dead_img = null;	
	protected BufferedImage dialogIcon = null;

	protected Dimension charactorSize = null;		// 캐릭터 사이즈
	
	protected Point p = null;						// 캐릭터 좌표
	
	protected int row = 0, col = 0;					// 행과 열(이미지 드로우시 필요)
	protected int oldMove = KeyEvent.VK_DOWN;
	protected int speed = 4;						// 이동 속도
	protected int scale = 1;						// 캐릭터 크기 배율

	protected int moveCnt = 0;						// 이동 카운트(이미지 드로우시 필요)
	
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
	
	// 이동가능한지 판별하는 메소드
	public boolean movable(Point newPoint, int code) {
		// 이동되는 비정규화 좌표, 방향(키 코드)

		boolean b = true;
		
		// 이동할 정규화 좌표를 만듦
		Point newVpz = this.getVpz(newPoint);

		// 현재 정규화 좌표와 이동방향을 매개변수로 넘겨준다
		LinkedList<Rectangle> list = Map.getRect(this.getVpz(), code);
		
		// 캐릭터의 정규화 범위 정의
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
		// 캐릭터의 발쪽을 기준으로 삼음
		return new Point((this.p.x+charactorSize.width/2)/Map.getTileSize().width, (this.p.y+charactorSize.height-10)/Map.getTileSize().height);
		
	}
	
	public Point getVpz(Point np) {
		// 캐릭터의 발쪽을 기준으로 삼음
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
