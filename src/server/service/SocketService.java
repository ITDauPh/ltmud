package server.service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SocketService {
	private ServerSocket ss;
	private Thread serverThread;
	private boolean running;
	private SocketServer handler;
	private List<Thread> serverThreads = Collections.synchronizedList(new LinkedList());

	public void serve(int port, SocketServer handler) throws IOException {
		ss = new ServerSocket();
		ss.setReuseAddress(true);
		ss.bind(new InetSocketAddress(port));
		this.handler = handler;
		serverThread = makeServerThread();
		serverThread.start();
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
			Thread.sleep(100);
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
