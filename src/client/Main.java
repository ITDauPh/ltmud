package client;

import javax.swing.SwingUtilities;

import client.bus.AccountBUS;
import client.gui.fMain;

public class Main implements Runnable {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Main());
	}

	@Override
	public void run() {
		fMain frame = new fMain(new AccountBUS());
		frame.setVisible(true);		
	}
}
