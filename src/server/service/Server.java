package server.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static ServerSocket server = null;
	private static Socket socket = null;
	private static BufferedReader in = null;
	private static BufferedWriter out = null;
	
	public Server() {
		try {
			server = new ServerSocket(8000);
			System.out.println("Server started...");
		} catch (IOException e) {
			System.err.println(e);
		}		
	}
	
	public String acceptRes() {
		String line = "";
		try {
			socket = server.accept();
			System.out.println("Client connected...");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			// Server nhận dữ liệu từ client qua stream
			line = in.readLine();
			System.out.println("Server get: " + line);
			
			// Server gửi phản hồi ngược lại cho client (chuỗi đảo ngược)
//			out.write(line);
//			out.newLine();
//			out.flush();
		
			System.out.println("Server closed connection");
			in.close();
			out.close();
			socket.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
}
