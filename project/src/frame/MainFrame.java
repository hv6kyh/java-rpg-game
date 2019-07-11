package frame;

import java.awt.HeadlessException;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import battleField.Map;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6254917444644849825L;
	private static JPanel currentPanel;
	
	private static MainFrame main;
	
	private static NewMainPanel panel;

	public MainFrame(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		this.setPreferredSize(Map.getMapSize());				// 프레임 사이즈 설정
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();

	}

	public static void main(String[] args) throws UnknownHostException, SocketException {
		// TODO Auto-generated method stub		
		
		if (!args[0].equals("success08")) {
			JOptionPane.showMessageDialog(null, "비정상적인 실행입니다.", "경고", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		main = new MainFrame("The World ver1.1");
		panel = new NewMainPanel();
		main.getContentPane().add(panel);
		main.setVisible(true);
		
	}

	public static void setCurrentPanel(JPanel currentPanel) {
		MainFrame.currentPanel = currentPanel;
		main.setVisible(false);
		main.getContentPane().removeAll();
		main.getContentPane().add(MainFrame.currentPanel);
		main.setVisible(true);
		System.out.println(MainFrame.getCurrentPanelName());
	}

	public static JPanel getCurrentPanel() {
		return currentPanel;
	}
	
	public static String getCurrentPanelName() {		
		return MainFrame.currentPanel.getClass().getName();		
	}
	
	public static void goMainMenu() {
		MainFrame.setCurrentPanel(panel);
	}

}
