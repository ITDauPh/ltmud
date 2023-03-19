package client.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import message.Message;

public class Client {
	private Socket socket = null;
	private ObjectInputStream is = null;
	private ObjectOutputStream os = null;
	private BufferedReader stdin = null;
	
	public Client() {
		stdin = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void close() {
		try {
			os.close();
			socket.close();
			is.close();
		} catch (IOException e) {
		}
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
