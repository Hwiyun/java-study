package chat.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClientApp {
	private static final String SERVER_IP = "0.0.0.0";

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;

		// 1. create socket
		try {
		socket = new Socket();

			// 2. connect to server
			SocketAddress address = new InetSocketAddress(SERVER_IP, ChatServer.PORT);
			socket.connect(address);

			// 3. get iostream
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter pw = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

			while (true) {
				System.out.println("대화명을 입력하세요.");
				System.out.print(">>> ");
				name = scanner.nextLine();
				
				if (!name.isEmpty()) {
					pw.println("join:" + name);
					String line = br.readLine();
					if ("join:ok".equals(line)) {
						break;
					}
				}

				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}
			new ChatWindow(name, br, pw).show();



		} catch (IOException e) {
			e.printStackTrace();
		}
		scanner.close();
	}
}
