package client.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class fDangKy extends JPanel {
	private JPanel panel;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtHo;
	private JTextField txtTen;
	private ButtonGroup gender;
	private JTextField textField;
	private JTextField textField_1;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("img\\login.jpg").getImage(), 0, 0, null);
	}

	/**
	 * Create the panel.
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
		
		JDateChooser dateChooser = new JDateChooser();
		sl_panel.putConstraint(SpringLayout.NORTH, dateChooser, 13, SpringLayout.SOUTH, txtTen);
		sl_panel.putConstraint(SpringLayout.WEST, dateChooser, 0, SpringLayout.WEST, txtUsername);
		sl_panel.putConstraint(SpringLayout.EAST, dateChooser, -235, SpringLayout.EAST, panel);
		panel.add(dateChooser);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
		sl_panel.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton, 13, SpringLayout.SOUTH, dateChooser);
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
		
		JButton btnNewButton = new JButton("Đăng nhập");
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -27, SpringLayout.SOUTH, panel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rootPane.removeAll();
				rootPane.add(new fDangNhap(accountBus, rootPane));
				rootPane.revalidate();
				rootPane.repaint();
			}
		});
		panel.add(btnNewButton);
		
		JButton btnngK = new JButton("Đăng ký");
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -6, SpringLayout.WEST, btnngK);
		sl_panel.putConstraint(SpringLayout.NORTH, btnngK, 0, SpringLayout.NORTH, btnNewButton);
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
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_3, 0, SpringLayout.SOUTH, dateChooser);
		panel.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Giới tính");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_4, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_4, 0, SpringLayout.SOUTH, rdbtnNewRadioButton);
		panel.add(lblNewLabel_1_1_4);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 13, SpringLayout.SOUTH, rdbtnNewRadioButton);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, txtUsername);
		sl_panel.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, lblNewLabel);
		textField.setColumns(10);
		panel.add(textField);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, -141, SpringLayout.EAST, lblNewLabel);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		JButton btnLyOtp = new JButton("Lấy OTP");
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 1, SpringLayout.NORTH, btnLyOtp);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 27, SpringLayout.EAST, btnLyOtp);
		sl_panel.putConstraint(SpringLayout.SOUTH, textField_1, 0, SpringLayout.SOUTH, btnLyOtp);
		sl_panel.putConstraint(SpringLayout.NORTH, btnLyOtp, 31, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, btnLyOtp, 0, SpringLayout.WEST, txtUsername);
		sl_panel.putConstraint(SpringLayout.EAST, btnLyOtp, 1, SpringLayout.EAST, rdbtnN);
		panel.add(btnLyOtp);
		
		JLabel lblNewLabel_1_1_4_1 = new JLabel("Email");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_4_1, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_4_1, 0, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_4_1, -67, SpringLayout.WEST, textField);
		panel.add(lblNewLabel_1_1_4_1);
	}
	
	private void init(JPanel rootPane) {
		JFrame topFrame = (JFrame) SwingUtilities.getRoot(rootPane);
		topFrame.setSize(690, 490);
	}
}
