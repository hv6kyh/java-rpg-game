package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import charactors.PlayerCharactor;

public class NewMainPanel extends JPanel {
	int clickCnt = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2694743302612020646L;
	JPanel charactorChattingPanel;				// 왼쪽 캐릭터와 채팅
	JPanel charactorPanel;						// └캐릭터만
	JPanel chattingPanel;						// └채팅만
	
	final static Color color = Color.WHITE;

	JPanel itemPanel;							// 아이템 탭
	JPanel monsterPanel = new MonsterPanel();						// 몬스터 탭
	JPanel equipmentPanel;						// 장비 탭
	JPanel statPanel;							// 스탯 탭
	
	PlayerCharactor playerCharactor = null;
	
	Dimension panelSize = new Dimension(800,600);
	Dimension btnSize = new Dimension(70,30);

	public NewMainPanel() throws UnknownHostException, SocketException {
		super();
		// TODO Auto-generated constructor stub
		this.setName("메인패널");
		this.setPreferredSize(panelSize);
		this.setLayout(new GridLayout(0,2));
		this.setSize(800,600);
		
		charactorChattingPanel = new JPanel(new BorderLayout());
		
		charactorPanel = new CharactorPanel();

		chattingPanel = new ChattingPanel();
		
		charactorChattingPanel.add(charactorPanel);
		charactorChattingPanel.add(chattingPanel, BorderLayout.SOUTH);
		
		itemPanel = new ItemPanel();
//		monsterPanel = new MonsterPanel();
		equipmentPanel = new EquipmentPanel();
		statPanel = new StatPanel();
		
		JTabbedPane itemMonsterPane = new JTabbedPane();
		itemMonsterPane.addTab("아이템", itemPanel);
		itemMonsterPane.addTab("몬스터", monsterPanel);
		itemMonsterPane.addTab("장비", equipmentPanel);
		itemMonsterPane.addTab("스탯", statPanel);
		
//		itemMonsterPane.setUI(new BasicTabbedPaneUI() {
//
//			@Override
//			protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
//				// TODO Auto-generated method stub
//				super.paintContentBorder(g, tabPlacement, selectedIndex);
//				g.setColor(Color.BLACK);
//				System.out.println("페이트컨턴트보더");
//			}
//
//			@Override
//			protected void paintTab(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect,
//					Rectangle textRect) {
//				// TODO Auto-generated method stub
//				super.paintTab(g, tabPlacement, rects, tabIndex, iconRect, textRect);
//
//
//				setFont(new Font("Seirf", Font.PLAIN, 50));
//			}
//			
//			
//		});
		
		this.add(charactorChattingPanel);				// 왼쪽
		this.add(itemMonsterPane);						// 오른쪽
		this.setBackground(color);
		
	}

	private class CharactorPanel extends JPanel implements ActionListener {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -2517684995907187121L;
		private JButton advanture = null;

		public CharactorPanel() {
			super();
			// TODO Auto-generated constructor stub
			this.setLayout(new BorderLayout());
			playerCharactor = PlayerCharactor.getInstance();
			
			advanture = new JButton();
			advanture.addActionListener(this);
			advanture.setIcon(new ImageIcon("D:/TheWorld/res/frame/play.png"));
			advanture.setBorderPainted(false);
			advanture.setPreferredSize(new Dimension(98,30));
			
			JPanel p = new JPanel();
			p.setBackground(color);
			p.setLayout(new FlowLayout(FlowLayout.RIGHT));
			p.add(advanture);
			this.add(p, BorderLayout.SOUTH);
			
			this.setBackground(color);
			
			advanture.setContentAreaFilled(false);
			advanture.setFocusPainted(false);
			
		}

		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			playerCharactor.draw(g);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			MainFrame.setCurrentPanel(new WorldMap());
			
		}
		
	}
	
	private class ChattingPanel extends JPanel implements ActionListener, Runnable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -5615145785289706381L;
		
		JTextArea chattingArea;
		JTextField chattingField;
		
		DatagramSocket socket;
		DatagramPacket packet;
		
		InetAddress address = null;
		
		final int myPort = 6000;			// 수신용 포트
		final int otherPort = 5000;			// 송신용 포트
		
		public ChattingPanel() throws UnknownHostException, SocketException {
			super();
			// TODO Auto-generated constructor stub
			this.setLayout(new BorderLayout());
			
			address = InetAddress.getByName("localhost");
			socket = new DatagramSocket(myPort);
			
			chattingArea = new JTextArea(10, 0);
			chattingArea.setEditable(false);
			JScrollPane sc = new JScrollPane(chattingArea);
			sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);			
			sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			// 스크롤바 안뜨게
			
			chattingArea.append("수신포트 : " + myPort + "/n");
			chattingArea.append("송신포트 : " + otherPort + "/n");
						
			chattingField = new JTextField();
			chattingField.addActionListener(this);
			
			this.add(sc);
			this.add(chattingField, BorderLayout.SOUTH);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String s = chattingField.getText();

			byte[] totalByteMessage = new byte[s.length()];
			
			try {
				totalByteMessage = s.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			DatagramPacket packet;

			packet = new DatagramPacket(totalByteMessage, totalByteMessage.length, address, otherPort);
			
			try {
				socket.send(packet);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			chattingArea.append("SENT : " + s + "/n");
			chattingField.setText("");
			chattingArea.setCaretPosition(chattingArea.getDocument().getLength());
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				
				try {
					byte[] buf = new byte[256];
					packet = new DatagramPacket(buf, buf.length);
					socket.receive(packet);
					
					String byteToString = new String(buf,0,buf.length,"UTF-8");
					
					chattingArea.append("RECIEVE : " + byteToString + "/n");
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		}
				
	}
	
	private class ItemPanel extends JPanel implements ActionListener {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 2350088926244889226L;
		JPanel itemInventory, itemButtonPanel, buttonPanel;
		JButton[] itemButton = new JButton[15];
		JButton equipButton, itemSellButton; //장착, 되팔기
		JLabel gameMoneyLabel;
		
//		Item item;
		
		public ItemPanel(){
			
			this.setLayout(new BorderLayout());
			this.setBackground(color);
			
			itemInventory = new JPanel(new GridLayout(0, 3));
			itemButtonPanel = new JPanel(new BorderLayout());
			buttonPanel = new JPanel(new GridLayout(0,2));
			
			for(int i=0; i<itemButton.length; i++){
//				itemButton[i] = new JButton("아이템" + (i+1));
				itemButton[i] = new JButton();
//				itemButton[i].setEnabled(false);
				itemButton[i].addActionListener(this);
				itemButton[i].setName("버튼"+i);
				itemButton[i].setContentAreaFilled(false);
				itemButton[i].setFocusPainted(false);
				itemInventory.add(itemButton[i]);
			}
			
			this.add(itemInventory, BorderLayout.CENTER);
			
			// 장착 버튼
			equipButton = new JButton();
			equipButton.setIcon(new ImageIcon("D:/TheWorld/res/frame/equip.png"));
			equipButton.setContentAreaFilled(false);
			equipButton.setBorderPainted(false);
			equipButton.setPreferredSize(btnSize);
			
			// 팔기 버튼
			itemSellButton = new JButton();
			itemSellButton.setIcon(new ImageIcon("D:/TheWorld/res/frame/sell.png"));
			itemSellButton.setContentAreaFilled(false);
			itemSellButton.setBorderPainted(false);
			itemSellButton.setPreferredSize(btnSize);
			
			buttonPanel.add(equipButton);
			buttonPanel.add(itemSellButton);
			
			gameMoneyLabel = new JLabel(playerCharactor.getMoney() + "");
			itemButtonPanel.add(buttonPanel, BorderLayout.WEST);
			itemButtonPanel.add(gameMoneyLabel, BorderLayout.EAST);
			this.add(itemButtonPanel, BorderLayout.SOUTH);
			
			itemButtonPanel.setBackground(color);
			itemInventory.setBackground(color);
			buttonPanel.setBackground(color);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton b = (JButton)e.getSource();
			System.out.println(b.getName());
			
		}
		
	}
	
	private class MonsterPanel extends JPanel implements ActionListener {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 482777623541643645L;
		JPanel monsterIventory;
		JPanel monsterButtonPanel;
		JButton[] monsterButton = new JButton[15];
		JButton researchButton, disassembleButton, composeButton, monsterSellButton; //연구,분해,합성,되팔기
		
//		ArrayList<Monster> caughtMonster = new ArrayList<>();
		
		public MonsterPanel() {
			
			this.setLayout(new BorderLayout());
			this.setBackground(color);
			
			monsterIventory = new JPanel(new GridLayout(0, 3));
			monsterButtonPanel = new JPanel(new GridLayout(0, 4));
			
			for(int i=0; i<monsterButton.length; i++){
				monsterButton[i] = new JButton("몬스터" + (i+1));
				monsterButton[i].setName("버튼"+i);
				monsterButton[i].setEnabled(false);
				monsterButton[i].setContentAreaFilled(false);
				monsterButton[i].setFocusPainted(false);
				monsterButton[i].addActionListener(this);
				monsterIventory.add(monsterButton[i]);
			}
			
			this.add(monsterIventory, BorderLayout.CENTER);
			
			// 연구 버튼
			researchButton = new JButton();
			researchButton.setIcon(new ImageIcon("D:/TheWorld/res/frame/research.png"));
			researchButton.setContentAreaFilled(false);
			researchButton.setBorderPainted(false);
			researchButton.setPreferredSize(btnSize);
			
			// 분해 버튼
			disassembleButton = new JButton();
			disassembleButton.setIcon(new ImageIcon("D:/TheWorld/res/frame/disassemble.png"));
			disassembleButton.setContentAreaFilled(false);
			disassembleButton.setBorderPainted(false);
			disassembleButton.setPreferredSize(btnSize);
						
			// 합성 버튼
			composeButton = new JButton();
			composeButton.setIcon(new ImageIcon("D:/TheWorld/res/frame/compose.png"));
			composeButton.setContentAreaFilled(false);
			composeButton.setBorderPainted(false);
			composeButton.setPreferredSize(btnSize);
						
			// 팔기 버튼
			monsterSellButton = new JButton();
			monsterSellButton.setIcon(new ImageIcon("D:/TheWorld/res/frame/sell.png"));
			monsterSellButton.setContentAreaFilled(false);
			monsterSellButton.setBorderPainted(false);
			monsterSellButton.setPreferredSize(btnSize);
			
			monsterButtonPanel.add(researchButton);
			monsterButtonPanel.add(disassembleButton);
			monsterButtonPanel.add(composeButton);
			monsterButtonPanel.add(monsterSellButton);
			
			JPanel p = new JPanel(new BorderLayout());
			p.add(monsterButtonPanel, BorderLayout.WEST);
			p.setBackground(color);
			
			this.add(p, BorderLayout.SOUTH);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton b = (JButton)e.getSource();
			System.out.println(b.getName());
			
		}

	}
	
	private class EquipmentPanel extends JPanel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -8874205182860411169L;
		JLabel[] equippedItemLabel = new JLabel[11];
		String[] equippedItemString = {"장신구1", "머리", "장신구2", "무기", "상의", "방패", "", "하의", "", "", "신발"};
		
		public EquipmentPanel() {
			super();
			// TODO Auto-generated constructor stub
			this.setLayout(new GridLayout(0,3));
			this.setBackground(color);
			
			for (int i = 0; i < equippedItemLabel.length; i++) {
				equippedItemLabel[i]  = new JLabel(equippedItemString[i]);
				this.add(equippedItemLabel[i]);
			}
			
		}		
		
	}
	
	private class StatPanel extends JPanel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 4597173639831494946L;
		JLabel[] statLabel = new JLabel[3];
		String[] statString = {"HP", "ATK", "DEF"};
		
		public StatPanel() {
			super();
			// TODO Auto-generated constructor stub
			this.setLayout(new GridLayout(3,2));
			this.setBackground(color);
			
			for (int i = 0; i < statLabel.length; i++) {
				statLabel[i] = new JLabel(statString[i]);
				this.add(statLabel[i]);
				this.add(new JLabel("0"));
			}
			
		}
		
	}
	
}
