package battleField;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class AsiaVillage extends Map { 		// ���� �гη� �����Ѵ�
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1283747220481587343L;
	private int[][] tmp = {
			
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,0,0,0,0,1,1,1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,1,0,0,1,1,1,1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{1,1,0,0,0,1,1,1,1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1},
			{1,1,0,0,0,1,1,1,1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1},
			{1,1,0,0,0,1,1,0,0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1},
			{1,0,0,0,0,0,1,0,0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1},
			{1,0,0,0,1,1,1,0,0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,1,1,1,0,0,1,1,1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
			{1,1,1,1,0,1,1,1,1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
			{1,1,1,1,1,1,1,0,0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1},
			{1,1,1,1,1,1,1,0,0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1},
			{1,1,1,1,1,1,1,0,0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,0,0,0,0,0,0,0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
			{1,1,1,1,1,1,1,1,1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
			
	};
	
	public AsiaVillage() {			// ������
		
		super();
		// TODO Auto-generated constructor stub
//		this.setName("�ʵ�3");		
		Map.map = tmp;
		
		try {
			this.background = ImageIO.read(new File("D:/TheWorld/res/map/downtown.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		this.repaintThread.start();

	} 

//	@Override
//	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paint(g);
//		playerCharactor.draw(g);
//		
//	}
	
	@Override
	public boolean reachPortal() {
		// TODO Auto-generated method stub
		boolean b = false;
				
		return b;
	}

}