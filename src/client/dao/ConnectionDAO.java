package client.dao;

import java.io.IOException;
import java.net.UnknownHostException;

import client.network.Client;

// duy trì 1 kết nối từ client tới server
public class ConnectionDAO {
	private static client.network.Client client;

	public static Client getConnection() throws UnknownHostException, IOException {
		if (client != null) {
			return client;
		}
		client = new Client();
		return client;
	}

	public static void closeConnection() {
		if (client != null) {
			client.close();
		}
	}

}
