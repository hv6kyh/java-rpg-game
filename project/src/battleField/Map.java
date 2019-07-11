package battleField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.JPanel;

import charactors.Charactor;
import charactors.Monster;
import charactors.Npc;
//import charactors.Movable.State;
import charactors.PlayerCharactor;
import charactors.State;
import frame.DialogPanel;
import frame.MainFrame;
import utility.PhysicsEngine;

public abstract class Map extends JPanel implements Runnable, KeyListener{ 		// 맵을 패널로 정의한다

	/**
	 * 
	 */
	private static final long serialVersionUID = 4877179502486473836L;
	protected static int[][] map = new int[19][25];
	protected static Dimension tileSize = new Dimension(32,32);		// 맵에서 타일 하나하나의 크기
	protected static Dimension mapSize = new Dimension(tileSize.width*map[0].length+7, tileSize.height*map.length+30);		// 전체 맵의 사이즈
	protected BufferedImage background = null;
	protected Thread repaintThread = null;
	protected PlayerCharactor playerCharactor = PlayerCharactor.getInstance();	
	protected Npc kyle = Npc.getKyle();
	protected Npc commander = Npc.getCommander();
	protected Npc hyde = Npc.getHyde();
	protected Npc madame = Npc.getMadame();
	protected Npc shuban = Npc.getShuban();
	protected Npc soldier = Npc.getSoldier();
	protected Npc villager = Npc.getVillager();
	
	protected JPanel nextPanel;
	
	protected Monster m[];
	
	protected boolean dialoging = false;
	
	protected final int fps = 25;
	
	public Map() {
		super();
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		this.addKeyListener(this);				// 키리스너 등록
		this.repaintThread = new Thread(this);
		
		// 포커스 줌(포커스를 가져야지만 키 이벤트를 발생시킬 수 있다)
		this.setFocusable(true);
		
		initCharactorVisible();
		
	}

	public static LinkedList<Rectangle> getRect(Point p, int code) {
		// p는 정규화된 좌표
		// p는 캐릭터의 현재 좌표, 코드는 방향(키 코드)
		LinkedList<Rectangle> list = new LinkedList<>();

		switch (code) {
			
		case KeyEvent.VK_UP :
			if (map[p.y-1][p.x-1] != 0) {	// 위
				list.add(new Rectangle((p.x-1)*tileSize.width, (p.y-1)*tileSize.height, tileSize.width, tileSize.height));
			}
			if (map[p.y-1][p.x] != 0) {		// 위
				list.add(new Rectangle(p.x*tileSize.width, (p.y-1)*tileSize.height, tileSize.width, tileSize.height));
			}
			if (map[p.y-1][p.x+1] != 0) {	// 위
				list.add(new Rectangle((p.x+1)*tileSize.width, (p.y-1)*tileSize.height, tileSize.width, tileSize.height));
			}
			break;

		case KeyEvent.VK_DOWN :
			if (map[p.y+1][p.x-1] != 0) {	// 아래
				list.add(new Rectangle((p.x-1)*tileSize.width, (p.y+1)*tileSize.height, tileSize.width, tileSize.height));
			}
			if (map[p.y+1][p.x] != 0) {		// 아래
				list.add(new Rectangle(p.x*tileSize.width, (p.y+1)*tileSize.height, tileSize.width, tileSize.height));
			}
			if (map[p.y+1][p.x+1] != 0) {	// 아래
				list.add(new Rectangle((p.x+1)*tileSize.width, (p.y+1)*tileSize.height, tileSize.width, tileSize.height));
			}
			break;
			
		case KeyEvent.VK_LEFT :
			if (map[p.y-1][p.x-1] != 0) {	// 좌
				list.add(new Rectangle((p.x-1)*tileSize.width, (p.y-1)*tileSize.height, tileSize.width, tileSize.height));
			}
			if (map[p.y][p.x-1] != 0) {		// 좌
				list.add(new Rectangle((p.x-1)*tileSize.width, p.y*tileSize.height, tileSize.width, tileSize.height));
			}
			if (map[p.y+1][p.x-1] != 0) {	// 좌
				list.add(new Rectangle((p.x-1)*tileSize.width, (p.y+1)*tileSize.height, tileSize.width, tileSize.height));
			}
			break;
			
		case KeyEvent.VK_RIGHT :
			if (map[p.y-1][p.x+1] != 0) {	// 우
				list.add(new Rectangle((p.x+1)*tileSize.width, (p.y-1)*tileSize.height, tileSize.width, tileSize.height));
			}
			if (map[p.y][p.x+1] != 0) {		// 우
				list.add(new Rectangle((p.x+1)*tileSize.width, p.y*tileSize.height, tileSize.width, tileSize.height));
			}
			if (map[p.y+1][p.x+1] != 0) {	// 우
				list.add(new Rectangle((p.x+1)*tileSize.width, (p.y+1)*tileSize.height, tileSize.width, tileSize.height));
			}
			break;
			
		}

		return list;
		
	}

	public static Dimension getMapSize() {
		return mapSize;
	}

	public static Dimension getTileSize() {
		return tileSize;
	}

	// 패널에 그림을 그리는 메소드
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g); 
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.drawImage(background, 0, 0, this);
		
		showDebugMap(g2d);
	
	}
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("맵 쓰레드 실행");
		
//		while (MainFrame.getCurrentPanelName() == this.getName()) {
		while (MainFrame.getCurrentPanelName() == this.getClass().getName()) {
			
			try {
				Thread.sleep(1000/fps);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("맵의 스레드가 인터럽트 받음");
				return;
			}
			repaint();
		}
		
		System.out.println("맵 쓰레드 종료");
//		SoundEngine.stopBGMSound();
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub	
		
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			MainFrame.goMainMenu();
		}		
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			playerCharactor.attack();
			
			if (m != null) {
				
				for (Monster i : m) {
	
					PhysicsEngine.hit(i);
					
				}
			
			}
		
		}
		else {
			playerCharactor.move(e);
			
//			attacked();
			
			if (reachPortal() == true) {
				MainFrame.setCurrentPanel(nextPanel);
			}
			
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		playerCharactor.setCurState(State.walk);
		playerCharactor.moveStop();
		playerCharactor.attackStop();
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	public boolean reachPortal() {return false;};
	
	public void attack() {};	
	
	public void attacked() {};

	public static Point toVpz(int x, int y) {
		return new Point(x*tileSize.width,y*tileSize.height);
	}
	
	public void showDialog(String name, int start, int end, Map map,
			Charactor c1, Charactor c2, String sequence) {
		
		dialoging = true;
		this.setFocusable(false);
		DialogPanel dp = new DialogPanel(name, start, end, map, c1, c2, sequence);		
		this.add(dp, BorderLayout.SOUTH);
		
	}
	
	public void showDialog(String name, int start, int end, Map map, Charactor c1) {
		
		dialoging = true;
		this.setFocusable(false);
		DialogPanel dp = new DialogPanel(name, start, end, map, c1);		
		this.add(dp, BorderLayout.SOUTH);
		
	}
	
	public void hideDialog() {
		dialoging = false;
		this.setFocusable(true);
		this.removeAll();
		System.out.println("hide");
	}
	
	public void showDebugMap(Graphics2D g2d) {
		
		for (int y = 0; y < map.length; y++) {
			
			for (int x = 0; x < map[0].length; x++) {

				g2d.setColor(Color.RED);
				g2d.drawRect(x*tileSize.width, y*tileSize.height, tileSize.width, tileSize.height);
				g2d.drawString(String.format("(%d,%d)", x, y), x*tileSize.width, y*tileSize.height+10);
				
//				g2d.setColor(Color.CYAN);
//				g2d.fillRect(playerCharactor.getVpz().x*tileSize.width, playerCharactor.getVpz().y*tileSize.height, tileSize.width, tileSize.height);
//				
//				LinkedList<Rectangle> list = Map.getRect(playerCharactor.getVpz(), playerCharactor.getOldMove());
//				
//				g2d.setColor(Color.YELLOW);
//				for (Rectangle rt : list) {
//					g2d.fillRect(rt.x, rt.y, rt.width, rt.height);
//				}
//				
//				g2d.setColor(Color.BLACK);
//				if (map[y][x] != 0) {
//					g2d.fillRect(x*tileSize.width, y*tileSize.height, tileSize.width, tileSize.height);
//				}				
				
			}
			
		}
		
	}

	public static int[][] getMap() {
		return map;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		if (playerCharactor != null && playerCharactor.isVisible()) playerCharactor.draw(g);
		if (kyle != null && kyle.isVisible()) kyle.draw(g);
		if (commander != null && commander.isVisible()) commander.draw(g);
		if (hyde != null && hyde.isVisible()) hyde.draw(g);
		if (madame != null && madame.isVisible()) madame.draw(g);
		if (shuban != null && shuban.isVisible()) shuban.draw(g);
		if (soldier != null && soldier.isVisible()) soldier.draw(g);
		if (villager != null && villager.isVisible()) villager.draw(g);
		
		if (m != null) {
			
			for (Monster i : m)
				i.draw(g);
			
		}
		
	}
	
	public void initCharactorVisible() {
		
		playerCharactor.setVisible(false);
		commander.setVisible(false);
		hyde.setVisible(false);
		kyle.setVisible(false);
		madame.setVisible(false);
		shuban.setVisible(false);
		soldier.setVisible(false);
		villager.setVisible(false);
		
	}
	
	 
}