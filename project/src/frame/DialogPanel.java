package frame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import battleField.Map;
import charactors.Charactor;

public class DialogPanel extends JPanel implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6501144488063280288L;

	BufferedImage[] dialogImage = null;
	
	private int pageIndex = 0;					// 현재 페이지
	private int numberOfPages;					// 전체 페이지
	int speakIndex = 0;							// 말하고 있는 사람 배열 인덱스
	int spoke = 1;								// 아까 말했던 사람

	private boolean isWalking = true;			// 대화창이 동작중인지 판별
	private boolean isSingle = false;
	
	private Map map;							// 포커스를 돌려줘야 할 맵
	private Charactor[] c = new Charactor[2];	// 대화하는 캐릭터 두 명
	
	private String sequence;					// 대화 순서를 나타내는 문자열

	// 시작 페이지와 종료 페이지 받음
	public DialogPanel(String name, int start, int end, Map map,
			Charactor c1, Charactor c2, String sequence) {
		super();
		// TODO Auto-generated constructor stub
		
		this.setName("대화창");
		this.setPreferredSize(new Dimension(800,200));

		int n = start;
		this.numberOfPages = end - start + 1;
		
		this.map = map;
		
		this.c[0] = c1;
		this.c[1] = c2;
		
		this.sequence = sequence;
		
		nextSpeak();
		
		dialogImage = new BufferedImage[numberOfPages];
		
		for (int i = 0; i <= end - start; i++) {
			
			try {
				dialogImage[i] = ImageIO.read(new File("D:/TheWorld/res/dialog/" + name + n++ + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		this.addKeyListener(this);
		
		this.setFocusable(true);
		
	}
	
	public DialogPanel(String name, int start, int end, Map map, Charactor c1) {
		super();
		// TODO Auto-generated constructor stub
		
		this.setName("대화창");
		this.setPreferredSize(new Dimension(800,200));
		
		int n = start;
		this.numberOfPages = end - start + 1;
		
		this.map = map;

		this.isSingle = true;
		
		c[0] = c1;
		c[0].setSpeaking(true);
		
		dialogImage = new BufferedImage[numberOfPages];
		
		for (int i = 0; i <= end - start; i++) {
			
			try {
				dialogImage[i] = ImageIO.read(new File("D:/TheWorld/res/dialog/" + name + n++ + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		this.addKeyListener(this);
		
		this.setFocusable(true);
		
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(dialogImage[pageIndex], 0, 0, this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			
			if (pageIndex < numberOfPages - 1) {
				pageIndex++;
				this.repaint();
				
				if (!isSingle)
					nextSpeak();
				
			}
			else {
				isWalking = false;
				map.hideDialog();
				System.out.println("대화 종료");
				
				if (!isSingle) {
					c[0].setSpeaking(false);
					c[1].setSpeaking(false);
				}
				else
					c[0].setSpeaking(false);
				
			}
			
		}
		
	}

	public boolean isWalking() {
		return isWalking;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void nextSpeak() {

		c[spoke].setSpeaking(false);
		int tmp = Integer.parseInt(sequence.charAt(speakIndex)+"");
		c[tmp-1].setSpeaking(true);
		speakIndex++;
		spoke = tmp-1;
		
	}

}
