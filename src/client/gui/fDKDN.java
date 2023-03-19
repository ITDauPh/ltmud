package client.gui;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import client.bus.AccountBUS;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;

public class fDKDN extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField username;
	private JPasswordField password;
	private client.bus.AccountBUS account;

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

	private void init() {
		this.account = new AccountBUS();
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				account.close();
				super.windowClosed(e);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public fDKDN() {
		init();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 386);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 287);
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
		username.setBounds(114, 106, 264, 20);
		pdn.add(username);
		username.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(31, 152, 85, 14);
		pdn.add(lblNewLabel_1);

		password = new JPasswordField();
		password.setBounds(114, 149, 264, 20);
		pdn.add(password);

		JLabel lblNewLabel_2 = new JLabel("\u0110\u0103ng nh\u1EADp");
		lblNewLabel_2.setBounds(166, 44, 101, 20);
		pdn.add(lblNewLabel_2);

		JPanel pdk = new JPanel();
		pdk.setBackground(Color.WHITE);
		panel.add(pdk, "name_15361792369100");

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 296, 414, 40);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btndn = new JButton("\u0110\u0103ng nh\u1EADp");
		btndn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.getComponent(0).equals(pdn)) {
					System.out.println("dang nhap");

					// ---------------------------------------------
					try {
						if (account.dangNhap(username.getText(), password.getText())) {
							JOptionPane.showMessageDialog(panel, "Đăng nhập thành công", "Thành Công", JOptionPane.INFORMATION_MESSAGE);
						} else {
							throw new IOException("Sai mật khẩu");
						}
					} catch (HeadlessException | IOException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(panel, "Đăng nhập thất bại\n" + e1, "Thất bại", JOptionPane.ERROR_MESSAGE);
					}
					// ---------------------------------------------

				} else {
					panel.removeAll();
					panel.add(pdn);
					panel.repaint();
					panel.revalidate();
				}
			}
		});
		btndn.setBounds(293, 11, 111, 23);
		panel_1.add(btndn);

		JButton btndk = new JButton("\u0110\u0103ng k\u00FD");
		btndk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.getComponent(0).equals(pdk))
					System.out.println("dang ky");
				else {
					panel.removeAll();
					panel.add(pdk);
					panel.repaint();
					panel.revalidate();
				}
			}
		});
		btndk.setBounds(174, 11, 111, 23);
		panel_1.add(btndk);
	}
}
