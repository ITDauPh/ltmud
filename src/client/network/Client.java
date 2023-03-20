package client.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

// tạo kết nối
public class Client {
	private Socket socket;
	private ObjectInputStream is;
	private ObjectOutputStream os;

	public Client() throws UnknownHostException, IOException {
		socket = new Socket("127.0.0.1", 9990);
		os = new ObjectOutputStream(socket.getOutputStream());
		is = new ObjectInputStream(socket.getInputStream());
	}

	public ObjectInputStream getIs() {
		return is;
	}

	public ObjectOutputStream getOs() {
		return os;
	}

	public void close() {
		try {
			os.close();
			is.close();
			socket.close();
		} catch (IOException e) {
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public void send(Object o) throws IOException {
		os.writeObject(o);
	}

	public void receive() {

	}
}
