package server.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import message.Message;
import server.gui.fMain;

// handle only 1 connection
public class SimpleServer implements SocketServer {
	private Socket clientSocket;
	private ObjectInputStream is;
	private ObjectOutputStream os;
	private fMain frame;

	public SimpleServer() {
	}

	public SimpleServer(fMain frame) {
		this.frame = frame;
	}

	@Override
	public void serve(Socket clientSocket) {
		Message message = null;
		this.clientSocket = clientSocket;

		System.out.println("Server received a request");
		
		try {
			os = new ObjectOutputStream(clientSocket.getOutputStream());
			is = new ObjectInputStream(clientSocket.getInputStream());
		
			while(clientSocket.isConnected()) {
				message = (Message) is.readObject();
				System.out.println("Server received account " + message);
				this.frame.HandleMessage(message);
			}
			close();
			System.out.println("Server closed connection with " + message);
		} catch (IOException e) {
			close();
			System.out.println("Server closed connection with " + message);
		} catch (ClassNotFoundException e) {
		}
	}

	public void close() {
		
		try {
			is.close();
			os.close();
			clientSocket.close();
		} catch (IOException e) {
		}
	}
}
