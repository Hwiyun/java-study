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
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatWindow {
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private PrintWriter pw;
	private BufferedReader br;
	String nickname = null;
	Scanner scanner = new Scanner(System.in);

	public ChatWindow(String name, BufferedReader br, PrintWriter pw) {

		nickname = name;
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.br = br;
		this.pw = pw;
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

		new ChatClientThread().start();
	}

	private void finish() {
		// quit protocol 구현
		System.exit(0);
	}

	private void sendMessage() {
		String message = textField.getText();
		String request = "message:" + message + "\r\n";
		if ("quit".equals(message) == true) {
			// 8. quit 프로토콜 처리
			pw.println("quit:" + nickname);
			finish();
		} else {
			// 9. 메시지 처리
			pw.println(request);
		}
		textField.setText("");
		textField.requestFocus();
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private class ChatClientThread extends Thread {
		@Override
		public void run() {

			while (true) {
				try {
					String request = br.readLine();
					if (request == null) {
						log("서버로 부터 연결 끊김");
						break;
					}
					updateTextArea(request);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					log("socket closed");
//					e.printStackTrace();
					break;
				} finally {
					finish();
				}

			}

		}

		public static void log(String msg) {
			System.out.println(msg);
		}
	}
}
