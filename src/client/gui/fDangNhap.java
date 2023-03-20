package client.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import client.bus.AccountBUS;

public class fDangNhap extends JPanel {
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_1;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("img\\login.jpg").getImage(), 0, 0, null);
	}

	/**
	 * Create the panel.
	 */
	public fDangNhap(AccountBUS accountBus) {
		setBorder(new EmptyBorder(5, 5, 13, 5));
		setLayout(new BorderLayout(0, 0));

		panel = this;

		JPanel panel = new JPanel();
		add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JButton btnNewButton = new JButton("\u0110\u0103ng k\u00FD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ---------------------------------------------
				Container parent = panel.getParent().getParent();
				parent.removeAll();
				parent.add(new fDangKy(accountBus));
				parent.repaint();
				parent.revalidate();
				// ---------------------------------------------
			}
		});
		panel.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("\u0110\u0103ng Nh\u1EADp");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 136, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -132, SpringLayout.EAST, panel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 113, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 44, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 27, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, 0, SpringLayout.EAST, lblNewLabel_1);
		panel.add(lblNewLabel_1_1);

		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, -62, SpringLayout.NORTH, textField);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -42, SpringLayout.NORTH, textField);
		sl_panel.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 15, SpringLayout.EAST, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -33, SpringLayout.EAST, panel);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 15, SpringLayout.EAST, lblNewLabel_1_1);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		textField_1.setColumns(10);
		panel.add(textField_1);

		JButton btnngNhp = new JButton("\u0110\u0103ng nh\u1EADp");
		btnngNhp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ---------------------------------------------
				System.out.println("Xử lý đăng nhập");
				

				// ---------------------------------------------
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnngNhp);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.WEST, btnngNhp);
		sl_panel.putConstraint(SpringLayout.NORTH, btnngNhp, 43, SpringLayout.SOUTH, textField_1);
		sl_panel.putConstraint(SpringLayout.EAST, btnngNhp, 0, SpringLayout.EAST, textField);
		panel.add(btnngNhp);

	}

}
