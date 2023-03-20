package server.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import message.Message;
import server.service.SimpleServer;
import server.service.SocketService;

public class fMain extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fMain frame = new fMain();
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
	public fMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, "name_50260469969800");
		panel.setLayout(new BorderLayout(0, 0));

		status = new JTextArea();
		status.setText("chờ kết nối");
		status.setEditable(false);
		panel.add(status, BorderLayout.CENTER);

		// setup server
		SocketService server = new SocketService();

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				server.close();
			}
		});

		try {
			server.serve(9990, new SimpleServer(this));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void HandleMessage(Message message) {
		String text = this.status.getText();
		if (text.equalsIgnoreCase("chờ kết nối"))
			text = "new user connected: ";
		
		this.status.setText(text + " " + message);
	}
}
