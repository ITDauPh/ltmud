package client.dao;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import client.dto.AccountDTO;
import client.network.Client;
import message.Message;

public class AccountDAO {
	private client.network.Client clientConnection; 
	
	public AccountDAO() throws UnknownHostException, IOException {
		this.clientConnection = new Client();
	}
	
	public AccountDTO dangNhap(AccountDTO account) {
		Message message = new Message(account);
		try {
			this.clientConnection.send(message);
			// should get account from server
			return message.getAccount();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean isConnected() {
		Socket socket = clientConnection.getSocket();
		return socket != null && socket.isConnected();
	}
}
