package client.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JDateChooser;

import client.bus.AccountBUS;

public class fDangKy extends JPanel {
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtHo;
	private JTextField txtTen;
	private ButtonGroup gender;
	private JTextField txtEmail;
	private JTextField txtOTP;

	/**
	 * Create the panel.
	 * 
	 * @param accountBus
	 */
	public fDangKy(AccountBUS accountBus, JPanel rootPane) {
		init(rootPane);

		setBorder(null);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JLabel lblNewLabel = new JLabel("Đăng Ký Tài Khoản");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 22, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 49, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -55, SpringLayout.EAST, panel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 27, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_1);

		txtUsername = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, txtUsername);
		sl_panel.putConstraint(SpringLayout.NORTH, txtUsername, 37, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, txtUsername, 130, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtUsername, 0, SpringLayout.EAST, lblNewLabel);
		panel.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtPassword, 13, SpringLayout.SOUTH, txtUsername);
		sl_panel.putConstraint(SpringLayout.WEST, txtPassword, 0, SpringLayout.WEST, txtUsername);
		sl_panel.putConstraint(SpringLayout.EAST, txtPassword, -55, SpringLayout.EAST, panel);
		txtPassword.setColumns(10);
		panel.add(txtPassword);

		txtHo = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtHo, 13, SpringLayout.SOUTH, txtPassword);
		sl_panel.putConstraint(SpringLayout.WEST, txtHo, 0, SpringLayout.WEST, txtUsername);
		sl_panel.putConstraint(SpringLayout.EAST, txtHo, -55, SpringLayout.EAST, panel);
		txtHo.setColumns(10);
		panel.add(txtHo);

		txtTen = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtTen, 13, SpringLayout.SOUTH, txtHo);
		sl_panel.putConstraint(SpringLayout.WEST, txtTen, 0, SpringLayout.WEST, txtUsername);
		sl_panel.putConstraint(SpringLayout.EAST, txtTen, 0, SpringLayout.EAST, lblNewLabel);
		txtTen.setColumns(10);
		panel.add(txtTen);

		JDateChooser txtNgaySinh = new JDateChooser();
		sl_panel.putConstraint(SpringLayout.NORTH, txtNgaySinh, 13, SpringLayout.SOUTH, txtTen);
		sl_panel.putConstraint(SpringLayout.WEST, txtNgaySinh, 0, SpringLayout.WEST, txtUsername);
		sl_panel.putConstraint(SpringLayout.EAST, txtNgaySinh, -235, SpringLayout.EAST, panel);
		panel.add(txtNgaySinh);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
		sl_panel.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton, 13, SpringLayout.SOUTH, txtNgaySinh);
		sl_panel.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton, 0, SpringLayout.WEST, txtUsername);
		panel.add(rdbtnNewRadioButton);

		JRadioButton rdbtnN = new JRadioButton("Nữ");
		sl_panel.putConstraint(SpringLayout.NORTH, rdbtnN, 0, SpringLayout.NORTH, rdbtnNewRadioButton);
		sl_panel.putConstraint(SpringLayout.WEST, rdbtnN, 6, SpringLayout.EAST, rdbtnNewRadioButton);
		panel.add(rdbtnN);

		JRadioButton rdbtnKhc = new JRadioButton("Khác");
		sl_panel.putConstraint(SpringLayout.NORTH, rdbtnKhc, 0, SpringLayout.NORTH, rdbtnNewRadioButton);
		sl_panel.putConstraint(SpringLayout.WEST, rdbtnKhc, 6, SpringLayout.EAST, rdbtnN);
		panel.add(rdbtnKhc);

		gender = new ButtonGroup();
		gender.add(rdbtnNewRadioButton);
		gender.add(rdbtnN);
		gender.add(rdbtnKhc);

		JButton btnDangNhap = new JButton("Đăng nhập");
		sl_panel.putConstraint(SpringLayout.SOUTH, btnDangNhap, -27, SpringLayout.SOUTH, panel);
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rootPane.removeAll();
				rootPane.add(new fDangNhap(accountBus, rootPane));
				rootPane.revalidate();
				rootPane.repaint();
			}
		});
		panel.add(btnDangNhap);

		JButton btnngK = new JButton("Đăng ký");
		sl_panel.putConstraint(SpringLayout.EAST, btnDangNhap, -6, SpringLayout.WEST, btnngK);
		sl_panel.putConstraint(SpringLayout.NORTH, btnngK, 0, SpringLayout.NORTH, btnDangNhap);
		sl_panel.putConstraint(SpringLayout.EAST, btnngK, 0, SpringLayout.EAST, lblNewLabel);
		panel.add(btnngK);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1, 0, SpringLayout.SOUTH, txtPassword);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Họ và tên đệm");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_1, 0, SpringLayout.SOUTH, txtHo);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Tên");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_2, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_2, 0, SpringLayout.SOUTH, txtTen);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_2, -9, SpringLayout.EAST, lblNewLabel_1);
		panel.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_3 = new JLabel("Ngày sinh");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_3, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_3, 0, SpringLayout.SOUTH, txtNgaySinh);
		panel.add(lblNewLabel_1_1_3);

		JLabel lblNewLabel_1_1_4 = new JLabel("Giới tính");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_4, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_4, 0, SpringLayout.SOUTH, rdbtnNewRadioButton);
		panel.add(lblNewLabel_1_1_4);

		txtEmail = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtEmail, 13, SpringLayout.SOUTH, rdbtnNewRadioButton);
		sl_panel.putConstraint(SpringLayout.WEST, txtEmail, 0, SpringLayout.WEST, txtUsername);
		sl_panel.putConstraint(SpringLayout.EAST, txtEmail, 0, SpringLayout.EAST, lblNewLabel);
		txtEmail.setColumns(10);
		panel.add(txtEmail);

		txtOTP = new JTextField();
		sl_panel.putConstraint(SpringLayout.EAST, txtOTP, -141, SpringLayout.EAST, lblNewLabel);
		txtOTP.setColumns(10);
		panel.add(txtOTP);

		JButton btnLyOtp = new JButton("Lấy OTP");
		sl_panel.putConstraint(SpringLayout.NORTH, txtOTP, 1, SpringLayout.NORTH, btnLyOtp);
		sl_panel.putConstraint(SpringLayout.WEST, txtOTP, 27, SpringLayout.EAST, btnLyOtp);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtOTP, 0, SpringLayout.SOUTH, btnLyOtp);
		sl_panel.putConstraint(SpringLayout.NORTH, btnLyOtp, 31, SpringLayout.SOUTH, txtEmail);
		sl_panel.putConstraint(SpringLayout.WEST, btnLyOtp, 0, SpringLayout.WEST, txtUsername);
		sl_panel.putConstraint(SpringLayout.EAST, btnLyOtp, 1, SpringLayout.EAST, rdbtnN);
		panel.add(btnLyOtp);

		JLabel lblNewLabel_1_1_4_1 = new JLabel("Email");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_4_1, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_4_1, 0, SpringLayout.SOUTH, txtEmail);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_4_1, -67, SpringLayout.WEST, txtEmail);
		panel.add(lblNewLabel_1_1_4_1);
	}

	private void init(JPanel rootPane) {
		JFrame topFrame = (JFrame) SwingUtilities.getRoot(rootPane);
		topFrame.setSize(690, 490);
	}
}
