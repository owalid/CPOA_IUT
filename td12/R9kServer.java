import java.io.*;
import java.util.*;
import java.net.*;

public class R9kServer {
	public static final int DEFAULT_PORT = 9898;
	public static HashSet<String> msgs = new HashSet<String>();

	public static void main(String[] args) throws Exception {
		ServerSocket listener = new ServerSocket(DEFAULT_PORT);
		System.out.println("The server is running at port " + DEFAULT_PORT  + ".");
		try {
			while (true) {
				new Thread(new Responder(listener.accept())).start();
			}
		} finally {
			listener.close();
		}
	}

	private static class Responder implements Runnable {
		private Socket socket;

		public Responder(Socket socket) {
			this.socket = socket;
			log("New connection with client at " + socket);
		}

		@Override
		public void run() {
			try {

				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

				boolean stop = false;

				while(!stop) {
					String msg = in.readLine();
					synchronized(msgs) {
						if(msgs.contains(msg)) {
							stop = true;
							log("Duplicate message: " + msg);
							out.println("Duplicate message: " + msg);
						} else {
							msgs.add(msg);
							log("New message: " + msg);
							out.println("New message: " + msg);
						}
					}
				}
			} catch (IOException e) {
				log("Error handling client at " + socket + ": " + e);
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					log("Couldn't close a socket");
				}
				log("Connection with " + socket + " closed");
			}
		}

		private void log(String message) {
			System.out.println(message);
		}
	}
}
