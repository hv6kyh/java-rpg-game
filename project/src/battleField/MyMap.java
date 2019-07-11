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

public class MyMap extends Map { 		// ���� �гη� �����Ѵ�
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1283747220481587343L;
	
	private Point mp;
	
	public MyMap() {			// ������
		
		super();
		// TODO Auto-generated constructor stub
		this.setName("�����");
		
		playerCharactor.setSpeed(10);
		
		mp = new Point(0,0);
		
		this.addKeyListener(this);				// Ű������ ���
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

	// �гο� �׸��� �׸��� �޼ҵ�
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
		
		System.out.println("�����  ����");
		
		while (MainFrame.getCurrentPanelName() == "�����") {

			try {
				Thread.sleep(1000/fps);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("������� �����尡 ���ͷ�Ʈ ����");
				return;
			}
			repaint();
		}
		
		System.out.println("����� ������ ����");
		
	}
	
	public void mapScroll() {
		
		// �߾� ����������
		if (this.getRootPane().getWidth()/2 - playerCharactor.getP().x < 0 && this.mp.x >= -(this.getRootPane().getWidth()-7)) {
			this.mp.x -= playerCharactor.getSpeed();
			this.playerCharactor.getP().x -= playerCharactor.getSpeed();
		}		
		// �߾� ��������
		else if (this.getRootPane().getWidth()/2 - playerCharactor.getP().x > 0 && this.mp.x <= -playerCharactor.getSpeed()) {
			this.mp.x += playerCharactor.getSpeed();
			this.playerCharactor.getP().x += playerCharactor.getSpeed();
		}
		
		// �߾� ��������
		if (this.getRootPane().getHeight()/2 - playerCharactor.getP().y < 0 && this.mp.y >= -(this.getRootPane().getHeight()-30)) {
			this.mp.y -= playerCharactor.getSpeed();
			this.playerCharactor.getP().y -= playerCharactor.getSpeed();
		}		
		// �߾� �Ʒ�������
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