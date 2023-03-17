package server;

public class Main {

	public static void main(String[] args) {
		// init csdl
		new server.gui.fStart().setVisible(true);
		new server.service.Server().acceptRes();
	}
}
