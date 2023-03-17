package client.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static Socket socket = null;
	private static BufferedReader in = null;
	private static BufferedWriter out = null;
	private static BufferedReader stdIn = null;
	
	public Server() {
	}
	
	public boolean dangNhap(String username, String password) {
		try {
			socket = new Socket("localhost", 8000);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			stdIn = new BufferedReader(new InputStreamReader(System.in));
				
			System.out.print("Client input: " + username + " " + password);
			//String line = stdIn.readLine();
			String line = username + " " + password;
			out.write(line);
			out.newLine();
			out.flush();
			long start = System.nanoTime();
			
			// Client nhận phản hồi từ server
			//line = in.readLine();
			
			//long end = System.nanoTime();
			//long elapsedTime = end - start;
			//System.out.println("Client get(" + elapsedTime + "): " + line );
		
			System.out.println("Client closed connection");
			in.close();
			out.close();
			stdIn.close();
			socket.close();
			return true;
		} catch (IOException e) {
			System.err.println(e);
			return false;
		}
	}
	
	public static void main(String[] args) {
		
	}

}
