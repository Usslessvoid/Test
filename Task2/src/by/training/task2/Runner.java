package by.training.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Runner {
	static final int PORT = 2080;
	public static void main(String[] args) {
		ServerSocket socket = null;
		Socket client;
		BufferedReader input = null;
		PrintWriter output = null;
		try {
			socket = new ServerSocket(PORT);
			System.out.println("Socket create successful!");
			client = socket.accept();
			System.out.println("Successful connection! "+client.getInetAddress().toString());
			input = new BufferedReader(new InputStreamReader(client.getInputStream()));
			output = new PrintWriter(client.getOutputStream(),true);
		}catch (IOException e) {
			System.err.println("Can't create connection ");
		}
		output.println("Hello,niga");
		try {
			if(input != null) {
				input.close();
			}
			if(output != null) {
				output.close();
			}
		}catch (IOException e) {
			System.err.println("Streams not closed");
		}
	}

}
