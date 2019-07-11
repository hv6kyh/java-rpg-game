package attribute;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class HpBar {
	
	private int hp;
	private int maxHp;
	
	private int width;
	private int maxWidth;
	
	private Point point;
	
	private final int height = 10;

	public HpBar(int maxHp, Point point, int maxWidth) {
		super();
		this.maxHp = maxHp;
		this.point = point;
		this.maxWidth = maxWidth;
	}
	
	public void draw(Graphics g) {

		width = (int)(maxWidth*hp/maxHp);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.RED);
		g2d.fillRect(point.x, point.y+50, width, height);
		
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setPoint(Point point) {
		this.point = point;
	}	

}
