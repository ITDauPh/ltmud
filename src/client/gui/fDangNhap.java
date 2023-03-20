package client.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import client.bus.AccountBUS;

public class fDangNhap extends JPanel {
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Create the panel.
	 */
	public fDangNhap(AccountBUS accountBus, JPanel rootPane) {
		init(rootPane);

		setBorder(new EmptyBorder(5, 5, 13, 5));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JButton btnDangky = new JButton("\u0110\u0103ng k\u00FD");
		btnDangky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ---------------------------------------------
//				Container parent = panel.getRootPane();

				rootPane.removeAll();
				rootPane.add(new fDangKy(accountBus, rootPane));
				rootPane.revalidate();
				rootPane.repaint();
				// ---------------------------------------------
			}
		});
		panel.add(btnDangky);

		JLabel lblNewLabel = new JLabel("\u0110\u0103ng Nh\u1EADp");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 136, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -132, SpringLayout.EAST, panel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username");
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 44, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel_1_1);
		panel.add(lblNewLabel_1_1);

		txtUsername = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtUsername, 110, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, txtUsername, 15, SpringLayout.EAST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.EAST, txtUsername, -33, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, txtUsername);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, -62, SpringLayout.NORTH, txtUsername);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -42, SpringLayout.NORTH, txtUsername);
		panel.add(txtUsername);
		txtUsername.setColumns(10);

		JButton btnDangNhap = new JButton("\u0110\u0103ng nh\u1EADp");
		sl_panel.putConstraint(SpringLayout.NORTH, btnDangky, 0, SpringLayout.NORTH, btnDangNhap);
		sl_panel.putConstraint(SpringLayout.EAST, btnDangky, -14, SpringLayout.WEST, btnDangNhap);
		sl_panel.putConstraint(SpringLayout.EAST, btnDangNhap, 0, SpringLayout.EAST, txtUsername);
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ---------------------------------------------
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				if (username.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(panel, "Không được bỏ trống", "Thiếu thông tin",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					try {
						if (accountBus.dangNhap(txtUsername.getText(), txtPassword.getText())) {
							JOptionPane.showMessageDialog(panel, "Đăng nhập thành công", "Thành Công",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							throw new IOException("Sai mật khẩu");
						}
					} catch (HeadlessException | IOException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(panel, e1, "Thất bại", JOptionPane.ERROR_MESSAGE);
					}
				}
				// ---------------------------------------------
			}
		});
		panel.add(btnDangNhap);

		txtPassword = new JPasswordField();
		sl_panel.putConstraint(SpringLayout.NORTH, btnDangNhap, 53, SpringLayout.SOUTH, txtPassword);
		sl_panel.putConstraint(SpringLayout.WEST, txtPassword, 17, SpringLayout.EAST, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.EAST, txtPassword, -33, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 3, SpringLayout.NORTH, txtPassword);
		sl_panel.putConstraint(SpringLayout.NORTH, txtPassword, 18, SpringLayout.SOUTH, txtUsername);
		panel.add(txtPassword);

	}

	private void init(JPanel rootPane) {
		JFrame topFrame = (JFrame) SwingUtilities.getRoot(rootPane);
		topFrame.setSize(500, 320);
	}
}
