import java.io.*;
import java.util.*;
import java.net.*;

public class R9kClient {
	public static final String DEFAULT_ADDRESS = "localhost";
	public static final int DEFAULT_PORT = 9898;

	public static void main(String[] args) throws Exception {
		String address;
		int port;

		if(args.length >= 2) {
			address = args[0];
			try {
				port = Integer.parseInt(args[1]);
			} catch(NumberFormatException e) {
				port = DEFAULT_PORT;
			}

		} else if(args.length == 1) {
			address = args[0];
			port = DEFAULT_PORT;
		} else {
			address = DEFAULT_ADDRESS;
			port = DEFAULT_PORT;
		}


		Socket socket = new Socket(address, port);
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);	
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		Scanner stdin = new Scanner(System.in);

		String line;
		String answer;
		do {
			line = stdin.nextLine();
			out.println(line);
			answer = in.readLine();
			System.out.println(answer);
		} while(!line.equals("") && answer.startsWith("New message"));

		socket.close();
	}
}
