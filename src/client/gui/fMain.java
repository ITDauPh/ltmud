package client.gui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import client.bus.AccountBUS;

public class fMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					fMain frame = new fMain(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * 
	 * @param accountBUS
	 */
	public fMain(AccountBUS accountBUS) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 320);
		setLocationRelativeTo(null);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		fDangNhap fDangNhap = new fDangNhap(accountBUS, contentPane);
		contentPane.add(fDangNhap, "name_19265023155700");
		contentPane.revalidate();
	}

}
