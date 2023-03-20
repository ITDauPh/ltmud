package client.bus;

import java.io.IOException;
import java.net.UnknownHostException;

import client.dao.AccountDAO;
import message.dto.AccountDTO;

public class AccountBUS {
	private AccountDAO client;

	public AccountBUS() {
	}

	public boolean dangNhap(String username, String password) throws UnknownHostException, IOException {
		if (client == null || !client.isConnected()) {
			connect();
		}
		AccountDTO account = new AccountDTO();
		account.setUsername(username);
		account.setPassword(password);

		AccountDTO result = client.dangNhap(account);

		return result != null;
	}

	private void connect() throws UnknownHostException, IOException {
		client = new AccountDAO();
	}

	public void close() {
		client.close();
	}
}
