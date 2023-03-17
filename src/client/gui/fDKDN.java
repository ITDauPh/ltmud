package client.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import client.service.Server;
import server.database.DatabaseConnection;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;

public class fDKDN extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField password;
	protected Server server;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fDKDN frame = new fDKDN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public fDKDN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 386);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 265);
		getContentPane().add(panel);
		panel.setLayout(new CardLayout());
		
		JPanel pdn = new JPanel();
		pdn.setBackground(Color.WHITE);
		panel.add(pdn, "name_15343481437400");
		pdn.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(31, 109, 87, 14);
		pdn.add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(128, 106, 233, 20);
		pdn.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(33, 152, 85, 14);
		pdn.add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setBounds(128, 149, 233, 20);
		pdn.add(password);
		
		JLabel lblNewLabel_2 = new JLabel("\u0110\u0103ng nh\u1EADp");
		lblNewLabel_2.setBounds(166, 44, 101, 20);
		pdn.add(lblNewLabel_2);
		
		JPanel pdk = new JPanel();
		pdk.setBackground(Color.WHITE);
		panel.add(pdk, "name_15361792369100");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 277, 414, 59);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		
		JButton btndn = new JButton("\u0110\u0103ng nh\u1EADp");
		btndn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel.getComponent(0).equals(pdn)) {
					System.out.println("dang nhap");
					server = new client.service.Server();
					if(server.dangNhap(username.getText(), password.getText())) {
						JOptionPane.showMessageDialog(panel, "Đăng nhập thành công", "S", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(panel, "Đăng nhập thất bại", "E", JOptionPane.ERROR_MESSAGE);
					}
					
				} else {
					panel.removeAll();
					panel.add(pdn);
					panel.repaint();
					panel.revalidate();
				}
			}
		});
		btndn.setBounds(293, 36, 111, 23);
		panel_1.add(btndn);
		
		JButton btndk = new JButton("\u0110\u0103ng k\u00FD");
		btndk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel.getComponent(0).equals(pdk))
					System.out.println("dang ky");
				else {
					panel.removeAll();
					panel.add(pdk);
					panel.repaint();
					panel.revalidate();
				}
			}
		});
		btndk.setBounds(172, 36, 111, 23);
		panel_1.add(btndk);
	}
}
