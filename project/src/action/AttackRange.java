package action;

import java.awt.Point;
import java.awt.geom.Arc2D;

public class AttackRange extends Arc2D.Double {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static int radius = 100;
	
	public AttackRange(double x, double y) {
		super(x, y, radius*2, radius*2, 0, 90, Arc2D.PIE);
		// TODO Auto-generated constructor stub
	}
	
	public void setPosition(Point p) {
		this.x = p.x-radius;
		this.y = p.y-radius;
	}
	
}
