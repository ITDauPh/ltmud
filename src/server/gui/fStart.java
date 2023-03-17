package server.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import message.Message;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JLabel;

public class fStart extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fStart frame = new fStart();
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
	public fStart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 227);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "name_7096536115700");
		panel_2.setLayout(null);
		
		JLabel status = new JLabel("\u0110ang kh\u1EDFi \u0111\u1ED9ng...");
		status.setBounds(10, 11, 414, 205);
		panel_2.add(status);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 228, 434, 33);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Tr\u1EDF v\u1EC1");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(0, 11, 89, 23);
		panel_1.add(btnNewButton);
		System.out.println("HERE");
		
		Runnable server =
				new Runnable() {
					public void run() {
						Message message = new server.service.Server().acceptRes();
						status.setText("new user connected " + message.getUsername());
					}
				};
		new Thread(server).start();
	}
}
