package server.service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import server.gui.fStart;

public class SocketService {
	private ServerSocket ss;
	private boolean running;
	private SocketServer handler;
	private Thread serverThread;
	private List<Thread> serverThreads = Collections.synchronizedList(new LinkedList());
	
	public SocketService() {
		
	}

	public void serve(int port, SocketServer handler) throws IOException {
		this.ss = new ServerSocket();
		this.ss.setReuseAddress(true);
		this.ss.bind(new InetSocketAddress(port));
		this.handler = handler;
		this.serverThread = makeServerThread();
		this.serverThread.start();
	}

	private Thread makeServerThread() {
		running = true;
		return new Thread(new Runnable() {
			@Override
			public void run() {
				while (running) {
					try {
						Socket s = ss.accept();
						Thread t = new Thread(new Runnable() {
							@Override
							public void run() {
								handler.serve(s);
								try {
									s.close();
								} catch (IOException e) {
								}
							}
						});
						serverThreads.add(t);
						t.start();
					} catch (IOException e) {
					}
				}
			}
		});
	}

	public void close() {
		try {
			running = false;
			ss.close();
			serverThread.join();
			while (serverThreads.size() > 0) {
				Thread t = (Thread) serverThreads.get(0);
				serverThreads.remove(t);
				t.join();
			}
		} catch (NullPointerException e) {
		} catch (IOException e) {
		} catch (InterruptedException e) {
		}
	}
}
