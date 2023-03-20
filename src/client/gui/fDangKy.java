package client.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import client.bus.AccountBUS;

public class fDangKy extends JPanel {
	private JPanel panel;
	private JTextField txtngKThng;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("img\\login.jpg").getImage(), 0, 0, null);
	}

	/**
	 * Create the panel.
	 * @param accountBus 
	 */
	public fDangKy(AccountBUS accountBus) {
		setBorder(null);
		setLayout(new BorderLayout(0, 0));

		panel = this;

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		txtngKThng = new JTextField();
		txtngKThng.setEditable(false);
		txtngKThng.setHorizontalAlignment(SwingConstants.CENTER);
		txtngKThng.setText("\u0110\u0103ng k\u00FD th\u00F4ng tin");
		panel.add(txtngKThng);

		JButton btnNewButton = new JButton("\u0110\u0103ng Nh\u1EADp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container parent = panel.getParent().getParent();
				parent.removeAll();
				parent.add(new fDangNhap(accountBus));
				parent.repaint();
				parent.revalidate();
			}
		});
		panel.add(btnNewButton, BorderLayout.SOUTH);

	}

}
