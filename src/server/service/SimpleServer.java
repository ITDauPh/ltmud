package server.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import message.Message;
import server.gui.fStart;

// handle only 1 connection
public class SimpleServer implements SocketServer {
	private Socket clientSocket;
	private ObjectInputStream is;
	private ObjectOutputStream os;
	private fStart frame;

//	public Message acceptRes() {
//		Message message = null;
//		try {
//			socket = server.accept();
//			
//			System.out.println("Client connected...");
//
//			// Server nhận dữ liệu từ client
//			message = (Message) is.readObject();
//			System.out.println("Server received: " + message);
//
//			System.out.println("Server closed connection");
//		} catch (IOException | ClassNotFoundException e) {
//			System.err.println(e);
//		}
//		return message;
//	}

	public SimpleServer() {
	}

	public SimpleServer(fStart frame) {
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

			message = (Message) is.readObject();

			this.frame.HandleMessage(message);
			close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Server received: " + message);
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
