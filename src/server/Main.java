package server;

import javax.swing.SwingUtilities;

import server.gui.fMain;

public class Main implements Runnable {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Main());
	}

	@Override
	public void run() {
		fMain frame = new fMain();
		frame.setVisible(true);
	}
}
