package client.dao;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import message.dto.AccountDTO;

// xử lí các Message, gửi nhận các object
public class AccountDAO {
	private client.network.Client clientConnection;

	public AccountDAO() throws UnknownHostException, IOException {
		this.clientConnection = client.dao.ConnectionDAO.getConnection();
	}

	public AccountDTO dangNhap(String username, String password) {
		if (clientConnection == null)
			return null;

		AccountDTO account = new AccountDTO();
		account.getAccount().setUsername(username);
		account.getAccount().setUsername(password);
		account.setRequest("dangnhap");

		try {
			this.clientConnection.send(account);
			// should get account from server
			return account;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean isConnected() {
		if (clientConnection == null)
			return false;

		Socket socket = clientConnection.getSocket();
		return socket != null;
	}

	public void close() {
		if (clientConnection != null)
			clientConnection.close();
	}
}
