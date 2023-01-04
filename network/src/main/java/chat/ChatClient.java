package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);
			// 2. socket 생성
			socket = new Socket();
			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			log("connected");
			// 4. reader/writer 생성
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			// 5. join 프로토콜
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			pw.println("join:" + nickname);
//			pw.flush();
			String result = br.readLine();
			if (result.equals("JOIN:OK")) {
				// 6. ChatClientReceiveThread 시작
				new ChatClientThread(socket).start();
			}

			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();

				if ("quit".equals(input)) {
					break;
				} else {
					pw.println("message:" + input);
				}
			}

		} catch (IOException ex) {
			log("error:" + ex);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
				if (scanner != null) {
					scanner.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String message) {
		System.out.println("[ChatClient]" + message);
	}

}
