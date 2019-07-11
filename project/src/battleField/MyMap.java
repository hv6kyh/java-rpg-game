package battleField;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import charactors.State;
import frame.MainFrame;

public class MyMap extends Map { 		// 맵을 패널로 정의한다
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1283747220481587343L;
	
	private Point mp;
	
	public MyMap() {			// 생성자
		
		super();
		// TODO Auto-generated constructor stub
		this.setName("실험소");
		
		playerCharactor.setSpeed(10);
		
		mp = new Point(0,0);
		
		this.addKeyListener(this);				// 키리스너 등록
		this.repaintThread = new Thread(this);
		
		try {
			this.background = ImageIO.read(new File("bin/tiles/map.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.setFocusable(true);	  
	
		this.repaintThread.start();

	} 

	// 패널에 그림을 그리는 메소드
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g); 
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.drawImage(background, mp.x, mp.y, this);
	
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		playerCharactor.draw(g);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("실험소  실행");
		
		while (MainFrame.getCurrentPanelName() == "실험소") {

			try {
				Thread.sleep(1000/fps);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("실험소의 스레드가 인터럽트 받음");
				return;
			}
			repaint();
		}
		
		System.out.println("실험소 쓰레드 종료");
		
	}
	
	public void mapScroll() {
		
		// 중앙 오른쪽으로
		if (this.getRootPane().getWidth()/2 - playerCharactor.getP().x < 0 && this.mp.x >= -(this.getRootPane().getWidth()-7)) {
			this.mp.x -= playerCharactor.getSpeed();
			this.playerCharactor.getP().x -= playerCharactor.getSpeed();
		}		
		// 중앙 왼쪽으로
		else if (this.getRootPane().getWidth()/2 - playerCharactor.getP().x > 0 && this.mp.x <= -playerCharactor.getSpeed()) {
			this.mp.x += playerCharactor.getSpeed();
			this.playerCharactor.getP().x += playerCharactor.getSpeed();
		}
		
		// 중앙 위쪽으로
		if (this.getRootPane().getHeight()/2 - playerCharactor.getP().y < 0 && this.mp.y >= -(this.getRootPane().getHeight()-30)) {
			this.mp.y -= playerCharactor.getSpeed();
			this.playerCharactor.getP().y -= playerCharactor.getSpeed();
		}		
		// 중앙 아래쪽으로
		else if (this.getRootPane().getHeight()/2 - playerCharactor.getP().y > 0 && this.mp.y <= -playerCharactor.getSpeed()) {
			this.mp.y += playerCharactor.getSpeed();
			this.playerCharactor.getP().y += playerCharactor.getSpeed();
		}

	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub	
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			playerCharactor.attack();
		}
		else {
			playerCharactor.move(e);
		}
		
		this.mapScroll();
				
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

		playerCharactor.setCurState(State.walk);
		playerCharactor.moveStop();
		playerCharactor.attackStop();
	
	}
	 
}