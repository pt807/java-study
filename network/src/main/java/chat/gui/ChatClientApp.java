package chat.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import chat.ChatClientThread;
import chat.ChatServer;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;

		while (true) {
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();

			if (!name.isEmpty()) {
				break;
			}

			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

//		socket = new Socket();
//		try {
//			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		new ChatWindow(socket, name).show();
		// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡtestㅡㅡㅡㅡㅡㅡㅡㅡsuccessㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//		BufferedReader br;
//		try {
//			// 1. create socket
//			socket = new Socket();
//
//			// 2. connect to server
//			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
//
//			// 3. get iostream
//			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
//			 br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
//			
//			// 4. join protocol 진행 
//			pw.println("join:" + name);
//			String result = br.readLine();
//			if (result.equals("join:ok")) {
//				// 6. ChatClientReceiveThread 시작
//				new ChatWindow(socket, name).show();
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡisFinallyErrorㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		try {
			// 1. create socket
			socket = new Socket();

			// 2. connect to server
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));

			// 3. get iostream
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			// 4. join protocol 진행 
		pw.println("join:" + name);
			String result = br.readLine();
			if (result.equals("JOIN:OK")) {
				// 6. ChatClientReceiveThread 시작
				new ChatWindow(socket, name).show();
			}

		} catch (IOException e) {
			e.printStackTrace();
	
		}
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

//		try {
//			// 1. create socket
//			socket = new Socket();
//
//			// 2. connect to server
//			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
//
//			// 3. get iostream
//			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
//			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
//
//			// 4. join protocol 진행 
//		pw.println("join:" + name);
//			String result = br.readLine();
//			if (result.equals("JOIN:OK")) {
//				// 6. ChatClientReceiveThread 시작
//				new ChatWindow(socket, name).show();
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		} finally {
//			try {
//				if (socket != null && !socket.isClosed()) {
//					socket.close();
//				}
//				if (scanner != null) {
//					scanner.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}
}