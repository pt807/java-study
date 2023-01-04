package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class ChatServerThread extends Thread {
	private Socket socket;
	private String nickName;
	List<Writer> listWriters;

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = inetSocketAddress.getAddress().getHostAddress();
		int remotePort = inetSocketAddress.getPort();
		ChatServer.log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (true) {
				String request = br.readLine();
				if (request == null) {
					ChatServer.log("클라이언트로 부터 연결이 끊김");
					break;
				}

				String[] token = request.split(":");
				if ("join".equals(token[0])) {
					doJoin(token[1], pw);
				} else if ("message".equals(token[0])) {
					doMessage(token[1]);
				} else if ("quit".equals(token[0])) {
					doQuit(pw);
				} else {
					ChatServer.log("에러: 알수 없는 요청(" + token[0] + ")");
				}

			}

		} catch (IOException e) {
			ChatServer.log("error: " + e);
		}
	}

	private void doQuit(Writer writer) {
		removeWriter(writer);

		String data = nickName + "님이 퇴장 하였습니다.";
		broadcast(data);
	}

	private void removeWriter(Writer writer) {
		synchronized (writer) {
			listWriters.remove(writer);
		}
	}

	private void doMessage(String message) {
		broadcast(nickName + " : " + message);
	}

	private void doJoin(String nickName, Writer writer) {
		this.nickName = nickName;

		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);

		addWriter(writer);

		PrintWriter printWriter = (PrintWriter) writer;
		printWriter.println("JOIN:OK");
		printWriter.flush();
	}

	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}

	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}

}