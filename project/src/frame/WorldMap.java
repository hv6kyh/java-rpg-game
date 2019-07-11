package frame;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import battleField.AfricaLab;
import battleField.Army;
import battleField.AsiaLab;
import battleField.EuropeVillage;
import battleField.OceaniaForest;
import battleField.SouthAmericaVillage;

public class WorldMap extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3584713787937831906L;
	JButton asia, northamerica, southamerica, europe, africa, oceania;		// Ç©¸»
	BufferedImage background;	// ¹è°æ
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(background, 0, 0, this);
		
	}
	
	private class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton b = (JButton)e.getSource();
			
			System.out.println(b.getName());
			
			switch (b.getName()) {
			
			case "asia" :
//				MainFrame.setCurrentPanel(new AsiaVillageEnter());
				MainFrame.setCurrentPanel(new AsiaLab());
				
				break;
				
			case "europe" :
				MainFrame.setCurrentPanel(new EuropeVillage());
				break;
				
			case "africa" :
				MainFrame.setCurrentPanel(new AfricaLab());
				break;
				
			case "oceania" :
				MainFrame.setCurrentPanel(new OceaniaForest());
				break;
				
			case "southamerica" :
				MainFrame.setCurrentPanel(new SouthAmericaVillage());
				break;
				
			case "northamerica" :
				MainFrame.setCurrentPanel(new Army());
				
			}
			
		}
		
	}

	public WorldMap(){
		this.setName("¿ùµå¸Ê");
		this.setLayout(null);
		
		Listener listener = new Listener();
		
		try {
			background = ImageIO.read(new File("D:/TheWorld/res/frame/WorldMap.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		asia = new JButton();
		asia.setIcon(new ImageIcon("D:/TheWorld/res/frame/asia.png"));
		asia.setBorderPainted(false);
		asia.setContentAreaFilled(false);
		asia.setFocusPainted(false);
		asia.setBounds(214, 180, 294-214, 250-180);
		asia.setName("asia");
		asia.addActionListener(listener);

		northamerica = new JButton();
		northamerica.setIcon(new ImageIcon("D:/TheWorld/res/frame/northamerica.png"));
		northamerica.setBorderPainted(false);
		northamerica.setContentAreaFilled(false);
		northamerica.setFocusPainted(false);
		northamerica.setBounds(557, 191, 637-557, 261-191);
		northamerica.setName("northamerica");
		northamerica.addActionListener(listener);
		
		southamerica = new JButton();
		southamerica.setIcon(new ImageIcon("D:/TheWorld/res/frame/southamerica.png"));
		southamerica.setBorderPainted(false);
		southamerica.setContentAreaFilled(false);
		southamerica.setFocusPainted(false);
		southamerica.setBounds(662, 363, 742-662, 433-363);
		southamerica.setName("southamerica");
		southamerica.addActionListener(listener);
		
		europe = new JButton();
		europe.setIcon(new ImageIcon("D:/TheWorld/res/frame/europe.png"));
		europe.setBorderPainted(false);
		europe.setContentAreaFilled(false);
		europe.setFocusPainted(false);
		europe.setBounds(68, 127, 148-68, 217-127);
		europe.setName("europe");
		europe.addActionListener(listener);

		africa = new JButton();
		africa.setIcon(new ImageIcon("D:/TheWorld/res/frame/africa.png"));
//		africa.setIcon(new ImageIco);
		
		africa.setBorderPainted(false);
		africa.setContentAreaFilled(false);
		africa.setFocusPainted(false);
		africa.setBounds(51, 292, 131-51, 362-292);
		africa.setName("africa");
		africa.addActionListener(listener);
		
		oceania = new JButton();
		oceania.setIcon(new ImageIcon("D:/TheWorld/res/frame/oceania.png"));
		oceania.setBorderPainted(false);
		oceania.setContentAreaFilled(false);
		oceania.setFocusPainted(false);
		oceania.setBounds(280, 357, 360-280, 427-357);
		oceania.setName("oceania");
		oceania.addActionListener(listener);

		this.add(asia);
		this.add(northamerica);
		this.add(southamerica);
		this.add(europe);
		this.add(africa);
		this.add(oceania);
		
	}
 
}

