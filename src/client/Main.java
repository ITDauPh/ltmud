package client;

import client.gui.fMain;

public class Main {

	public static void main(String[] args) {
		new fMain(new client.bus.AccountBUS()).setVisible(true);
	}
}
