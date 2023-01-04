package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.SocketException;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private Socket socket;
	private PrintWriter pw = null;
	private BufferedReader br;
	private String nickname;

	public ChatWindow(Socket socket, String name) {
		this.socket = socket;
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		nickname = name;
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		// buttonSend.addActionListener((ActionEvent e) ->{
		// });
		// buttonSend.addActionListener((e) ->{
		// });

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		try {
			// Iostream 받아오기
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			//pw.println("join:" + nickname);
			// ChatClientThread 생성하고 실행
			new ChatClientThread().start();

		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	private void finish() {
		try {
			// quit protocol 구현
			pw.println("quit");

			if (socket != null && !socket.isClosed()) {
				socket.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		// exit java(Application)
		System.exit(0);

	}

	private void sendMessage() {
		String message = textField.getText();
		// System.out.println("메세지 보내는 프로토콜 구현!!: " + message);

		if ("quit".equals(message)) {
			finish();
		} else {
			pw.println("message:" + message);
		}

		textField.setText("");
		textField.requestFocus();

		// chatClientThread 에서 서버로부터 받은 메세지가 있다 치고
		// updateTextArea("마이콜: " + message);
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private class ChatClientThread extends Thread {
		@Override
		public void run() {
			try {
				while (true) {
					String message = br.readLine();
					if (message == null) {
						break;
					}
					updateTextArea(message);
				}
			} catch (SocketException e) {
				System.out.println("SocketException.finish()");
				finish();
			} catch (IOException e) {
				System.out.println("error: " + e);
			}

		}

	}
}