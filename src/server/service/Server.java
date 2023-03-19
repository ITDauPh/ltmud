package server.service;

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

public class Server {
	private static ServerSocket server = null;
	// có thể có nhiều kết nối cùng 1 lúc, nhiều socket, nhiều client, dùng Thread
	// để xử lí
	private static Socket socket = null;
	private ObjectInputStream is = null;
	private ObjectOutputStream os = null;

	public Server() {
		try {
			server = new ServerSocket(8000);
			System.out.println("Server started...");
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public Message acceptRes() {
		Message message = null;
		try {
			socket = server.accept();
			os = new ObjectOutputStream(socket.getOutputStream());
			is = new ObjectInputStream(socket.getInputStream());
			System.out.println("Client connected...");

			// Server nhận dữ liệu từ client
			message = (Message) is.readObject();
			System.out.println("Server received: " + message);

			System.out.println("Server closed connection");
		} catch (IOException | ClassNotFoundException e) {
			System.err.println(e);
		}
		return message;
	}

	public void close() {
		System.out.println("Server shutdown...");
		try {
			os.close();
			socket.close();
			server.close();
			is.close();
		} catch (IOException e) {
		}
	}

	public static void main(String[] args) {
		new Server().acceptRes();
	}
}
