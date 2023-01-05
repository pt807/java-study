package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClientThread extends Thread {
	private Socket socket;
	BufferedReader br;

	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			String input = null;
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			while (true) {
				input = br.readLine();
				System.out.println(input);
			}
		} catch (IOException e) {
			System.out.println("error: " + e);
			System.exit(1);
		}

	}
}
