package client.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

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
	
//	public boolean dangNhap(String username, String password) {
//		try {
//			socket = new Socket("localhost", 8000);
//			// https://stackoverflow.com/questions/27736175/how-to-send-receive-objects-using-sockets-in-java
//			os = new ObjectOutputStream(socket.getOutputStream());
//			is = new ObjectInputStream(socket.getInputStream());
//			System.out.println("Dang nhap: " + username + " " + password);
//			
//			// gửi một thực thể qua mạng
//			Message message = new Message(username, password);
//			os.writeObject(message);
//			
//			System.out.println("Client closed connection");
//			return true;
//		} catch (IOException e) {
//			System.err.println(e);
//			return false;
//		}
//	}
}
